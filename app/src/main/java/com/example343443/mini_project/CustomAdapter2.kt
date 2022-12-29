package com.example343443.mini_project

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter2(
    val text: Array<String>
  /* val c_text: Array<String>,
    val python_text: Array<String>,
    val net_text: Array<String>,
    val em_text: Array<String>*/
    , private val onCell:OnCellItemClick ,val context: Context
): RecyclerView.Adapter<CustomAdapter2.CustomViewHolder2>()


{

    class CustomViewHolder2(itemView: View): RecyclerView.ViewHolder(itemView)
    {
       var itemtital:TextView=itemView.findViewById(R.id.java_text)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomAdapter2.CustomViewHolder2 {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.list_item2,parent,false)
        return CustomViewHolder2(v)

    }




    override fun onBindViewHolder(holder: CustomAdapter2.CustomViewHolder2, position: Int) {


            holder.itemtital.text=text[position]

        holder.itemView.setOnClickListener {

            if(position==0)
            {
                Toast.makeText(
                        context,
                        "java program",
                        Toast.LENGTH_LONG
                ).show()


            }
            if(position==1)
            {

                Toast.makeText(
                        context,
                        " C program",
                        Toast.LENGTH_LONG
                ).show()

            }
            if(position==2)
            {
                Toast.makeText(
                        context,
                        "Python",
                        Toast.LENGTH_LONG
                ).show()
            }
            if(position==3)
            {
                Toast.makeText(
                        context,
                        "C# program",
                        Toast.LENGTH_LONG
                ).show()
            }
            if(position==4)
            {
                Toast.makeText(
                        context,
                        "Mouse program",
                        Toast.LENGTH_LONG
                ).show()
            }
            if(position==5)
            {
                Toast.makeText(
                    context,
                    "Embedded program",
                    Toast.LENGTH_LONG
                ).show()
            }
            if(position==6)
            {
                Toast.makeText(
                    context,
                    "C++ program",
                    Toast.LENGTH_LONG
                ).show()
            }
            if(position==7)
            {
                Toast.makeText(
                    context,
                    "Youtube link ",
                    Toast.LENGTH_LONG
                ).show()
            }
            if(position==8)
            {
                Toast.makeText(
                    context,
                    "BOOK ",
                    Toast.LENGTH_LONG
                ).show()
            }




            onCell.onCellClickListener(text[position])

        }



    }

    override fun getItemCount(): Int {
        return text.size;
    }



}
