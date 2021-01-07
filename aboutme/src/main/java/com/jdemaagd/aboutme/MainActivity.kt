package com.jdemaagd.aboutme

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import com.jdemaagd.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    lateinit var layout: ConstraintLayout
    lateinit var boxOne: View
    lateinit var boxTwo: View
    lateinit var boxThree: View
    lateinit var boxFour: View
    lateinit var boxFive: View
    lateinit var greenBtn: Button
    lateinit var redBtn: Button
    lateinit var yellowBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        layout = binding.clLayout
        boxOne = binding.tvBoxOne
        boxTwo = binding.tvBoxTwo
        boxThree = binding.tvBoxThree
        boxFour = binding.tvBoxFour
        boxFive = binding.tvBoxFive
        greenBtn = binding.btnGreen
        redBtn = binding.btnRed
        yellowBtn = binding.btnYellow

        setListeners();
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_bio -> {
                val intent: Intent = Intent(this, BioActivity::class.java)
                startActivity(intent)
            }
        }

        return super.onOptionsItemSelected(item)
    }

    private fun setListeners() {
        val clickableViews: List<View> =
            listOf(boxOne, boxTwo, boxThree, boxFour, boxFive, layout, greenBtn, redBtn, yellowBtn)

        for (item in clickableViews) {
            item.setOnClickListener { colorBoxes(it) }
        }
    }

    private fun colorBoxes(view: View) {
        when (view.id) {

            // Boxes using Color class colors for background
            R.id.tv_box_one -> view.setBackgroundColor(Color.DKGRAY)
            R.id.tv_box_two -> view.setBackgroundColor(Color.GRAY)

            // Boxes using Android color resources for background
            R.id.tv_box_three -> view.setBackgroundResource(android.R.color.holo_green_light)
            R.id.tv_box_four -> view.setBackgroundResource(android.R.color.holo_green_dark)
            R.id.tv_box_five -> view.setBackgroundResource(android.R.color.holo_green_light)

            // Boxes using custom colors for background
            R.id.btn_red -> boxThree.setBackgroundResource(R.color.my_red)
            R.id.btn_yellow -> boxFour.setBackgroundResource(R.color.my_yellow)
            R.id.btn_green -> boxFive.setBackgroundResource(R.color.my_green)

            else -> view.setBackgroundColor(Color.LTGRAY)
        }
    }
}