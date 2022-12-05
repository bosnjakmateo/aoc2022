import Day04.calculateCompletelyOverlappingSections
import Day04.calculatePartiallyOverlappingSections

object Day04 {

    fun calculateCompletelyOverlappingSections(data: List<String>): Int {
        return data
            .map(::parseSections)
            .count { checkIfSectionsIntersect(it, ::containsCompletely) }
    }

    fun calculatePartiallyOverlappingSections(data: List<String>): Int {
        return data
            .map(::parseSections)
            .count { checkIfSectionsIntersect(it, ::containsPartially) }
    }

    private fun parseSections(data: String): Pair<Section, Section> {
        val (
            startFirstSection,
            endFirstSection,
            startSecondSection,
            endSecondSection,
        ) = data.findAllNumbers()

        return Pair(
            Section(startFirstSection, endFirstSection),
            Section(startSecondSection, endSecondSection)
        )
    }

    private fun checkIfSectionsIntersect(
        pair: Pair<Section, Section>,
        intersect: (Section, Section) -> Boolean,
    ) = intersect(pair.first, pair.second) || intersect(pair.second, pair.first)

    private fun containsCompletely(section: Section, otherSection: Section) =
        (otherSection.start in section.start..section.end) && (otherSection.end in section.start..section.end)

    private fun containsPartially(section: Section, otherSection: Section) =
        (otherSection.start in section.start..section.end) || (otherSection.end in section.start..section.end)

    data class Section(val start: Int, val end: Int)
}

fun main() {
    val data = DataParser.parseStrings("day04.txt")

    println("Solutions")
    println("Part one: ${calculateCompletelyOverlappingSections(data)}")
    println("Part two: ${calculatePartiallyOverlappingSections(data)}")
}