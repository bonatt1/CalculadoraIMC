package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottcal: Button = findViewById(R.id.bottcal)
        val EDTTEXT_PESO : EditText = findViewById(R.id.EDTTEXT_PESO)
        val EDTTEXT_ALTURA : EditText = findViewById(R.id.EDTTEXT_ALTURA)


        bottcal.setOnClickListener {

            val alturaStr = EDTTEXT_ALTURA.text.toString()
            val pesoStr = EDTTEXT_PESO.text.toString()

            if (alturaStr.isNotEmpty () && pesoStr.isNotEmpty()){


            val altura: Float = EDTTEXT_ALTURA.text.toString().toFloat()
            val pesoFinal: Float = EDTTEXT_PESO.text.toString().toFloat()
            val alturaFINAL: Float = altura * altura
            val imc = pesoFinal/alturaFINAL


            val intent = Intent(this, ResultActivity::class.java)

                .apply {
                    putExtra( "EXTRA_RESULT", imc)
                }
            startActivity(intent)
        } else {
            Toast.makeText(this, "Preencher todos os campos", Toast.LENGTH_LONG).show()
            }

    }
}}