package com.example.android_assignments

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.graphics.Bitmap
import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import android.widget.*
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar

class Assignment2 : AppCompatActivity() {
    var displayImage : ImageView? = null
    companion object{
        val IMAGE_REQUEST_CODE = 1_000;
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.assignment2)

        displayImage = findViewById(R.id.uploadImage)

        val uploadButton = findViewById<Button>(R.id.btn_upload)
        uploadButton.setOnClickListener(){ uploadImageFromGallery() }

        val convertButton = findViewById<Button>(R.id.btn_convert)
        convertButton.setOnClickListener(){ conversion() }
    }

    private fun conversion() {
        val usd = findViewById<EditText>(R.id.input_text).text.toString().toInt()

        val rupees = usd*75

        val displayConversion = findViewById<TextView>(R.id.converted)

        displayConversion.text = rupees.toString()

        val snack = Snackbar.make(displayConversion, rupees.toString(), Snackbar.LENGTH_LONG)

        snack.view.setBackgroundColor(ContextCompat.getColor(this, R.color.teal_700))
        snack.show()
    }

    private fun uploadImageFromGallery() {
        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        startActivityForResult(intent, IMAGE_REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == IMAGE_REQUEST_CODE){
            if(resultCode == Activity.RESULT_OK){
                val image_uri = data?.data

                Glide.with(this)
                    .load(image_uri)
                    .fitCenter()
                    .circleCrop()
                    .placeholder(R.drawable.uploadicon)
                    .into(displayImage!!)
            }
        }
    }

}