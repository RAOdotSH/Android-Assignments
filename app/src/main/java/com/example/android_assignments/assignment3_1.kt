package com.example.android_assignments

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class assignment3_1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.assignmnet3_1)

        val name = getIntent().getStringExtra("username")
        findViewById<TextView>(R.id.wlcText).text = "Welcome, $name"

        val backBtn = findViewById<Button>(R.id.backbtn)
        backBtn.setOnClickListener{ back() }
    }

    private fun back(){
        val backIntent = Intent(this, assignment3::class.java)
        startActivity(backIntent)
    }
}