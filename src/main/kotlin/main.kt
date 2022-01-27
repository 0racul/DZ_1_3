
fun whatNumeralToUse(seconds: Int): String{

    val numeral = when (seconds){

        in 0..60 -> "now"
        in 61..60*60 -> "min"
        in 60*60 + 1..24*60*60 -> "hours"
        in 24*60*60 + 1..24*60*60*2 -> "today"
        in 24*60*60*2 + 1..24*60*60*3 -> "yesterday"
        else -> "ages_ago"
    }

    return numeral

}


fun getThePhrase(seconds: Int): String{

    val num = whatNumeralToUse(seconds)
    var keyWord = ""

    when (num){
        "min" -> keyWord = getMinutesPhrase(seconds)
        "hours" -> keyWord = getHoursPhrase(seconds)
    }

    var phrase = ""

    when (num){
        "ages_ago" -> phrase = "Был давно"
        "yesterday" -> phrase = "Был вчера"
        "today" -> phrase = "Был сегодня"
        in "min", "hours" -> phrase = "Был $keyWord  назад"
    }

    return phrase

}


fun getMinutesPhrase(seconds: Int): String{

    val minutes = seconds / 60
    var keyWord = ""

    when {

        ((minutes / 5) % 2 == 1) && minutes in 11..20 -> keyWord = "$minutes минут"
        (minutes % 10 == 1 || minutes / 10 != 1) && minutes == 1 -> keyWord = "$minutes минуту"
        (minutes % 10 in 2..4) || (minutes / 10 != 1) -> keyWord = "$minutes минуты"

    }

    return keyWord

}


fun getHoursPhrase(seconds: Int): String{

    val hours = seconds / 60 / 60
    var keyWord = ""

    when {

        hours == 1 && hours == 21 -> keyWord = "$hours час"
        hours in 2..4 && hours in 22..23 -> keyWord = "$hours часа"
        hours in 5..20 -> keyWord = "$hours часов"

    }

    return keyWord

}


fun main(args: Array<String>) {








}