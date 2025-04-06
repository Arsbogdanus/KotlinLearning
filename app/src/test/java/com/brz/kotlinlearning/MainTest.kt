package com.brz.kotlinlearning

class MainTest {
    fun main(args: Array<String>) {
        val animal = Animal.EAGLE

        fun eval(e: Expr): Int {
            if (e is Num) {
                val n = e as Num       // Явное приведение к типу Num здесь излишне
                return n.value
            }
            if (e is Sum) {
                return eval(e.right) + eval(e.left)     // Переменная e уже приведена к нужному типу!
            }
            throw IllegalArgumentException("Unknown expression")
        }
        println(eval(Sum(Sum(Num(1), Num(2)), Num(4))))
        // 7

        fun eval2(e: Expr): Int =
            if (e is Num) {
                e.value
            } else if (e is Sum) {
                eval2(e.right) + eval2(e.left)
            } else {
                throw IllegalArgumentException("Unknown expression")
            }
        println(eval2(Sum(Num(1), Num(2))))
        // 3

        fun eval3(e: Expr): Int =
            when (e) {
                is Num ->
                    e.value

                is Sum ->
                    eval3(e.right) + eval3(e.left) // <-- Используется автоматическое приведение типов
                else ->
                    throw IllegalArgumentException("Unknown expression")
            }

        fun evalWithLogging(e: Expr): Int =
            when (e) {
                is Num -> {
                    println("num: ${e.value}")
                    e.value                             // Это последнее выражение в блоке,
                }                                       // функция вернет его значение, если e имеет тип Num
                is Sum -> {
                    val left = evalWithLogging(e.left)
                    val right = evalWithLogging(e.right)
                    println("sum: $left + $right")      // Функция вернет значение этого выражения,
                    left + right                        // если e имеет тип Sum
                }

                else -> throw IllegalArgumentException("Unknown expression")
            }
        println(evalWithLogging(Sum(Sum(Num(1), Num(2)), Num(4))))
        // num: 1
        // num: 2
        // sum: 1 + 2
        // num: 4
        // sum: 3 + 4
        // 7

        fun myCar(car: Car): String =
            when(car) {
                is Mercedes ->
                    car.getBrand(car).toString() + " version of Maybach – ${car.isMaybach}"
                is Audi ->
                    car.getBrand(car).toString() + " version of RS - ${car.isVersionRS}"
                is BMW ->
                    car.getBrand(car).toString() + " version of CS - ${car.isVersionCS}"
                is Renault ->
                    car.getBrand(car).toString() + " version of AWD - ${car.isAWD}"
                is Toyota ->
                    car.getBrand(car).toString() + " version of Hybrid - ${car.isHybrid}"
                is Toyota ->
                    car.getBrand(car).toString() + " version of Hybrid - ${car.isHybrid}"
                else -> throw IllegalArgumentException("Unknown brand")
            }

        println(myCar(Mercedes(1500, 500, 320, true)))



        fun getPhraseWhenSeeingCat(cat: CatFamily): String =
            when(cat) {
                CatFamily.CHEETAH -> "Боже мой! какой быстрый!"
                CatFamily.LEOPARD -> "Боже мой! какой праворный!"
                CatFamily.TIGER -> "Боже мой! какой большой!"
                CatFamily.LION -> "Боже мой! какой пушистый!"
            }

        println(getPhraseWhenSeeingCat(CatFamily.TIGER))

        fun getFactAboutAnimal(animal: Animal) =
            when(animal) {
                Animal.ELEPHANT -> "Средний вес самцов слонов ${animal.weight}кг!"
                Animal.SHARK -> "Белая акула может выростать до ${animal.height}м в длину!"
                Animal.DOG -> "Порода кангал выведена для защиты стада от нападения волков и шакалов, кангал может развивать скорость до ${animal.speed}км/ч!"
                Animal.EAGLE -> "Орел может лететь со скоростью ${animal.speed}км/ч!"
                Animal.BLACK_DOG -> "Это собака Баскервиллей, ТИКАЙ!!!"
            }
            /*if (animal == Animal.ELEPHANT) {
                "Средний вес самцов слонов ${animal.weight}кг!"
            } else if(animal == Animal.SHARK){
                "Белая акула может выростать до ${animal.height}м в длину!"
            } else if (animal == Animal.DOG) {
                "Порода кангал выведена для защиты стада от нападения волков и шакалов, кангал может развивать скорость до ${animal.speed}км/ч!"
            } else {
                "Орел может лететь со скоростью ${animal.speed}км/ч!"
            }*/
    }
}