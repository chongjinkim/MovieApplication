package com.soomgo.movieapp.common

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("android:SetImageUrl")
fun setImage(view : ImageView, url : String?){
    url?.let {
        Glide.with(view).load(ImageUrl+url).centerCrop().into(view)
    }
}

@BindingAdapter("android:formatNumber")
fun setFormatNumber(view : TextView, amount : Double){
    val formatNumber = amount.toString()
    view.text = formatNumber
}

@BindingAdapter("android:setRunningTime")
fun setRunningTime(view : TextView, time : Int){
    val runningTime = if(time > 1){
        "$time mins"
    } else {
        "$time mi"
    }

    view.text = runningTime
}


//좋아요 기능 추가 1. BindingAdapter 생성 뒤에 -> 분기 처리, startOn, startOff 지정
//별표 표시 시에 FavoriteFragment로 가는 그림 우선 설정 할 것
@BindingAdapter("android:setFavoriteMovie")
fun setFavoriteMovie(view : ImageView, isFavorite : Boolean){
    view.setImageResource(
        when(isFavorite){
            true -> android.R.drawable.star_on
            false -> android.R.drawable.star_off
        }
    )
}