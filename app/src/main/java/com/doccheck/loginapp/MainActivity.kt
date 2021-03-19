package com.doccheck.loginapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import com.doccheck.apploginsdk.DocCheckLoginActivity

class MainActivity : AppCompatActivity() {

    private var selectedLanguage = "de" // your prefered language
    private val loginId = "" // your login Id



    private val REQUEST_CODE = 2022;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.login)
        val editTextNumber = findViewById<EditText>(R.id.editTextNumber)

        editTextNumber.setText(loginId)

        button.setOnClickListener {
            val intent = Intent(it.context, DocCheckLoginActivity::class.java).apply {
                putExtra("loginId", editTextNumber.text.toString())
                putExtra("language", selectedLanguage)
            }

            startActivityForResult(intent, REQUEST_CODE)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode != REQUEST_CODE) {
            return
        }
        val resultTextView = findViewById<TextView>(R.id.textView1)
        val builder = StringBuilder()
            .append("LOGIN_RESULT: ${data?.getBooleanExtra("LOGIN_RESULT", false)}\n")
            .append("RESPONSE: ${data?.getStringExtra("RESPONSE")}\n")

        if (resultCode == RESULT_OK) {
            builder.append("\nURLPARAMS:\n")
            val map = data?.getSerializableExtra("URLPARAMS") as? Map<String, List<String>?>
            map?.forEach{ (key, value) ->
                builder.append("$key: $value\n")
            }
        }
        resultTextView.text = builder.trim().toString()
    }
}