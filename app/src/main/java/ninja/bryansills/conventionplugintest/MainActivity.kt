package ninja.bryansills.conventionplugintest

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import ninja.bryansills.conventionplugintest.kmp.compose.WhatComposable

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        setContentView(R.layout.activity_main)
//        val textView = findViewById<TextView>(R.id.text_view_cool)
//        textView.text = Instant.now().toString()
//        val lessTextView = findViewById<TextView>(R.id.text_view_less_cool)
//        lessTextView.text = NumberHolder(300).theNumber.toString()

        setContent {
            WhatComposable()
        }
    }
}
