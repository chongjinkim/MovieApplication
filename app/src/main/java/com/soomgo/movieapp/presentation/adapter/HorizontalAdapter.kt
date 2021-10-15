package com.soomgo.movieapp.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.soomgo.movieapp.databinding.LayoutHorizontalRecyclerviewBinding



class HorizontalAdapter(private val subAdapter : MovieListAdapter) : RecyclerView.Adapter<HorizontalAdapter.HorizontalViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HorizontalViewHolder {

        val view = LayoutHorizontalRecyclerviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return HorizontalViewHolder(view)
    }

    override fun onBindViewHolder(holder: HorizontalViewHolder, position: Int) {
        holder.binding.apply {
            horizontalRecyclerView.adapter = subAdapter
        }
    }

    override fun getItemCount() = 1


    inner class HorizontalViewHolder(val binding : LayoutHorizontalRecyclerviewBinding) : RecyclerView.ViewHolder(binding.root)
}