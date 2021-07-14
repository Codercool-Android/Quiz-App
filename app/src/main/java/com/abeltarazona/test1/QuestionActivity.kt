package com.abeltarazona.test1

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.abeltarazona.test1.databinding.ActivityQuestionBinding

class QuestionActivity : AppCompatActivity() {

    lateinit var binding: ActivityQuestionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuestionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intent: Intent = intent
        val data = intent.getStringExtra(Utils.PUSH_DATA)

        binding.tvTitleWelcome.text = data

        val question = Utils.listQuestions.random()
        val questionOptionCorrect = question.isCorrect

        binding.tvTitleQuestion.text = question.title

        var point = 0

        binding.btnTrue.setOnClickListener {
            binding.tvIndicator.text = "Has respondido: VERDADERO"
            point = if (questionOptionCorrect) {
                1
            } else {
                -1
            }

        }

        binding.btnFalse.setOnClickListener {
            binding.tvIndicator.text = "Has respondido: FALSO"
            point = if (!questionOptionCorrect) {
                1
            } else {
                -1
            }
        }

        binding.btnValidateQuestion.setOnClickListener {
            val returnIntent = Intent()
            returnIntent.putExtra("player", data)
            returnIntent.putExtra("point", point)
            setResult(RESULT_OK, returnIntent)
            finish()
        }
    }
}