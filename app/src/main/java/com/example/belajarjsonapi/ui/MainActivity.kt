package com.example.belajarjsonapi.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.belajarjsonapi.remote.response.LambangItem
import com.example.belajarjsonapi.R
import com.example.belajarjsonapi.adapter.ProvinsiAdapter
import com.example.belajarjsonapi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding as ActivityMainBinding

    private var _viewModel: MainViewModel? = null
    private val viewModel get() = _viewModel as MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        _viewModel = ViewModelProvider(this@MainActivity).get(MainViewModel::class.java)

        viewModel.apply {
            getDataProvinsi()
            lambangItem.observe(this@MainActivity) {showData(it)}
            isLoading.observe(this@MainActivity) { showLoading(it) }
            isError.observe(this@MainActivity) { showError(it) }
        }
    }

    private fun showError(e: Throwable?) {
        Log.e("ERROR", "showError: $e", )
    }

    private fun showData(data: List<LambangItem>) {
        binding.apply {
            rvProvinsi.layoutManager = LinearLayoutManager(this@MainActivity)
            rvProvinsi.adapter = ProvinsiAdapter(data)
        }
    }


    private fun showLoading(isLoading : Boolean?) {
        if (isLoading == true){
            binding.rvProvinsi.visibility = View.INVISIBLE
            binding.progressMain.visibility = View.VISIBLE
        } else {
            binding.rvProvinsi.visibility = View.VISIBLE
            binding.progressMain.visibility = View.INVISIBLE
        }
    }

}