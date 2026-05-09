package com.example.codmweaponcatalog

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class WeaponListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        try {

            setContentView(R.layout.activity_weapon_list)

            // Log halaman dibuka
            Log.d("42230047", "WeaponListActivity berhasil dibuka")

            // Ambil kategori dari halaman sebelumnya
            val category = intent.getStringExtra("CATEGORY")

            // Log kategori yang dipilih
            Log.d("42230047", "Kategori dipilih: $category")

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

            // Log jumlah data
            Log.d("42230047", "Jumlah weapon ditemukan: ${weaponNames.size}")

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

                    // Log search
                    Log.d("42230047", "Searching: $searchText")

                    val filteredList = weaponNames.filter {
                        it.lowercase().contains(searchText)
                    }

                    // Log hasil search
                    Log.d("42230047", "Hasil search: ${filteredList.size} item")

                    rvWeapon.adapter = WeaponAdapter(filteredList)
                }
            })

            // Button Sorting
            val btnAZ = findViewById<Button>(R.id.btnAZ)
            val btnZA = findViewById<Button>(R.id.btnZA)

            // Sorting A-Z
            btnAZ.setOnClickListener {

                Log.d("42230047", "Sorting A-Z dimulai")

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

                Log.d("42230047", "Sorting A-Z selesai")
            }

            // Sorting Z-A
            btnZA.setOnClickListener {

                Log.d("42230047", "Sorting Z-A dimulai")

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

                Log.d("42230047", "Sorting Z-A selesai")
            }

        } catch (e: Exception) {

            // Log error
            Log.e("42230047", "Terjadi error: ${e.message}")

            e.printStackTrace()
        }
    }
}