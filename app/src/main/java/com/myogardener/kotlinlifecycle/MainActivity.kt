package com.myogardener.kotlinlifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.d
import androidx.lifecycle.Observer

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.myogardener.kotlinlifecycle.viewmodel.NumberViewModel
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    lateinit var viewModel: NumberViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        d("MainActivity","OnCreate")


    }

    override fun onStart() {
        super.onStart()
        d("MainActivity","OnStart")
    }

    override fun onResume() {
        super.onResume()
        d("MainActivity","OnResume")
    }

    override fun onPause() {
        print("OnPauser")
        super.onPause()
        d("MainActivity","OnPause")
    }

    override fun onStop() {
        print("ON Stop")
        super.onStop()
        d("MainActivity","OnStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        d("MainActivity","OnDestroy")
    }


}