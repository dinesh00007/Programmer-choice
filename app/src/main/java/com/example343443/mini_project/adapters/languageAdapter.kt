package com.example343443.mini_project.adapters

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import com.example343443.mini_project.OnCellItemClick
import com.example343443.mini_project.R
import com.example343443.mini_project.model.languageItem
import kotlin.time.TestTimeSource

class languageAdapter(var context: Context,var  arrayList: ArrayList<languageItem>, private val onCell: OnCellItemClick):BaseAdapter() {


    override fun getItem(position: Int): Any {
        return arrayList!!.get(position)
    }

    override fun getItemId(position: Int): Long {
      return position.toLong()
    }

    override fun getCount(): Int {
        return arrayList!!.size
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {


        var view:View = View.inflate(context , R.layout.carview,null)

        var icons:ImageView=view.findViewById(R.id.icos)
        var names:TextView=view.findViewById(R.id.name_tex)

        var listItem:languageItem=arrayList.get(position)

        icons.setImageResource(listItem.icons!!)
        names.text=listItem.name

        icons.setOnClickListener {
            onCell.onCellClickListener(names.text.toString())
        }

        return view
    }
}