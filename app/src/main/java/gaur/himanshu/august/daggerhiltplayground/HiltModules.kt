package gaur.himanshu.august.daggerhiltplayground

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Qualifier

@InstallIn(SingletonComponent::class)
@Module
object HiltModules {


    @Provides
    fun provideEngine(piston: Piston): Engine {
        return Engine(piston)
    }

    @Provides
    fun provideCar(engine: Engine, @Six numberOfCars: Int): Car {
        return Car(engine, numberOfCars)
    }

    @Provides
    fun providePiston(numberOfCylinder: NumberOfCylinder): Piston {
        return Piston(numberOfCylinder)
    }

    @Provides
    fun provideNumberOfCylinder(): NumberOfCylinder {
        return NumberOfCylinderImpl()
    }

    @Provides
    @Four
    fun provideFourCars(): Int {
        return 4
    }

    @Provides
    @Six
    fun provideSixCars(): Int {
        return 6
    }

}


@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class Four

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class Six