package com.example.android_assignments

import android.app.Activity
import android.content.Context
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBindings
import com.bumptech.glide.Glide
import com.bumptech.glide.GlideExperiments
import de.hdodenhof.circleimageview.CircleImageView
import org.w3c.dom.Text
import java.security.AccessControlContext

class MyAdapter(private var infoList: ArrayList<User>, var context: Context) : RecyclerView.Adapter<MyAdapter.myViewHolder>() {

    class myViewHolder(view: View) : RecyclerView.ViewHolder(view){
        var imgView = view.findViewById<CircleImageView>(R.id.profile_pic)

        var username = view.findViewById<TextView>(R.id.person_name)

        var mobileNum = view.findViewById<TextView>(R.id.mobile_num)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
        return myViewHolder(LayoutInflater.from(context).inflate(R.layout.list_item, parent, false))
    }

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {
        var model = infoList[position]

        holder.username.text = model.Fname
        holder.mobileNum.text = model.mobNo

        Glide.with(context)
            .load(model.imageLink)
            .fitCenter()
            .circleCrop()
            .into(holder.imgView)
    }

    override fun getItemCount(): Int {
        return infoList.size
    }


}