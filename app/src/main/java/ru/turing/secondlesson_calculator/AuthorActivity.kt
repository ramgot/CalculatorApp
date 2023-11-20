package ru.turing.secondlesson_calculator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.turing.secondlesson_calculator.databinding.ActivityAuthorBinding

class AuthorActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAuthorBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAuthorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val textForPreviousResult: String

        intent.getStringExtra(MainActivity.RESULT_EXTRA)?.let {
            textForPreviousResult = "${getString(R.string.previous_activity_result)} $it"
            binding.authorPreviousText.text = textForPreviousResult
        }
    }
}