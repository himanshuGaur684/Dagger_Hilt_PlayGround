package gaur.himanshu.august.daggerhiltplayground

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var car: Car


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        car.startCar()
    }


}


class Car(val engine: Engine, val carNumber:Int) {
    fun startCar() {
        engine.startEngine()
        Log.d("TAG", "${carNumber} car start")
    }
}

class Engine @Inject constructor(val piston: Piston) {
    fun startEngine() {
        piston.startPiston()
        Log.d("TAG", "startEngine: is started")
    }
}

class Piston(val numberOfCylinder: NumberOfCylinder) {
    fun startPiston() {
        numberOfCylinder.getNumberOfCylinder()
        Log.d("TAG", "startPiston")
    }
}

interface NumberOfCylinder {
    fun getNumberOfCylinder()
}

class NumberOfCylinderImpl : NumberOfCylinder {
    override fun getNumberOfCylinder() {
        Log.d("TAG", "getNumberOfCylinder: 4")
    }
}


