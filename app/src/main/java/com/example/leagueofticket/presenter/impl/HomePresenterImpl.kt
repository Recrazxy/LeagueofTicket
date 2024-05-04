package com.example.leagueofticket.presenter.impl

import android.util.Log
import com.example.leagueofticket.model.domain.Categories
import com.example.leagueofticket.presenter.IHomePresenter
import com.example.leagueofticket.view.IHomeCallback
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import com.example.leagueofticket.utils.RetrofitManager
import java.net.HttpURLConnection

class HomePresenterImpl : IHomePresenter {
    private var callback_: IHomeCallback? = null

    override fun getCatergories() {
        callback_?.onLoading()
        val api = RetrofitManager.instance?.getApi()
//        val api = retrofit.create(Api::class.java)
        val task = api?.getCatergories()
        task?.enqueue(object : Callback<Categories> {
            override fun onResponse(call: Call<Categories>, response: Response<Categories>) {
                // 数据结果
                val code = response.code()
                Log.d("HomePresenterImpl", "result code is -> $code")
                if (code == HttpURLConnection.HTTP_OK) {
                    val categories = response.body()
                    Log.d("HomePresenterImpl", "data is -> ${categories.toString()}")
                    // 通知UI更新
                    if (categories == null || categories.data.isEmpty()) {
                        callback_?.onEmpty()
                    } else {
                        callback_?.onCatergoriesLoaded(categories)

                    }
                } else {
                    Log.i("HomePresenterImpl", "请求失败, code -> $code")
                    callback_?.onNetworkError()
                }
            }

            override fun onFailure(call: Call<Categories>, t: Throwable) {
                // 加载失败结果
                Log.e("HomePresenterImpl", "请求错误, error -> ${t.message}")
                callback_?.onNetworkError()
            }
        })
    }

    override fun registerCallback(callback: IHomeCallback) {
//         TODO("Not yet implemented")
        this.callback_ = callback
    }

    override fun unregisterCallback(callback: IHomeCallback) {
//         TODO("Not yet implemented")
        this.callback_ = null
    }

}