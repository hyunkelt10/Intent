package com.example.intents

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.intents.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    private lateinit var b:ActivityResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityResultBinding.inflate(layoutInflater)
        setContentView(b.root)

        getAndShow()
        b.bntVolver.setOnClickListener { onBackPressed() }
    }

    fun getAndShow(){
//        val datosIntent = intent.extras
//        val mail = datosIntent?.get("INTENT_MAIL")
//        val phone = datosIntent?.get("INTENT_PHONE")
//        val pass = datosIntent?.get("INTENT_PASS")

        val bundle = intent.extras
        val mail = bundle?.getString("INTENT_MAIL")
        val phone = bundle?.getString("INTENT_PHONE")
        val pass = bundle?.getString("INTENT_PASS", "Password No Enviado")

        b.tvDatos.text = """DATOS
            |
            |E-Mail: $mail
            |Teléfono: $phone
            |Contraseña: $pass
        """.trimMargin()
    }
}