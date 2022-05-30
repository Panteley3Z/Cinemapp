package ru.devzerkpant.cinemapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initButtons()

        supportFragmentManager
            .beginTransaction()
            .add(R.id.v_main_fragment_ph, HomeFragment())
            .addToBackStack(null)
            .commit()
    }

    fun launchDetailsFragment(film: Film) {
        val bundle = Bundle()
        bundle.putParcelable("film", film)
        val fragment = DetailsFragment()
        fragment.arguments = bundle

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.v_main_fragment_ph, fragment)
            .addToBackStack(null)
            .commit()
    }

    private fun initButtons() {
        v_main_app_bar.setNavigationOnClickListener {
            Toast.makeText(this, "Left navigation", Toast.LENGTH_SHORT).show()
        }
        v_main_app_bar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.v_menu_top_profile_link -> {
                    Toast.makeText(this, "Profile", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.v_menu_top_settings -> {
                    Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.v_menu_top_ltheme -> {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                    true
                }
                R.id.v_menu_top_dtheme -> {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                    true
                }
                R.id.v_menu_top_more -> {
                    Toast.makeText(this, "More", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }
    }
}

