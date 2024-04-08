package com.example.myapplication.presenter

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.domain.CalculateValue
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.launch

import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val calculateValue: CalculateValue) : ViewModel() {

    var state by mutableStateOf(CalculatorState())
    var action = Channel<CalculatorActions>()
    init {
        viewModelScope.launch {
            action.consumeAsFlow().collect{
                when(it){
                    is CalculatorActions.Number -> enterNumber(it.number)
                    is CalculatorActions.Delete -> delete()
                    is CalculatorActions.Clear -> state = CalculatorState()
                    is CalculatorActions.Operations -> enterOperation(it.calculatorOperation)
                    is CalculatorActions.Decimal -> enterDecimal()
                    is CalculatorActions.Calculate -> calculate()
                }
            }
        }

    }

    private fun enterOperation(operation: CalculatorOperation) {
        if(state.number1.isNotBlank()) {
            state = state.copy(operation = operation)
        }
    }

    private fun calculate() {
        val number1 = state.number1.toDoubleOrNull()
        val number2 = state.number2.toDoubleOrNull()
        if(number1 != null && number2 != null) {
            val result = calculateValue.getValue(number1,number2,state.operation)
            state = state.copy(
                number1 = result.toString().take(15),
                number2 = "",
                operation = null
            )
        }
    }

    private fun delete() {
        when {
            state.number2.isNotBlank() -> state = state.copy(
                number2 = state.number2.dropLast(1)
            )
            state.operation != null -> state = state.copy(
                operation = null
            )
            state.number1.isNotBlank() -> state = state.copy(
                number1 = state.number1.dropLast(1)
            )
        }
    }

    private fun enterDecimal() {
        if(state.operation == null &&
            !state.number1.contains(".")
            && state.number1.isNotBlank()) {
            state = state.copy(
                number1 = state.number1 + "."
            )
            return
        } else if(!state.number2.contains(".") && state.number2.isNotBlank()) {
            state = state.copy(
                number2 = state.number2 + "."
            )
        }
    }

    private fun enterNumber(number: Int) {
        if(state.operation == null) {
            if(state.number1.length >= MAX_NUM_LENGTH) {
                return
            }
            state = state.copy(
                number1 = state.number1 + number
            )
            return
        }
        if(state.number2.length >= MAX_NUM_LENGTH) {
            return
        }
        state = state.copy(
            number2 = state.number2 + number
        )
    }

    companion object {
        private const val MAX_NUM_LENGTH = 8
    }
}