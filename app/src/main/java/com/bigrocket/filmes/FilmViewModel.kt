package com.bigrocket.filmes

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class FilmViewModel(private val repository: FilmRepository): ViewModel() {

    var filmLiveData = MutableLiveData<List<Film>>()

    fun getFilm() {
        repository.getFilm { films ->
            filmLiveData.postValue(films)
        }
    }

    class FilmViewModelFactory(
        private val repository: FilmRepository
        ) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return FilmViewModel(repository) as T
        }
    }
}