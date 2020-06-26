package com.geektech.firsthwkt

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.geektech.firsthwkt.Toast.toast
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {
    lateinit var value: String
    private val EXTRA_VALUE = "value"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        sa_btn.setOnClickListener { clickBtn() }

        if (intent.extras != null) {
            value = intent.getStringExtra(EXTRA_VALUE)
            sa_edit.setText(value)
        }
    }

    private fun clickBtn() {
         var text : String = sa_edit.text.toString()
        if (text.isNotEmpty()) {
            val intent = Intent()
            intent.putExtra(EXTRA_VALUE, text)
            setResult(Activity.RESULT_OK, intent)
            Log.d("adada" , text)
            finish()
        } else {
            toast(this,"Поле не может быть пустым")
        }
    }
}
