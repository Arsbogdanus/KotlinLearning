package com.brz.kotlinlearning

class ExtensionLesson {
    fun main() {
        val europeanCountries = listOf("Italia", "Ukraine", "Germany", null)
        val northAmericanCountries = listOf("USA", "Canada", "Mexico")
        val countries = listOf(europeanCountries, northAmericanCountries)
        val capitals = listOf("Rome", "Kyiv", "Berlin", null, "Washington", "Ottawa", "Mexico City")

        // map
        println(
            europeanCountries.map {
                it?.uppercase() ?: "UNKNOWN"
            }
        )
        // [ITALIA, UKRAINE, GERMANY, UNKNOWN]

        // mapIndexed
        val numberedCountries = europeanCountries.mapIndexed { index, country ->
            "${index + 1}. ${country?.uppercase()}"
        }
        println(numberedCountries)
        // [1. ITALIA, 2. UKRAINE, 3. GERMANY, 4. null]

        // mapNotNull
        println(
            europeanCountries.mapNotNull {
                it?.uppercase()
            }
        )
        // [ITALIA, UKRAINE, GERMANY]

        // flapMap
        println(
            countries.flatMap { innerList ->
                innerList.mapNotNull {
                    it?.uppercase()
                }
            }
        )
        // [ITALIA, UKRAINE, GERMANY, USA, CANADA, MEXICO]

        // flatten
        println(
            countries.flatten()
        )
        // [Italia, Ukraine, Germany, null, USA, Canada, Mexico]

        // filter
        println(
            countries.map { innerList ->
                innerList.filter { it != null && it.length > 6 }
            }
        )
        // [[Ukraine, Germany], []]

        // filterNot
        println(
            countries.map { innerList ->
                innerList.filterNot { it != null && it.length > 6 }
            }
        )
        // [[Italia, null], [USA, Canada, Mexico]]

        // filterNotNull
        println(
            countries.flatten().filterNotNull()
        )
        // [Italia, Ukraine, Germany, USA, Canada, Mexico]

        // filterIndexed
        println(
            countries
                .flatten()
                .filterNotNull()
                .filterIndexed { index, country -> index % 2 == 0 }
        )
        // [Italia, Germany, Canada]

        // filterIsInstance
        val mixedList: List<Any?> = listOf("Kotlin", 42, "Java", 3.14, null, "Swift", 777)

        val strings: List<String> = mixedList.filterIsInstance<String>()
        println(strings)
        // [Kotlin, Java, Swift]

        val integers: List<Int> = mixedList.filterIsInstance<Int>()
        println(integers)
        // [42, 777]

        // find
        println(
            countries
                .flatten()
                .find { it?.startsWith("U") == true }
        )
        // Ukraine
        // если не находит значение, возвращает null

        // first
        println(
            countries
                .flatten()
                .first { it?.length == 3 }
        )
        // USA
        // если не находит значение, возвращает краш

        // firstOrNull
        println(
            countries
                .flatten()
                .firstOrNull { it?.startsWith("G") ?: false }
        )
        // Germany
        // если не находит значение, возвращает null

        // last
        println(
            countries
                .flatten()
                .last { it?.startsWith("C") ?: false }
        )
        // Canada
        // если не находит значение, возвращает краш

        // lastOrNull
        println(
            countries
                .flatten()
                .lastOrNull { it?.startsWith("I") ?: false }
        )
        // Italian
        // если не находит значение, возвращает null

        // indexOfFirst
        println(
            countries
                .flatten()
                .indexOfFirst { it?.startsWith("U") ?: false }
        )
        // 1

        // indexOfLast
        println(
            countries
                .flatten()
                .indexOfLast { it?.startsWith("U") ?: false }
        )
        // 4

        // contains
        println(
            countries
                .flatten()
                .contains("Japan")
        )
        // false

        // any
        println(
            countries
                .flatten()
                .any { it?.length!! > 5 }
        )
        // true

        // none
        println(
            countries
                .flatten()
                .none { it?.startsWith("Z") ?: false }
        )
        // true

        // all
        println(
            countries
                .flatten()
                .all { (it?.length ?: 4) > 3 }
        )
        // false

        // sorted
        println(
            countries
                .flatten()
                .filterNotNull()
                .sorted()
        )
        // [Canada, Germany, Italia, Mexico, USA, Ukraine]

        // sortedDescending
        println(
            countries
                .flatten()
                .filterNotNull()
                .sortedDescending()
        )
        // [Ukraine, USA, Mexico, Italia, Germany, Canada]

        // sortedBy
        println(
            countries
                .flatten()
                .filterNotNull()
                .sortedBy { it.length }
        )
        // [USA, Italia, Canada, Mexico, Ukraine, Germany]

        // sortedWith
        println(
            countries
                .flatten()
                .sortedWith(nullsLast(compareBy { it.length }))
        )
        // [USA, Italia, Canada, Mexico, Ukraine, Germany, null]

        // groupBy
        println(
            countries
                .flatten()
                .groupBy { it?.first() }
        )
        // {I=[Italia], U=[Ukraine, USA], G=[Germany], null=[null], C=[Canada], M=[Mexico]}

        // associate
        println(
            countries
                .flatten()
                .associate { (it?.uppercase() ?: "NULL") to it?.length }
        )
        // {ITALIA=6, UKRAINE=7, GERMANY=7, NULL=null, USA=3, CANADA=6, MEXICO=6}

        // associateBy
        println(
            countries
                .flatten()
                .associateBy { it?.length }
        )
        // {6=Mexico, 7=Germany, null=null, 3=USA}

        // associateWith
        println(
            countries
                .flatten()
                .associateBy { it?.length }
        )
        // {Italia=6, Ukraine=7, Germany=7, null=null, USA=3, Canada=6, Mexico=6}

        // foreach
        countries
            .flatten()
            .filterNotNull()
            .forEach { country ->
                println("В $country: ${country.length} букв")
            }
        /*
        В Italia: 6 букв
        В Ukraine: 7 букв
        В Germany: 7 букв
        В USA: 3 букв
        В Canada: 6 букв
        В Mexico: 6 букв
        */

        // foreachIndexed
        countries
            .flatten()
            .forEachIndexed { index, country ->
                println("${index + 1}. $country")
            }

        /*
        1. Italia
        2. Ukraine
        3. Germany
        4. null
        5. USA
        6. Canada
        7. Mexico
        */

        // onEach
        println(
            countries
                .flatten()
                .onEach { println("Прошла фильтр: $it") }
        )
        /*
        Прошла фильтр: Italia
        Прошла фильтр: Ukraine
        Прошла фильтр: Germany
        Прошла фильтр: null
        Прошла фильтр: USA
        Прошла фильтр: Canada
        Прошла фильтр: Mexico
        [Italia, Ukraine, Germany, null, USA, Canada, Mexico]
        */

        // max
        val numbers = listOf(4, 12, 8, 3)
        println(numbers.maxOrNull())
        // 12

        // min
        println(numbers.minOrNull())
        // 3

        // average
        println(numbers.average())
        // 6.75

        // sum
        println(numbers.sum())
        // 27

        // sumOff
        val cart = listOf(
            Product("Apple", 1.5),
            Product("Banana", 0.8),
            Product("Milk", 2.2)
        )

        val total = cart.sumOf { it.price }

        println(total)
        // 4.5

        // count
        println(
            countries
                .flatten()
                .count()
        )
        // 7

        // isEmpty
        println(countries.isEmpty())
        // false

        // isNotEmpty
        println(countries.isNotEmpty())
        // true

        // plus
        println(countries.flatten().plus("China"))
        // [Italia, Ukraine, Germany, null, USA, Canada, Mexico, China]

        // zip
        println(countries.flatten().zip(capitals))
        /*
        [(Italia, Rome),
        (Ukraine, Kyiv),
        (Germany, Berlin),
        (null, null),
        (USA, Washington),
        (Canada, Ottawa),
        (Mexico, Mexico City)]
        */

        // distinct
        val numbersDistinct = listOf(1, 2, 2, 3, 4, 4, 4, 1)

        val uniqueNumbers = numbersDistinct.distinct()
        println(uniqueNumbers)
        // [1, 2, 3, 4]

        // distinctBy
        val users = listOf(
            UserExtensionLesson(1, "Алексей"),
            UserExtensionLesson(2, "Мария"),
            UserExtensionLesson(1, "Алексей Дубликат"),
            UserExtensionLesson(3, "Иван")
        )

        val uniqueUsers = users.distinctBy { it.id }

        uniqueUsers.forEach { println(it) }
        /*
        User(id=1, name=Алексей)
        User(id=2, name=Мария)
        User(id=3, name=Иван)
        */

        // drop
        println(
            countries
                .flatten()
                .drop(3)
        )
        // [null, USA, Canada, Mexico]

        // dropLast
        println(
            countries
                .flatten()
                .dropLast(3)
        )
        // [Italia, Ukraine, Germany, null]

        // dropWhile
        val numbersDropWhile = listOf(2, 4, 6, 5, 8, 10, 3)

        val resultDropWhile = numbersDropWhile.dropWhile { it % 2 == 0 }

        println(resultDropWhile)
        // [5, 8, 10, 3]

        // take
        println(
            countries
                .flatten()
                .take(3)
        )
        // [Italia, Ukraine, Germany]

        // takeLast
        println(
            countries
                .flatten()
                .takeLast(3)
        )
        // [USA, Canada, Mexico]

        // takeWhile
        val numbersTakeLast = listOf(2, 5, 8, 12, 3, 1, 9)

        val resultTakeLast = numbersTakeLast.takeWhile { it < 10 }

        println(resultTakeLast)
        // [2, 5, 8]
    }
}

fun <T> List<T>.second(): T? {
    return this.getOrNull(1)
}

fun <T> List<T>.beforeLast(): T? {
    return this.getOrNull(size - 2)
}

data class Product(val name: String, val price: Double)

data class UserExtensionLesson(val id: Int, val name: String)
