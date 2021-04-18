package com.example.castparty2.utils


fun splitToComponentTimes(totalSecs: Int): String {
    val hours = totalSecs / 3600;
    val minutes = (totalSecs % 3600) / 60;
    val seconds = totalSecs % 60;

    return String.format("%02d:%02d:%02d", hours, minutes, seconds);
}