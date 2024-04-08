package com.example.myapplication.data

import com.example.myapplication.domain.CalculateValue
import com.example.myapplication.presenter.CalculatorOperation
import javax.inject.Inject

class CalculateValueImpl @Inject constructor()  : CalculateValue {
    override fun getValue(
        number1: Double,
        number2: Double,
        operation: CalculatorOperation?
    ): Double {
        return when(operation) {
            is CalculatorOperation.Add ->  number1 + number2
            is CalculatorOperation.Sub ->  number1 - number2
            is CalculatorOperation.Mult ->  number1 * number2
            is CalculatorOperation.Div ->  number1 / number2
            else -> { 0.00}
        }
    }

}