package com.example.android_assignments

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class assignment3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.assignment3)

        val SubmitButton = findViewById<Button>(R.id.submitbtn)
        SubmitButton.setOnClickListener{ submit() }
    }

    private fun submit(){
        val name = findViewById<EditText>(R.id.usrID).text.toString()

        val intent = Intent(this, assignment3_1::class.java)
        intent.putExtra("username", name)
        startActivity(intent)
    }
}