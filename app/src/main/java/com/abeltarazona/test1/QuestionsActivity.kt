package com.abeltarazona.test1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.abeltarazona.test1.databinding.ActivityQuestionsBinding
import com.bumptech.glide.Glide
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class QuestionsActivity : AppCompatActivity() {

    lateinit var binding: ActivityQuestionsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuestionsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Glide.with(this).load("https://rccl-h.assetsadobe.com/is/image/content/dam/royal/content/destinations/australia/australia-sydney-opera-house.jpg?\$750x667\$").into(binding.imageView4)

        lifecycleScope.launch {
            startCounter()
        }

    }

    private suspend fun startCounter() {
        for (i in 1..10) {
            val num = Utils().calculatePercentage(i, 10).toInt()
            binding.progressBar.progress = num
            binding.textView2.text = i.toString()
            delay(1500)
        }
        showFinishDialog(canceledOnTouchOutside = true)
    }
}