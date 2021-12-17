package com.example.assignment3intents

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MailIntent : AppCompatActivity() {
    lateinit var btn_mail: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mail_intent)

        btn_mail = findViewById(R.id.btn_mail)
        var user_mail: EditText = findViewById(R.id.mail)
        var user_subj: EditText = findViewById(R.id.subj)
        var user_txt: EditText = findViewById(R.id.txt)

        btn_mail.setOnClickListener({
            var mail = user_mail.text
            var subj = user_mail.text
            var txt = user_mail.text

            val intent = Intent(Intent.ACTION_SENDTO)
            intent.setData(Uri.parse("mailto:"));
            intent.putExtra(Intent.EXTRA_EMAIL, mail);
            intent.putExtra(Intent.EXTRA_SUBJECT, subj);
            intent.putExtra(Intent.EXTRA_TEXT, txt);
            startActivity(intent)
        })
    }
}