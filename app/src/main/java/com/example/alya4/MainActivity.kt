package com.example.alya4

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.activity.enableEdgeToEdge

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("ActivityLifecycle", "onCreate dipanggil")

        // Mengaktifkan Edge-to-Edge UI (jika ingin)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main) // Pastikan layout yang benar dipanggil

        // Menambahkan listener untuk WindowInsets untuk menyesuaikan padding pada view utama
        val mainView = findViewById<View>(R.id.main) // Pastikan ada ID `main` pada layout
        ViewCompat.setOnApplyWindowInsetsListener(mainView) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Menambahkan OnClickListener untuk tombol locationButton
        val locationButton: Button = findViewById(R.id.locationButton)
        locationButton.setOnClickListener {
            // Buka Google Maps dengan lokasi tertentu (Bantul, D.I Yogyakarta)
            val latitude = -7.7949955
            val longitude = 110.4026204
            val uri = "geo:$latitude,$longitude?q=$latitude,$longitude(Bantul, D.I Yogyakarta)"
            val intent = Intent(Intent.ACTION_VIEW, android.net.Uri.parse(uri))

            // Memastikan ada aplikasi yang bisa membuka intent ini
            intent.setPackage("com.google.android.apps.maps")
            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            } else {
                Log.d("LocationIntent", "Tidak ada aplikasi yang mendukung untuk membuka Maps")
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("ActivityLifecycle", "onStart dipanggil")
    }

    override fun onResume() {
        super.onResume()
        Log.d("ActivityLifecycle", "onResume dipanggil")
    }

    override fun onPause() {
        super.onPause()
        Log.d("ActivityLifecycle", "onPause dipanggil")
    }

    override fun onStop() {
        super.onStop()
        Log.d("ActivityLifecycle", "onStop dipanggil")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("ActivityLifecycle", "onRestart dipanggil")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("ActivityLifecycle", "onDestroy dipanggil")
    }
}
