package com.example.and101_p4_codemath

import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.TextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.example.and101_p4_codemath.ui.theme.And101_p4_codemathTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.actiivity_main)

        val inputEditText = findViewById<EditText>(R.id.inputEditText)
        val calculateButton = findViewById<Button>(R.id.calculateButton)
        val resultTextView = findViewById<TextView>(R.id.resultTextView)

        calculateButton.setOnClickListener {
            val input = inputEditText.text.toString()
            val result = calculateBits(input)
            resultTextView.text = result
        }
    }


    private fun calculateBits(input: String): String {
        val parts = input.split(" ")
        if (parts.size != 2) {
            return "Invalid format"
        }

        val value = parts[0].toDoubleOrNull()
        if (value == null) {
            return "Invalid input"
        }

        val unit = parts[1].toUpperCase()
        val bits = when (unit) {
            "BIT" -> value
            "BYTE" -> value * 8
            "KB" -> value * 8 * 1024
            "MB" -> value * 8 * 1024 * 1024
            "GB" -> value * 8 * 1024 * 1024 * 1024
            "TB" -> value * 8 * 1024 * 1024 * 1024 * 1024
            else -> return "Invalid unit"
        }

        return "Number of bits: $bits"
    }
}
