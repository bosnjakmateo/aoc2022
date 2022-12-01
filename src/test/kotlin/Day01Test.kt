import org.junit.Test
import kotlin.test.assertEquals

class Day01Test {

    @Test
    fun `should calculate calories for top elf`() {
        val data = DataParser.parseStrings("day01.txt")

        assertEquals(24000, Day01.calculateMostCaloriesCarried(data))
    }

    @Test
    fun `should calculate calories for top 3 elves`() {
        val data = DataParser.parseStrings("day01.txt")

        assertEquals(45000, Day01.calculateMostCaloriesCarried(data, numberOfElves = 3))
    }
}