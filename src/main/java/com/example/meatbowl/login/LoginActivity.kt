package com.example.meatbowl.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.meatbowl.R
import com.google.firebase.auth.FirebaseAuth
import android.content.Intent
import android.view.View
import android.widget.Toast
import com.example.meatbowl.main.MainActivity
import com.example.meatbowl.register.RegisterActivity
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_register.*

class LoginActivity : AppCompatActivity() {

    val firebaseAuth by lazy { FirebaseAuth.getInstance() }
    var lockButton = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btn_register.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        btn_login.setOnClickListener {
            isValidateInputs()?.let { pair ->
                firebaseAuth.signInWithEmailAndPassword(pair.first, pair.second).addOnCompleteListener(this) { task ->

                    task.addOnSuccessListener {
                        lockButton = false
                        moveToMainActivity()
                    }

                    task.addOnFailureListener {
                        lockButton = false
                        Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }

    fun moveToMainActivity() {
        Intent(this, MainActivity::class.java).run {
            startActivity(this)
            finish()
        }
    }

    fun isValidateInputs(): Pair<String, String>? {
        val userId = user_Id.text.toString()
        val userPw = user_Pw.text.toString()

        if (userId.isBlank() || userPw.isBlank()) {
            Toast.makeText(this, "이메일과 비밀번호를 입력하세요.", Toast.LENGTH_LONG).show()
            return null
        } else {
            return Pair(userId, userPw)
        }
    }
}

