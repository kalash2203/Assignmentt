package com.example.assignmentt.presentation.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.assignmentt.databinding.ActivityMainBinding
import com.example.assignmentt.presentation.adapter.DataListAdapter
import com.example.assignmentt.presentation.viewmodel.DataViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private var binding : ActivityMainBinding? = null
    private lateinit var dataAdapter: DataListAdapter
    private val dataViewModel: DataViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding!!.root)
binding!!.progressBar.visibility=View.VISIBLE
        dataViewModel.getMemes()

        binding?.refreshBtn?.setOnClickListener {
            binding!!.progressBar.visibility=View.VISIBLE
            dataViewModel.getMemes()
        }
        dataViewModel.postLiveData.observe(this) {
            binding!!.progressBar.visibility=View.GONE
            dataAdapter = DataListAdapter(it,this)
            binding!!.rvData.apply {
                adapter = dataAdapter
                layoutManager = LinearLayoutManager(this@MainActivity)
            }
        }
    }
}