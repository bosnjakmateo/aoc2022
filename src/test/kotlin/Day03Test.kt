import org.junit.Test
import kotlin.test.assertEquals

class Day03Test {

    @Test
    fun `should calculate the sum of priorities`() {
        val data = DataParser.parseStrings("day03.txt")

        assertEquals(157, Day03.calculateSumOfPriorities(data))
    }

    @Test
    fun `should calculate the sum of badge priorities`() {
        val data = DataParser.parseStrings("day03.txt")

        assertEquals(70, Day03.calculateSumOfBadgePriorities(data))
    }
}