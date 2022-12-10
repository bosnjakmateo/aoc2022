import Day07.calculateIdealDirectorySizeForDeletion
import Day07.calculateSumOfSmallDirectoriesSize

object Day07 {

    fun calculateSumOfSmallDirectoriesSize(data: List<String>): Int {
        return getDirectories(data)
            .filter { it.size <= 100_000 }.sumOf { it.size }
    }

    fun calculateIdealDirectorySizeForDeletion(data: List<String>): Int {
        val directories = getDirectories(data)

        val neededSpace = NEEDED_UNUSED_DISK_SPACE - (TOTAL_DISK_SPACE - directories[0].size)

        return directories
            .filter { it.size > neededSpace }.minByOrNull { it.size }!!.size
    }

    private fun getDirectories(data: List<String>): MutableList<Directory> {
        val root = parseData(data)

        populateDirectoriesSize(root)

        val directories = mutableListOf<Directory>()
        populateAllDirectories(root, directories)

        return directories
    }

    private fun parseData(data: List<String>): Directory {
        val root = Directory(ROOT, null, mutableListOf())
        var currentNode = root

        data.forEach { command ->
            when {
                command.contains("dir") -> {
                    currentNode.children.add(Directory(command.getDirectoryName(), currentNode))
                }
                command.first().isDigit() -> {
                    val (size, name) = command.getPlainDataSizeAndName()
                    currentNode.children.add(PlainData(name, size))
                }
                command.hasMatch("\\$ cd [a-z]+") -> {
                    currentNode = currentNode.children
                        .filterIsInstance<Directory>()
                        .first { it.name == command.getDirectoryName() }
                }
                command.hasMatch("\\$ cd ..") -> {
                    currentNode = currentNode.parent!!
                }
            }
        }

        return root
    }

    private fun populateDirectoriesSize(node: File): Int {
        when (node) {
            is Directory -> {
                node.size = node.children.sumOf { populateDirectoriesSize(it) }
                if (node.size != 0) {
                    return node.size
                }
            }
            is PlainData -> {
                return node.size
            }
        }

        return 0
    }

    private fun populateAllDirectories(node: File, directories: MutableList<Directory>) {
        when (node) {
            is Directory -> {
                directories.add(node)
                node.children.forEach { populateAllDirectories(it, directories) }
            }
            else -> {}
        }
    }

    private fun String.getDirectoryName() = split(" ").last()
    private fun String.getPlainDataSizeAndName() = split(" ").let { Pair(it[0].toInt(), it[1]) }

    sealed class File
    data class Directory(
        val name: String,
        val parent: Directory?,
        val children: MutableList<File> = mutableListOf(),
        var size: Int = 0,
    ) : File()

    data class PlainData(val name: String, val size: Int) : File()

    private const val ROOT = "/"
    private const val TOTAL_DISK_SPACE = 70_000_000
    private const val NEEDED_UNUSED_DISK_SPACE = 30_000_000
}

fun main() {
    val data = DataParser.parseStrings("day07.txt")

    println("Solutions")
    println("Part one: ${calculateSumOfSmallDirectoriesSize(data)}")
    println("Part two: ${calculateIdealDirectorySizeForDeletion(data)}")
}