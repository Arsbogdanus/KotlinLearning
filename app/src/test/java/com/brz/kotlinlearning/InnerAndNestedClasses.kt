package com.brz.kotlinlearning

class Outer {
    val outerField: Int = 1

    class Nested {
        fun print() = "Вложенный класс" // Не имеет доступ к полям внешнего класса
    }

    inner class Inner {
        fun getOuterValue() = outerField // Имеет доступ к полям внешнего класса
    }
}

