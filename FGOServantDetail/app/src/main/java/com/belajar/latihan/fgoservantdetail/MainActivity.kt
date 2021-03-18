package com.belajar.latihan.fgoservantdetail

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvServant: RecyclerView
    private var list: ArrayList<Servant> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val actionbar = supportActionBar
        actionbar!!.title= "Servant List"

        rvServant = findViewById(R.id.rv_servant)
        rvServant.setHasFixedSize(true)

        list.addAll(ServantData.listServant)
        showRecyclerList()
    }
    private fun showRecyclerList() {
        rvServant.layoutManager = LinearLayoutManager(this)
        val listServantAdapter = ListServantAdapter(list)
        rvServant.adapter = listServantAdapter
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.profile_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }
    private fun setMode(selectedMode: Int) {
        when (selectedMode) {
            R.id.myProfile -> {
                val iProfile = Intent(this@MainActivity, Profile::class.java)
                startActivity(iProfile)
            }
        }
    }

}