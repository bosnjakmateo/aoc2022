import Day06.countCharactersBeforeMarker

object Day06 {

    fun countCharactersBeforeMarker(data: String, markerSize: Int): Int {
        data
            .toList()
            .windowed(size = markerSize, step = 1)
            .forEachIndexed { index, characters ->
                if (characters.toSet().size == markerSize) {
                    return index + markerSize
                }
            }

        error("This should not happen")
    }
}

fun main() {
    val data = DataParser.parseString("day06.txt")

    println("Solutions")
    println("Part one: ${countCharactersBeforeMarker(data, markerSize = 4)}")
    println("Part two: ${countCharactersBeforeMarker(data, markerSize = 14)}")
}