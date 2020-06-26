package com.geektech.firsthwkt

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {
    lateinit var value: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        sa_btn.setOnClickListener { clickBtn() }

        if (intent.extras != null) {
            value = intent.getStringExtra("value")
            sa_edit.setText(value)
        }
    }

    private fun clickBtn() {
        if (sa_edit.text.isEmpty()) {
            Toast.makeText(this, "Поле не может быть пустым", Toast.LENGTH_LONG).show()
        } else {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("value", sa_edit.text.toString())
            startActivity(intent)
        }
    }
}
