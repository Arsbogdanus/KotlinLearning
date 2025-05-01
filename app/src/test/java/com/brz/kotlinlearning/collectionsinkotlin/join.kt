@file:JvmName("Blablabla")          // Аннотация для объявления имени класса

package com.brz.kotlinlearning.collectionsinkotlin      // Выражение package следует за аннотациями уровня файла

fun <T> joinToStringDefaultParameters(
    collection: Collection<T>,
    separator: String = ", ",
    prefix: String = "",
    postfix: String = ""
): String {
    val result = StringBuilder(prefix)

    for ((index, element) in collection.withIndex()) {
        if (index > 0) result.append(separator)
        result.append(element)
    }

    result.append(postfix)
    return result.toString()
}

var opCount = 0                 // Объявление свойства верхнего уровня

fun performOperation() {
    opCount++                   // Изменение значения свойства
}

fun reportOperationCount() {
    println("Operation performed $opCount times")       // Чтение значения свойства
}

const val UNIX_LINE_SEPARATOR = "\n"
// public static final String UNIX_LINE_SEPARATOR = "\n";
