package ru.devzerkpant.cinemapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.ActionMode
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import androidx.annotation.Nullable
import androidx.appcompat.app.AppCompatDelegate
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.search_card.view.*


class SearhCardView(context: Context, @Nullable attributeSet: AttributeSet) : LinearLayout(context, attributeSet) {
    private val editText: EditText
    private val searchButton: Button

    init {
        LayoutInflater.from(context).inflate(R.layout.search_card, this)
        this.orientation = VERTICAL
        editText = search_field
        searchButton = search_button

        searchButton.setOnClickListener {
            Toast.makeText(context, search_field.text, Toast.LENGTH_SHORT).show()
        }

    }
}


class MainActivity : AppCompatActivity() {

    private var actionMode: ActionMode? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initButtons()
    }

    private fun initButtons() {

        topAppBar.setNavigationOnClickListener {
            Toast.makeText(this, "Left navigation", Toast.LENGTH_SHORT).show()
        }

        topAppBar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.top_profile_link -> {
                    Toast.makeText(this, "Profile", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.top_settings -> {
                    Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show()
                    true
                }

                R.id.top_ltheme -> {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                    true
                }
                R.id.top_dtheme -> {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                    true
                }

                R.id.top_more -> {
                    Toast.makeText(this, "More", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }

        card1_movieName.setOnLongClickListener {
            if(actionMode != null) {
                return@setOnLongClickListener false
            }

            actionMode = startActionMode(object : ActionMode.Callback {
                override fun onCreateActionMode(p0: ActionMode?, p1: Menu?): Boolean {
                    val inflater = p0?.menuInflater
                    inflater?.inflate(R.menu.cont_menu,p1)
                    p0?.title = "Select option"
                    return true
                }

                override fun onPrepareActionMode(p0: ActionMode?, p1: Menu?): Boolean {
                    return false
                }

                override fun onActionItemClicked(p0: ActionMode?, p1: MenuItem?): Boolean {
                    when(p1?.itemId) {
                        R.id.top_add -> Toast.makeText(this@MainActivity, "Added", Toast.LENGTH_LONG).show()
                        R.id.top_remove -> Toast.makeText(this@MainActivity, "No more shows", Toast.LENGTH_LONG).show()
                    }
                    return true
                }

                override fun onDestroyActionMode(p0: ActionMode?) {
                    actionMode = null
                }
            })
            return@setOnLongClickListener true
        }


        card1_movieName.setOnClickListener {
            Toast.makeText(
                this,
                "Walter White, a chemistry teacher, discovers that he has cancer and decides to get into the meth-making business to repay his medical debts. His priorities begin to change when he partners with Jesse.",
                Toast.LENGTH_LONG
            ).show()
        }
        card2_movieName.setOnClickListener {
            Toast.makeText(
                this,
                "The lives of four socially awkward friends, Leonard, Sheldon, Howard and Raj, take a wild turn when they meet the beautiful and free-spirited Penny.",
                Toast.LENGTH_LONG
            ).show()
        }
        card3_movieName.setOnClickListener {
            Toast.makeText(
                this,
                "Chuck Rhoades, a sincere but ruthless US attorney, engages in an egoistic battle with hedge fund kingpin Bobby 'Axe' Axelrod as they try to outdo each other in the competitive financial market.",
                Toast.LENGTH_LONG
            ).show()
        }

    }
}