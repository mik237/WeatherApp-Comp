package me.ibrahim.weatherapp_comp.utils

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

object Utils {
    fun timestampToDay(timestamp: Long): String {
        val format = SimpleDateFormat("EEEE, MMM dd", Locale.getDefault())
        val date = Date(timestamp)
        return format.format(date)
    }
}