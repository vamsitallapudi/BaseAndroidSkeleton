package com.coderefer.baseandroidskeleton.ui.home

import android.os.Bundle
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import androidx.lifecycle.Observer
import com.coderefer.baseandroidskeleton.BaseApp
import com.coderefer.baseandroidskeleton.R
import com.coderefer.baseandroidskeleton.ui.base.BaseActivity
import javax.inject.Inject

class HomeActivity : BaseActivity() {

    @Inject
    lateinit var viewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as BaseApp).appComponent.injectActivity(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel.fetchMovies()
        viewModel.stockLiveData.observe(this, Observer {
            for(i in it) {
                Toast.makeText(this, i.title, LENGTH_LONG).show()
            }
        })
    }
}