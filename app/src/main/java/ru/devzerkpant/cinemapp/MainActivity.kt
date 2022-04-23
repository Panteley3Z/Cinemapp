package ru.devzerkpant.cinemapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initButtons()
    }

    private fun initButtons() {
        card_movie1desc.setOnClickListener {
            Toast.makeText(
                this,
                "Walter White, a chemistry teacher, discovers that he has cancer and decides to get into the meth-making business to repay his medical debts. His priorities begin to change when he partners with Jesse.",
                Toast.LENGTH_LONG
            ).show()
        }
        card_movie2desc.setOnClickListener {
            Toast.makeText(
                this,
                "The lives of four socially awkward friends, Leonard, Sheldon, Howard and Raj, take a wild turn when they meet the beautiful and free-spirited Penny.",
                Toast.LENGTH_LONG
            ).show()
        }
        card_movie3desc.setOnClickListener {
            Toast.makeText(
                this,
                "Chuck Rhoades, a sincere but ruthless US attorney, engages in an egoistic battle with hedge fund kingpin Bobby 'Axe' Axelrod as they try to outdo each other in the competitive financial market.",
                Toast.LENGTH_LONG
            ).show()
        }

        bottomP_button_marked.setOnClickListener {
            Toast.makeText(this, "Favorites", Toast.LENGTH_SHORT).show()
        }
        bottomP_button_wLater.setOnClickListener {
            Toast.makeText(this, "Watch later", Toast.LENGTH_SHORT).show()
        }
        bottomP_button_fortune.setOnClickListener {
            Toast.makeText(this, "Cinema fortune", Toast.LENGTH_SHORT).show()
        }
    }


}