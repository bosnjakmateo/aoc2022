fun List<String>.filterNotEmpty() = this.filter { it.isNotEmpty() }

fun String.findAllNumbers() = Regex("(\\d+)").findAll(this).map { it.groupValues.first().toInt() }.toList()

fun String.hasMatch(regex: String) = Regex(regex).matches(this)