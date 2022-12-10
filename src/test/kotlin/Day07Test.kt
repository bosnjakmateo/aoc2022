import org.junit.Test
import kotlin.test.assertEquals

class Day07Test {

    @Test
    fun `should calculate sum of all directories with size less than 100_000`() {
        val data = DataParser.parseStrings("day07.txt")

        assertEquals(95437, Day07.calculateSumOfSmallDirectoriesSize(data))
    }

    @Test
    fun `should calculate ideal directory size to delete`() {
        val data = DataParser.parseStrings("day07.txt")

        assertEquals(24933642, Day07.calculateIdealDirectorySizeForDeletion(data))
    }
}