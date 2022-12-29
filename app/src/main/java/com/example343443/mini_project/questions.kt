package com.example343443.mini_project

import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_questions.*
import kotlin.math.log

class questions : AppCompatActivity() {

    private var questionList:ArrayList<Questiondata>?=null
    private var currenposition:Int=1
    private var selectoption:Int=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)


//        setdata.getquestion()
//
//        questionList=setdata.getquestion()
//        setQuestion()
//        option1.setOnClickListener {
//            selectoptionstyle(option1,1)
//
//        }
//        option2.setOnClickListener {
//            selectoptionstyle(option2,2)
//
//        }
//        option3.setOnClickListener {
//            selectoptionstyle(option3,3)
//
//        }
//        option4.setOnClickListener {
//            selectoptionstyle(option4,4)
//
//        }
//
//        nextbtn.setOnClickListener {
//
//            if(selectoption!=0)
//            {
//                val question=questionList!![currenposition-1]
//                if(selectoption!=question.correct_ans)
//                {
//                    setcolor(selectoption,R.drawable.error)
//
//                }
//                setcolor(question.correct_ans,R.drawable.correct)
//                if(currenposition==questionList!!.size)
//                    nextbtn.text="FINISH"
//                else
//                    nextbtn.text="Go to Next"
//            }
//            else
//            {
//                currenposition++
//                when{
//
//                    currenposition<=questionList!!.size->{
//                        setQuestion()
//                    }
//                    else->
//                    {
//                        Toast.makeText(this,"HIIII",Toast.LENGTH_LONG).show()
//                    }
//                }
//            }
//            selectoption=0
//        }

    }

    fun setcolor(opt:Int,color:Int)
    {
     when(opt)
     {
         1->{
             option1.background=ContextCompat.getDrawable(this,color)
         }
         2->{
             option2.background=ContextCompat.getDrawable(this,color)
         }
         3->{
             option3.background=ContextCompat.getDrawable(this,color)
         }
         4->{
             option4.background=ContextCompat.getDrawable(this,color)
         }
     }
    }


    fun setQuestion()
    {
        val question = questionList!![currenposition-1]
        setoptionstyle()

        progressd.progress=currenposition;
        progressd.max=questionList!!.size
        totalsum.text="${currenposition}"+"/"+"${questionList!!.size}"
        question1.text=question.question
        option1.text=question.option_one
        option2.text=question.option_two
        option3.text=question.option_three
        option4.text=question.option_four

    }

    fun setoptionstyle()
    {
        var optionlist:ArrayList<TextView> = arrayListOf()
        optionlist.add(0,option1)
        optionlist.add(1,option2)
        optionlist.add(2,option3)
        optionlist.add(3,option4)

        for(op in optionlist)
        {
            op.setTextColor(Color.parseColor("#555151"))
            op.background=ContextCompat.getDrawable(this,R.drawable.quetio_op)
            op.typeface= Typeface.DEFAULT
        }

    }

    fun selectoptionstyle(view:TextView,opt:Int)
    {
        setoptionstyle()
        selectoption=opt
        view.background=ContextCompat.getDrawable(this,R.drawable.selectoption)
        view.typeface= Typeface.DEFAULT
        view.setTextColor(Color.parseColor("#000000"))
    }
}