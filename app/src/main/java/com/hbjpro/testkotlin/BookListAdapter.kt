package com.hbjpro.testkotlin

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView


data class BookListAdapter (var list:MutableList<Book>, var context: Context) : BaseAdapter(){
    var bookList : MutableList<Book>? = null
    var infalter : LayoutInflater? = null

    init {
        bookList = list
        infalter = LayoutInflater.from(context)
    }


    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view: View? = null
        view = infalter?.inflate(R.layout.layout_book_item, parent, false)

        var viewHolder = ViewHolder(view)
        viewHolder.setText(position + 1, bookList?.get(position)?.title, bookList?.get(position)?.author)

        return view!!
    }

    override fun getItem(position: Int): Book? {
        return bookList?.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return bookList!!.size
    }
}

private class ViewHolder(var view: View?){

    var root: View? = null

    init {
        this.root = view
    }

    fun setText(number: Int, book: String?, author: String?){
        //var numberText = root?.findViewById(R.id.txt_number) as TextView
        var image = root?.findViewById(R.id.imageView) as ImageView
        var bookNameText = root?.findViewById(R.id.txt_bookName) as TextView
        var authorText = root?.findViewById(R.id.txt_bookAuthor) as TextView

        //numberText.text = number.toString()
        if(number % 2 == 0)
            image.setBackgroundColor(Color.parseColor("#0000FF"))
        else
            image.setBackgroundColor(Color.parseColor("#FFFF00"))
        bookNameText.text = book
        authorText.text = author
    }
}