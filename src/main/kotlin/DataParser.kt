import java.io.File
import java.lang.System.lineSeparator

object DataParser {

    fun parseStrings(fileName: String, filterOutNewLines: Boolean = false, trim: Boolean = true): List<String> {
        val inputs = File(DataParser::class.java.getResource("/inputs/${fileName}")!!.toURI())
            .readText()
            .split(lineSeparator())
            .map { if (trim) it.trim() else it }

        return if (filterOutNewLines) {
            inputs.filter { it != "" }
        } else {
            inputs
        }
    }
}