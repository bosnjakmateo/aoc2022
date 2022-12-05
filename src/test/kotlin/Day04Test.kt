import org.junit.Test
import kotlin.test.assertEquals

class Day04Test {

    @Test
    fun `should calculate completely overlapping sections`() {
        val data = DataParser.parseStrings("day04.txt")

        assertEquals(2, Day04.calculateCompletelyOverlappingSections(data))
    }

    @Test
    fun `should calculate partially overlapping sections`() {
        val data = DataParser.parseStrings("day04.txt")

        assertEquals(4, Day04.calculatePartiallyOverlappingSections(data))
    }
}