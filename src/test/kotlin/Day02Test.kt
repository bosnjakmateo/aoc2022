import org.junit.Test
import kotlin.test.assertEquals

class Day02Test {

    @Test
    fun `should calculate correct score`() {
        val data = DataParser.parseStrings("day02.txt")

        assertEquals(15, Day02.calculateScore(data))
    }

    @Test
    fun `should resolve strategy and calculate correct score`() {
        val data = DataParser.parseStrings("day02.txt")

        assertEquals(12, Day02.resolveStrategyGuideAndCalculate(data))
    }
}