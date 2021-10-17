package com.soomgo.movieapp.presentation.my

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.ConcatAdapter
import com.soomgo.movieapp.databinding.LayoutRecyclerviewBinding
import com.soomgo.movieapp.presentation.adapter.FavoriteAdapter
import com.soomgo.movieapp.presentation.adapter.HeaderAdapter
import com.soomgo.movieapp.presentation.movie.movieClickListener
import org.koin.android.compat.ScopeCompat.viewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MyFragment : Fragment() {

    lateinit var binding : LayoutRecyclerviewBinding

    private val viewModel by viewModel<MyViewModel>()

    private val adapter = FavoriteAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = LayoutRecyclerviewBinding.inflate(inflater, container, false).apply {
       lifecycleOwner = viewLifecycleOwner
       binding = this
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observe()
        initView()
    }

    private fun observe(){
        viewModel.list.observe(viewLifecycleOwner){
            adapter.submitList(it)
        }
    }

    private fun initView(){
        binding.recyclerView.adapter = ConcatAdapter().apply {
            addAdapter(HeaderAdapter("My", "내가 저장한 영화"))
            addAdapter(adapter.apply {
                clickListener = movieClickListener(requireActivity())
            })
        }
    }
}