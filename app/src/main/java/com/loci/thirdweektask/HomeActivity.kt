package com.loci.thirdweektask

import android.graphics.Color
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main_page)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val idData = intent.getStringExtra("id")
        val editTextId = findViewById<TextView>(R.id.tv_homeId)
        val buttonEnd = findViewById<ConstraintLayout>(R.id.layout_btn_end)
        val imageViewBall = findViewById<ImageView>(R.id.img_ball)
        val mainPage = findViewById<ConstraintLayout>(R.id.main_page)

        val random = Random.nextInt(5)
        when (random) {
            0 -> {
                imageViewBall.setImageResource(R.drawable.baseball_image)
                mainPage.setBackgroundColor(Color.parseColor("#FFFFFF"))
            }
            1 -> {
                imageViewBall.setImageResource(R.drawable.pngegg)
                mainPage.setBackgroundColor(Color.parseColor("#D7FFD9"))
            }
            2 -> {
                imageViewBall.setImageResource(R.drawable.volleyball_remove_bg)
                mainPage.setBackgroundColor(Color.parseColor("#FFFDD7"))
            }
            3 -> {
                imageViewBall.setImageResource(R.drawable.rugb_removebg)
                mainPage.setBackgroundColor(Color.parseColor("#D7EEFF"))
            }
            4 -> {
                imageViewBall.setImageResource(R.drawable.basketball_removebg)
                mainPage.setBackgroundColor(Color.parseColor("#FFD7D7"))
            }
        }

        editTextId.setText(idData)

        buttonEnd.setOnClickListener {
            finish()
        }
    }
}