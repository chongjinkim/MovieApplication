package com.soomgo.movieapp.presentation.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.soomgo.movieapp.BR
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.soomgo.movieapp.common.KEY_DETAIL
import com.soomgo.movieapp.databinding.LayoutDetailFragmentBinding
import com.soomgo.movieapp.domain.model.Movie
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel



class DetailFragment : Fragment(){

    lateinit var binding : LayoutDetailFragmentBinding

    private val viewModel by viewModel<DetailViewModel>()

    lateinit var movie : Movie

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = LayoutDetailFragmentBinding.inflate(inflater, container, false).apply {
        binding = this
        lifecycleOwner = viewLifecycleOwner
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        observe()
    }

    private fun initView(){
        arguments?.getParcelable<Movie>(KEY_DETAIL)?.let {
            movie = it
            viewModel.fetchDetail(it)
        }

        binding.startImage.setOnClickListener {
            viewLifecycleOwner.lifecycleScope.launch {
                viewModel.updateMovie(movie)
            }
        }
    }

    private fun observe(){
        viewModel.movieDetail.observe(viewLifecycleOwner){
            binding.setVariable(BR.movieDetail, it)
            binding.executePendingBindings()
        }

        viewModel.moiveFavorite.observe(viewLifecycleOwner){
            binding.isFavorite = it
        }
    }
}