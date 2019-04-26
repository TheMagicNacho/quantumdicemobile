package com.example.quantum_dice_mobile

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    // constructor(parcel: Parcel) : this() {}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // get reference to button
        val roll = findViewById<Button>(R.id.button)

        // set on-click listener
        roll.setOnClickListener {
            val dice = numDice.text.toString()
            val sides = numSides.text.toString()
            val mod = numMod.text.toString()
            val xdice = Integer.parseInt(dice)
            val xsides = Integer.parseInt(sides)
            val xmod = Integer.parseInt(mod)

            // LIST
            val listRoll = mutableListOf(1)
            listRoll.removeAt(0)
            for (i in 1..xdice) {
                //random number generator - TODO: insert quantum engine requirements here
                val randomGenerator = Random()
                val randInt = randomGenerator.nextInt(xsides) + 1
                listRoll.add(randInt)
            }

            val final = listRoll.sum()+xmod

            //display
            this.findViewById<TextView>(R.id.displayRoll).apply {
                text = listRoll.toString()
            }
            this.findViewById<TextView>(R.id.displayMod).apply {
                text = mod
            }
            this.findViewById<TextView>(R.id.displayFinal).apply {
                text = final.toString()
            }
            //Toast.makeText(this@MainActivity, "You clicked me.", Toast.LENGTH_SHORT).show()
        }
    }}