package com.example.finalproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen

class MainActivity : AppCompatActivity() {

    private lateinit var usernameInput : EditText
    private lateinit var passwordInput : EditText
    private lateinit var loginButton : Button
    private lateinit var facebookLogin : ImageButton
    private lateinit var  googleLogin : ImageButton

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
    }
}