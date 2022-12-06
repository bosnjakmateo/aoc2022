import org.junit.Test
import kotlin.test.assertEquals

class Day06Test {

    @Test
    fun `should calculate number of characters before start of packet`() {
        assertEquals(7, Day06.countCharactersBeforeMarker("mjqjpqmgbljsphdztnvjfqwrcgsmlb", 4))
        assertEquals(5, Day06.countCharactersBeforeMarker("bvwbjplbgvbhsrlpgdmjqwftvncz", 4))
        assertEquals(6, Day06.countCharactersBeforeMarker("nppdvjthqldpwncqszvftbrmjlhg", 4))
        assertEquals(10, Day06.countCharactersBeforeMarker("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg", 4))
        assertEquals(11, Day06.countCharactersBeforeMarker("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw", 4))
    }

    @Test
    fun `should calculate number of characters before start of message`() {
        assertEquals(19, Day06.countCharactersBeforeMarker("mjqjpqmgbljsphdztnvjfqwrcgsmlb", 14))
        assertEquals(23, Day06.countCharactersBeforeMarker("bvwbjplbgvbhsrlpgdmjqwftvncz", 14))
        assertEquals(23, Day06.countCharactersBeforeMarker("nppdvjthqldpwncqszvftbrmjlhg", 14))
        assertEquals(29, Day06.countCharactersBeforeMarker("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg", 14))
        assertEquals(26, Day06.countCharactersBeforeMarker("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw", 14))
    }
}