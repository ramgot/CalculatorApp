package ru.turing.secondlesson_calculator

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.turing.secondlesson_calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var numberResult: Double
        var textResult: String

        with(binding) {
            plusButton.setOnClickListener {
                numberResult =
                    upperNumber.text.toString().toDouble() + lowerNumber.text.toString().toDouble()
                textResult = "${upperNumber.text} + ${lowerNumber.text} = $numberResult"
                answerText.text = textResult
            }

            minusButton.setOnClickListener {
                numberResult =
                    upperNumber.text.toString().toDouble() - lowerNumber.text.toString().toDouble()
                textResult = "${upperNumber.text} - ${lowerNumber.text} = $numberResult"
                answerText.text = textResult
            }

            multiplyButton.setOnClickListener {
                numberResult =
                    upperNumber.text.toString().toDouble() * lowerNumber.text.toString().toDouble()
                textResult = "${upperNumber.text} * ${lowerNumber.text} = $numberResult"
                answerText.text = textResult
            }

            divideButton.setOnClickListener {
                if (lowerNumber.text.toString().toDouble() != 0.0) {
                    numberResult =
                        upperNumber.text.toString().toDouble() / lowerNumber.text.toString()
                            .toDouble()
                    textResult = "${upperNumber.text} / ${lowerNumber.text} = $numberResult"
                } else {
                    textResult = getString(R.string.dividing_zero)

                }
                answerText.text = textResult
            }
            aboutAuthorButton.setOnClickListener {
                val authorActivityIntent = Intent(this@MainActivity, AuthorActivity::class.java)
                authorActivityIntent.putExtra(RESULT_EXTRA, binding.answerText.text.toString())
                startActivity(authorActivityIntent)
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putString(RESULT_BUNDLE_KEY, binding.answerText.text.toString())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        binding.answerText.text = savedInstanceState.getString(RESULT_BUNDLE_KEY) ?: "null"


    }

    companion object {
        const val RESULT_BUNDLE_KEY = "result"
        const val RESULT_EXTRA = "result extra"
    }

}