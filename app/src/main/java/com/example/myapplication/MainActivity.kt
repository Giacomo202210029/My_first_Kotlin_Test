package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var questions: ArrayList<Question>
    var position = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        loadQuestions()
        setupViews()
    }

    private fun loadQuestions() {
        questions = ArrayList()
        questions.add(Question("Is the sun hot?", true))
        questions.add(Question("Is the moon made of cheese?", false))
        questions.add(Question("Is the earth flat?", false))
    }

    private fun setupViews() {
        // Setup your views here
        val btYes = findViewById<Button>(R.id.btYes)
        val btNo = findViewById<Button>(R.id.btNo)
        val btNext = findViewById<Button>(R.id.btNext)
        val tvQuestion = findViewById<TextView>(R.id.tvQuestion)

        tvQuestion.text = questions[position].sentence

        btNext.setOnClickListener{
            position++
            tvQuestion.text = questions[position].sentence

        }

        btYes.setOnClickListener{
            if (questions[position].correctAnswer){
                Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Incorrect", Toast.LENGTH_SHORT).show()
            }
        }

        btNo.setOnClickListener{
            if (!questions[position].correctAnswer){
                Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Incorrect", Toast.LENGTH_SHORT).show()
            }
        }

    }
}