package com.example.assignment07

class Book {
    private var title: String = ""
    private var author: String = ""

    constructor(title: String, author: String) {
        this.title = title
        this.author = author
    }
    fun getTitle(): String {
        return title
    }
    fun getAuthor(): String {
        return author
    }
}