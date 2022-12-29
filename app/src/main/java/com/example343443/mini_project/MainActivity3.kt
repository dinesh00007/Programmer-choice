package com.example343443.mini_project

import android.app.DownloadManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.GridView
import android.widget.Toast
import com.example343443.mini_project.model.languageItem

class MainActivity3 : AppCompatActivity(),OnCellItemClick {

    private var arrayLists:ArrayList<bookitem> ? = null
    private var gridViews: GridView? = null

    private var bookadapter : bookadapter ? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        supportActionBar!!.setTitle("BOOK ")





    }



    private fun setdatalists():ArrayList<bookitem>
    {


        var arrayLists:ArrayList<bookitem> = ArrayList()
        arrayLists.add(bookitem(R.drawable.cl,"C Language","Download C" ))
        arrayLists.add(bookitem(R.drawable.ccc,"C++ Language","Download C++"))
        arrayLists.add(bookitem(R.drawable.javaa,"java Language","Download java"))

        arrayLists.add(bookitem(R.drawable.pythons,"Python Language","Download python"))

        arrayLists.add(bookitem(R.drawable.ccsg,"C# Language","Download C#"))
        arrayLists.add(bookitem(R.drawable.mouses,"Mouse Language","Download Mouse"))
        arrayLists.add(bookitem(R.drawable.unos,"Embedded program Language","Download Ep"))
        return arrayLists
    }






    override fun onCellClickListener(texts: String) {
        try{
            if(texts=="java Language"){
                    var mydow:Long=0
                    var b = findViewById<Button>(R.id.but)

                    b.setOnClickListener {
                        var request :DownloadManager.Request = DownloadManager.Request(Uri.parse("https://drive.google.com/file/d/1z7bbQ5OapfAkR2bldoMuGz_W56sDStC5/view?usp=sharing"))
                            .setTitle("c language")
                            .setDescription("Download atmiya")
                            .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE)
                            .setAllowedOverMetered(true)

                        var manager:DownloadManager = getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
                        mydow = manager.enqueue(request)
                    }


                var br = object :BroadcastReceiver()
                {
                    override fun onReceive(context: Context?, intent: Intent?) {
                        var id:Long? = intent?.getLongExtra(DownloadManager.EXTRA_DOWNLOAD_ID, -1 )
                        if (id==mydow)
                        {
                            Toast.makeText(applicationContext,"Download completed",Toast.LENGTH_LONG).show()
                        }
                    }
                }

                registerReceiver(br, IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE))

            }else if(texts=="C Language"){
                var intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/EMEvheCVhMk"));
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.setPackage("com.google.android.youtube");
                startActivity(intent)
            }

            else if(texts=="C++ Language"){
                var intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://youtube.com/playlist?list=PLLYz8uHU480j37APNXBdPz7YzAi4XlQUF"));
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.setPackage("com.google.android.youtube");
                startActivity(intent)
            }

            else if(texts=="Python Language"){
                var intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://youtube.com/playlist?list=PLbGui_ZYuhigZkqrHbI_ZkPBrIr5Rsd5L"));
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.setPackage("com.google.android.youtube");
                startActivity(intent)
            }
        }catch (e:Exception){

        }


    }


}