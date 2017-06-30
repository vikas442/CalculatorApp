package com.vikas.calculatorapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var operation = ""
    var oldNumber = ""
    var isNewOperation = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onNumbersEvent(view: View) {
        if (isNewOperation) {
            etResult.setText("")
        }
        isNewOperation = false
        val btnSelected = view as Button
        var value: String = etResult.text.toString()
        when (btnSelected.id) {
            R.id.button0 -> {
                value += "0"
            }
            R.id.button1 -> {
                value += "1"
            }
            R.id.button2 -> {
                value += "2"
            }
            R.id.button3 -> {
                value += "3"
            }
            R.id.button4 -> {
                value += "4"
            }
            R.id.button5 -> {
                value += "5"
            }
            R.id.button6 -> {
                value += "6"
            }
            R.id.button7 -> {
                value += "7"
            }
            R.id.button8 -> {
                value += "8"
            }
            R.id.button9 -> {
                value += "9"
            }
            R.id.buttonDot -> {
                //Prevent adding more than one dot
                if (!value.contains("."))
                    value += "."
            }
            R.id.buttonPlusMinus -> {
                if (!value.startsWith("-"))
                    value = "-" + value
                else if (value.length > 1)
                    value = value.substring(1)
                else
                    value = ""
            }
            R.id.buttonAC -> {
                oldNumber = "0"
                isNewOperation = true
                operation = ""
                value = oldNumber
            }
        }
        etResult.setText(value)
    }

    fun onOperationEvent(view: View) {
        val btnSelected = view as Button
        when (btnSelected.id) {
            R.id.buttonMod -> {
                operation = "%"
            }
            R.id.buttonDiv -> {
                operation = "/"
            }
            R.id.buttonMul -> {
                operation = "*"
            }
            R.id.buttonSub -> {
                operation = "-"
            }
            R.id.buttonAdd -> {
                operation = "+"
            }
        }
        oldNumber = etResult.text.toString()
        isNewOperation = true
    }

    fun onEqualEvent(view: View) {
        if (!isNewOperation && oldNumber.isNotEmpty()) {
            val newNumber = etResult.text.toString()
            var finalNumber: Double? = null
            when (operation) {
                "*" -> {
                    finalNumber = oldNumber.toDouble() * newNumber.toDouble()
                }
                "/" -> {
                    finalNumber = oldNumber.toDouble() / newNumber.toDouble()
                }
                "-" -> {
                    finalNumber = oldNumber.toDouble() - newNumber.toDouble()
                }
                "+" -> {
                    finalNumber = oldNumber.toDouble() + newNumber.toDouble()
                }
                "%" -> {
                    finalNumber = oldNumber.toDouble() % newNumber.toDouble()
                }
                else -> {
                    finalNumber = newNumber.toDouble()
                }
            }
            etResult.setText(finalNumber.toString())
            isNewOperation = true
        }
    }

    fun onDelEvent(view: View) {
        if (isNewOperation) {
            etResult.setText("0")
            isNewOperation = false
        } else {
            var num = etResult.text.toString()
            if (num.length > 1)
                num = num.substring(0, num.lastIndex)
            else
                num = "0"
            etResult.setText(num)
        }
        oldNumber = etResult.text.toString()
    }
}
