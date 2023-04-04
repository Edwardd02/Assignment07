package com.example.assignment07

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    private var hasTwoContainers = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        hasTwoContainers = findViewById<View>(R.id.bookFragmentContainer2) != null
        val textViewModel = ViewModelProvider(this)[TextViewModel::class.java]
        val bookList = BookList()
        bookList.addBook(Book("The Hobbit", "J.R.R. Tolkien"))
        bookList.addBook(Book("The Adventures of Huckleberry Finn", "Mark Twain"))
        bookList.addBook(Book("Anna Karenina", "Leo Tolstoy"))
        bookList.addBook(Book("The Great Gatsby", "F. Scott Fitzgerald"))
        bookList.addBook(Book("1984", "George Orwell"))
        bookList.addBook(Book("Brave New World", "Aldous Huxley"))
        bookList.addBook(Book("Madame Bovary", "Gustave Flaubert"))
        bookList.addBook(Book("One Hundred Years of Solitude", "Gabriel Garcia Marquez"))
        bookList.addBook(Book("The Feast of the Goat", "Mario Vargas Llosa"))
        bookList.addBook(Book("In Search of Lost Time", "Marcel Proust"))
        bookList.addBook(Book("The Sound and the Fury", "William Faulkner"))
        bookList.addBook(Book("Mein Kampf","Jake Kenichi"))
        val fragment1 = BookListFragment()
        textViewModel.setBooks(bookList)

        if(savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.bookFragmentContainer1, fragment1)
                .addToBackStack(null)
                .setReorderingAllowed(true)
                .commit()
        }
        if(hasTwoContainers) {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.bookFragmentContainer2, BookFragment())
                .commit()
        }
        textViewModel.getSelectedBook().observe(this) {
            if (!textViewModel.getHasSeenSelection() && !hasTwoContainers) {
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.bookFragmentContainer1, BookFragment())
                    .addToBackStack(null)
                    .setReorderingAllowed(true)
                    .commit()
                textViewModel.setHasSeenSelection(true)
            }
        }
    }

}