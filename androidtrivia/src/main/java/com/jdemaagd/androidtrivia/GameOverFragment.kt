package com.jdemaagd.androidtrivia

import android.os.Bundle
import android.view.*

import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController

import com.jdemaagd.androidtrivia.databinding.FragmentGameOverBinding

class GameOverFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        // Note: Fragment requires you to manually inflate and return layout
        //       vs where Activity does it via setContentView in onCreate
        val binding: FragmentGameOverBinding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_game_over, container, false)

        // Note: in layout editor popUpTo titleFragment non-inclusive
        binding.btnTryAgain.setOnClickListener {
            // it.findNavController().navigate(R.id.action_gameOverFragment_to_gameFragment)
            it.findNavController().navigate(GameOverFragmentDirections.actionGameOverFragmentToGameFragment())
        }

        return binding.root
    }
}
