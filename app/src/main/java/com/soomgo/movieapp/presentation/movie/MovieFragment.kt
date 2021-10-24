package com.soomgo.movieapp.presentation.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.ConcatAdapter
import com.soomgo.movieapp.R
import com.soomgo.movieapp.common.KEY_DETAIL
import com.soomgo.movieapp.databinding.LayoutRecyclerviewBinding
import com.soomgo.movieapp.domain.model.Movie
import com.soomgo.movieapp.presentation.adapter.HeaderAdapter
import com.soomgo.movieapp.presentation.adapter.HorizontalAdapter
import com.soomgo.movieapp.presentation.adapter.MovieListAdapter
import com.soomgo.movieapp.presentation.detail.DetailFragment
import org.koin.android.compat.ViewModelCompat.viewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class MovieFragment : Fragment(){

    lateinit var binding : LayoutRecyclerviewBinding

    private val viewModel by viewModel<MovieViewModel>()

    private val popularAdapter = MovieListAdapter()

    private val upComingAdapter = MovieListAdapter()

    private val topRatedAdapter = MovieListAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = LayoutRecyclerviewBinding.inflate(inflater, container, false).apply{
        lifecycleOwner = viewLifecycleOwner
        binding = this
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observe()
        initRecyclerView()
    }

    private fun observe(){
        viewModel.popularMovies.observe(viewLifecycleOwner){
            popularAdapter.submitList(it)
        }

        viewModel.topRateMovies.observe(viewLifecycleOwner){
            topRatedAdapter.submitList(it)
        }

        viewModel.upcomingMovies.observe(viewLifecycleOwner){
            upComingAdapter.submitList(it)
        }

    }

    private fun initRecyclerView(){
        binding.recyclerView.apply {
            adapter = ConcatAdapter().apply {
                addAdapter(HeaderAdapter("POPULAR", "가장 인기있는 영화"))
                addAdapter(HorizontalAdapter(popularAdapter.apply {
                    clickListener = movieClickListener(requireActivity())
                }))
                addAdapter(HeaderAdapter("TOP RATED", "평점이 가장 높은 영화"))
                addAdapter(HorizontalAdapter(topRatedAdapter.apply {
                    clickListener = movieClickListener(requireActivity())
                }))
                addAdapter(HeaderAdapter("UPCOMING", "개봉 예정 영화"))
                addAdapter(HorizontalAdapter(upComingAdapter.apply {
                    clickListener = movieClickListener(requireActivity())
                }))
            }
        }
    }
}

fun movieClickListener(activity: FragmentActivity) : (Movie) -> Unit =
    {  movie ->
        val fragment = DetailFragment().apply {
            arguments = Bundle().apply {
                putParcelable(KEY_DETAIL, movie)
            }
        }
    activity
        .supportFragmentManager
        .beginTransaction()
        .replace(R.id.fragmentContainerView, fragment)
        .addToBackStack(null).commit()

    }

