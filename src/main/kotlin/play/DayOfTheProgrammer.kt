package play

fun dayOfProgrammer(year: Int): String {
    val dayWithoutLeap = lazy {
        "13.09.$year"
    }
    val dayWithLeap = lazy {
        "12.09.$year"
    }

    when {
        year >= 1919 -> { // modern (gregorian calendar)
            return if ((year % 400 == 0) || (year % 4 == 0 && year % 100 != 0)) {
                dayWithLeap.value
            } else {
                dayWithoutLeap.value
            }
        }

        year == 1918 -> { // transition Feb, 14th is 32nd day
            return "30.08.$year"
        }

        year in 1700..1917 -> { // older (julian calendar)
            return if (year % 4 == 0) {
                dayWithLeap.value
            } else {
                dayWithoutLeap.value
            }
        }

    }

    throw IllegalArgumentException()
}
