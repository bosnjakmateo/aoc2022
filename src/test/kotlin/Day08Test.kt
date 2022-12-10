import org.junit.Test
import kotlin.test.assertEquals

class Day08Test {

    @Test
    fun `should calculate number of visible trees`() {
        val data = DataParser.parseStrings("day08.txt")

        assertEquals(21, Day08.calculateNumberOfVisibleTrees(data))
    }

    @Test
    fun `should calculate highest scenic score`() {
        val data = DataParser.parseStrings("day08.txt")

        assertEquals(8, Day08.calculateHighestScenicScore(data))
    }
}
