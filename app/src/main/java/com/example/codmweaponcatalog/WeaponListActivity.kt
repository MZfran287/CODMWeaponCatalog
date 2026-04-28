package com.example.codmweaponcatalog

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class WeaponListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weapon_list)

        // Ambil data dari Intent
        val category = intent.getStringExtra("CATEGORY")

        // Hubungkan ke TextView
        val tvTitle = findViewById<TextView>(R.id.tvTitleWeapon)

        // Set teks
        tvTitle.text = category
    }
}