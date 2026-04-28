package com.example.codmweaponcatalog

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.content.Intent

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rvCategory = findViewById<RecyclerView>(R.id.rvCategory)

        val categories = listOf(
            "Assault Rifle",
            "SMG",
            "Sniper",
            "Shotgun",
            "LMG",
            "Pistol"
        )

        rvCategory.layoutManager = LinearLayoutManager(this)
        rvCategory.adapter = CategoryAdapter(categories) { selectedCategory ->

            val intent = Intent(this, WeaponListActivity::class.java)
            intent.putExtra("CATEGORY", selectedCategory)
            startActivity(intent)

        }
    }
}