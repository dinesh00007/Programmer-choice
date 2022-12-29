package com.example343443.mini_project

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.animation.AnimationUtils
import android.widget.*
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import com.google.firebase.database.FirebaseDatabase


class MainActivity : AppCompatActivity(), OnCellItemClick{


    lateinit var toggle: ActionBarDrawerToggle
    lateinit var authss: FirebaseAuth
   /* public val img = arrayOf(  R.drawable.javaa, R.drawable.cl,R.drawable.pythons,R.drawable.ccsg,R.drawable.mouses,R.drawable.unos,R.drawable.ccc,R.drawable.yo,R.drawable.book1)

    public  var texts = arrayOf("Java programming","C programming","Python programming",".Net programming","Mouse Programming","Embedded programming","C++ programming ","YouTube Tutorials","Programming Books")
*/

    lateinit var btnInsert: Button
    lateinit var databaseReference: DatabaseReference
    lateinit var emaildata:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


       /* emaildata=findViewById(R.id.emaildada)

        var intent = intent
        val name = intent.getStringExtra("Name")

        emaildata.text= name*/



    /*   btnInsert=findViewById(R.id.button7)
        databaseReference=FirebaseDatabase.getInstance().getReference("employees")
        btnInsert.setOnClickListener {
            var id=databaseReference.push().key.toString()
            var namedata="Java programming"
            var imgs="https://www.google.com/imgres?imgurl=https%3A%2F%2Flookaside.fbsbx.com%2Flookaside%2Fcrawler%2Fmedia%2F%3Fmedia_id%3D1174948699217098&imgrefurl=https%3A%2F%2Fwww.facebook.com%2Fmodaimg%2F&tbnid=oDZzgxlq2lIRjM&vet=12ahUKEwjFiIHX_5_wAhWrCrcAHV7WBFQQMygGegUIARDkAQ..i&docid=un6vfHu-MY9eMM&w=819&h=819&q=img&ved=2ahUKEwjFiIHX_5_wAhWrCrcAHV7WBFQQMygGegUIARDkAQ"
            var employee=Employee(id,namedata,imgs)
            databaseReference.child(id).setValue(employee)
            Toast.makeText(applicationContext,"Record Inserted Successfully", Toast.LENGTH_LONG).show()


        }*/

        databaseReference=FirebaseDatabase.getInstance().getReference("employees")


        var listofemployees=ArrayList<Employee>()


       val recyclerViews = findViewById<RecyclerView>(R.id.recycler_view)
        var gridLayoutManager = GridLayoutManager(this,2,LinearLayoutManager.VERTICAL,false)
        databaseReference.addValueEventListener(object: ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {



                if(snapshot!!.exists())
                {
                    for(data in snapshot.children)
                    {
                        var employee=data.getValue(Employee::class.java)
                        // Log.e("employee",employee.)
                        listofemployees.add(employee!!)

                    }

                    var customAdapter= CustomAdapter(listofemployees,object: OnCellItemClick {
                        override fun onCellClickListener(text: String) {
                            val intent = Intent(applicationContext, MainActivity2::class.java)
                            intent.putExtra("data",text)
                            startActivity(intent)

                        }
                    },context = applicationContext)
                    recyclerViews.adapter=customAdapter


                }
            }
            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
                finish()

            }
        })
       var myadpter = CustomAdapter(listofemployees,onCell = this,context = applicationContext)


        recyclerViews.adapter=myadpter

        recyclerViews.layoutManager = gridLayoutManager
        // recyclerViews.layoutManager = LinearLayoutManager(this )

        recyclerViews.setHasFixedSize(true)
        //  recyclerViews.setHasFixedSize(true)



      /*  var listofdata = ArrayList<Model>()

       var data = Model(R.drawable.javaa,"Java programming")
        var data1 = Model(R.drawable.cl,"C programming")
        var data2 = Model(R.drawable.pythons,"Python programming")
        var data3 = Model(R.drawable.ccsg,".Net programming")
        var data4 = Model(R.drawable.mouses,"Mouse Programming")
        var data5 = Model(R.drawable.unos,"Embedded programming")
        var data6 = Model(R.drawable.ccc,"C++ programming ")
        var data7 = Model(R.drawable.yo,"YouTube Tutorials")
        var data8 = Model(R.drawable.book1,"Programming Books")

        listofdata.add(data)
        listofdata.add(data1)
        listofdata.add(data2)
        listofdata.add(data3)
        listofdata.add(data4)
        listofdata.add(data5)
        listofdata.add(data6)
        listofdata.add(data7)
        listofdata.add(data8)

*/



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

        fun new4()
        {
            FirebaseAuth.getInstance().signOut()
           // authss.signOut()
            val intent = Intent(this, loginss::class.java)
            startActivity(intent)
            finish()
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

                R.id.mitItem4 -> new4()
            }
            true


            true
        }



    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.login,menu)




        return true
    }




    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item))
        {


            return true
        }

        if(item.itemId==R.id.first)
        {
            FirebaseAuth.getInstance().signOut()
            // authss.signOut()
            val intent = Intent(this, loginss::class.java)
            startActivity(intent)
            finish()
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onCellClickListener(text: String) {
        TODO("Not yet implemented")
    }


    /* override fun onCellClickListener(text:String) {


         val intent = Intent(this, MainActivity2::class.java)
         intent.putExtra("data",text)
         startActivity(intent)

     }*/




}

