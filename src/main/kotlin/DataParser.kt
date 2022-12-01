import java.io.File
import java.lang.System.lineSeparator

object DataParser {

    fun parseStrings(fileName: String, filterOutNewLines: Boolean = false): List<String> {
        val inputs = File(DataParser::class.java.getResource("/inputs/${fileName}")!!.toURI())
            .readText()
            .split(lineSeparator())
            .map { it.trim() }

        return if (filterOutNewLines) {
            inputs.filter { it != "" }
        } else {
            inputs
        }
    }
}