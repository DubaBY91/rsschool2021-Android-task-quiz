package com.rsschool.quiz

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.rsschool.quiz.databinding.ResultFragmtBinding


class ResultFragment : Fragment() {
    private var _binding: ResultFragmtBinding? = null
    private val binding get() = _binding!!

    private var listener: QuizInterfaces? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = ResultFragmtBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.result.text = "Your result: ${QuezQuestss.calcResult()}%"

        binding.share.setOnClickListener {
            listener?.sendResult()
        }

        binding.restart.setOnClickListener {
            listener?.startQuiz()
        }

        binding.close.setOnClickListener {
            listener?.closeQuiz()
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as? QuizInterfaces
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    companion object {
        fun newInstance() = ResultFragment()
    }
}