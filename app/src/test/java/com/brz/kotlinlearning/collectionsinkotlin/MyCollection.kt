package com.brz.kotlinlearning.collectionsinkotlin

class MyCollection<T> {
    fun main(args: Array<String>) {
        val set = hashSetOf(1, 7, 53)
        val list = arrayListOf(1, 7, 53)
        val map = hashMapOf(1 to "one", 7 to "seven", 53 to "fifty-three")

        val strings = listOf("first", "second", "fourteenth")
        println(strings.last())
        // fourteenth

        val numbers = setOf(1, 14, 2)
        println(numbers.max())
        // 14


        val list2 = listOf(1, 2, 3).withIndex()
        println(list2)      // Вызов метода toString()
        // [1, 2, 3]
        println(joinToString(list, "; ", "(", ")"))      // Вызов метода joinToString()
        // (1; 2; 3)

        println(joinToStringDefaultParameters(list))      // Параметры по умолчанию
        println(
            joinToStringDefaultParameters(
                list,
                postfix = ";",
                prefix = "# "
            )
        )      // Параметры по умолчанию
        // # 1, 2, 3;

    }

    fun <T> joinToString(
        collection: Collection<T>,
        separator: String,
        prefix: String,
        postfix: String
    ): String {
        val result = StringBuilder(prefix)

        for ((index, element) in collection.withIndex()) {
            if (index > 0) result.append(separator)
            result.append(element)
        }

        result.append(postfix)
        return result.toString()
    }

    fun <T> joinToStringDefaultParameters(
        collection: Collection<T>,
        separator: String = ", ",         // Параметры со значениями
        prefix: String = "",              // по умолчанию
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
}