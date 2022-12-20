package com.bigrocket.filmes

class FilmRepository {
    fun getFilm(callback: (films: List<Film>) -> Unit) {
        Thread(Runnable {
            Thread.sleep(3000)
            callback.invoke(
                listOf(
                    Film(0,"Django Livre"),
                    Film(1,"V de Vingança"),
                    Film(2, "Bastardos Inglórios")
                )
            )
        }).start()
    }
}