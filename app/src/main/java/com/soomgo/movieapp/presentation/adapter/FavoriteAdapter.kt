package com.soomgo.movieapp.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.soomgo.movieapp.BR
import com.soomgo.movieapp.databinding.ItemFavoriteBinding
import com.soomgo.movieapp.domain.model.Movie


//onCreateViewHold시 inflate 까먹지 말 것
//FavoriteViewHoler 생성 -> 추후 recyclerview item으로 사용할 예정

class FavoriteAdapter : ListAdapter<Movie, FavoriteAdapter.FavoriteViewHolder>(Movie.DiffUtil) {

    //클릭이벤트 처리를 하기 위한 함수

    var clickListener : ((Movie) -> (Unit))? = null

    //LAYOUT -> onCreateViewHolder -> 레이아웃 뷰 홀더로 만든다.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = FavoriteViewHolder(
        ItemFavoriteBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

   //각각의 id값에 맞는 데이터 바인딩 작업 진행
   //recyclerview의 경우 매번 데이터 포맷이 바뀌면 어댑터를 손봐야하는 단점이 있다.
    //이를 해결하기 위해서 databinding을 사용을 하게 된다

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