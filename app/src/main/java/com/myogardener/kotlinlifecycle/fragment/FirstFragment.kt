package com.myogardener.kotlinlifecycle.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.util.Log.d
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.myogardener.kotlinlifecycle.R
import com.myogardener.kotlinlifecycle.viewmodel.NumberViewModel
import kotlinx.android.synthetic.main.fragment_first.*
import java.util.EnumSet.of
import java.util.List.of
import java.util.Map.of
import java.util.OptionalDouble.of
import java.util.Set.of
import java.util.stream.Collector.of


class FirstFragment : Fragment() {

  lateinit var viewModel: NumberViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
                return inflater.inflate(R.layout.fragment_first, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

   viewModel = ViewModelProviders.of(this).get(NumberViewModel::class.java)

        viewModel.currentNumber.observe(this.viewLifecycleOwner, Observer {
            number.text= it.toString()
        })
        next.setOnClickListener{
            var action= FirstFragmentDirections.actionFirstFragmentToSecondFragment()
            findNavController().navigate(action)
        }
incredement()

    }

private fun incredement(){
    add.setOnClickListener{
        viewModel.currentNumber.value = viewModel.numbers++
    }

}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        d("First Fragment","OnCreated")
    }
    override fun onStart() {
        super.onStart()
        print("OnStart")
        d("First Fragment","OnStart")
    }

    override fun onResume() {
        print("OnResume")
        super.onResume()
        d("First Fragment","OnResume")
    }

    override fun onStop() {
        super.onStop()
        d("First Fragment","Onstop")
    }

    override fun onPause() {
        super.onPause()
        Log.d("First Fragment", "OnPause")
    }

    override fun onDestroy() {
        super.onDestroy()
        d("First Fragment","OnDestroy")
    }


}