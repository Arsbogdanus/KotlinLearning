package com.brz.kotlinlearning

data class UserUniversalMethodsInKotlin(
    val id: Long,
    val name: String,
    val email: String,
    val age: Int = 18
)

fun main() {
    val user1 = UserUniversalMethodsInKotlin(1, "Анна", "anna@example.com")

    println(user1)

    val user2 = UserUniversalMethodsInKotlin(1, "Анна", "anna@example.com")
    println(user1 == user2)

    val updatedUser = user1.copy(age = 25)
    println(updatedUser)

    val (id, name) = user1
    println("$name с ID $id") // Вывод: Анна с ID 1
}