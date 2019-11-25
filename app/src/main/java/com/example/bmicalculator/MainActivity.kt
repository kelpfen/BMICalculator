package com.example.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.pow

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        buttonCalculate.setOnClickListener(){
            try {
                val weight: Double = txtWeight.text.toString().toDouble()
                val height: Double = txtHeight.text.toString().toDouble()
//jj
                val bmi: Double = weight / (height * height)
                val result: String



                if (bmi < 18.5) {
                    imageView.setImageResource(R.drawable.under)
                    result = "Under"
                } else if (bmi >= 18.5 && bmi <= 24.9) {
                    imageView.setImageResource(R.drawable.normal)
                    result = "Normal"
                } else {
                    imageView.setImageResource(R.drawable.over)
                    result = "Over"
                }

                textView5.text = "BMI : %.2f (%s)".format(bmi, result)
            }catch (e : Exception){

                val toast: Toast = Toast.makeText(this, "Invalid Input", Toast.LENGTH_LONG)
                toast.setGravity(Gravity.CENTER, 0, 0)
                toast.show()
            }

        }


        buttonReset.setOnClickListener(){
            txtHeight.text = null;
            txtWeight.text = null;

            textView5.text = null;
            imageView.setImageResource(R.drawable.empty)
        }
    }


}
