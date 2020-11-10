package com.myogardener.kotlinlifecycle.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NumberViewModel:ViewModel() {

    var numbers = 0;
    var numbers2 = 0;

  val currentNumber : MutableLiveData<Int>by lazy {
      MutableLiveData<Int>()
  }

}