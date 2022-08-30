package com.woowahan.pattern.mvc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.woowahan.pattern.databinding.ActivityMainBinding
import com.woowahan.pattern.model.DBModel

class MvcActivity : AppCompatActivity() {
    private lateinit var model: DBModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //View
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        model = DBModel()

        //Controller
        binding.btnUpdate.setOnClickListener {
            updateDB()
        }
    }

    private fun updateDB() {
        //Model
        //새로운 데이터 요청
        model.updateDB()

        //전달받은 데이터를 View 에 반영
        Toast.makeText(this, model.getDB(), Toast.LENGTH_SHORT).show()
    }
}