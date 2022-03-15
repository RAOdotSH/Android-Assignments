package com.example.android_assignments

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import com.example.android_assignments.databinding.ActivityMainBinding
import com.example.android_assignments.databinding.Assignment1Binding
import com.example.android_assignments.databinding.Assignment4Binding
import org.json.JSONArray

class Assignment4 : AppCompatActivity() {

    private lateinit var mBinding: Assignment4Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = Assignment4Binding.inflate(layoutInflater)
        setContentView(mBinding.root)

        getData()

    }

    fun getData(){
        val listOfUser = ArrayList<User>()
        val apiReq = JsonArrayRequest("https://random-data-api.com/api/users/random_user?size=10", {
            for(i in 0 until it.length()){
                val obj = it.getJSONObject(i)

                val fname = obj.getString("first_name")
                val lname = obj.getString("last_name")
                val email = obj.getString("email")
                val mobNum = obj.getString("phone_number")
                val imgLink = obj.getString("avatar")


                listOfUser.add(User(fname, lname, email, mobNum, imgLink))

//                Toast.makeText(this, fname, Toast.LENGTH_LONG).show()
            }
            val adapter = MyAdapter(listOfUser, this)
            mBinding.rv.layoutManager = LinearLayoutManager(this)

            mBinding.rv.adapter = adapter

        }, {

        })

        val queue = Volley.newRequestQueue(this)
        queue.add(apiReq)

    }

}