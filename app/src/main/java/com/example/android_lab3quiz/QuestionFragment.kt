package com.example.android_lab3quiz

import android.content.Context
import android.content.DialogInterface
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AlertDialog
import com.example.android_lab3quiz.databinding.QuestionFragmentBinding
import quiz.QuizViewModel

class QuestionFragment : Fragment() {

    private lateinit var viewModel: QuizViewModel
    private lateinit var binding: QuestionFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(requireActivity()).get(QuizViewModel::class.java)
        binding = QuestionFragmentBinding.inflate(inflater, container, false)
        viewModel.currentQuestion.observe(requireActivity()) { (question, isLast) ->
            binding.textViewQuestion.text = question?.text
            binding.radioButtonA.text = question?.answers?.get(0) ?: "A"
            binding.radioButtonB.text = question?.answers?.get(1) ?: "B"
            binding.radioButtonC.text = question?.answers?.get(2) ?: "C"
            binding.radioButtonD.text = question?.answers?.get(3) ?: "D"
            if (isLast) {
                binding.buttonNext.text = "SUBMIT"
                binding.buttonNext.setOnClickListener {
                    val fragmentManager = parentFragmentManager.beginTransaction()
                    fragmentManager.replace(R.id.fragment_container_view, QuizEndFragment())
                    fragmentManager.commit()
                }
            }
        }
        return binding.root;
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonNext.text = "NEXT"
        binding.buttonNext.setOnClickListener {
            val checkedId = binding.radio.checkedRadioButtonId;
            if (checkedId == -1) {
                return@setOnClickListener
            }
            if (requireView().findViewById<RadioButton>(checkedId).text == viewModel.currentQuestion.value?.first?.correctAnswer) {
                viewModel.numCorrect++

            }
            viewModel.getNextQuestion()
            binding.radio.clearCheck()
            Log.d("Question", viewModel.numCorrect.toString())
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        val callback: OnBackPressedCallback = object : OnBackPressedCallback(
            true
        ) {
            override fun handleOnBackPressed() {
                alertUser()
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(
            requireActivity(),
            callback
        )
    }

    fun alertUser() {
        val builder = AlertDialog.Builder(requireActivity())
        builder.setTitle("WARNING!")
        builder.setMessage("Are you sure you want to finish the quiz? Your progress will be lost!")
        builder.setPositiveButton("Yes") { dialog, which ->
            viewModel.resetQuiz()
            val fragmentManager = parentFragmentManager.beginTransaction()
            fragmentManager.replace(R.id.fragment_container_view, QuizStartFragment())
            fragmentManager.commit()
        }
        builder.setNegativeButton("No, I want to continue") { dialog, which ->
            dialog.cancel()
        }
        builder.show()
    }
}

