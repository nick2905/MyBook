package com.proyek.mamikos.mybook.utils

import java.text.SimpleDateFormat
import java.util.*

class DateConverter {

    fun covertDate(date: String): String {
        val inputFormatter = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US)
        val outputFormatter = SimpleDateFormat("dd MMM yyyy", Locale.US)

        var answer: Date = inputFormatter.parse(date)

        return outputFormatter.format(answer).toString()
    }

}