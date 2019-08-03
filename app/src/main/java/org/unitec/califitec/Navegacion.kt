package org.unitec.califitec

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_navegacion.*

class Navegacion : AppCompatActivity() {

   // private lateinit var textMessage: TextView
    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {

         frame.removeAllViews();
     var vistaLayout=
       LayoutInflater.from(applicationContext)
     .inflate(R.layout.inicio,null,false)
                frame.addView(vistaLayout)


                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {

                frame.removeAllViews();
                var vistaLayout=
                    LayoutInflater.from(applicationContext)
                        .inflate(R.layout.materias,null,false)
                frame.addView(vistaLayout)


                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {

                frame.removeAllViews();
                var vistaLayout=
                    LayoutInflater.from(applicationContext)
                        .inflate(R.layout.calificaciones,null,false)
                frame.addView(vistaLayout)


                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navegacion)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

//Aqui ponemos otra vez el primero porque el onCreate es el punto de entrada de la app
        frame.removeAllViews();
        var vistaLayout=
            LayoutInflater.from(applicationContext)
                .inflate(R.layout.inicio,null,false)
        frame.addView(vistaLayout)



        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
    }
}
