package com.senne.motivation.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.senne.motivation.R
import com.senne.motivation.infra.SecurityPreferences

class SplashActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var msecurityPreferences :SecurityPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        msecurityPreferences = SecurityPreferences(this)

        if(supportActionBar != null) {
            supportActionBar!!.hide()
        }
        val buttonSave: Button = findViewById(R.id.buttonSave)
        buttonSave.setOnClickListener(this)

    }

    override fun onClick(view: View) {
        val id = view.id
        if(id == R.id.buttonSave) {
            bundleSave()
        }
    }

    private fun bundleSave() {
        val name : EditText = findViewById(R.id.cx)

        if(name.text.toString() != "") {
            msecurityPreferences.storeString("name", name.text.toString())
            startActivity(Intent(this, MainActivity::class.java))
        }else {
            Toast.makeText(this, "Digite seu nome", Toast.LENGTH_SHORT).show()
        }
    }
}

