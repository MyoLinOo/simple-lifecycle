package com.myogardener.kotlinlifecycle.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewManager
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.myogardener.kotlinlifecycle.R
import com.myogardener.kotlinlifecycle.viewmodel.NumberViewModel
import kotlinx.android.synthetic.main.fragment_first.*
import kotlinx.android.synthetic.main.fragment_second.*


class SecondFragment : Fragment() {
    //
   lateinit var  viewModel: NumberViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        viewModel= ViewModelProviders.of(this).get(NumberViewModel::class.java)
        viewModel.currentNumber.observe(
            this.viewLifecycleOwner, Observer {
                number2.text= viewModel.currentNumber.toString()
            }
            )
        increantment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("Second Fragment", "OnCreated")
    }
    override fun onStart() {
        super.onStart()
        print("OnStart")
        Log.d("Second Fragment", "OnStart")
    }

    override fun onPause() {
        super.onPause()
        Log.d("Second Fragment", "OnPause")
    }

    override fun onResume() {
        print("OnResume")
        super.onResume()
        Log.d("Second Fragment", "OnResume")
    }

    override fun onStop() {
        super.onStop()
        Log.d("Second Fragment", "Onstop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Second Fragment", "OnDestroy")
    }


    fun  increantment(){
        add2.setOnClickListener{
            viewModel.currentNumber.value = ++viewModel.numbers2
        }
    }
}