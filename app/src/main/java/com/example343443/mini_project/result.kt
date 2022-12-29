package com.example343443.mini_project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager

import kotlinx.android.synthetic.main.activity_result.*

class result : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_result)


        val scope=intent.getStringExtra(setdata.score)
        val totalQuestiondata=intent.getStringExtra("total size")

        scores.text="${scope}/${totalQuestiondata}"
        button.setOnClickListener {

            startActivity(Intent(applicationContext,MainActivity::class.java))
            finish()
        }


    }
}