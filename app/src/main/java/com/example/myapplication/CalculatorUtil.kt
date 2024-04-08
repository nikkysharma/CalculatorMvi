package com.example.myapplication

object CalculatorUtil {
    fun Double.getCalValue(secondValue: Double, lamba: (first:Double, secondValue: Double) -> Double) :Double {
        return Math.round(this.getCalValue(secondValue,lamba) * 10.0) / 10.0
    }
}