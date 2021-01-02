package com.jdemaagd.guessit.screens.game

import android.os.Build
import android.os.Bundle
import android.os.VibrationEffect
import android.os.Vibrator
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.getSystemService

import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController

import com.jdemaagd.guessit.R
import com.jdemaagd.guessit.databinding.FragmentGameBinding
import timber.log.Timber

/**
 * Fragment where the game is played
 */
class GameFragment : Fragment() {

    // Note: binding contains references to all the views
    //       which should not be in ViewModel
    private lateinit var binding: FragmentGameBinding
    private lateinit var gameViewModel: GameViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_game, container,false)

        // Note: leverage ViewModelProvider to create ViewModel (also makes association)
        //       to handle persisting data in configuration changes
        gameViewModel = ViewModelProvider(this).get(GameViewModel::class.java)
        Timber.i("Association to GameViewModel")

        binding.gameViewModel = gameViewModel
        binding.lifecycleOwner = this               // Note: LiveData binding

        gameViewModel.eventGameFinish.observe(viewLifecycleOwner, { isFinished ->
            if (isFinished) {
                val currentScore = gameViewModel.score.value ?: 0
                val action = GameFragmentDirections.actionGameToScore(currentScore)
                findNavController().navigate(action)
                // findNavController().navigate(GameFragmentDirections.actionGameToScore(viewModel.score.value ?: 0))

                gameViewModel.onGameFinishComplete()
            }
        })

        gameViewModel.eventBuzz.observe(viewLifecycleOwner, { buzzType ->
            if (buzzType != GameViewModel.BuzzType.NO_BUZZ) {
                buzz(buzzType.pattern)
                gameViewModel.onBuzzComplete()
            }
        })

        return binding.root
    }

    private fun buzz(pattern: LongArray) {
        val buzzer = activity?.getSystemService<Vibrator>()

        buzzer?.let {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                buzzer.vibrate(VibrationEffect.createWaveform(pattern, -1))
            } else {
                //deprecated in API 26
                @Suppress("DEPRECATION")
                buzzer.vibrate(pattern, -1)
            }
        }
    }
}
