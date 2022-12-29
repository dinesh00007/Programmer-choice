package com.example343443.mini_project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class hedactivity : AppCompatActivity() {
    lateinit var emaildata: TextView
    lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hedactivity)


        emaildata=findViewById(R.id.emaildada)

        var intent = intent
        val name = intent.getStringExtra("Name")

        emaildata.text= name

        fun new()
        {

            val sharein = Intent()
            sharein.action = Intent.ACTION_SEND
            sharein.type = "text/plain"
            sharein.putExtra(
                Intent.EXTRA_TEXT,
                "https://play.google.com/store/apps/details?id= hi"
            )
            startActivity(Intent.createChooser(sharein, "Share With App..."))
        }

        fun new2()
        {
            val Email = Intent(Intent.ACTION_SEND)
            Email.type = "text/email"
            Email.putExtra(Intent.EXTRA_EMAIL, arrayOf(" "))
            Email.putExtra(Intent.EXTRA_SUBJECT, "Feedback")
            Email.putExtra(Intent.EXTRA_TEXT, "Dear ...," + "")
            startActivity(Email)

        }

        fun new3()
        {


            val intent = Intent(this, about::class.java)

            startActivity(intent)




        }





        var drew =findViewById<DrawerLayout>(R.id.drawerLayout)

        toggle= ActionBarDrawerToggle(this, drew, R.string.open,R.string.close)
        drew.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)




        var views=findViewById<NavigationView>(R.id.navview)



        views.setNavigationItemSelectedListener {


            when(it.itemId)
            {
                R.id.mitItem1->new()

                R.id.mitItem2-> new2()

                R.id.mitItem3-> new3()
            }
            true


            true
        }


    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item))
        {
            return true
        }
        return super.onOptionsItemSelected(item)
    }

}