package com.brz.kotlinlearning.example

class ExampleClass {
    fun main(args: Array<String>) {
        val dog = Dog(12, "Курва бобр", false, true)
        println("Моей собаке ${dog.years} лет, я её называю ${dog.nickname} и она ${dog.answerToTheQuestionIsBarking}.")

        val cat = Cat(2, "Kotlin", true, true)
        println("Моему коту ${cat.years} лет, я его называю ${cat.nickname} и она ${cat.answerToTheQuestionIsMeowing}.")
    }
}