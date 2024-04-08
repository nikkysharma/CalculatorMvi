package com.example.myapplication.presenter

sealed class CalculatorOperation(val symbol :String) {
    data object Add: CalculatorOperation("+")
    data object Sub: CalculatorOperation("-")
    data object Mult: CalculatorOperation("*")
    data object Div: CalculatorOperation("/")
}