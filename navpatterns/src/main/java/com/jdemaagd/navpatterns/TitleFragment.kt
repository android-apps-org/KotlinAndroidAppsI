package com.jdemaagd.navpatterns

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.jdemaagd.navpatterns.databinding.FragmentTitleBinding

// App Start Destination on Navigation Graph -->
class TitleFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding: FragmentTitleBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_title, container, false)

        // Navigate to GameFragment
        binding.btnPlay.setOnClickListener {
            it.findNavController().navigate(TitleFragmentDirections.actionTitleFragmentToGameFragment())
        }

        // Note: let Android know we have menu associated with this Fragment
        setHasOptionsMenu(true)

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.overflow_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Note: leverage Navigation to find AboutFragment on navigation graph
        //       there was no Action connecting TitleFragment to AboutFragment
        //       menus can navigate to more than one destination, so navigate directly to destination(s)
        return NavigationUI.onNavDestinationSelected(
            item, requireView().findNavController()) ||
                super.onOptionsItemSelected(item)
    }
}