package com.bigrocket.filmes

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.fragment_film.*

class FilmFragment : Fragment(R.layout.fragment_film) {

    private lateinit var viewModel: FilmViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(
            this,
            FilmViewModel.FilmViewModelFactory(FilmRepository())
        ).get(FilmViewModel::class.java)

        viewModel.filmLiveData.observe(viewLifecycleOwner, Observer { films ->
            textViewTitle.text = films[0].title
        })

        viewModel.getFilm()
    }
}