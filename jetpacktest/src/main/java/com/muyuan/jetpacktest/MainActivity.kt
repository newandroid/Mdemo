package com.muyuan.jetpacktest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.muyuan.jetpacktest.databinding.ActivityDatabindingMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var user: User
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        val binding: ActivityDatabindingMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_databinding_main)
        user = User(30, "shaoshuai")
        binding.user = user
        binding.hand = MyHandlers()
    }

    fun change(view: View) {
        user.name = "feitian"
    }

    class MyHandlers {
        fun onClickFriend(view: View) {
            println("onClickFriend")
        }
    }
}
