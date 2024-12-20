package com.example.alya4

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class LoginActivity : Activity() {

    private lateinit var usernameEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var loginButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login) // Pastikan layout yang benar digunakan

        // Inisialisasi elemen-elemen UI
        usernameEditText = findViewById(R.id.usernameEditText)
        passwordEditText = findViewById(R.id.passwordEditText)
        loginButton = findViewById(R.id.loginButton)

        // Set listener untuk tombol login
        loginButton.setOnClickListener {
            val username = usernameEditText.text.toString().trim()
            val password = passwordEditText.text.toString().trim()

            // Validasi input pengguna
            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Username dan Password harus diisi", Toast.LENGTH_SHORT).show()
            } else {
                // Cek login (bisa menggunakan API atau database, misal hardcoded di sini)
                if (username == "admin" && password == "admin123") {
                    // Login berhasil, lanjutkan ke halaman utama
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish() // Menutup LoginActivity agar tidak bisa kembali
                } else {
                    // Login gagal
                    Toast.makeText(this, "Username atau Password salah", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
