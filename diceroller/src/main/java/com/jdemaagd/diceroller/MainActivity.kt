package com.jdemaagd.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    // Note: lateinit pattern to initialize non-null variables
    //       promise to compiler that variable will be initialized before calling any operation on it
    lateinit var diceImage: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Note: findViewById can be a very expensive operation
        diceImage = findViewById(R.id.iv_dice)

        val btnRoll: Button = findViewById(R.id.btn_roll)
        btnRoll.setOnClickListener {
            // Toast.makeText(this, "Button Clicked!", Toast.LENGTH_SHORT).show()
            rollDice()
        }
    }

    private fun rollDice() {

        val drawableResource = when (Random.nextInt(6) + 1) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        // Note: getting new reference to image view on every roll
        //       minimize calls to findViewById (searching view hierarchy - expensive operation)
        // val imageViewDice: ImageView = findViewById(R.id.iv_dice)
        // imageViewDice.setImageResource(drawableResource)

        diceImage.setImageResource(drawableResource)
    }
}