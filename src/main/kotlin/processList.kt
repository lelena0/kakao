fun processList(input: List<Double?>): Double {
    val filteredList = input.filterNotNull()
        .filter { it <= 25 }
        .take(10)
        .map { if (it.toInt() % 2 != 0) it / 2 else it * it }
        .sortedDescending()

    val sum = filteredList.sum()
    println("%.2f".format(sum))
    return sum
}

fun main() {
    val example1 = listOf(13.31, 3.98, 12.0, 2.99, 9.0)
    val example2 = listOf(133.21, null, 233.98, null, 26.99, 5.0, 7.0, 9.0)

    processList(example1)
    processList(example2)
}