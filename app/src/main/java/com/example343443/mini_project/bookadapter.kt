package com.example343443.mini_project

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.example343443.mini_project.bookitem

class bookadapter(var context: Context, var arrayLists: ArrayList<bookitem>?, private val onCell: OnCellItemClick):
    BaseAdapter() {


    override fun getItem(position: Int): Any {
        return arrayLists!!.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return arrayLists!!.size
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {


        var view: View = View.inflate(context , R.layout.carview2,null)

        var butt: Button =view.findViewById(R.id.but)
        var icons: ImageView =view.findViewById(R.id.icosss)
        var names: TextView =view.findViewById(R.id.name_texs)


        var listItem: bookitem =arrayLists!!.get(position)

        icons.setImageResource(listItem.iconss!!)
        names.text=listItem.names

        butt.text=listItem.butt

        butt.setOnClickListener {
            onCell.onCellClickListener(names.text.toString())
        }

        return view
    }
}