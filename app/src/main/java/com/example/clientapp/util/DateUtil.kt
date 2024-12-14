package com.example.clientapp.util

import java.util.Calendar


object DateUtil {
    fun getYear():Int {
       return Calendar.getInstance().get(Calendar.YEAR)
    }


    fun getMonth():Int {
        return Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
    }
}