package com.senne.motivation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.senne.motivation.R
import com.senne.motivation.infra.MotivationsConstants
import com.senne.motivation.infra.SecurityPreferences

class MainActivity : AppCompatActivity() {
    private lateinit var msecurityPreferences : SecurityPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        msecurityPreferences = SecurityPreferences(this)
        var textName : TextView = findViewById(R.id.textName)
        textName.text = msecurityPreferences.getString(MotivationsConstants.KEY.PERSON_NAME)
    }
}