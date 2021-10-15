package com.soomgo.movieapp.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.soomgo.movieapp.BR
import com.soomgo.movieapp.databinding.ItemFavoriteBinding
import com.soomgo.movieapp.domain.model.Movie



//onCreateViewHold시 inflate 까먹지 말 것
class FavoriteAdapter : ListAdapter<Movie, FavoriteAdapter.FavoriteViewHolder>(Movie.DiffUtil) {

    var clickListener : ((Movie) -> (Unit))? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteViewHolder {
        val view = ItemFavoriteBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return FavoriteViewHolder(view)
    }

    override fun onBindViewHolder(holder: FavoriteViewHolder, position: Int) {
            holder.binding.apply {
                setVariable(BR.movie, getItem(position))
                root.setOnClickListener {
                    clickListener?.invoke(getItem(position))
                    executePendingBindings()
                }
            }
    }

    inner class FavoriteViewHolder(var binding : ItemFavoriteBinding) : RecyclerView.ViewHolder(binding.root)


}