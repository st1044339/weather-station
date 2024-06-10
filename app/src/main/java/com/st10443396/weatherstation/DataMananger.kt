package com.st10443396.weatherstation

import android.text.Editable

class DataManger {
    companion object {
        var strDate = mutableListOf<String>()
        var intMorning = mutableListOf<Int>()
        var intAfternoon = mutableListOf<Int>()
        var strNotes = mutableListOf<String>()

        fun saveData(date: Editable, morning: Int, afternoon: Int, notes: String) {
            strDate.add(date.toString())
            intMorning.add(morning)
            intAfternoon.add(afternoon)
            strNotes.add(notes)
        }

        fun calculateAverageTemperature(): Double{
            val totalDays = strDate.size
            val totalTemperature = intMorning.sum() + intAfternoon.sum()
            return if (totalDays > 0) totalTemperature.toDouble() / totalDays else 0.0
        }

        fun getNumberOfDays(): Int {
            return strDate.size
        }
    }
}