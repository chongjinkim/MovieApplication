package com.soomgo.movieapp.presentation.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.soomgo.movieapp.databinding.LayoutDetailFragmentBinding
import com.soomgo.movieapp.domain.model.Movie

class DetailFragment : Fragment(){

    lateinit var binding : LayoutDetailFragmentBinding

    val viewModel : DetailViewModel by viewModels()

    lateinit var movie : Movie

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = LayoutDetailFragmentBinding.inflate(inflater, container, false).apply {
        binding = this
        lifecycleOwner = this@DetailFragment
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}