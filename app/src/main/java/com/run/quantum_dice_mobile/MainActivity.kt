package com.run.quantum_dice_mobile

import android.app.AlertDialog

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.PopupMenu
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import com.chaquo.python.Python
import com.chaquo.python.android.AndroidPlatform
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import kotlin.concurrent.thread


class MainActivity : AppCompatActivity() {

    private fun isNetworkConnected(): Boolean {
        val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectivityManager.activeNetworkInfo
        return networkInfo != null && networkInfo.isConnected
    }
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        // CALL ASSETS
        setContentView(R.layout.activity_main)

        val roll = findViewById<Button>(R.id.button)
        // spinner bar



        // ADD MENU
        menu_btn.setOnClickListener {
            val popupMenu = PopupMenu(this, it)
            popupMenu.setOnMenuItemClickListener { item ->
                when (item.itemId){
                    R.id.about -> {
                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://artemisorbitals.com/products/the-quantum-dice/"))
                        startActivity(intent)
                        true
                    }
                    R.id.version -> {
                        Toast.makeText(this, "Q-Dice Version : " + BuildConfig.VERSION_NAME, Toast.LENGTH_LONG).show()
                        true
                    }
                    R.id.copyright -> {
                        AlertDialog.Builder(this).setTitle("GNU Public License")
                            .setMessage("The Quantum Dice is released under the GNU General Public License is a free, copyleft license for software and other kinds of works. Please feel free to dissect, inspect, and improve this software.")
                            .setPositiveButton(android.R.string.ok) { _, _ -> }
                            .setIcon(android.R.drawable.ic_input_get).show()
                        true
                    }
                    else -> false
                }
            }
            popupMenu.inflate(R.menu.menu_main)
            try {
                val fieldMPopup = PopupMenu::class.java.getDeclaredField("mPopup")
                fieldMPopup.isAccessible = true
                val mPopup = fieldMPopup.get(popupMenu)
                mPopup.javaClass
                    .getDeclaredMethod("setForceShowIcon", Boolean::class.java)
                    .invoke(mPopup, true)
            } catch (e: Exception){
                Log.e("Main", "Error showing menu icons.", e)
            } finally {
                popupMenu.show()
            }
        }
        // spinner bar



        // LISTEN FOR ROLL
        roll.setOnClickListener {



            val dice = numDice.text.toString()
            val sides = numSides.text.toString()
            val mod = numMod.text.toString()
                // START THE INPUT VALIDATOR
            if (sides != "" && dice != "") {
                if (isNetworkConnected()) {
                    doAsync {
                        uiThread { Toast.makeText(this@MainActivity, "Quantum Integer Engine", Toast.LENGTH_SHORT).show()

                        }
                    }
                    //If user inputs int and there is a network for QISKIT
                    var xdice = Integer.parseInt(dice)
                    val psides = Integer.parseInt(sides)
                    val xsides = psides.toString()
                    val xmod = Integer.parseInt(mod)
                    // LIST
                    val listRoll = mutableListOf(1)
                    listRoll.removeAt(0)
                    for (i in 1..xdice) {



                        //START PYTHON & CALL QUANTUM ENGINE
                        if (! Python.isStarted()) {
                            Python.start(AndroidPlatform(this))
                        }
                        val py: Python = Python.getInstance()
                        var rawQ = py.getModule("qengine").callAttr("randint", xsides)
                        var callQ = rawQ.toString()
                        var qint = Integer.parseInt(callQ)
                        //END PYTHON / APPEND ANSERS TO LIST

                        listRoll.add(qint)
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
                } else {
                    doAsync {
                        uiThread { Toast.makeText(this@MainActivity, "Pseudorandom Interger Used", Toast.LENGTH_SHORT).show()
                        }
                    }
                    //IF USER INPUTS INT BUT THERE IS NO NETWORK AVAILABLE
                    var xdice = Integer.parseInt(dice)
                    val psides = Integer.parseInt(sides)
                    val xmod = Integer.parseInt(mod)
                    // LIST
                    val listRoll = mutableListOf(1)
                    listRoll.removeAt(0)
                    for (i in 1..xdice) {
                        val randy = (1..psides).shuffled().first()
                        // append to list
                        listRoll.add(randy) //TODO: re-include randint
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
                    } }
                    // INPUT ERROR HANDLE
                            } else {
                AlertDialog.Builder(this).setTitle("Please Enter a Number")
                    .setMessage("INTEGER ERROR: You must enter a number for dice and sides. The modifier may be left Zero.")
                    .setPositiveButton(android.R.string.ok) { _, _ -> }
                    .setIcon(android.R.drawable.ic_input_get).show()
            }   } } }
