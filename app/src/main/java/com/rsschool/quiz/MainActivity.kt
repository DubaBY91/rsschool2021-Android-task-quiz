package com.rsschool.quiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.rsschool.quiz.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), QuizInterfaces {
    private lateinit var binding: ActivityMainBinding
    var current = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root

        setContentView(view)
        startQuiz()
    }

    override fun startQuiz() {
        current = 0
        resetQuestions()
        changeTheme()

        supportFragmentManager.beginTransaction()
            .replace(android.R.id.content, FragmetQuiz.newInstance(current))
            .commit()
    }

    override fun showNext() {
        if (current == QuezQuestss.questsList.size - 1){
            showResult()
        } else {
            current++
            changeTheme()

            supportFragmentManager.beginTransaction()
                .add(android.R.id.content, FragmetQuiz.newInstance(current))
                .addToBackStack("")
                .commit()
        }
    }

    override fun showPrevious() {
        if (current > 0) {
            current--
            changeTheme()
            supportFragmentManager.popBackStack()
        }
    }

    override fun showResult() {
        supportFragmentManager.beginTransaction()
            .replace(android.R.id.content, ResultFragment.newInstance())
            .commit()
    }

    override fun sendResult() {
        val intent = Intent(Intent.ACTION_SEND).apply {
            putExtra(Intent.EXTRA_SUBJECT, "Quiz results")
            putExtra(Intent.EXTRA_TEXT, getResultText())
            type = "text/plain"
        }

        startActivity(Intent.createChooser(intent, "Share result"))
    }

    override fun closeQuiz() {
        finish()
    }

    private fun getResultText(): String {
        val result = StringBuilder()

        result.append("Your result: ${QuezQuestss.calcResult()}% \n\n")

        QuezQuestss.questsList.forEach { question ->
            result.append(
                "${question.id}) ${question.question}\n" +
                        "Your answer: ${question.userAnswer}\n\n"
            )
        }
        return result.toString()
    }

    private fun resetQuestions() {
        QuezQuestss.questsList.forEach { question ->
            question.answers.shuffle()
            question.userAnswer = ""
        }
    }

    private fun changeTheme() {
        setTheme(
            when (current) {
                0 -> R.style.Theme_Quiz_First
                1 -> R.style.Theme_Quiz_Second
                2 -> R.style.Theme_Quiz_Third
                3 -> R.style.Theme_Quiz_Forth
                4 -> R.style.Theme_Quiz_Fifth
                else -> R.style.Theme_Quiz_First
            }
        )
    }
}