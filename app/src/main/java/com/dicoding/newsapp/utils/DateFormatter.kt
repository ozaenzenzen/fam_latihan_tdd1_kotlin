package com.dicoding.newsapp.utils

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.TimeZone

object DateFormatter {
    @RequiresApi(Build.VERSION_CODES.O)
    fun formatDate(currentDateString: String): String {
        val instant = Instant.parse(currentDateString)
        val formatter = DateTimeFormatter.ofPattern("dd MMM yyyy | HH:mm")
            .withZone(ZoneId.of(TimeZone.getDefault().id))
        return formatter.format(instant)
    }
}