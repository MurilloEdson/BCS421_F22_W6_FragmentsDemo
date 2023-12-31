package edu.farmingdale.bcs421.bcs421_f22_w6_fragmentsdemo

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.Button
import android.widget.EditText
import android.widget.SeekBar
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {
    lateinit var mBtn1:Button
    lateinit var mBtn2:Button
    lateinit var mTV:TextView


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        mBtn1 = findViewById(R.id.btn1)
        mBtn2 = findViewById(R.id.btn2)
        var seekbar = findViewById<SeekBar>(R.id.seekBar)
        var editText = findViewById<EditText>(R.id.editText01)
        mTV = findViewById(R.id.tv1)
        val frgmnt01 = Fragment01()
        val frgmnt02 = Fragment02()

        seekbar?.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, p1: Int, p2: Boolean) {
                mTV.setTextSize(p1.toFloat())
                editText.setText(p1.toString())
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
                //editText.setText(seekbar.progress.toString())
            }

        })




        mBtn1.setOnClickListener{
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.framelayout1, frgmnt01)
                commit()
            }
        }
        mBtn2.setOnClickListener{
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.framelayout1, frgmnt02)
                commit()
            }
            readFromSharedPref()
        }
    }

    private fun readFromSharedPref(){
        var sharedPref= getSharedPreferences(MainActivity().SHAREDPREF_FILENAME, MODE_PRIVATE)
        mTV.setText(sharedPref.getString("KEY", "not forund"))
    }
}