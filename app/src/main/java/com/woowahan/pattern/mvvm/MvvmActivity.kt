package com.woowahan.pattern.mvvm

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.woowahan.pattern.databinding.ActivityMainBinding
import com.woowahan.pattern.mvvm.viewmodel.MainViewModel

class MvvmActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val factory = viewModelFactory {
        initializer {
            MainViewModel()
        }
    }
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this, factory)[MainViewModel::class.java]

        //View
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnUpdate.setOnClickListener {
            viewModel.updateDB()
        }

        viewModel.queriedDB.observe(this) {
            //ViewModel 에서 데이터 반영
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        }
    }
}