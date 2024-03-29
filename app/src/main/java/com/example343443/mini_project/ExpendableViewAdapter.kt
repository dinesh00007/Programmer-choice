package com.example343443.mini_project
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.TextView

class ExpendableViewAdapter internal constructor(private val context: Context,
                                                 private val j_textss:List<String>,
                                                 private  val topicsList:HashMap<String ,
                                                         List<String>>):
        BaseExpandableListAdapter() {
    override fun getGroup(groupPosition: Int): Any {
        return j_textss[groupPosition]
    }

    override fun isChildSelectable(groupPosition: Int, childPosition: Int): Boolean {
        return true
    }

    override fun hasStableIds(): Boolean {
        return false
    }

    override fun getGroupView(
            groupPosition: Int,
            isExpanded: Boolean,
            convertView: View?,
            parent: ViewGroup?
    ): View {
        var convertView=convertView
        val chapterTitle = getGroup(groupPosition) as String

        if (convertView == null)
        {
            val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE ) as LayoutInflater
            convertView = inflater.inflate(R.layout.list_item2,null)

        }

        val chapterTv = convertView!!.findViewById<TextView>(R.id.java_text)
        chapterTv.setText(chapterTitle)
        return convertView

    }

    override fun getChildrenCount(groupPosition: Int): Int {

        return this.topicsList[this.j_textss[groupPosition]]!!.size
    }

    override fun getChild(groupPosition: Int, childPosition: Int): Any {

        return this.topicsList[this.j_textss[groupPosition]]!![childPosition]
    }

    override fun getGroupId(groupPosition: Int): Long {
        return groupPosition.toLong()
    }

    override fun getChildView(
            groupPosition: Int,
            childPosition: Int,
            isLastChild: Boolean,
            convertView: View?,
            parent: ViewGroup?
    ): View {
        var convertView=convertView
        val topicTitle = getChild(groupPosition,childPosition) as String


        if (convertView == null)
        {
            val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE ) as LayoutInflater
            convertView = inflater.inflate(R.layout.topic,null)

        }

        val topicTv = convertView!!.findViewById<TextView>(R.id.topics_tv)
        topicTv.setText(topicTitle)

        return convertView


    }

    override fun getChildId(groupPosition: Int, childPosition: Int): Long {
        return childPosition.toLong()
    }

    override fun getGroupCount(): Int {
        return j_textss.size
    }

}


