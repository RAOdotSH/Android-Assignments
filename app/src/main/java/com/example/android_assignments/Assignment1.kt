package com.example.android_assignments

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Assignment1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.assignment1)

        val button1 = findViewById<Button>(R.id.createBTN)
        button1.setOnClickListener{ displayName() }

        val button2 = findViewById<Button>(R.id.createBTN2)
        button2.setOnClickListener{ toastName() }
    }

    private fun displayName(){
        val name = findViewById<EditText>(R.id.inputText).text.toString()
        findViewById<TextView>(R.id.displayText).text = "Hey, $name!"
    }

    private fun toastName(){
        findViewById<TextView>(R.id.displayText).text = ""

        val name = findViewById<EditText>(R.id.inputText).text.toString()
        Toast.makeText(applicationContext, "Hey, $name!", Toast.LENGTH_LONG).show()
    }
}