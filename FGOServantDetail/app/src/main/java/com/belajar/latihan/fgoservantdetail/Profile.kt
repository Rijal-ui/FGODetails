package com.belajar.latihan.fgoservantdetail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class Profile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        val actionbar = supportActionBar
        actionbar!!.title = "About"
        actionbar.setDisplayHomeAsUpEnabled(true)

        val imgMe: ImageView = findViewById(R.id.img_ku)
        val meImg = R.drawable.me

        Glide.with(this)
            .load(meImg)
            .apply(RequestOptions())
            .into(imgMe)
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}