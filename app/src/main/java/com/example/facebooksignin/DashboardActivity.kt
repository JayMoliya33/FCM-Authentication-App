package com.example.facebooksignin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_dashboard.*

class DashboardActivity : AppCompatActivity() {
    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        mAuth = FirebaseAuth.getInstance()
        val currentUser = mAuth.currentUser

        if(currentUser==null){
            startActivity(Intent(this,SignInActivity::class.java))
            finish()
        }

        logout_btn.setOnClickListener{
            mAuth.signOut()
            startActivity(Intent(this,SignInActivity::class.java))
            finish()
        }

    }
}