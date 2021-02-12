package com.senne.motivation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.senne.motivation.R
import com.senne.motivation.infra.MotivationsConstants
import com.senne.motivation.infra.SecurityPreferences

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var msecurityPreferences: SecurityPreferences

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val imageAll: ImageView = findViewById(R.id.imageAll)
        imageAll.setOnClickListener(this)
        val imageHappy: ImageView = findViewById(R.id.imageHappy)
        imageHappy.setOnClickListener(this)
        val imageMorning: ImageView = findViewById(R.id.imageMorning)
        imageMorning.setOnClickListener(this)

        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }

        msecurityPreferences = SecurityPreferences(this)
        var textName: TextView = findViewById(R.id.textName)
        textName.text = msecurityPreferences.getString(MotivationsConstants.KEY.PERSON_NAME)
    }

    override fun onClick(view: View) {
        val id = view.id

        val listFilter = listOf(
                R.id.imageAll,
                R.id.imageHappy,
                R.id.imageMorning
        )


        if (id == R.id.newPhrase) {
            bundleNewPhrase()
        } else if (id in listFilter) {
            bundleFilter(id)
        }
    }

    private fun bundleFilter(id: Int) {
        when (id) {
            R.id.imageAll -> {
                val imageAll: ImageView = findViewById(R.id.imageAll)
                imageAll.setColorFilter(resources.getColor(R.color.black))
            }
            R.id.imageHappy -> {
                val imageHappy: ImageView = findViewById(R.id.imageHappy)
                imageHappy.setColorFilter(resources.getColor(R.color.black))
            }
            R.id.imageMorning -> {
                val imageMorning: ImageView = findViewById(R.id.imageMorning)
                imageMorning.setColorFilter(resources.getColor(R.color.black))
            }
        }

    }

    private fun bundleNewPhrase() {

    }
}