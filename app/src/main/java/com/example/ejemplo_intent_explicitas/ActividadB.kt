package com.example.ejemplo_intent_explicitas

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ejemplo_intent_explicitas.databinding.ActivityActividadBBinding

class ActividadB : AppCompatActivity() {
    lateinit var mibinding:ActivityActividadBBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        inicializarComponentes()


    }

    private fun inicializarComponentes() {
       //Instanciamos el binding
        mibinding=ActivityActividadBBinding.inflate(layoutInflater)
        //Establecemos el layout
        setContentView(mibinding.root)

        //Obtenemos el intent que sirvio para abrir esta actividad
        var miintent=intent
        //Obtenemos el bundle vinculado al intent
        var mibundle=miintent.extras
        //Accedemos a los datos del bundle
        if(mibundle!=null)
            mibinding.textView.text=mibundle.getString("dato1")
        else
            mibinding.textView.text="VACIO"




        //Añadimos escuchador al boton
        mibinding.button2.setOnClickListener {
            //Creamos un intent que esta vinculado con la MainActivity
            //que me sirve para devolver datos
            var miintent= Intent()
            //Creo un bundle para meter los datos
            var mibundle=Bundle()
            //Relleno el bundle
            mibundle.putString("dato_actividadB",mibinding.editTextB.text.toString())
            //Vincular el bundle al intent
            miintent.putExtras(mibundle)
            //Establezco el resultado
            setResult(Activity.RESULT_OK,miintent)
            finish()
        }
    }
}