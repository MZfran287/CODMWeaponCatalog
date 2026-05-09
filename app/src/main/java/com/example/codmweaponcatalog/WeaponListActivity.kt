package com.example.codmweaponcatalog

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class WeaponListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weapon_list)

        // Ambil kategori dari halaman sebelumnya
        val category = intent.getStringExtra("CATEGORY")

        // Judul halaman
        val tvTitle = findViewById<TextView>(R.id.tvTitleWeapon)
        tvTitle.text = category

        // Data senjata
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

        // Filter sesuai kategori
        val filteredWeapons = weapons.filter {
            it.second == category
        }

        // Ambil nama senjata
        var weaponNames = filteredWeapons.map {
            it.first
        }.toMutableList()

        // RecyclerView
        val rvWeapon = findViewById<RecyclerView>(R.id.rvWeapon)

        rvWeapon.layoutManager = LinearLayoutManager(this)
        rvWeapon.adapter = WeaponAdapter(weaponNames)

        // Search Bar
        val etSearch = findViewById<EditText>(R.id.etSearch)

        etSearch.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable?) {}

            override fun beforeTextChanged(
                s: CharSequence?,
                start: Int,
                count: Int,
                after: Int
            ) {}

            override fun onTextChanged(
                s: CharSequence?,
                start: Int,
                before: Int,
                count: Int
            ) {

                val searchText = s.toString().lowercase()

                val filteredList = weaponNames.filter {
                    it.lowercase().contains(searchText)
                }

                rvWeapon.adapter = WeaponAdapter(filteredList)
            }
        })

        // Button Sorting
        val btnAZ = findViewById<Button>(R.id.btnAZ)
        val btnZA = findViewById<Button>(R.id.btnZA)

        // Sorting A-Z
        btnAZ.setOnClickListener {

            for (i in 0 until weaponNames.size) {
                for (j in 0 until weaponNames.size - i - 1) {

                    if (weaponNames[j] > weaponNames[j + 1]) {

                        val temp = weaponNames[j]
                        weaponNames[j] = weaponNames[j + 1]
                        weaponNames[j + 1] = temp
                    }
                }
            }

            rvWeapon.adapter = WeaponAdapter(weaponNames)
        }

        // Sorting Z-A
        btnZA.setOnClickListener {

            for (i in 0 until weaponNames.size) {
                for (j in 0 until weaponNames.size - i - 1) {

                    if (weaponNames[j] < weaponNames[j + 1]) {

                        val temp = weaponNames[j]
                        weaponNames[j] = weaponNames[j + 1]
                        weaponNames[j + 1] = temp
                    }
                }
            }

            rvWeapon.adapter = WeaponAdapter(weaponNames)
        }
    }
}