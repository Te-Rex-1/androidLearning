package com.example.learing.viewModel

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.learing.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var viewModel=ViewModelProvider(this).get(mainAcitvitiyViewModel::class.java)

        val btn=findViewById<Button>(R.id.button2)
        val textView=findViewById<TextView>(R.id.textView)
        textView.text=viewModel.number.toString()
        viewModel.number.observe(this, Observer {
            textView.text=it.toString()
        })
        btn.setOnClickListener{
          viewModel.addNumber()
//            textView.text=viewModel.number.toString()
        }

    }
}