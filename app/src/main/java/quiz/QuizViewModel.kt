package quiz

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

import androidx.lifecycle.ViewModel


class QuizViewModel : ViewModel() {
    val questions: MutableList<Question> = quiz.questions;
    var numCorrect: Int = 0
    private val numberOfQuestions: Int = 5
    var itQuestion: MutableIterator<Question> = doQuiz(numberOfQuestions).iterator()
    var currentQuestion: MutableLiveData<Pair<Question?, Boolean>> =
        MutableLiveData<Pair<Question?, Boolean>>()

    init {
        getNextQuestion()
    }

    private fun randomizeQuestions() {
        questions.forEach { q -> q.answers.shuffle() }
        questions.shuffle()
    }

    fun doQuiz(numOfQuestions: Int): MutableList<Question> {
        this.randomizeQuestions()
        val questionsToBeShown = questions.subList(0, numOfQuestions);
        return questionsToBeShown
    }

    fun getNextQuestion() {
        if (itQuestion.hasNext()) {
            currentQuestion.value = itQuestion.next() to !itQuestion.hasNext()
        }
    }

    fun resetQuiz() {
        numCorrect = 0
        itQuestion = doQuiz(5).iterator()
    }
}









































