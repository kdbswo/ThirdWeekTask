package com.loci.thirdweektask

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SignInActivity : AppCompatActivity() {

    private lateinit var resultLauncher: ActivityResultLauncher<Intent>
    private lateinit var editTextId: EditText
    private lateinit var editTextPassword: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        editTextId = findViewById(R.id.et_1)
        editTextPassword = findViewById(R.id.et_2)
        val loginBtn = findViewById<Button>(R.id.btn_1)
        val signUpBtn = findViewById<Button>(R.id.btn_2)

        loginBtn.setOnClickListener {
            if (editTextId.text.isEmpty() || editTextPassword.text.isEmpty()) {
                Toast.makeText(this, "입력되지 않은 정보가 있습니다", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "로그인 성공", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, HomeActivity::class.java)
                val idData = editTextId.text.toString()
                intent.putExtra("id", idData)
                startActivity(intent)
            }
        }

        setResultSignUp()

        signUpBtn.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            resultLauncher.launch(intent)
        }

    }

    private fun setResultSignUp() {
        resultLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                if (result.resultCode == Activity.RESULT_OK) {
                    val id = result.data?.getStringExtra("id") ?: ""
                    val password = result.data?.getStringExtra("password") ?: ""
                    editTextId.setText(id)
                    editTextPassword.setText(password)
                }

            }
    }

}