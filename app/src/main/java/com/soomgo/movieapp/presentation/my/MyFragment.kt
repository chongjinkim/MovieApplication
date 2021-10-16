package com.soomgo.movieapp.presentation.my

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.soomgo.movieapp.databinding.LayoutMyFragmentBinding
import com.soomgo.movieapp.presentation.adapter.FavoriteAdapter

class MyFragment : Fragment() {

    lateinit var binding : LayoutMyFragmentBinding

    val viewModel : MyViewModel by viewModels()

    private val adapter = FavoriteAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = LayoutMyFragmentBinding.inflate(inflater, container, false).apply {
       lifecycleOwner = this@MyFragment
       binding = this
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}