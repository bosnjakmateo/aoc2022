import Day03.calculateSumOfBadgePriorities
import Day03.calculateSumOfPriorities

object Day03 {

    fun calculateSumOfPriorities(data: List<String>): Int {
        return data
            .map(::splitCompartments)
            .map(::splitItems)
            .map(::findIntersectedItem)
            .sumOf(::getPriority)
    }

    fun calculateSumOfBadgePriorities(data: List<String>): Int {
        return data.chunked(3)
            .map(::splitIntoGroup)
            .map(::findBadgeInGroup)
            .sumOf(::getPriority)
    }

    private fun splitIntoGroup(group: List<String>): List<List<String>> {
        return group.map { it.split("").filterNotEmpty() }
    }

    private fun findBadgeInGroup(group: List<List<String>>): String {
        return group[0].intersect(group[1].toSet()).intersect(group[2].toSet()).first()
    }

    private fun splitCompartments(bag: String) =
        bag.substring(0, bag.length / 2) to bag.substring(bag.length / 2, bag.length)

    private fun splitItems(bag: Pair<String, String>) =
        bag.first.split("").filterNotEmpty() to bag.second.split("").filterNotEmpty()

    private fun findIntersectedItem(bag: Pair<List<String>, List<String>>) =
        bag.first.intersect(bag.second.toSet()).first()

    private fun getPriority(letter: String): Int {
        val asciiCode = letter.first().code
        return if (asciiCode >= 97) {
            asciiCode - 96
        } else {
            asciiCode - 38
        }
    }
}

fun main() {
    val data = DataParser.parseStrings("day03.txt")

    println("Solutions")
    println("Part one: ${calculateSumOfPriorities(data)}")
    println("Part two: ${calculateSumOfBadgePriorities(data)}")
}