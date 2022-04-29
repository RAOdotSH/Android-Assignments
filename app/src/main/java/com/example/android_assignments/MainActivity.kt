package com.example.android_assignments

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val assignment1btn = findViewById<Button>(R.id.Assignment1)
        assignment1btn.setOnClickListener{ assignment1() }

        val assignment2btn = findViewById<Button>(R.id.Assignment2)
        assignment2btn.setOnClickListener{ assignment2() }

        val assignment3btn = findViewById<Button>(R.id.Assignment3)
        assignment3btn.setOnClickListener{ assignment3() }

        val assignment4btn = findViewById<Button>(R.id.Assignment4)
        assignment4btn.setOnClickListener{ assignment4() }

        val assignment5btn = findViewById<Button>(R.id.Assignment5)
        assignment5btn.setOnClickListener{ assignment5() }

        val assignment7_8btn = findViewById<Button>(R.id.Assignment7And8)
        assignment7_8btn.setOnClickListener{ assignment7_8() }
    }

    private fun assignment1() {
        val intent1 = Intent(this, Assignment1::class.java)
        startActivity(intent1)
    }

    private fun assignment2() {
        val intent2 = Intent(this, Assignment2::class.java)
        startActivity(intent2)
    }

    private fun assignment3(){
        val intent3 = Intent(this, assignment3::class.java)
        startActivity(intent3)
    }

    private fun assignment4(){
        val intent4 = Intent(this, Assignment4::class.java)
        startActivity(intent4)
    }

    private fun assignment5(){
        val intent5 = Intent(this, Assignment5::class.java)
        startActivity(intent5)
    }

    private fun assignment7_8(){
        val intent7_8 = Intent(this, Assignment7_8::class.java)
        startActivity(intent7_8)
    }
}