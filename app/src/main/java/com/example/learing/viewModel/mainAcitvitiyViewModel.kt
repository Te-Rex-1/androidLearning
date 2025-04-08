package com.example.learing.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class mainAcitvitiyViewModel:ViewModel() {
        var number=MutableLiveData<Int>()

    init {
        number.value=0
    }

    fun addNumber(){
    number.value=(number.value)?.plus(1)

    }

}