import org.junit.Test
import kotlin.test.assertEquals

class Day05Test {

    @Test
    fun `should correctly get top crates after moves are done`() {
        val data = DataParser.parseStrings("day05.txt", trim = false)

        assertEquals("CMZ", Day05.getTopCrates(data))
    }

    @Test
    fun `should correctly get top crates after moves are done with new crane model`() {
        val data = DataParser.parseStrings("day05.txt", trim = false)

        assertEquals("MCD", Day05.getTopCrates(data, true))
    }
}