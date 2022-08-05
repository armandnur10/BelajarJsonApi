package com.example.belajarjsonapi.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.belajarjsonapi.remote.response.LambangItem
import com.example.belajarjsonapi.databinding.RowItemProvinsiBinding

class ProvinsiAdapter(private val listProvinsi : List<LambangItem>) :
    RecyclerView.Adapter<ProvinsiAdapter.MyViewHolder>() {

    inner class MyViewHolder(val binding: RowItemProvinsiBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MyViewHolder(
        RowItemProvinsiBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: ProvinsiAdapter.MyViewHolder, position: Int) {
        val data = listProvinsi[position]
        holder.binding.apply {
            tvProvinsi.text = data.title
            Glide.with(ivProvinsi.context).load(data.url).into(ivProvinsi)
        }
    }

    override fun getItemCount() = listProvinsi.size

}