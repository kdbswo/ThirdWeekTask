package com.loci.thirdweektask

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val idData = intent.getStringExtra("id")
        val editTextId = findViewById<TextView>(R.id.tv_homeId)
        val buttonEnd = findViewById<Button>(R.id.btn_end)
        val imageViewBall = findViewById<ImageView>(R.id.img_ball)

        val random = Random.nextInt(5)
        when (random) {
            0 -> imageViewBall.setImageResource(R.drawable.baseball_image)
            1 -> imageViewBall.setImageResource(R.drawable.pngegg)
            2 -> imageViewBall.setImageResource(R.drawable.volleyball_remove_bg)
            3 -> imageViewBall.setImageResource(R.drawable.rugb_removebg)
            4 -> imageViewBall.setImageResource(R.drawable.basketball_removebg)
        }

        editTextId.setText(idData)

        buttonEnd.setOnClickListener {
            finish()
        }
    }
}