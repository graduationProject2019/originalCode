package com.example.meatbowl.register

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Toast
import com.example.meatbowl.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {

    var lockButton = false

    //declare_auth
    private lateinit var firebaseAuth:FirebaseAuth
    //DB셋팅
    private val database by lazy { FirebaseDatabase.getInstance() }
    private val userRef = database.getReference("userData")
    private val dietRef = database.getReference("dietData")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        //initialize_auth
        firebaseAuth = FirebaseAuth.getInstance()

        //create_account
        btn_register_confrim.setOnClickListener {
            //유효성 검사
            if(!lockButton){
                isValidateInputs()?.let{
                    pair ->
                    lockButton = true
                    //유저 생성.
                    firebaseAuth.createUserWithEmailAndPassword(pair.first, pair.second)
                        .addOnCompleteListener { task ->
                            //유저 등록 성공
                            task.addOnSuccessListener {
                                lockButton = false
                                Toast.makeText(this,"회원 가입 성공",Toast.LENGTH_SHORT).show()
                                val user = firebaseAuth.currentUser
                                //DB에 데이터 셋팅
                                userRef.child("users").push().child("userId").setValue(pair.first)
                                //화면 닫음
                                finish()
                            }
                            //유저 등록 실패
                            task.addOnFailureListener {
                                lockButton = false
                                Toast.makeText(this,"회원가입 실패 : + ${it.message}",Toast.LENGTH_SHORT).show()
                            }
                        }

                }
            } else{
                Toast.makeText(this, " 요청 처리 중...",Toast.LENGTH_SHORT).show()
            }
        }

    }
    // 가입 폼 유효성 확인
    fun isValidateInputs():Pair<String,String>?{
        val registerId = register_id.text.toString()
        val registerPw = register_pw.text.toString()
        val registerPwConfrim = register_pw_confirm.text.toString()
        //빈칸처리 및 비밀번호 일치 처리
        if(registerId.isBlank() || registerPw.isBlank()){
            Toast.makeText(this, "이메일과 비밀번호를 입력하세요.",Toast.LENGTH_LONG).show()
            return null
        } else if(registerPw != registerPwConfrim){
            Toast.makeText(this, "비밀번호가 일치하지 않습니다.", Toast.LENGTH_LONG).show()
            return null
        } else {
            return Pair(registerId,registerPw)
        }
    }
}
