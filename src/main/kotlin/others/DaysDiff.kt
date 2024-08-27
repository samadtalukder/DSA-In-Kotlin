import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit

fun main() {
    val currentDate = getCurrentDate()
    //val currentDate = "2022-09-06T00:00:00+0800"
    val toDate = "2023-05-30T00:00:00+0800"
    val appleCount:Int
    appleCount = 10

    println(appleCount)

    println("daysDifference: ${daysDifference(currentDate, toDate)}")
}

fun getCurrentDate(): String {
    val formatter = SimpleDateFormat("yyyy-MM-dd", Locale.US)
    val calendarIns = Calendar.getInstance()
    return formatter.format(calendarIns.time)
}

fun daysDifference(currentDate: String,toDate: String): Int? {
    var days: Int? = 0
    try {
        val formatter = SimpleDateFormat("yyyy-MM-dd", Locale.US)

        val date1: Date = formatter.parse(toDate) as Date
        val date2: Date = formatter.parse(currentDate) as Date

        val diff = date1.time - date2.time

        days = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS).toInt()

    } catch (e: NumberFormatException) {
        e.printStackTrace()
    }
    return days
}