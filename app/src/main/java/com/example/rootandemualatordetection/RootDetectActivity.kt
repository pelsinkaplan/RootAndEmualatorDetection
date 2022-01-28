package com.example.rootandemualatordetection

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.scottyab.rootbeer.RootBeer

class RootDetectActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_root_detect)
        findViewById<Button>(R.id.root_detect_button).setOnClickListener {
            if (rootDetection())
                Toast.makeText(applicationContext, "WARNING, Rooted Device!", Toast.LENGTH_SHORT)
                    .show()
            else
                Toast.makeText(
                    applicationContext,
                    "KEEP CALM, Device in not Rooted.",
                    Toast.LENGTH_SHORT
                ).show()
        }

        findViewById<Button>(R.id.emulator_detector_button).setOnClickListener {
            val intent = Intent(this, EmulatorDetectActivity::class.java)
            startActivity(intent)
        }
    }

    private fun rootDetection(): Boolean {
        val rootBeer = RootBeer(applicationContext)
        return rootBeer.isRooted
    }
}

