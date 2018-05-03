package com.hbjpro.testkotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initElem()
    }

    private fun initElem(){
        var adapter = BookListAdapter(addBookData(), this)
        var list = findViewById(R.id.list_books) as ListView
        list.adapter = adapter
        
        list.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            Log.i("click", position.toString())
            var item = parent.getItemAtPosition(position)
            Toast.makeText(applicationContext, item.toString(), Toast.LENGTH_SHORT)
        }
    }

    private fun addBookData() : MutableList<Book>{
        var bookList: MutableList<Book> = mutableListOf()

        bookList.add(Book("Dragon Ball", "Akira Toriyama"))

        bookList.add(Book("Harry Potter", "JK Rowling"))

        bookList.add(Book("The Lord of the Rings", "JRR Tolkien"))

        bookList.add(Book("Spider-man", "Stan Lee"))

        bookList.add(Book("The Hobbit", "JRR Tolkien"))

        return bookList
    }


}
