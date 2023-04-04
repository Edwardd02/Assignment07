package com.example.assignment07

class BookList {
    private var books = ArrayList<Book>()

    fun addBook(book: Book) {
        books.add(book)
    }

    fun removeBook(book: Book) {
        books.remove(book)
    }

    fun get(index: Int): Book {
        return books[index]
    }

    fun size(): Int {
        return books.size
    }


}