package com.woowahan.pattern.mvp.presenter.main

import com.woowahan.pattern.model.DBModel
import com.woowahan.pattern.mvp.presenter.base.Presenter

class MainPresenter(private val view: View): Presenter {
    private lateinit var model: DBModel

    override fun onCreate() { model = DBModel() }

    fun updateDB() {
        //Model
        model.updateDB()

        //새로운 데이터 반영
        view.showToast(model.getDB())
    }

    interface View {
        fun showToast(db: String)
    }
}