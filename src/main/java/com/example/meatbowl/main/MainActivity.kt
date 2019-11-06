package com.example.meatbowl.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.meatbowl.R
import com.google.firebase.auth.FirebaseAuth
import android.view.MenuItem
import android.view.View
import androidx.fragment.app.FragmentManager
import androidx.viewpager.widget.ViewPager
import com.example.meatbowl.calculator.CalculateFragment
import com.example.meatbowl.calculator.CalculatorResultFragment
import com.example.meatbowl.fragments.CommunityFragment
import com.example.meatbowl.fragments.FeedingFragment
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() , BottomNavigationView.OnNavigationItemSelectedListener {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //권한셋팅\
        auth = FirebaseAuth.getInstance()


        //바텀네비게이션
        val bottomNavigationView = findViewById<View>(R.id.main_bottom_navi) as BottomNavigationView
        bottomNavigationView.setOnNavigationItemSelectedListener(this)
        bottomNavigationView.selectedItemId = R.id.navi_plan

    }

    //[Bottom Navigation Action]
    override fun onNavigationItemSelected(p0: MenuItem): Boolean {
        when (p0.itemId) {
            R.id.navi_plan -> {
                val fragmentA = FeedingFragment()
                supportFragmentManager.beginTransaction().replace(R.id.main_frameLayout, fragmentA).commit()
            }
            R.id.navi_calculate -> {
                val fragmentC = CalculateFragment()
                supportFragmentManager.beginTransaction().replace(R.id.main_frameLayout, fragmentC).commit()
            }
            R.id.navi_community -> {
                val fragmentD = CommunityFragment()
                supportFragmentManager.beginTransaction().replace(R.id.main_frameLayout, fragmentD).commit()
            }
        }
        return true
    }
    //로그인확인
    public override fun onStart() {
        super.onStart()
        val currentUser = auth.currentUser
    }

    fun moveToResultFragment(bundle: Bundle){
        val resultFragment = CalculatorResultFragment().apply{
            arguments = bundle
        }
        supportFragmentManager.beginTransaction().replace(R.id.main_frameLayout, CalculatorResultFragment()).commit()
    }
}

