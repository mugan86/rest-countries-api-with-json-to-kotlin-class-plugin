package utils

/**
 * Created by anartzmugika on 13/10/17.
 */
fun cleanStringResult(value: String) =  value.replace("[", "").replace("]", "")

fun countSelectCharInString (word:String, findChar: Char): Int {
    var countAppearances = 0;
    for (i in 0..word.length - 1) {
        if (word.get(i) == findChar) {
            countAppearances+= 1
        }
    }
    return countAppearances
}

fun CharSequence.toChar() = single()