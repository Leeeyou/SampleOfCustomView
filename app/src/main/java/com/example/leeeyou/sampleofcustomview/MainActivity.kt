package com.example.leeeyou.sampleofcustomview

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.leeeyou.sampleofcustomview.demo1.Demo1MainActivity
import com.example.leeeyou.sampleofcustomview.demo2.Demo2MainActivity
import com.example.leeeyou.sampleofcustomview.demo3.Demo3MainActivity
import com.example.leeeyou.sampleofcustomview.demo4.Demo4MainActivity
import com.example.leeeyou.sampleofcustomview.demo5.Demo5MainActivity
import com.example.leeeyou.sampleofcustomview.demo6.Demo6MainActivity
import com.example.leeeyou.sampleofcustomview.demo7.Demo7MainActivity
import com.example.leeeyou.sampleofcustomview.demo8.Demo8MainActivity
import com.example.leeeyou.sampleofcustomview.demo9.Demo9MainActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onClickDemo1(v: View) {
        startActivity(Intent(this, Demo1MainActivity::class.java))
    }

    fun onClickDemo2(v: View) {
        startActivity(Intent(this, Demo2MainActivity::class.java))
    }

    fun onClickDemo3(v: View) {
        startActivity(Intent(this, Demo3MainActivity::class.java))
    }

    fun onClickDemo4(v: View) {
        startActivity(Intent(this, Demo4MainActivity::class.java))
    }

    fun onClickDemo5(v: View) {
        startActivity(Intent(this, Demo5MainActivity::class.java))
    }

    fun onClickDemo6(v: View) {
        startActivity(Intent(this, Demo6MainActivity::class.java))
    }

    fun onClickDemo7(v: View) {
        startActivity(Intent(this, Demo7MainActivity::class.java))
    }

    fun onClickDemo8(v: View) {
        startActivity(Intent(this, Demo8MainActivity::class.java))
    }

    fun onClickDemo9(v: View) {
        startActivity(Intent(this, Demo9MainActivity::class.java))
    }
}