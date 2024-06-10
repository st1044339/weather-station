package com.st10443396.weatherstation

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.text.ParseException
import java.text.SimpleDateFormat

class MainActivity2 : AppCompatActivity() {
    private lateinit var  etDate: EditText
    private lateinit var  etMorning: EditText
    private lateinit var  etAfternoon: EditText
    private lateinit var  strNotes: EditText
    private lateinit var  tvErrors: TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        //initialize views
        etDate = findViewById(R.id.etDate)
        etMorning = findViewById(R.id.etMorning)
        etAfternoon = findViewById(R.id.etAfternoon)
       strNotes = findViewById(R.id.strNotes)
        tvErrors = findViewById(R.id.tvErrors)

        val btnClear: Button = findViewById(R.id.btnclear)
        btnClear.setOnClickListener { clearForm()
        }

    }

    private fun clearForm() {
        TODO("Not yet implemented")
    }

    private fun saveData(){
        val date = etDate.text
        val morningStr = etMorning.text.toString()
        val afternoonStr = etAfternoon.text.toString()
        val notes =  strNotes.text.toString()
        val errors = mutableListOf<String>()
        if (DataManger.getNumberOfDays()<= 7){

            // Validate date format
            try {
                val dateFormat = SimpleDateFormat("d MMM yyyy, Locale.US")
                dateFormat.parse(date.toString())// Check if parsing succeeds
            }catch (e:ParseException){
                errors.add("Invalid date format. Use format: 6 June 2024")
            }

            // validate morning and afternoon temperature

            val morning = morningStr.toIntOrNull()
            val afternoon = afternoonStr.toIntOrNull()
            if (morning == null || afternoon == null) {
                errors.add("Morning and Afternoon temperature must be numerical.")
            }else{
                if (morning < 0 || morning > 240){
                    errors.add("Morning temperature must be between 0 and 240 degrees.")
                }
                if (afternoon< 0 || afternoon > 240){
                    error("Afternoon temperature must be between 0 and 240 degree.")
            }

        }
            // Display error messages (if any)
            if (errors.isNotEmpty()){
                val errorMessage = errors.joinToString("\n")
                tvErrors.text = errorMessage
                return
            }

            // Save data to parallel arrays
            if (morning != null && afternoon != null){
            }
            if (afternoon != null) {
                if (morning != null) {
                    DataManger.saveData(date, morning, afternoon, notes)
                }
            }


                // Clear input fields for next input
                etDate.text.clear()
                etMorning.text.clear()
                etAfternoon.text.clear()
                strNotes.text.clear()

                }else{

                    tvErrors.text = "You have already saved 7 days of information"



        }

        fun clearForm(){
            etDate.text.clear()
            etMorning.text.clear()
            etAfternoon.text.clear()
            strNotes.text.clear()
        }

    }
}