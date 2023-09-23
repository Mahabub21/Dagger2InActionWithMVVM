package com.dagger2inaction

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.dagger2inaction.db.FakerDB
import com.dagger2inaction.viewmodels.MainViewModel
import com.dagger2inaction.viewmodels.MainViewModelFactory
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private lateinit var mainViewModel: MainViewModel

    @Inject
    lateinit var mainViewModelFactory: MainViewModelFactory

    @Inject
    lateinit var fakerDB: FakerDB

    private val productsText : TextView
        get() = findViewById(R.id.products)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (application as MyApplication).applicationComponent.inject(this)

        val map =  (application as MyApplication).applicationComponent.getMap()

        mainViewModel = ViewModelProvider(this, mainViewModelFactory)[MainViewModel::class.java]

        mainViewModel.productsLiveData.observe(this, Observer {
           productsText.text = it.joinToString { x -> x.title + "\n\n" }
        })
    }

}