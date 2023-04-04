package com.example.assignment07

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView


class BookListFragment : Fragment() {

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
        return inflater.inflate(R.layout.fragment_book_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(view as RecyclerView) {
            layoutManager = GridLayoutManager(requireContext(), 2)

            textViewModel.getBooks().observe(requireActivity()){ it ->
                adapter = CustomRecyclerAdapter(it) {
                    textViewModel.setSelectedBook(it)
                }
            }
        }
    }
}

class CustomRecyclerAdapter(private val books: BookList, private val callback: (Book) -> Unit) : RecyclerView.Adapter<CustomRecyclerAdapter.MyViewHolder>() {

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var titleTextView = itemView.findViewById<TextView>(R.id.title)
        var authorTextView = itemView.findViewById<TextView>(R.id.author)
        init {
            super.itemView.setOnClickListener {
                callback(books.get(adapterPosition))
            }


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder{
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.fragment_book, parent, false))
    }


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.titleTextView.text = books.get(position).getTitle()
        holder.authorTextView.text = books.get(position).getAuthor()
    }

    override fun getItemCount(): Int {
        return books.size()
    }
}