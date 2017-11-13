package com.hbjpro.testkotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

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
    }

    private fun addBookData() : ArrayList<Book>{
        var bookList = ArrayList<Book>()

        var book1 = Book()
        book1.name = "Dragon Ball"
        book1.author = "Akira Toriyama"
        bookList.add(book1)

        var book2 = Book()
        book2.name = "Harry Potter"
        book2.author = "JK Rowling"
        bookList.add(book2)

        var book3 = Book()
        book3.name = "The Lord of the Rings"
        book3.author = "JRR Tolkien"
        bookList.add(book3)

        var book4 = Book()
        book4.name = "Spider-man"
        book4.author = "Stan Lee"
        bookList.add(book4)

        var book5 = Book()
        book5.name = "The Hobbit"
        book5.author = "JRR Tolkien"
        bookList.add(book5)

        return bookList
    }
}
