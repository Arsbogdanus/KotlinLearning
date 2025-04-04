package com.brz.kotlinlearning

interface Expr
class Num(val value: Int) : Expr
class Sum(val left: Expr, val right: Expr) : Expr // Аргументами операции Sum могут быть любые экземпляры Expr:
                                                  // Num или другой объект Sum