package com.brz.kotlinlearning

enum class Color(
    val r: Int, val g: Int, val b: Int
) {
    RED(255, 0, 0),
    ORANGE(255, 165, 0),
    YELLOW(255, 255, 0),
    GREEN(0, 255, 0),
    BLUE(0, 0, 255),
    INDIGO(75, 0, 130),
    VIOLET(238, 130, 238); // <------- точка с запятой обязательна, отделяет список констант от определений методов

    fun rgb() = (r * 256 + g) * 256 + b

}


// import.com.brz.kotlinlearning.Color.*    <---- Импорт класса Color, объявленный в другом месте
// fun getWarmth(color: Color) =
//            when (color) {
//                RED, ORANGE, YELLOW -> "Теплый"
//                GREEN -> "Нейтральный"
//                BLUE, INDIGO, VIOLET -> "Холодный"

class MainColor {
    fun main(args: Array<String>) {
        fun getMnemonic(color: Color) =
            when (color) {
                Color.RED -> "Каждый"
                Color.ORANGE -> "Охотник"
                Color.YELLOW -> "Желает"
                Color.GREEN -> "Знать"
                Color.BLUE -> "Где"
                Color.INDIGO -> "Сидит"
                Color.VIOLET -> "Фазан"
            }
        // При наличии совпадния выполняется только соотвествующая ветка (break не нужен)
        println(getMnemonic(Color.BLUE))
        // Где

        // В одну ветка можно объединить несколько значений, разделив из запятыми:
        fun getWarmth(color: Color) =
            when (color) {
                Color.RED, Color.ORANGE, Color.YELLOW -> "Теплый"
                Color.GREEN -> "Нейтральный"
                Color.BLUE, Color.INDIGO, Color.VIOLET -> "Холодный"
            }
        println(getWarmth(Color.ORANGE))
        // Теплый


        fun mix(c1: Color, c2: Color) =
            when (setOf(c1, c2)) {            // Перечесление пар цветов, пригодных для смешивания
                setOf(Color.RED, Color.YELLOW) -> Color.ORANGE // Аргументом может быть любой объект.
                setOf(Color.YELLOW, Color.BLUE) -> Color.GREEN // Он проверяется условными выражениями ветвей
                setOf(Color.BLUE, Color.VIOLET) -> Color.INDIGO
                else -> throw  Exception("Грязный цвет") // <--- Выполняется если не соотвествует ни одной из ветвей
            }
        println(mix(Color.BLUE, Color.YELLOW)) // наоборот тоже самое
        // GREEN

    //      Множество – это коллекция, порядок элементов которой не важен;
    //      два множества считаются равными, если содержат одинаковые элементы.

    //      В каждом вызове функция создает несколько множеств Set,
    //      которые использыются только для сравнения двух пар цветов. Обычно это не вызывает проблем,
    //      но если функция  вызывается часто, стоит переписать код таким образом,
    //      чтобы при его выполнении не создавался мусор. Это делается с помощью выражения when без аргументов.
    //      Код станет менее читабельным, но это цена, которую часто приходится платить за лучшую производительность.

        fun mixOptimized(c1: Color, c2: Color) =
            when {
                (c1 == Color.RED && c2 == Color.YELLOW) ||
                (c1 == Color.YELLOW && c2 == Color.RED) ->
                    Color.ORANGE
                (c1 == Color.BLUE && c2 == Color.YELLOW) ||
                (c1 == Color.YELLOW && c2 == Color.BLUE) ->
                    Color.GREEN
                (c1 == Color.BLUE && c2 == Color.VIOLET) ||
                (c1 == Color.VIOLET && c2 == Color.BLUE) ->
                    Color.INDIGO
                else -> throw  Exception("Грязный цвет")
            }
        println(mixOptimized(Color.BLUE, Color.YELLOW))
        // GREEN
    }
}