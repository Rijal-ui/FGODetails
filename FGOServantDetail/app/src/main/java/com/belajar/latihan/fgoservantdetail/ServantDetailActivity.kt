package com.belajar.latihan.fgoservantdetail

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import org.w3c.dom.Text

class ServantDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_servant_detail)
        val actionbar = supportActionBar
        actionbar!!.title = "Detail Servant"
        actionbar.setDisplayHomeAsUpEnabled(true)

        val tvName: TextView = findViewById(R.id.tv_name)
        val imgServant: ImageView = findViewById(R.id.img_servant)
        val tvDetail: TextView = findViewById(R.id.tv_set_detail)
        val tvBio: TextView = findViewById(R.id.tv_set_bio)

        val sName = intent.getStringExtra(EXTRA_NAME)
        val sImg = intent.getIntExtra(EXTRA_PHOTO, 0)
        val sKelas = intent.getStringExtra(EXTRA_KELAS)
        val sDetail = intent.getStringExtra(EXTRA_DETAIL)
        val sBio = intent.getStringExtra(EXTRA_BIO)

        tvName.text = sName
        Glide.with(this)
                .load(sImg)
                .apply(RequestOptions())
                .into(imgServant)
        tvDetail.text = sDetail
        tvBio.text = sBio
    }

    companion object {
        const val EXTRA_NAME ="extra_name"
        const val EXTRA_PHOTO = "extra_photo"
        const val EXTRA_KELAS = "extra_kelas"
        const val EXTRA_DETAIL = "extra_detail"
        const val EXTRA_BIO = "extra_bio"
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}