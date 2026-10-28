package com.aramjan.app.model

enum class MoodType(val title: String, val emoji: String) {
    CALM("آرام", "🌱"),
    TIRED("خسته", "😴"),
    ENERGETIC("سرحال", "⚡"),
    GLOOMY("دلگیر", "🌧️")
}

data class QuizQuestion(
    val id: Int,
    val text: String,
    val options: List<String>,
    val correctAnswerIndex: Int
)

data class VoiceMemory(
    val id: String,
    val title: String,
    val dateText: String,
    val durationText: String
)
