package com.ritikcoder.project33ofandroiddevelopment_bmicalculator

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ritikcoder.project33ofandroiddevelopment_bmicalculator.databinding.ActivityMain2Binding
import kotlin.math.pow

class MainActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.buttonForBMICalculator.setOnClickListener {
            calculateBMI()
        }


    }

    @SuppressLint("SetTextI18n")
    private fun calculateBMI(){
        val weight= binding.editTextForWeightEdit.text.toString().toFloatOrNull()
        val height= binding.editTextForHeightEdit.text.toString().toFloatOrNull()

        if (weight != null && height != null){
            val bmi= weight/ (height/ 100).pow(2)
            val bmiResult= String.format("%.2f", bmi)

            val bmiCategory= when {
                bmi < 18.5 -> "Under Weight"
                bmi < 25 -> "Normal Weight"
                bmi < 30 -> "Over Weight"
                else -> "Obese"
            }
            binding.textViewForResult.text= "BMI: $bmiResult\nCategory: $bmiCategory"
        } else {
                binding.textViewForResult.text= "Invalid Input"
            }

    }

}