package com.example343443.mini_project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth

class SingupActivity : AppCompatActivity() {

    lateinit var auth: FirebaseAuth
    lateinit var uname: TextView
    lateinit var pass: TextView
    lateinit var passconfirm : TextView
    lateinit var butt: Button
    lateinit var btt2: Button
    lateinit var alrt:TextView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_singup)

        auth= FirebaseAuth.getInstance()
        butt = findViewById(R.id.btnsin)
        butt.setOnClickListener {

            singUpUser()
        }

        var gin = findViewById<Button>(R.id.Already)

        gin.setOnClickListener {
            val intent = Intent(this, loginss::class.java)
            startActivity(intent)
            finish()
        }

    }

    private fun singUpUser()
    {
        uname=findViewById(R.id.sinname)
        pass=findViewById(R.id.sinpass)
        passconfirm=findViewById(R.id.passcon)




        val email= uname.text.toString()
        val password=pass.text.toString()
        val passconfir= passconfirm.text.toString()

        if (email.isBlank()||password.isBlank()||passconfir.isBlank())
        {
            Toast.makeText(this, "Email and Password Can't be blank", Toast.LENGTH_LONG).show()
            return

        }
        if (password != passconfir)
        {
            Toast.makeText(this, "Password and Confirm Password do not match", Toast.LENGTH_LONG).show()
            return
        }


        auth.createUserWithEmailAndPassword(email,password)
            .addOnCompleteListener(this) {
            if(it.isSuccessful){
                Toast.makeText(this, "Successfully Registered", Toast.LENGTH_LONG).show()
                val intent = Intent(this, loginss::class.java)
                startActivity(intent)
                finish()
            }else {
                Toast.makeText(this, "Registration Failed", Toast.LENGTH_LONG).show()
            }
        }

    }
}