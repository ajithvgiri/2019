package `in`.januprasad.calender

import android.graphics.Bitmap

import java.text.SimpleDateFormat
import java.util.Calendar

object Utils {

    val monthString: String
        get() {
            val cal = Calendar.getInstance()
            val monthDate = SimpleDateFormat("MMMM")
            return monthDate.format(cal.time)
        }

    val monthYearNumber: String?
        get() {
            val cal = Calendar.getInstance()
            return (cal.get(Calendar.MONTH) + 1).toString() + " - " + cal.get(Calendar.YEAR).toString()
        }

    fun getDominantColor(bitmap: Bitmap): Int {
        val newBitmap = Bitmap.createScaledBitmap(bitmap, 1, 1, true)
        val color = newBitmap.getPixel(0, 0)
        newBitmap.recycle()
        return color
    }

}
