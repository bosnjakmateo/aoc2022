import Day05.getTopCrates

object Day05 {

    fun getTopCrates(data: List<String>, canMoveMultipleCrates: Boolean = false): String {
        val (crates, moves) = parseData(data)

        moves.forEach { move ->
            val cratesToMove = crates[move.from - 1].take(move.size)
            repeat(move.size) { crates[move.from - 1].removeFirst() }
            crates[move.to - 1].addAll(index = 0, resolveCrateOrder(canMoveMultipleCrates, cratesToMove))
        }

        return crates.filter { it.isNotEmpty() }.joinToString("") { it.first() }
    }

    private fun resolveCrateOrder(canMoveMultipleCrates: Boolean, cratesToMove: List<String>) =
        if (canMoveMultipleCrates) cratesToMove else cratesToMove.reversed()

    private fun parseData(data: List<String>): Pair<MutableList<ArrayDeque<String>>, List<Move>> {
        val bottomCratesIndex = data.indexOfFirst { row -> row.all { it.isDigit() || it.isWhitespace() } } - 1

        val crates = parseCrates(data, bottomCratesIndex)
        val moves = parseMoves(data, bottomCratesIndex)

        return Pair(crates, moves)
    }

    private fun parseCrates(
        data: List<String>,
        bottomCratesIndex: Int,
    ): MutableList<ArrayDeque<String>> {
        val crates = MutableList<ArrayDeque<String>>(data[bottomCratesIndex].length / 3) { ArrayDeque() }

        for (i in bottomCratesIndex downTo 0) {
            data[i].windowed(size = 3, step = 4).forEachIndexed { index, it ->
                if (it.isBlank()) return@forEachIndexed

                crates[index].addFirst(it.removeSurrounding("[", "]"))
            }
        }

        return crates
    }

    private fun parseMoves(data: List<String>, bottomCratesIndex: Int) =
        data.drop(bottomCratesIndex + 3).map {
            val (size, from, to) = it.findAllNumbers()
            Move(size, from, to)
        }

    data class Move(val size: Int, val from: Int, val to: Int)
}

fun main() {
    val data = DataParser.parseStrings("day05.txt")

    println("Solutions")
    println("Part one: ${getTopCrates(data)}")
    println("Part two: ${getTopCrates(data, true)}")
}