package com.brz.kotlinlearning

enum class Animal(
    val weight: Int,
    val height: Int,
    val speed: Int
) {
    ELEPHANT(6000, 3,40),
    SHARK(1000, 4,56),
    DOG(90, 1,100),
    EAGLE(4, 1,240),
    BLACK_DOG(3,2,1);

    fun isBird(): Boolean {
        return this == EAGLE
    }

    fun isFish(): Boolean{
        return this == SHARK
    }

    fun isDog():Boolean{
        return this == DOG || this == BLACK_DOG
    }
}