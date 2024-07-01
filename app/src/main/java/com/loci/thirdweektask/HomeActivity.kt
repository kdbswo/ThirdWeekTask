package com.loci.thirdweektask

import android.graphics.Color
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.res.ResourcesCompat
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

        val textViewId = findViewById<TextView>(R.id.tv_homeId)
        val textViewUsername = findViewById<TextView>(R.id.tv_username)
        val buttonEnd = findViewById<ConstraintLayout>(R.id.btn_main_end)
        val imageViewBall = findViewById<ImageView>(R.id.img_ball)
        val mainPage = findViewById<ConstraintLayout>(R.id.main_page)

        val (id, color) = when ((0..4).random()) {
            0 -> Pair(R.drawable.baseball_image, "#FFFFFF")
            1 ->
                Pair(R.drawable.pngegg, "#D7FFD9")
            2 ->
                Pair(R.drawable.volleyball_remove_bg, "#FFFDD7")
            3 ->
                Pair(R.drawable.rugb_removebg, "#D7EEFF")
            4 ->
                Pair(R.drawable.basketball_removebg, "#FFFDD7")
            else ->
                Pair(R.drawable.baseball_image, "#FFD7D7")
        }

        imageViewBall.setImageDrawable(ResourcesCompat.getDrawable(resources, id, null))
        mainPage.setBackgroundColor(Color.parseColor(color))

        if (intent.hasExtra("data")) {
            val userData: User = intent.getParcelableExtra("data")!!

            textViewId.text = "아이디 : " + userData.name
            textViewUsername.text = String.format("이름: %s", userData.username)
        }

        buttonEnd.setOnClickListener {
            finish()
        }
    }
}