package gaur.himanshu.august.daggerhiltplayground

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import gaur.himanshu.august.daggerhiltplayground.mvvm.MyVIewModel
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var car: Car

    val myviewModel: MyVIewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       // car.startCar()


        myviewModel.startCar()

    }


}

class Car(val engine: Engine,val number:Int) {

    fun startCar() {
        engine.getStartEngine()
        Log.d("TAG", "${number}  startCar")
    }
}


class Engine @Inject constructor(val piston: Piston) {

    fun getStartEngine() {
        piston.pistonStarted()
        Log.d("TAG", "getStartEngine")
    }


}


class Piston (val numberOfPiston: NumberOfPiston) {
    fun pistonStarted() {
        numberOfPiston.pistonNumber()
        Log.d("TAG", "pistonStarted")
    }
}


interface NumberOfPiston {
    fun pistonNumber()
}


class NumberOfPistonImpl : NumberOfPiston{
    override fun pistonNumber() {
        Log.d("TAG", "pistonNumber: 4")
    }
}












