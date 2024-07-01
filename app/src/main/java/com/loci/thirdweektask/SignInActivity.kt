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
    private lateinit var userData: User
    var initial = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_in)
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
            if (editTextId.text.toString().trim().isEmpty() || editTextPassword.text.toString().trim().isEmpty()) {
                Toast.makeText(this, "", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "로그인 성공", Toast.LENGTH_SHORT).show()

                val intent = Intent(this, HomeActivity::class.java)
                if (initial) {
                    userData.name = editTextId.text.toString()
                    userData.password = editTextPassword.text.toString()
                    userData.username = userData.username
                } else {
                    userData =
                        User(editTextId.text.toString(), "김윤재", editTextPassword.text.toString())
                }

                intent.putExtra("data", userData)
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
                if (result.resultCode == RESULT_OK) {
                    userData = result.data?.getParcelableExtra("data")!!
                    editTextId.setText(userData.name)
                    editTextPassword.setText(userData.password)
                    initial = true
                }

            }
    }

}