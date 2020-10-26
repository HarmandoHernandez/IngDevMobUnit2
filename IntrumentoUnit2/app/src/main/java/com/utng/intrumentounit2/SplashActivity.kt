package com.utng.intrumentounit2

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        // Animations
        val anim1 = AnimationUtils.loadAnimation(this, R.anim.desplazamiento_abajo)
        val anim2 = AnimationUtils.loadAnimation(this, R.anim.desplazamiento_arriba)
        val splashIcon = findViewById<ImageView>(R.id.splashIcon)
        val splashBy = findViewById<TextView>(R.id.splashBy)
        splashIcon.animation = anim1
        splashBy.animation = anim2
        // Intent
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, MenuActivity::class.java)
            startActivity(intent) // TODO startActivityForResult
            /** Finish activity */
            finish()
        }, 3500)
    }
}