package ru.devzerkpant.cinemapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_go.setOnClickListener {
            Toast.makeText(this, "Enjoy watching the movie!", Toast.LENGTH_SHORT).show()
        }
    }

}