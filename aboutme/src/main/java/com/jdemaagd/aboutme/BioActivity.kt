package com.jdemaagd.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import com.jdemaagd.aboutme.databinding.ActivityBioBinding

class BioActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBioBinding

    private val myName: Name = Name("Jon DeMaagd", "Nick Name..")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_bio)

        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }

        binding.myName = myName

        binding.btnDone.setOnClickListener { view ->
            addNickName(view)
        }
    }

    private fun addNickName(view: View) {
        binding.apply {
            tvNickName.text = this.etNickName.text
            invalidateAll()
            etNickName.visibility = View.GONE
            btnDone.visibility = View.GONE
            tvNickName.visibility = View.VISIBLE
        }

        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}