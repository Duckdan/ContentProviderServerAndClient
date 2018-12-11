package com.study.yang.contentproviderclientdemo.observer


import android.database.ContentObserver
import android.net.Uri
import android.os.Handler

class DefineContentObserver(handler: Handler) : ContentObserver(handler) {
    var handler=handler


    /**
     * 当内容发生变化
     */
    override fun onChange(selfChange: Boolean) {
        onChange(selfChange, null)
    }

    /**
     *
     */
    override fun onChange(selfChange: Boolean, uri: Uri?) {
        handler.sendEmptyMessage(1)
    }
}