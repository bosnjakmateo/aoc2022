import Day02.Result.*
import Day02.calculateScore
import Day02.resolveStrategyGuideAndCalculate

object Day02 {

    fun calculateScore(data: List<String>): Int {
        return data
            .map {
                val splitMoves = it.split(" ")
                convert(splitMoves[1]) to convert(splitMoves[0])
            }
            .sumOf { it.first.getRoundResult(it.second) }
    }

    fun resolveStrategyGuideAndCalculate(data: List<String>): Int {
        return data
            .map {
                val splitMoves = it.split(" ")
                val opponentMove = convert(splitMoves[0])
                val wantedEndResult = Result.from(splitMoves[1])

                convert(opponentMove, wantedEndResult) to opponentMove
            }
            .sumOf { it.first.getRoundResult(it.second) }
    }

    private fun convert(move: String) =
        when (move) {
            "A", "X" -> ROCK
            "B", "Y" -> PAPER
            "C", "Z" -> SCISSORS
            else -> error("test")
        }

    private fun convert(move: Move, wantedEndResult: Result) =
        when (wantedEndResult) {
            WIN -> symbolToMoves[move.losingAgainst]!!
            LOSE -> symbolToMoves[move.winningAgainst]!!
            DRAW -> move
        }

    class Move(
        private val symbol: String,
        val winningAgainst: String,
        val losingAgainst: String,
        val value: Int,
    ) {
        fun getRoundResult(otherMove: Move) =
            when (otherMove.symbol) {
                winningAgainst -> 6 + value
                losingAgainst -> 0 + value
                symbol -> 3 + value
                else -> error("This should not happen")
            }
    }

    enum class Result {
        WIN,
        LOSE,
        DRAW,
        ;

        companion object {
            fun from(symbol: String) =
                when (symbol) {
                    "Z" -> WIN
                    "X" -> LOSE
                    "Y" -> DRAW
                    else -> error("This should not happen")
                }
        }
    }

    private const val ROCK_SYMBOL = "R"
    private const val PAPER_SYMBOL = "P"
    private const val SCISSORS_SYMBOL = "S"

    private val ROCK = Move(ROCK_SYMBOL, winningAgainst = SCISSORS_SYMBOL, losingAgainst = PAPER_SYMBOL, value = 1)
    private val PAPER = Move(PAPER_SYMBOL, winningAgainst = ROCK_SYMBOL, losingAgainst = SCISSORS_SYMBOL, value = 2)
    private val SCISSORS = Move(SCISSORS_SYMBOL, winningAgainst = PAPER_SYMBOL, losingAgainst = ROCK_SYMBOL, value = 3)

    private val symbolToMoves = mapOf(
        ROCK_SYMBOL to ROCK,
        PAPER_SYMBOL to PAPER,
        SCISSORS_SYMBOL to SCISSORS,
    )
}

fun main() {
    val data = DataParser.parseStrings("day02.txt")

    println("Solutions")
    println("Part one: ${calculateScore(data)}")
    println("Part two: ${resolveStrategyGuideAndCalculate(data)}")
}