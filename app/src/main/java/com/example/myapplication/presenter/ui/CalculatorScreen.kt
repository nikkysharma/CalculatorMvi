package com.example.myapplication.presenter.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.presenter.CalculatorActions
import com.example.myapplication.presenter.CalculatorOperation
import com.example.myapplication.presenter.MainViewModel
import com.example.myapplication.ui.theme.CalculatorPrepTheme
import com.example.myapplication.ui.theme.LightGray
import com.example.myapplication.ui.theme.MediumGray
import com.example.myapplication.ui.theme.Orange


@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun GetCalculatorScreen(viewModel :MainViewModel,onClick: (type:CalculatorActions)->Unit){
    CalculatorPrepTheme {
        val state = viewModel.state
        val buttonSpacing = 8.dp
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(16.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter),
                verticalArrangement = Arrangement.spacedBy(buttonSpacing),
            ) {
                Text(
                    text = state.number1 + (state.operation?.symbol
                        ?: "|") + state.number2,
                    textAlign = TextAlign.End,

                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 32.dp)
                        ,
                    fontWeight = FontWeight.Light,
                    fontSize = 80.sp,
                    color = Color.Black,
                    maxLines = 2,

                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
                ) {
                    CalculatorButton(
                        symbol = "AC",
                        color = LightGray,
                        modifier = Modifier
                            .aspectRatio(2f)
                            .weight(2f)
                    ) {
                       onClick(CalculatorActions.Clear)
                    }
                    CalculatorButton(
                        symbol = "Del",
                        color = LightGray,
                        modifier = Modifier
                            .aspectRatio(1f)
                            .weight(1f)
                    ) {
                        onClick(CalculatorActions.Delete)
                    }
                    CalculatorButton(
                        symbol = "/",
                        color = Orange,
                        modifier = Modifier
                            .aspectRatio(1f)
                            .weight(1f)
                    ) {
                        onClick( CalculatorActions.Operations(
                            CalculatorOperation.Div
                        ))

                    }
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
                ) {
                    CalculatorButton(
                        symbol = "7",
                        color = MediumGray,
                        modifier = Modifier
                            .aspectRatio(1f)
                            .weight(1f)
                    ) {
                        onClick(CalculatorActions.Number(7))
                    }
                    CalculatorButton(
                        symbol = "8",
                        color = MediumGray,
                        modifier = Modifier
                            .aspectRatio(1f)
                            .weight(1f)
                    ) {
                        onClick(CalculatorActions.Number(8))
                    }
                    CalculatorButton(
                        symbol = "9",
                        color = MediumGray,
                        modifier = Modifier
                            .aspectRatio(1f)
                            .weight(1f)
                    ) {
                        onClick(CalculatorActions.Number(9))
                    }
                    CalculatorButton(
                        symbol = "x",
                        color = Orange,
                        modifier = Modifier
                            .aspectRatio(1f)
                            .weight(1f)
                    ) {
                        onClick(
                            CalculatorActions.Operations(
                                CalculatorOperation.Mult
                            )
                        )
                    }
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
                ) {
                    CalculatorButton(
                        symbol = "4",
                        color = MediumGray,
                        modifier = Modifier
                            .aspectRatio(1f)
                            .weight(1f)
                    ) {
                        onClick(CalculatorActions.Number(4))
                    }
                    CalculatorButton(
                        symbol = "5",
                        color = MediumGray,
                        modifier = Modifier
                            .aspectRatio(1f)
                            .weight(1f)
                    ) {
                        onClick(CalculatorActions.Number(5))
                    }
                    CalculatorButton(
                        symbol = "6",
                        color = MediumGray,
                        modifier = Modifier
                            .aspectRatio(1f)
                            .weight(1f)
                    ) {
                        onClick(CalculatorActions.Number(6))
                    }
                    CalculatorButton(
                        symbol = "-",
                        color = Orange,
                        modifier = Modifier
                            .aspectRatio(1f)
                            .weight(1f)
                    ) {
                        onClick(
                            CalculatorActions.Operations(
                                CalculatorOperation.Sub
                            )
                        )
                    }
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
                ) {
                    CalculatorButton(
                        symbol = "1",
                        color = MediumGray,
                        modifier = Modifier
                            .aspectRatio(1f)
                            .weight(1f)
                    ) {
                        onClick(CalculatorActions.Number(1))
                    }
                    CalculatorButton(
                        symbol = "2",
                        color = MediumGray,
                        modifier = Modifier
                            .aspectRatio(1f)
                            .weight(1f)
                    ) {
                        onClick(CalculatorActions.Number(2))
                    }
                    CalculatorButton(
                        symbol = "3",
                        color = MediumGray,
                        modifier = Modifier
                            .aspectRatio(1f)
                            .weight(1f)
                    ) {
                        onClick(CalculatorActions.Number(3))
                    }
                    CalculatorButton(
                        symbol = "+",
                        color = Orange,
                        modifier = Modifier
                            .aspectRatio(1f)
                            .weight(1f)
                    ) {
                        onClick(
                            CalculatorActions.Operations(
                                CalculatorOperation.Add
                            )
                        )
                    }
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
                ) {
                    CalculatorButton(
                        symbol = "0",
                        color = MediumGray,
                        modifier = Modifier
                            .aspectRatio(2f)
                            .weight(2f)
                    ) {
                        onClick(CalculatorActions.Number(0))
                    }
                    CalculatorButton(
                        symbol = ".",
                        color = MediumGray,
                        modifier = Modifier
                            .aspectRatio(1f)
                            .weight(1f)
                    ) {
                        onClick(CalculatorActions.Decimal)
                    }
                    CalculatorButton(
                        symbol = "=",
                        color = Orange,
                        modifier = Modifier
                            .aspectRatio(1f)
                            .weight(1f)
                    ) {
                        onClick(CalculatorActions.Calculate)
                    }
                }
            }
        }
    }
}