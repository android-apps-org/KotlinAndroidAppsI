package com.jdemaagd.navpatterns

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class RulesFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        // Note: Fragment requires you to manually inflate and return layout
        //       vs where Activity does it via setContentView in onCreate
        return inflater.inflate(R.layout.fragment_rules, container, false)
    }
}
