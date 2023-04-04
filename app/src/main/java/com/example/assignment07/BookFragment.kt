package com.example.assignment07

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

class BookFragment : Fragment() {
    private lateinit var title: TextView
    private lateinit var author: TextView
    lateinit var textViewModel: TextViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        textViewModel = ViewModelProvider(requireActivity())[TextViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_book, container, false).apply{
            title = findViewById(R.id.title)
            author = findViewById(R.id.author)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        textViewModel.getSelectedBook().observe(requireActivity()) {
            title.text = it.getTitle()
        }
        textViewModel.getSelectedBook().observe(requireActivity()) {
            author.text = it.getAuthor()
        }
    }
}