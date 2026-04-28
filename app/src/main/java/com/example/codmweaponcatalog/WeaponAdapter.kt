package com.example.codmweaponcatalog

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class WeaponAdapter(private val list: List<String>) :
    RecyclerView.Adapter<WeaponAdapter.ViewHolder>() {

    // ViewHolder → representasi 1 item
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvName: TextView = view.findViewById(R.id.tvWeaponName)
    }

    // Dipanggil saat bikin item baru
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_weapon, parent, false)
        return ViewHolder(view)
    }

    // Isi data ke item
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvName.text = list[position]
    }

    // Jumlah item
    override fun getItemCount(): Int = list.size
}