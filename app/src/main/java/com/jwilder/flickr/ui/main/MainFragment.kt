package com.jwilder.flickr.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.jwilder.flickr.databinding.MainFragmentBinding
import com.jwilder.flickr.ui.main.adapter.MovieListAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private val viewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = MainFragmentBinding.inflate(inflater, container, false)

        // Init Recycler
        binding.movieRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = MovieListAdapter(
                context
            )
        }

        binding.message.setOnClickListener {
            viewModel.fetMovieData()
        }

        viewModel.movieList.observe(viewLifecycleOwner, Observer { list ->
            (binding.movieRecyclerView.adapter as MovieListAdapter).submitList(list)
        })

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.fetMovieData()
    }
}