package quiz

data class Question(val text: String, val answers: MutableList<String>, val correctAnswer: String)

val questions: MutableList<Question> = mutableListOf(
    Question(
        text = "What is Android Jetpack?",
        answers = mutableListOf("All of these", "Tools", "Documentation", "Libraries"),
        correctAnswer = "All of these"
    ),
    Question(
        text = "What is the base class for layouts?",
        answers = mutableListOf("ViewGroup", "ViewSet", "ViewCollection", "ViewRoot"),
        correctAnswer = "ViewGroup"
    ),
    Question(
        text = "What layout do you use for complex screens?",
        answers = mutableListOf("ConstraintLayout", "GridLayout", "LinearLayout", "FrameLayout"),
        correctAnswer = "ConstraintLayout"
    ),
    Question(
        text = "What do you use to push structured data into a layout?",
        answers = mutableListOf("Data binding", "Data pushing", "Set text", "An OnClick method"),
        correctAnswer = "Data binding"
    ),
    Question(
        text = "What method do you use to inflate layouts in fragments?",
        answers = mutableListOf(
            "onCreateView()",
            "onActivityCreated()",
            "onCreateLayout()",
            "onInflateLayout()"
        ), correctAnswer = "onCreateView()"
    ),
    Question(
        text = "What's the build system for Android?",
        answers = mutableListOf("Gradle", "Graddle", "Grodle", "Groyle"), correctAnswer = "Gradle"
    ),
    Question(
        text = "Which class do you use to create a vector drawable?",
        answers = mutableListOf(
            "VectorDrawable",
            "AndroidVectorDrawable",
            "DrawableVector",
            "AndroidVector"
        ), correctAnswer = "VectorDrawable"
    ),
    Question(
        text = "Which one of these is an Android navigation component?",
        answers = mutableListOf("NavController", "NavCentral", "NavMaster", "NavSwitcher"),
        correctAnswer = "NavController"
    ),
    Question(
        text = "Which XML element lets you register an activity with the launcher activity?",
        answers = mutableListOf(
            "intent-filter",
            "app-registry",
            "launcher-registry",
            "app-launcher"
        ), correctAnswer = "intent-filter"
    ),
    Question(
        text = "What do you use to mark a layout for data binding?",
        answers = mutableListOf("<layout>", "<binding>", "<data-binding>", "<dbinding>"),
        correctAnswer = "<layout>"
    ),
    Question(
        text = "Which of the following is NOT an activity lifecycle state?",
        answers = mutableListOf("Waiting", "Started", "Created", "Destroyed"),
        correctAnswer = "Waiting"
    ),
    Question(
        text = "Which lifecycle method is called to make an activity visible?",
        answers = mutableListOf("osStart", "onPause", "onVisible", "onDestroy"),
        correctAnswer = "osStart"
    ),
    Question(
        text = "Which lifecycle method is called to give an activity focus?",
        answers = mutableListOf("onResume", "onFocus", "onVisible", "onStart"),
        correctAnswer = "onResume"
    )
)