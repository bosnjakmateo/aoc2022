import Day01.calculateMostCaloriesCarried

object Day01 {

    fun calculateMostCaloriesCarried(data: List<String>, numberOfElves: Int = 1): Int {
        return data
            .joinToString(" ")
            .split("  ")
            .map { calories -> calories.split(" ").sumOf { it.toInt() } }
            .sorted()
            .takeLast(numberOfElves)
            .sum()
    }
}

fun main() {
    val data = DataParser.parseStrings("day01.txt")

    println("Solutions")
    println("Part one: ${calculateMostCaloriesCarried(data)}")
    println("Part two: ${calculateMostCaloriesCarried(data, numberOfElves = 3)}")
}