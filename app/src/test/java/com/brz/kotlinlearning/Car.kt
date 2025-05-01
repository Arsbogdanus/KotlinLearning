package com.brz.kotlinlearning

import kotlin.reflect.KClass

sealed interface Car {
    val weight: Int
    val enginePower: Int
    val maxSpeed: Int

    fun getBrand(car: Car): KClass<out Car> {
        return car::class
    }
}

 class Mercedes(override val weight: Int,
                override val enginePower: Int,
                override val maxSpeed: Int,
                val isMaybach: Boolean
 ): Car

 class Audi(override val weight: Int,
            override val enginePower: Int,
            override val maxSpeed: Int,
            val isVersionRS: Boolean
 ): Car

 class BMW(override val weight: Int,
           override val enginePower: Int,
           override val maxSpeed: Int,
           val isVersionCS: Boolean
 ): Car

 class Renault(override val weight: Int,
               override val enginePower: Int,
               override val maxSpeed: Int,
               val isAWD: Boolean
 ): Car

 class Toyota(override val weight: Int,
              override val enginePower: Int,
              override val maxSpeed: Int,
              val isHybrid: Boolean
 ): Car
