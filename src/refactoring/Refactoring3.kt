import java.awt.Color

// example from Effective Kotlin

data class Weather(val description: String, val color: Color)

fun updateWeather(degrees: Int): Weather {
    return when {
        degrees < 5 -> Weather("cold", Color.BLUE)
        degrees in 5..22 -> Weather("mild", Color.YELLOW)
        else -> Weather("hot", Color.RED)
    }
}
