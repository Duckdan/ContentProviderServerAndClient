package com.study.yang.contentproviderclientdemo

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.view.View
import com.study.yang.contentproviderclientdemo.handler.MyAsyncQueryHandler
import com.study.yang.contentproviderclientdemo.observer.DefineContentObserver
import com.study.yang.contentproviderclientdemo.observer.DefineDataSetObserver
import com.study.yang.contentproviderserverdemo.adapter.MyCursorAdapter
import kotlinx.android.synthetic.main.activity_user_list.*

class UserListActivity : AppCompatActivity() {

    var handler = object : Handler() {
        override fun handleMessage(msg: Message?) {
            super.handleMessage(msg)
          //  reallyQuery()  //当数据更新重新查询数据
        }
    }
    lateinit var defineContentObserver: DefineContentObserver
    var cursorAdapter: MyCursorAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_list)
        var uri: Uri = Uri.parse("content://com.study.user.provider/user")
        defineContentObserver = DefineContentObserver(handler)
        /**
         * 针对相应的uri添加内容观察者，true代表这个观察将会观察uri及其子层级的数据
          */
        contentResolver.registerContentObserver(uri, true, defineContentObserver)
    }

    fun jumpActivity(view: View) {
        var intent = Intent(this, JumpActivity::class.java)
        startActivity(intent)
    }

    fun queryUser(view: View) {
        var maqh = MyAsyncQueryHandler(contentResolver)
        var uri = Uri.parse("content://com.study.user.provider/user")
        var cursorAdapter = MyCursorAdapter(this, null)

        lv.adapter = cursorAdapter

        maqh.startQuery(88, cursorAdapter, uri, null, null, null, null)

//     reallyQuery()
    }

    private fun reallyQuery() {
        var uri = Uri.parse("content://com.study.user.provider/user/query")
        val cursor = contentResolver.query(uri, null, null, null, null)
        if (cursorAdapter == null) {
            cursorAdapter = MyCursorAdapter(this, cursor)
            lv.adapter = cursorAdapter
        } else {
            cursorAdapter?.swapCursor(cursor)
        }
    }


}
