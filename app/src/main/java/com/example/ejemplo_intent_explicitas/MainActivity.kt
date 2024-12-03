package com.example.ejemplo_intent_explicitas

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ejemplo_intent_explicitas.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    lateinit var mibinding:ActivityMainBinding

    var milauncher=registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        miobjeto:ActivityResult->
        if(miobjeto.resultCode==Activity.RESULT_OK)
        {
            //Obtengo los datos de B
            mibinding.textView2.text=miobjeto.data?.extras?.getString("dato_actividadB")

        }






    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()



        inicializarComponentes()

    }

    private fun inicializarComponentes() {
        //Instancio el objeto binding
        mibinding=ActivityMainBinding.inflate(layoutInflater)
        //Establecer el layout a mi actividad
        setContentView(mibinding.root)

        //Escuchador al boton
        mibinding.button.setOnClickListener {
            //Abrir la actividad B
            //1º creo el intent
            var miintent= Intent(this,ActividadB::class.java)
            //2º Creo el Bundle
            var mibundle=Bundle()
            //3º Relleno el bundle
            mibundle.putString("dato1",mibinding.editTextText.text.toString())
            mibundle.putInt("dato2",4)
            //4º vinculo el bundle al intent
            miintent.putExtras(mibundle)
            //4º Inicio la actividad B
            //startActivity(miintent)
            //5º Inicio la actividad B para que me devuelva datos
            milauncher.launch(miintent)

        }


    }
}