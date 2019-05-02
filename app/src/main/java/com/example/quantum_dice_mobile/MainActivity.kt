package com.example.quantum_dice_mobile

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.chaquo.python.PyObject
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.Toast
//python integration
import com.chaquo.python.Python
import com.chaquo.python.android.AndroidPlatform



class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContentView(R.layout.activity_main)
        // get reference to button
        val roll = findViewById<Button>(R.id.button)

            // some code
        // set on-click listener
        roll.setOnClickListener {
            val dice = numDice.text.toString()
            val sides = numSides.text.toString()
            val mod = numMod.text.toString()


                // START THE INPUT VALIDATOR
            if (sides != "" && dice != "") {
                //good
                // translate inputs into INT
                var xdice = Integer.parseInt(dice)
                val psides = Integer.parseInt(sides)
                val xsides = psides.toString()
                val xmod = Integer.parseInt(mod)
                // LIST
                val listRoll = mutableListOf(1)
                listRoll.removeAt(0)
                for (i in 1..xdice) {
                    //JAVA RANDOM NUMBER  TODO: Create java logic for degraded network conditions




                    //quantum random number
                    //START PYTHON
                    if (! Python.isStarted()) {
                        Python.start(AndroidPlatform(this))
                    }
                    val py: Python = Python.getInstance()
                    var rawQ = py.getModule("qengine").callAttr("randint", xsides)
                    var callQ = rawQ.toString()
                    var qint = Integer.parseInt(callQ)
                    //END PYTHON
                    // append to list
                    listRoll.add(qint) //TODO: re-include randint
                }
                val final = listRoll.sum()+xmod

                //display
                this.findViewById<TextView>(R.id.displayRoll).apply {
                    text = listRoll.toString()
                }
                this.findViewById<TextView>(R.id.displayMod).apply {
                    text = mod
                    //text = qint.toString()
                }
                this.findViewById<TextView>(R.id.displayFinal).apply {
                    text = final.toString()
                }
                    // INPUT ERROR HANDLE
                            } else {
                displayRoll.text = "You must enter a value for dice & sides."
            }

            //Toast.makeText(this@MainActivity, "You clicked me.", Toast.LENGTH_SHORT).show()
            } } }










