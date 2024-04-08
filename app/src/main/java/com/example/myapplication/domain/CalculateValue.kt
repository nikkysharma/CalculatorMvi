package com.example.myapplication.domain

import com.example.myapplication.presenter.CalculatorOperation

interface CalculateValue {
    fun getValue(first: Double, secondValue: Double, operation: CalculatorOperation?):Double
}