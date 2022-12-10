import Day08.calculateHighestScenicScore
import Day08.calculateNumberOfVisibleTrees

object Day08 {

    fun calculateNumberOfVisibleTrees(data: List<String>): Int {
        val trees = parseData(data)

        return (1..trees[0].size - 2).sumOf { columnIndex ->
            (1..trees.size - 2).count { rowIndex ->
                val coordinates = generateCoordinates(trees, rowIndex, columnIndex)

                visible(trees, coordinates[0], columnIndex, rowIndex) ||
                visible(trees, coordinates[1], columnIndex, rowIndex) ||
                visible(trees, coordinates[2], columnIndex, rowIndex) ||
                visible(trees, coordinates[3], columnIndex, rowIndex)
            }
        }.let { it + (((trees[0].size) * 2) + ((trees.size - 2) * 2)) }
    }

    fun calculateHighestScenicScore(data: List<String>): Int {
        val trees = parseData(data)

        return (1..trees[0].size - 2).flatMap { columnIndex ->
            (1..trees.size - 2).map { rowIndex ->
                val coordinates = generateCoordinates(trees, rowIndex, columnIndex)

                listOf(
                    calculateScenicScore(trees, coordinates[0], columnIndex, rowIndex),
                    calculateScenicScore(trees, coordinates[1], columnIndex, rowIndex),
                    calculateScenicScore(trees, coordinates[2], columnIndex, rowIndex),
                    calculateScenicScore(trees, coordinates[3], columnIndex, rowIndex),
                ).reduce { acc, i -> acc * i }
            }
        }.maxOf { it }
    }

    private fun generateCoordinates(trees: List<List<Int>>, rowIndex: Int, columnIndex: Int) =
        listOf(
            (rowIndex - 1 downTo 0).zip(List(trees[0].size - 2) { columnIndex }),
            (rowIndex + 1 until trees.size).zip(List(trees[0].size - 2) { columnIndex }),
            List(trees.size - 2) { rowIndex }.zip(columnIndex + 1 until trees[0].size),
            List(trees.size - 2) { rowIndex }.zip(columnIndex - 1 downTo 0),
        )

    private fun visible(
        trees: List<List<Int>>,
        coordinates: List<Pair<Int, Int>>,
        columnIndex: Int,
        rowIndex: Int,
    ): Boolean {
        (coordinates).forEach {
            if (trees[it.first][it.second] >= trees[rowIndex][columnIndex]) {
                return false
            }
        }
        return true
    }

    private fun calculateScenicScore(
        trees: List<List<Int>>,
        coordinates: List<Pair<Int, Int>>,
        columnIndex: Int,
        rowIndex: Int,
    ): Int {
        var count = 0
        (coordinates).forEach {
            if (trees[it.first][it.second] < trees[rowIndex][columnIndex]) {
                count++
            } else {
                count++
                return count
            }
        }
        return count
    }

    private fun parseData(data: List<String>): List<List<Int>> {
        return data.map { row ->
            row.map { it.digitToInt() }
        }
    }
}

fun main() {
    val data = DataParser.parseStrings("day08.txt")

    println("Solutions")
    println("Part one: ${calculateNumberOfVisibleTrees(data)}")
    println("Part two: ${calculateHighestScenicScore(data)}")
}