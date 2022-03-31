package com.example.android_assignments

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import com.example.android_assignments.databinding.Assignemnt51Binding
import kotlin.math.roundToInt

class Assignemnt5_1 : AppCompatActivity() {

    private  lateinit var mBinding: Assignemnt51Binding

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = Assignemnt51Binding.inflate(layoutInflater)
        setContentView(mBinding.root)

        // Three text views
        var displayBMI : TextView ? = null
        var categoryBMI : TextView ? = null
        var gender : TextView ? = null

        // Intent
        var intent : Intent ? = null

        // Image view to display the image
        var img : ImageView ? = null

        // String
        var stringBMI : String ? = null

        // bmi in double
        var doubleBMI : Double ? = null

        // string height, weight
        var stringHeight : String ? = null
        var stringWeight : String ? = null

        // height, weight in double
        var doubleHeight : Double ? = null
        var doubleWeight : Double ? = null

        // Relative layout
        var background : RelativeLayout ? = null


        // Get the intent
        intent = getIntent()

        // Get the height and weight from the intent and convert them to double
        stringHeight = intent!!.getStringExtra("height")
        stringWeight = intent.getStringExtra("weight")

        doubleHeight = stringHeight!!.toDouble()/100
        doubleWeight = stringWeight!!.toDouble()

        // Calculate the BMI
        doubleBMI = doubleWeight / (doubleHeight * doubleHeight)

        // Round the BMI to 2 decimal places
        doubleBMI = (doubleBMI * 100.0).roundToInt() / 100.0

        // Convert the BMI to string
        stringBMI = doubleBMI.toString()

        // Get the display, category and
        displayBMI = mBinding.resultTextValue
        categoryBMI = mBinding.bmiCategory

        // Set the display
        displayBMI.text = stringBMI

        // Get the image view
        img = mBinding.resultImg

        // Get the background layout
        background = mBinding.resultBackground

        // Setting the bmi category
        if (doubleBMI < 18.5) {
            categoryBMI.text = "Underweight"
            img.setImageResource(R.drawable.icons8_warning_button)
        }
        else if (doubleBMI >= 18.5 && doubleBMI < 25) {
            categoryBMI.text = "Normal"
            img.setImageResource(R.drawable.icons8_check_mark_button)
        }
        else if (doubleBMI >= 25 && doubleBMI < 30) {
            categoryBMI.text = "Overweight"
            img.setImageResource(R.drawable.icons8_warning_button)
        }
        else {
            categoryBMI.text = "Obese"
            img.setImageResource(R.drawable.icons8_cross_mark_button)
        }

        // Get and set the gender
        gender = mBinding.gender
        gender.text = intent.getStringExtra("gender")

        // Re-calculate button i.e. back button
        mBinding.recalculateBTN.setOnClickListener(){
            val backIntent = Intent(this, Assignment5::class.java)
            startActivity(backIntent)
        }

    }
}
