package com.example.quantum_dice_mobile

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.chaquo.python.PyObject
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
//python integration
import com.chaquo.python.Python
import com.chaquo.python.android.AndroidPlatform

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
            if (! Python.isStarted()) {
                Python.start(AndroidPlatform(this))
            }

            val py: Python = Python.getInstance()
            var qint = py.getModule("qengine").callAttr("grab", sides)

            //my_text_view.text = qint.toString()

            // LIST
            val listRoll = mutableListOf(1)
            listRoll.removeAt(0)
            for (i in 1..xdice) {
                //JAVA RANDOM NUMBER  TODO: Create java logic for degraded network conditions
                  val randomGenerator = Random()
                 val randInt = randomGenerator.nextInt(xsides) + 1
                //quantum random number


            // append to list
                listRoll.add(randInt) //TODO: re-include randint

            }


            val final = listRoll.sum()+xmod

            //display
                this.findViewById<TextView>(R.id.displayRoll).apply {
                text = listRoll.toString()
            }
            this.findViewById<TextView>(R.id.displayMod).apply {
                //text = mod
                text = qint.toString()
            }
            this.findViewById<TextView>(R.id.displayFinal).apply {
                text = final.toString()
            }
            //Toast.makeText(this@MainActivity, "You clicked me.", Toast.LENGTH_SHORT).show()
        }
    }}


