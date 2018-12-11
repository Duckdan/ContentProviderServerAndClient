package com.study.yang.contentproviderclientdemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class JumpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jump)
    }

    override fun onDestroy() {
        super.onDestroy()
        println("=========我被进程杀死了.....")
    }
}
