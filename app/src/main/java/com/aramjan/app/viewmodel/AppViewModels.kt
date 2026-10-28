package com.aramjan.app.viewmodel

import androidx.lifecycle.ViewModel
import com.aramjan.app.model.MoodType
import com.aramjan.app.model.QuizQuestion
import com.aramjan.app.model.VoiceMemory
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MainViewModel : ViewModel() {
    private val _selectedMood = MutableStateFlow<MoodType?>(MoodType.CALM)
    val selectedMood: StateFlow<MoodType?> = _selectedMood

    private val _phoneNumber = MutableStateFlow("")
    val phoneNumber: StateFlow<String> = _phoneNumber

    fun selectMood(mood: MoodType) {
        _selectedMood.value = mood
    }

    fun updatePhoneNumber(num: String) {
        _phoneNumber.value = num
    }
}

class GameViewModel : ViewModel() {
    val questions = listOf(
        QuizQuestion(
            id = 1,
            text = "قطره قطره جمع گردد، وانگهی ... شود",
            options = listOf("دریا", "باران", "رود"),
            correctAnswerIndex = 0
        )
    )

    private val _currentQuestionIndex = MutableStateFlow(0)
    val currentQuestionIndex: StateFlow<Int> = _currentQuestionIndex

    private val _selectedAnswer = MutableStateFlow<Int?>(0)
    val selectedAnswer: StateFlow<Int?> = _selectedAnswer

    private val _score = MutableStateFlow(20)
    val score: StateFlow<Int> = _score

    fun selectAnswer(index: Int) {
        _selectedAnswer.value = index
    }
}

class VoiceViewModel : ViewModel() {
    private val _isRecording = MutableStateFlow(true)
    val isRecording: StateFlow<Boolean> = _isRecording

    val voiceMemories = listOf(
        VoiceMemory("1", "قصه سفر شمال", "۱۰ مهر ۱۴۰۳", "۰۲:۱۵"),
        VoiceMemory("2", "خاطره اولین روز مدرسه", "۱۵ شهریور ۱۴۰۳", "۰۴:۳۰")
    )

    fun toggleRecording() {
        _isRecording.value = !_isRecording.value
    }
}
