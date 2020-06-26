package com.geektech.firsthwkt

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.geektech.firsthwkt.Toast.toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val EXTRA_VALUE = "value"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ma_btn.setOnClickListener { clickBtn() }


    }

    private fun clickBtn() {
         var text = ma_edit.text.toString()

        if (text.isNotEmpty()) {
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra(EXTRA_VALUE, text)
            startActivityForResult(intent, 101)
        } else {
            toast(this, "Поле не может быть пустым")
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 101 && resultCode == Activity.RESULT_OK && data != null){
            val value1 = intent.getStringExtra("value")

            println(intent.getStringExtra(EXTRA_VALUE))
            ma_edit.setText(value1)
        }
    }
}
