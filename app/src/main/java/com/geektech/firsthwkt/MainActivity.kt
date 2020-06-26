package com.geektech.firsthwkt

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var value: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ma_btn.setOnClickListener { clickBtn() }
        if (intent.extras != null) {
            value = intent.getStringExtra("value")
            ma_edit.setText(value)
        }

    }

    private fun clickBtn() {
        if (ma_edit.text.isEmpty()) {
            Toast.makeText(this, "Поле не может быть пустым", Toast.LENGTH_LONG).show()
        } else {
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("value", ma_edit.text.toString())
            startActivity(intent)
        }
    }
}
