package com.brz.kotlinlearning.example

open class Animal(
    val years: Int,
    val nickname: String,
    val tail: Boolean
)

class Dog(years: Int, nickname: String, tail: Boolean, val isBark: Boolean) :
    Animal(years, nickname, tail) {
    val answerToTheQuestionIsBarking: String
        get() {
            return if (isBark) "гавкает" else "не гавкает"
        }
    }

class Cat(years: Int, nickname: String, tail: Boolean, val isMeow: Boolean) :
    Animal(years, nickname, tail){
    val answerToTheQuestionIsMeowing: String
        get() {
            return if (isMeow) "мяукает" else "не мяукает"
        }
}