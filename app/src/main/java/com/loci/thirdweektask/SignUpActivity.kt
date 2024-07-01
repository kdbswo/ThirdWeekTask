package com.loci.thirdweektask

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_up)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val finishButton = findViewById<Button>(R.id.btn_signIn)
        val editTextName = findViewById<EditText>(R.id.et_name)
        val editTextId = findViewById<EditText>(R.id.et_id)
        val editTextPassword = findViewById<EditText>(R.id.et_password)

        finishButton.setOnClickListener {

            if (editTextName.text.toString().trim().isEmpty() || editTextId.text.toString().trim().isEmpty() || editTextPassword.text.toString().trim().isEmpty()) {
                Toast.makeText(this, getString(R.string.login_button_err_toast), Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this,SignInActivity::class.java)
                val data = User(editTextName.text.toString(),editTextId.text.toString(),editTextPassword.text.toString())
                intent.putExtra("data", data)
                setResult(RESULT_OK, intent)
                finish()
            }

        }
    }
}