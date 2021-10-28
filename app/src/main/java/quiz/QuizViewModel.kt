package quiz

import androidx.lifecycle.ViewModel


class QuizViewModel : ViewModel() {
    val questions: MutableList<Question> = quiz.questions;
    val correctAnswers: Int = 0
    var currentQuestion: MutableIterator<Question> = doQuiz(5).iterator()
    private fun randomizeQuestions() {
        questions.forEach { q -> q.answers.shuffle() }
        questions.shuffle()
    }

    fun doQuiz(numOfQuestions: Int): MutableList<Question> {
        this.randomizeQuestions()
        val questionsToBeShown = questions.subList(0, numOfQuestions);
        return questionsToBeShown;
    }
}










































