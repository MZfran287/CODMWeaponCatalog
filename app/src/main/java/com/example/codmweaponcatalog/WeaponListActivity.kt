package com.example.codmweaponcatalog

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class WeaponListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weapon_list)

        // Ambil data dari Intent
        val category = intent.getStringExtra("CATEGORY")

        val weapons = listOf(
            Pair("AK-47", "Assault Rifle"),
            Pair("M4", "Assault Rifle"),
            Pair("DR-H", "Assault Rifle"),

            Pair("QQ9", "SMG"),
            Pair("Fennec", "SMG"),
            Pair("RUS-79U", "SMG"),

            Pair("DL Q33", "Sniper"),
            Pair("Locus", "Sniper"),

            Pair("KRM-262", "Shotgun"),
            Pair("BY15", "Shotgun")
        )

        val filteredWeapons = weapons.filter {
            it.second == category
        }

        val weaponNames = filteredWeapons.map {
            it.first
        }

        val rvWeapon = findViewById<RecyclerView>(R.id.rvWeapon)

        rvWeapon.layoutManager = LinearLayoutManager(this)
        rvWeapon.adapter = WeaponAdapter(weaponNames)

        // Hubungkan ke TextView
        val tvTitle = findViewById<TextView>(R.id.tvTitleWeapon)

        // Set teks
        tvTitle.text = category
    }
}