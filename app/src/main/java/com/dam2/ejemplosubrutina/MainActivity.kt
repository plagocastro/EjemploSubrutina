package com.dam2.ejemplosubrutina

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

//Las librerias para hacer estas corrutinas las implementamos en el gradle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val Mibutton:Button = findViewById(R.id.button)
        Mibutton.setOnClickListener(){
            lanzarCorrutina()
        }
    }
    private fun lanzarCorrutina(){

        val miTexto: TextView = findViewById(R.id.textView)
        //launch se encarga de crear una corrutina
        // vamos a poder indentificar con el 'job'
        val job = GlobalScope.launch(Dispatchers.Main){
            //lamamos a una funcion que estará dentro de la corrutina
            // en esta función habrá delay()
            suspendingTask(miTexto)
        }
        val job2 = GlobalScope.launch(Dispatchers.Main){
            //lamamos a una funcion que estará dentro de la corrutina
            // en esta función habrá delay()
            suspendingTask2(miTexto)
        }
    }
    suspend fun suspendingTask2(miTexto: TextView){
        delay(1500L)
        miTexto.text="TasK2"
    }
   suspend fun suspendingTask(miTexto: TextView){
        miTexto.text = "Hola"
        delay(300L)
        miTexto.text="Corrutina"
    }
}