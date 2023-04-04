package com.example.assignment07

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TextViewModel : ViewModel(){
    private val selectedBook = MutableLiveData<Book>()
    private val books = MutableLiveData<BookList>()
    private var hasSeenSelection = false
    fun setSelectedBook(book: Book) {
        hasSeenSelection  = false
        selectedBook.value = book
    }
    fun getSelectedBook() : MutableLiveData<Book> {
        return selectedBook
    }
    fun getHasSeenSelection() : Boolean {
        return hasSeenSelection
    }
    fun setBooks(bookList: BookList) {
        books.value = bookList
    }
    fun getBooks() : MutableLiveData<BookList> {
        return books
    }
    fun setHasSeenSelection(hasSeen: Boolean) {
        hasSeenSelection = hasSeen
    }
}