package com.soomgo.movieapp.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.soomgo.movieapp.databinding.LayoutMovieHeaderBinding
import com.soomgo.movieapp.domain.model.Movie
import com.soomgo.movieapp.presentation.adapter.HeaderAdapter.HeaderViewHolder


class HeaderAdapter(private val title : String,
                    private val description : String) : RecyclerView.Adapter<HeaderViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeaderViewHolder {
        val view = LayoutMovieHeaderBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return HeaderViewHolder(view)
    }

    override fun onBindViewHolder(holder: HeaderViewHolder, position: Int) {
            holder.binding.apply {
                popularText.text = title
                categoryText.text = description
            }
    }

    override fun getItemCount() = 1

    inner class HeaderViewHolder(val binding : LayoutMovieHeaderBinding) : RecyclerView.ViewHolder(binding.root)
}