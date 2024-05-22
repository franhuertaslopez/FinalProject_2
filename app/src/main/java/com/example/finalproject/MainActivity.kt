package com.example.finalproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen

class MainActivity : AppCompatActivity() {

    private lateinit var usernameInput : EditText
    private lateinit var passwordInput : EditText
    private lateinit var loginButton : Button
    private lateinit var facebookLogin : ImageButton
    private lateinit var  googleLogin : ImageButton
    private lateinit var registerText: TextView
    private val handler = Handler(Looper.getMainLooper())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // SOLO PARA VER EL SPLASHSCREEN
        Thread.sleep(2000)

        // INSTANCIAMOS SPLASHSCREEN
        installSplashScreen()

        setContentView(R.layout.activity_main)

        usernameInput = findViewById(R.id.username_input)
        passwordInput = findViewById(R.id.password_input)
        loginButton = findViewById(R.id.login_button)
        facebookLogin = findViewById(R.id.facebook_login)
        googleLogin = findViewById(R.id.google_login)
        registerText = findViewById(R.id.register_text)

        loginButton.setOnClickListener {
            val username = usernameInput.text.toString().trim()
            val password = passwordInput.text.toString().trim()

            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Por favor ingrese usuario y contraseña", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Login correcto", Toast.LENGTH_SHORT).show()
            }
        }

        facebookLogin.setOnClickListener{
            Toast.makeText(this, "Login usando Facebook", Toast.LENGTH_SHORT).show();
        }

        googleLogin.setOnClickListener{
            Toast.makeText(this, "Login usando Google", Toast.LENGTH_SHORT).show();
        }

        registerText.setOnClickListener {
            Toast.makeText(this, "Redirigiendo a registro", Toast.LENGTH_SHORT).show()
        }

        // Programar la animación de pulsación cada 2 segundos
        val pulseAnimation = AnimationUtils.loadAnimation(this, R.anim.pulse)
        val runnable = object : Runnable {
            override fun run() {
                registerText.startAnimation(pulseAnimation)
                handler.postDelayed(this, 2000) // Repetir cada 2 segundos
            }
        }
        handler.post(runnable)
    }

    override fun onDestroy() {
        super.onDestroy()
        handler.removeCallbacksAndMessages(null) // Detener el handler cuando la actividad se destruya
    }
}