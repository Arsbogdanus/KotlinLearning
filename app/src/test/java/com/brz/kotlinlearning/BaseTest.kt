package com.brz.kotlinlearning

import org.junit.jupiter.api.Test

class BaseTest {

    @Test
    fun runPlayground() {
        // Extension-функция
        val number = 10
        println(number.isDivisibleBy5())

        // Extension-свойство
        val fruits = listOf("Яблоко", "Банан", "Груша")
        println(fruits.lastIndex)

        // Extensions для nullable-типов
        val userStatus: String? = null
        println("Статус пользователя: ${userStatus.default()}")

        // Generic extensions
        val namesOfBodybuilders = listOf("Arnold", "Ronnie", "Chris", "David", "Larry")
        println(namesOfBodybuilders.penultimate())

        // Generic extensions с ограничениями (<T : ...>)
        val value = 7
        println(value.multiplyByTen())

        // Inline extensions
        3.repeatAction {
            println("Привет!")
        }

        // Reified generic extensions
        val mixedList = listOf("Привет", 123, true, "Kotlin", 456)

        val firstString = mixedList.findFirst<String>()
        val firstNumber = mixedList.findFirst<Int>()

        println(firstString)
        println(firstNumber)

        // Infix extensions
        val dividend = 120
        val divider = 5

        if (dividend isMultipleOf divider) {
            println("число $dividend кратно $divider")
        }

        // Operators extensions
        val laugh = "Ха! " * 3
        println(laugh)

        // Extensions для Companion Object
        val guest = User.createGuest()

        println(guest.name)
        println(guest.role)

        // Extensions с receiver
        val cleanText = buildTextWithReceiver {
            append("Привет, ")
            append("как ")
            append("дела?")
        }
        println(cleanText)

        val rawInput = "   привет, котлин   "

        val result = rawInput
            .clean()
            .addPrefix("🚀")
            .exclaim()

        println(result)

        // Примеры построения небольшого DSL с использованием extension-функций
        val cart = buildList {
            +"Молоко"
            +"Шоколад"
            +"Кофе"
        }

        println(cart.items)

        // Static dispatch
        val pet: AnimalExtension = Dog()
        println(pet.speak())
    }
}


// Extension-функция
fun Int.isDivisibleBy5(): Boolean {
    return this % 5 == 0
}

// Extension-свойство
val <T> List<T>.lastIndex: Int
    get() = this.size - 1

// Extensions для nullable-типов
fun String?.default(): String = this ?: "default"

// Generic extensions
fun <T> List<T>.penultimate(): T = this[this.size - 2]

// Generic extensions с ограничениями (<T : ...>)
fun <T : Number> T.multiplyByTen(): Double {
    return this.toDouble() * 10
}

// Inline extensions
inline fun Int.repeatAction(action: () -> Unit) {
    for (i in 1..this) {
        action()
    }
}

// Reified generic extensions
inline fun <reified T> List<Any>.findFirst(): T? {
    for (item in this) {
        if (item is T) {
            return item
        }
    }
    return null
}

// Infix extensions
infix fun Int.isMultipleOf(number: Int): Boolean {
    return this % number == 0
}

// Operators extensions
operator fun String.times(count: Int): String {
    return this.repeat(count)
}

// Extensions для Companion Object
class User(val name: String, val role: String) {
    companion object
}

fun User.Companion.createGuest(): User {
    return User(name = "Гость", role = "Guest")
}

// Extensions с receiver
inline fun buildTextWithReceiver(action: StringBuilder.() -> Unit): String {
    val builder = StringBuilder()
    builder.action()
    return builder.toString()
}

// Цепочки вызовов extension-функций
fun String.clean(): String {
    return this.uppercase()
}

fun String.addPrefix(emoji: String): String {
    return "$emoji $this"
}

fun String.exclaim(): String {
    return "$this!"
}

// Примеры построения небольшого DSL с использованием extension-функций
class ShoppingList {
    val items = mutableListOf<String>()

    operator fun String.unaryPlus() {
        items.add(this)
    }
}

inline fun buildList(block: ShoppingList.() -> Unit): ShoppingList {
    val list = ShoppingList()
    list.block()
    return list
}

// Static dispatch

open class AnimalExtension
class Dog : AnimalExtension()

fun AnimalExtension.speak() = "Animal"
fun Dog.speak() = "Гав гав"