package com.example.intents

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.intents.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var b:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityMainBinding.inflate(layoutInflater)
        setContentView(b.root)

        b.btnSend.setOnClickListener {
            checkValores()
        }
    }
    fun checkValores(){
        if (b.etMail.text.isNotEmpty() and
                b.etPhone.text.isNotEmpty() and
                b.etPass.text.isNotEmpty()){
            enviarDatos()
        } else {
            mostrarError()
        }

    }
    fun mostrarError(){
        val str = "Error. No puede haber ningún campo vacío"
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show()
    }
    fun enviarDatos(){
        val bundle = Bundle()
        bundle.putString("INTENT_MAIL", b.etMail.text.toString())
        bundle.putString("INTENT_PHONE", b.etPhone.text.toString())
        bundle.putString("INTENT_PASS", b.etPass.text.toString())
        val myIntent = Intent(this, ResultActivity::class.java)
        myIntent.putExtras(bundle)
//        myIntent.putExtra("INTENT_MAIL", b.etMail.text.toString())
//        myIntent.putExtra("INTENT_PHONE", b.etPhone.text.toString())
//        myIntent.putExtra("INTENT_PASS", b.etPass.text.toString())
        startActivity(myIntent)
    }
}