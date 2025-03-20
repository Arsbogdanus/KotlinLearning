package com.brz.kotlinlearning

class Person(
    val name: String,
    var isMarried: Boolean
) {
    //    Классы содержащие только данные, без кода, часто называют объектами-значениями (value objects)
//    Модификатор public по умолчанию, поэтому можно не указывать
    fun main(args: Array<String>) {
//        Конструктор выполняется без ключевого слова "new"
        val person = Person("Bod", true)

//        Прямое обращение к свойству, но при этом вызывается метод чтения
        println(person.name)
        println(person.isMarried)
    }
}