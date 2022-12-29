package com.example343443.mini_project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class loginss : AppCompatActivity() {

    lateinit var auth: FirebaseAuth
    lateinit var uname: TextView
    lateinit var pass: TextView

    lateinit var alrt: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loginss)
        auth= FirebaseAuth.getInstance()

        var logins= findViewById<Button>(R.id.btnlog)



        /* val currentuser = auth.currentUser
         if (currentuser != null)
         {
             startActivity(Intent(applicationContext,LoginActivity::class.java))
             finish()
         }*/


        logins.setOnClickListener {

            login()
           /* var nameEm = findViewById<EditText>(R.id.logname)
            val name = nameEm.text.toString()

            val intent = Intent(this,MainActivity::class.java)
            intent.putExtra("Name",name)
            startActivity(intent)*/

        }

        var sin =findViewById<Button>(R.id.textsinup)

        sin.setOnClickListener {

            val intent = Intent(this, SingupActivity::class.java)
            startActivity(intent)
            finish()
        }

    }

    private fun login()
    {
        uname=findViewById(R.id.logname)
        pass=findViewById(R.id.logpass)



        val email= uname.text.toString()
        val password=pass.text.toString()


        if (email.isBlank()||password.isBlank())
        {
            Toast.makeText(this, "Email and Password Can't be blank", Toast.LENGTH_LONG).show()
            return

        }



        auth.signInWithEmailAndPassword(email,password).addOnCompleteListener(this) {

            if(it.isSuccessful) {

                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
            else
            {
                Toast.makeText(this, "Authentication Failed", Toast.LENGTH_LONG).show()
            }

        }

    }
}