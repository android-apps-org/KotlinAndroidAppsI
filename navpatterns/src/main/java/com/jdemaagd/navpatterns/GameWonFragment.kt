package com.jdemaagd.navpatterns

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.jdemaagd.navpatterns.databinding.FragmentGameWonBinding

class GameWonFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        // Note: Fragment requires you to manually inflate and return layout
        //       vs where Activity does it via setContentView in onCreate
        val binding: FragmentGameWonBinding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_game_won, container, false)

        return binding.root
    }
}
