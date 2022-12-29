package com.example343443.mini_project

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.Toast
import androidx.cardview.widget.CardView
import com.google.firebase.auth.FirebaseAuth
import java.lang.Exception

@Suppress("DEPRECATION")
class Welcomescree : AppCompatActivity() {
    lateinit var d:ImageView
    lateinit var auths: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcomescree)
        d = findViewById(R.id.imageView2)

        auths= FirebaseAuth.getInstance()

        d.alpha = 0f
        d.animate().setDuration(1500).alpha(1f).withEndAction {



            if (auths.currentUser != null)
            {

                Toast.makeText(this, "user is already login!", Toast.LENGTH_LONG).show()
                redirect("MAIN")
                finish()

            }
            else
            {
                redirect("LOGIN")
                finish()
            }


            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)


            finish()


        }





    }
    private fun redirect(name:String)
    {
        val intent = when(name){

            "LOGIN" -> Intent(this, loginss::class.java)

            "MAIN" -> Intent(this, MainActivity::class.java)


            else -> throw Exception("no path Exists")

        }

        startActivity(intent)
        finish()

    }
}