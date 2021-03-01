package com.example.movieapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movieapp.data.models.MovieModel
import com.example.movieapp.presentation.base.BaseActivity
import com.example.movieapp.presentation.main.MainPresenter
import com.example.movieapp.presentation.main.MainView
import com.example.movieapp.presentation.main.PopularMoviesAdapter
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseActivity<MainPresenter>(), MainView {

    private val popularMoviesAdapter = PopularMoviesAdapter {
        Log.e("Name->>>>>>>>>>hah", it.name)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
        presenter.attach(this)
    }

    private fun initViews(){
        rvPopularMovies.layoutManager = LinearLayoutManager(this)
        rvPopularMovies.adapter = popularMoviesAdapter
    }

    override fun populatePopularMovies(movies: List<MovieModel>) {
        popularMoviesAdapter.setItems(movies)
    }

    companion object {
        fun start(context: Context) {
            context.startActivity(Intent(context, MainActivity::class.java))
        }
    }
}