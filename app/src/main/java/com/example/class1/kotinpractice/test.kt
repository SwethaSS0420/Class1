package com.example.class1.kotinpractice
import com.example.class1.Calculator
fun Calculator.div(a: Int, b: Int): Int
{
    return a / b
}
val Calculator.ans:Int get()=3

fun main()
{
    class Employee(var name: String, var age: Int, var department: String)
    var myemp: Employee = Employee("hello", 12, "bye")
    println(myemp.name)
    myemp.name = "hi"
    println(myemp.name)

    val calculator = Calculator()
    println(calculator.div(10, 2))
}