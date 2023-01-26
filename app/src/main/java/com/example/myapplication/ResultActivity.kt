package com.example.myapplication

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.view.MenuItem
import android.widget.TextView

class ResultActivity() : AppCompatActivity() {
    @SuppressLint("StringFormatMatches")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        val tvResult = findViewById<TextView>(R.id.textview_result)
        val tvClassificacao = findViewById<TextView>(R.id.textview_classificacao)
        val result = intent.getFloatExtra("EXTRA_RESULT", 0.1f)

        tvResult.text = result.toString()

        /* TABELA IMC
        MENOR QUE 18.5      BAIXO DDO PESO 0
        ENTRE 18.5 E 24.9   NORMAL 0
        ENTRE 25.0 E 29.9   SOBREPESO I
        ENTRE 30.0 E 39.9   OBESIDADE II
        MAIOR QUE 40.0      OBESIDADE GRAVE III
         */

var classificacao = ""

        if (result < 18.5f ){
            classificacao = "ABAIXO DO PESO"     }
        else if (result in 18.5f..24.9f){
           classificacao = "NORMAL 0"         }
        else if (result in 25.0f..29.9f){
           classificacao = "SOBREPESO I"         }
        else if (result in 30.0f..39.9f){
           classificacao = "OBESIDADE II"         }
        else if(result>= 40.0){
           classificacao = "OBESIDADE GRAVE III"  }

        tvClassificacao.text = getString(R.string.message_classificacao, classificacao)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
    }
}