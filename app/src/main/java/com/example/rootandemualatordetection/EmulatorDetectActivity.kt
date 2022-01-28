package com.example.rootandemualatordetection

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.scottyab.rootbeer.RootBeer

class EmulatorDetectActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_emulator_detect)
        findViewById<Button>(R.id.emulator_detect_button).setOnClickListener {
            if (emulatorDetection())
                Toast.makeText(
                    applicationContext,
                    "WARNING, Emulator detected!",
                    Toast.LENGTH_SHORT
                )
                    .show()
            else
                Toast.makeText(
                    applicationContext,
                    "KEEP CALM, Device is not Emulator..",
                    Toast.LENGTH_SHORT
                ).show()
        }
        findViewById<Button>(R.id.root_detector_button).setOnClickListener {
            val intent = Intent(this, RootDetectActivity::class.java)
            startActivity(intent)
        }
    }

    private fun emulatorDetection(): Boolean {
        return Build.FINGERPRINT.startsWith("generic")
                || Build.FINGERPRINT.startsWith("unknown")
                || Build.MODEL.contains("google_sdk")
                || Build.MODEL.contains("Emulator")
                || Build.MODEL.contains("Android SDK built for x86")
                || Build.MANUFACTURER.contains("Genymotion")
                || (Build.BRAND.startsWith("generic") && Build.DEVICE.startsWith("generic"))
                || "google_sdk" == Build.PRODUCT;
    }
}