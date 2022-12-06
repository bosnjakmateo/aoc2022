import java.io.File

object DataParser {

    fun parseStrings(fileName: String) =
        File(DataParser::class.java.getResource("/inputs/${fileName}")!!.toURI()).readLines()

    fun parseString(fileName: String): String =
        File(DataParser::class.java.getResource("/inputs/${fileName}")!!.toURI()).readText()
}