package com.study.yang.contentproviderclientdemo.handler

import android.content.AsyncQueryHandler
import android.content.ContentResolver
import android.database.Cursor
import com.study.yang.contentproviderserverdemo.adapter.MyCursorAdapter

class MyAsyncQueryHandler(cr: ContentResolver) : AsyncQueryHandler(cr) {

    /**
     * 当查询完成之后，自动调用该方法
     */
    override fun onQueryComplete(token: Int, cookie: Any?, cursor: Cursor?) {
        super.onQueryComplete(token, cookie, cursor)
        //判断当前的cookie类型是否是MyCursorAdapter
        if (cookie is MyCursorAdapter) {
            var cursorAdapter = cookie
            cursorAdapter.changeCursor(cursor)
            println(cursor)
        }
    }
}