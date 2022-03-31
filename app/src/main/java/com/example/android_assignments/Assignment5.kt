package com.example.android_assignments

import android.content.Intent
import android.graphics.drawable.Drawable
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.*
import androidx.core.content.res.ResourcesCompat
import androidx.core.widget.addTextChangedListener
import com.example.android_assignments.databinding.Assignment5Binding
import org.w3c.dom.Text

class Assignment5 : AppCompatActivity() {

    private lateinit var mBinding: Assignment5Binding

    // Height vars
    var currProgressHeight : Int ? = 0
    var progressHeightString : String = "0"

    // Weight vars
    var currProgressWeight : Int ? = 0
    var progressWeightString : String = "0"

    var userType : String = "0"

    // Age Vars
    var age : Int  = 1
    var ageString : String = "1"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = Assignment5Binding.inflate(layoutInflater)
        setContentView(mBinding.root)

        // Calculate button
        mBinding.calculateBTN.setOnClickListener { calculateBMI() }

        // Current Height
        var currHeight : TextView ? = null
        currHeight = findViewById(R.id.curr_height)

        // Current Weight
        var currWeight : TextView ? = null
        currWeight = findViewById(R.id.curr_weight)

        // Current Age
        var currAge : TextView ? = null
        currAge = findViewById(R.id.curr_age)

        // Increase Age
        var incAge : ImageView ? = null
        incAge = findViewById(R.id.plus_age)

        // Decrese Age
        var decAge : ImageView ? = null
        decAge = findViewById(R.id.minus_age)

        // SeekBar of Height
        var heightBar : SeekBar ? = null
        heightBar = findViewById(R.id.height_bar)

        // SeekBar of weight
        var weightBar : SeekBar ? = null
        weightBar = findViewById(R.id.weight_bar)

        // Male icon layout
        var maleLayout : RelativeLayout ? = null
        maleLayout = findViewById(R.id.male)

        // Female icon layout
        var femaleLayout : RelativeLayout ? = null
        femaleLayout = findViewById(R.id.female)

        // Height edit text
        val heightEditText = mBinding.currHeight

        // Weight edit text
        var weightEditText = mBinding.currWeight

        maleLayout.setOnClickListener {
            maleLayout.background = ResourcesCompat.getDrawable(resources, R.drawable.male_female_focus, null)
            femaleLayout.background = ResourcesCompat.getDrawable(resources, R.drawable.male_female_normal, null)

            mBinding.textMale.setTextColor(resources.getColor(R.color.dark_blue))
            mBinding.textFemale.setTextColor(resources.getColor(R.color.pink))

            userType = "MALE"
        }

        femaleLayout.setOnClickListener {
            femaleLayout.background = ResourcesCompat.getDrawable(resources, R.drawable.male_female_focus, null)
            maleLayout.background = ResourcesCompat.getDrawable(resources, R.drawable.male_female_normal, null)

            mBinding.textFemale.setTextColor(resources.getColor(R.color.dark_blue))
            mBinding.textMale.setTextColor(resources.getColor(R.color.pink))

            userType = "FEMALE"
        }

        // setting max limit
        heightBar.max = 300
        // set the default value of seek bar
        heightBar.progress = 0

        // Height Seekbar working
        heightBar?.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                currProgressHeight = progress
                progressHeightString = currProgressHeight.toString()

                currHeight.text = progressHeightString

            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
            }

        })

        // setting max limit
        weightBar.max = 300
        // set the default value of seek bar
        weightBar.progress = 0

        // Weight SeekBar working
        weightBar?.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                currProgressWeight = progress
                progressWeightString = currProgressWeight.toString()

                currWeight.text = progressWeightString
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }

        })

        incAge.setOnClickListener {
            age += 1
            ageString = age.toString()

            currAge.text = ageString
        }

        decAge.setOnClickListener {
            age -= 1
            ageString = age.toString()

            currAge.text = ageString
        }
    }

    private fun calculateBMI(){
        if (userType == "0") Toast.makeText(this, "Select your Gender first", Toast.LENGTH_SHORT).show()

        else if(progressHeightString == "0") Toast.makeText(this, "Check your Height! \nHeight can't be zero", Toast.LENGTH_SHORT).show()

        else if(progressWeightString == "0") Toast.makeText(this, "Check your Weight! \nWeight can't be zero", Toast.LENGTH_SHORT).show()

        else if(age <= 0) Toast.makeText(this, "Check your Age! \nAge can't be negative or zero", Toast.LENGTH_SHORT).show()

        else{
            val intent5_1 = Intent(this, Assignemnt5_1::class.java)
            intent5_1.putExtra("gender", userType)
            intent5_1.putExtra("height", progressHeightString)
            intent5_1.putExtra("weight", progressWeightString)
            intent5_1.putExtra("age", ageString)

            startActivity(intent5_1)
        }
    }
}
