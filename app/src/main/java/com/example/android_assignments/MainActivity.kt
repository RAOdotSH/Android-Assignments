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

}