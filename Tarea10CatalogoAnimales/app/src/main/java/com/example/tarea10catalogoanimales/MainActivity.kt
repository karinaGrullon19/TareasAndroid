package com.example.tarea10catalogoanimales

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.navigation.NavigationView
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView
    private lateinit var toolbar: Toolbar
    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager: ViewPager2


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)


        toolbar = findViewById(R.id.toolbar)
        drawerLayout = findViewById(R.id.drawerLayout)
        navigationView = findViewById(R.id.navigationView)

        tabLayout = findViewById(R.id.tabLayout)
        viewPager = findViewById(R.id.viewPager)


        setSupportActionBar(toolbar)


        val toggle = ActionBarDrawerToggle(
            this,
            drawerLayout,
            toolbar,
            R.string.open,
            R.string.close
        )


        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()


        navigationView.setNavigationItemSelectedListener { item ->

            when (item.itemId) {

                R.id.nav_inicio -> {
                    Toast.makeText(
                        this,
                        "Inicio seleccionado",
                        Toast.LENGTH_SHORT
                    ).show()
                    true
                }


                R.id.nav_animales -> {
                    Toast.makeText(
                        this,
                        "Animales seleccionado",
                        Toast.LENGTH_SHORT
                    ).show()
                    true
                }


                R.id.nav_favoritos -> {
                    Toast.makeText(
                        this,
                        "Favoritos seleccionado",
                        Toast.LENGTH_SHORT
                    ).show()
                    true
                }


                else -> false
            }
        }


        val adapter = ViewPagerAdapter(this)

        viewPager.adapter = adapter


        TabLayoutMediator(tabLayout, viewPager) { tab, position ->

            when(position) {

                0 -> tab.text = "Mamíferos"

                1 -> tab.text = "Aves"

                2 -> tab.text = "Reptiles"

            }

        }.attach()

    }
}