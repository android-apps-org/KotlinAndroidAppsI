package com.jdemaagd.androidtrivia

import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.Toast

import androidx.core.app.ShareCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController

import com.jdemaagd.androidtrivia.databinding.FragmentGameWonBinding

class GameWonFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        // Note: Fragment requires you to manually inflate and return layout
        //       vs where Activity does it via setContentView in onCreate
        val binding: FragmentGameWonBinding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_game_won, container, false)

        // Note: in layout editor popUpTo titleFragment non-inclusive
        binding.btnNextMatch.setOnClickListener {
            // it.findNavController().navigate(R.id.action_gameWonFragment_to_gameFragment)
            it.findNavController().navigate(GameWonFragmentDirections.actionGameWonFragmentToGameFragment())
        }

        // Note: let Android know a menu is associated with this Fragment
        setHasOptionsMenu(true)

        var args = GameWonFragmentArgs.fromBundle(requireArguments())
        Toast.makeText(context, "Questions: ${args.numQuestions}  ||  Correct: ${args.numCorrect}", Toast.LENGTH_LONG).show()

        return binding.root
    }

    private fun getShareIntent() : Intent {
        val args = GameWonFragmentArgs.fromBundle(requireArguments())

        return ShareCompat.IntentBuilder.from(requireActivity())
            .setText(getString(R.string.share_success_text, args.numCorrect, args.numQuestions))
            .setType("text/plain")
            .intent
    }

    private fun shareSuccess() {
        startActivity(getShareIntent())
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)

        inflater.inflate(R.menu.winner_menu, menu)

        if (null == getShareIntent().resolveActivity(requireActivity().packageManager)) {
            menu.findItem(R.id.share)?.isVisible = false
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.share -> shareSuccess()
        }

        return super.onOptionsItemSelected(item)
    }
}
