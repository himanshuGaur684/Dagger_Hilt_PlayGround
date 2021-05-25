package gaur.himanshu.august.daggerhiltplayground.mvvm

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MyVIewModel @Inject constructor(private val repo: MyRepo): ViewModel() {


    fun startCar(){
        repo.car.startCar()
    }

}