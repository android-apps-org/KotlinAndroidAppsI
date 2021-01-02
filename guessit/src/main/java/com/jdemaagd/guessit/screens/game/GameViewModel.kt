package com.jdemaagd.guessit.screens.game

import android.os.CountDownTimer
import android.text.format.DateUtils
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import timber.log.Timber

private val CORRECT_BUZZ_PATTERN = longArrayOf(100, 100, 100, 100, 100, 100)
private val PANIC_BUZZ_PATTERN = longArrayOf(0, 200)
private val GAME_OVER_BUZZ_PATTERN = longArrayOf(0, 2000)
private val NO_BUZZ_PATTERN = longArrayOf(0)

// Note: ViewModel will get destroyed when Activity/Fragment it is associated with is destroyed
class GameViewModel : ViewModel() {

    enum class BuzzType(val pattern: LongArray) {
        CORRECT(CORRECT_BUZZ_PATTERN),
        GAME_OVER(GAME_OVER_BUZZ_PATTERN),
        COUNTDOWN_PANIC(PANIC_BUZZ_PATTERN),
        NO_BUZZ(NO_BUZZ_PATTERN)
    }

    // to represent different important times in game (i.e. game length)
    companion object {
        private const val DONE = 0L
        private const val ONE_SECOND = 1000L
        private const val COUNTDOWN_PANIC_SECONDS = 10L
        private const val COUNTDOWN_TIME = 30000L
    }

    private val timer: CountDownTimer

    // Note: setup internal MutableLiveData version
    private val _currentTime = MutableLiveData<Long>()
    private val _eventBuzz = MutableLiveData<BuzzType>()
    private val _eventGameFinish = MutableLiveData<Boolean>()
    private var _score = MutableLiveData<Int>()
    private var _word = MutableLiveData<String>()
    private lateinit var wordList: MutableList<String>

    // Note: transformation/map LiveData A to LiveData B (currentTimeString)
    val currentTimeString = Transformations.map(currentTime) { time ->
        DateUtils.formatElapsedTime(time)
    }

    init {
        Timber.i("Created!")

        _eventGameFinish.value = false
        resetList()
        nextWord()
        _score.value = 0

        timer = object : CountDownTimer(COUNTDOWN_TIME, ONE_SECOND) {

            override fun onTick(millisUntilFinished: Long) {
                _currentTime.value = (millisUntilFinished / ONE_SECOND)
                if (millisUntilFinished / ONE_SECOND <= COUNTDOWN_PANIC_SECONDS) {
                    _eventBuzz.value = BuzzType.COUNTDOWN_PANIC
                }
            }

            override fun onFinish() {
                _currentTime.value = DONE
                _eventBuzz.value = BuzzType.GAME_OVER
                _eventGameFinish.value = true
            }
        }

        timer.start()
    }

    // Note: exposed LiveData version (non-mutable)
    val currentTime: LiveData<Long>         // Note: LiveData A
        get() = _currentTime
    val eventBuzz: LiveData<BuzzType>
        get() = _eventBuzz
    val eventGameFinish : LiveData<Boolean>
        get() = _eventGameFinish
    val score : LiveData<Int>
        get() = _score
    val word : LiveData<String>
        get() = _word

    // Note: callback before ViewModel is destroyed
    override fun onCleared() {
        super.onCleared()
        Timber.i("Destroyed!")

        timer.cancel()
    }

    fun onBuzzComplete() {
        _eventBuzz.value = BuzzType.NO_BUZZ
    }

    fun onCorrect() {
        _score.value = (_score.value)?.plus(1)
        _eventBuzz.value = BuzzType.CORRECT
        nextWord()
    }

    // Note: LiveData observer to eventGameFinish will trigger on device rotation
    //       causes game to finish again when it is already finished
    //       this function is to fix that bug
    fun onGameFinishComplete() {
        _eventGameFinish.value = false
    }

    fun onSkip() {
        _score.value = (_score.value)?.minus(1)
        nextWord()
    }

    private fun nextWord() {
        if (wordList.isEmpty()) {
            // _eventGameFinish.value = true
            resetList()
        }

        _word.value = wordList.removeAt(0)
    }

    private fun resetList() {
        wordList = mutableListOf(
            "queen", "hospital", "basketball", "cat", "change", "snail", "soup",
            "calendar", "sad", "desk", "guitar", "home", "railway", "zebra",
            "jelly", "car", "crow", "trade", "bag", "roll", "bubble"
        )
        wordList.shuffle()
    }
}