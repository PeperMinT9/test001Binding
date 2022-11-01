package kr.ac.kumoh.s20170392.example.test001binding

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CountView: ViewModel() {
    private var _count = MutableLiveData<Int>(0)

    val count: LiveData<Int>
        get() = _count

    fun add() { _count.value = _count.value?.plus(1)}
    fun sub() { _count.value = _count.value?.minus(1)}
}