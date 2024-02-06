package edu.temple.inclassuiacvitivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spinner = findViewById<Spinner>(R.id.spinner)
        val displayTextView = findViewById<TextView>(R.id.textDisplay)

        val numberArray = arrayListOf<Int>()
        for (i in 1..100){
            if (i % 2 == 0){
                numberArray.add(i)
            }
        }

        spinner.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, numberArray)



        spinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long){
                p0?.run{
                    val number = getItemAtPosition(p2).toString()
                    displayTextView.textSize = number.toFloat()
                }
            }
            override fun onNothingSelected(p0: AdapterView<*>?){

            }
        }

    }
}