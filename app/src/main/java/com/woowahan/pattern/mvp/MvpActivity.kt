package com.woowahan.pattern.mvp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.woowahan.pattern.databinding.ActivityMainBinding
import com.woowahan.pattern.mvp.presenter.main.MainPresenter

class MvpActivity : AppCompatActivity(), MainPresenter.View {
    private val presenter = MainPresenter(this)
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Presenter 초기화
        presenter.onCreate()

        //View
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnUpdate.setOnClickListener {
            //Presenter 에 수정 요청
            presenter.updateDB()
        }
    }

    override fun showToast(db: String) {
        //Presenter 에서 데이터 반영
        Toast.makeText(this, db, Toast.LENGTH_SHORT).show()
    }
}