package com.study.yang.contentproviderserverdemo

import android.content.ContentValues
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CursorAdapter
import com.study.yang.contentproviderserverdemo.adapter.MyCursorAdapter
import kotlinx.android.synthetic.main.activity_add_object.*

class AddObjectActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_object)
    }

    fun addUser(view: View) {
        val name = et_name.text.toString().trim()
        val age = et_age.text.toString().trim()
        val description = et_description.text.toString().trim()

        var uri = Uri.parse("content://com.study.user.provider/user")
        var values = ContentValues()
        values.put("name", name)
        values.put("age", age)
        values.put("description", description)
        contentResolver.insert(uri, values)
    }

    fun queryUser(view: View) {
        var uri = Uri.parse("content://com.study.user.provider/user")
        //cursor不能关闭，一旦关闭CursorAdapter自动更新时将会报错
        //此处传入的uri及其子层级的uri发生变动的时候都会被更新
        val cursor = contentResolver.query(uri, null, null, null, null)
        var cursorAdapter = MyCursorAdapter(this, cursor)
        lv.adapter = cursorAdapter
    }

}
