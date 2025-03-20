package com.brz.kotlinlearning

class Rectangle(val height: Int, val wight: Int) {
    val isSquare: Boolean
        get() {      // Объявление метода чтения для свойства
            return height == wight
        }

    fun main(args: Array<String>){
        val rectangle = Rectangle(41,43)
        println(rectangle.isSquare)
    }
}