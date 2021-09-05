package play

object MagicSquare {

    /**
     * Check if a two-dimensional list is a magic square.
     *
     * @param square two-dimensional list, which will be checked.
     * @return true if provided parameter square is a magic square.
     */
    fun isSquareMagic(square: List<List<Int>>): Boolean {
        require(square.isNotEmpty())

        val n = square.size

        // check numbers
        if (!checkNumbers(square)) return false

        // check row's sizes
        for (row in square) {
            if (row.size != n) {
                return false
            }
        }

        var magicConstant: Int? = null

        // check if rows sum up to magic constant
        for (row in square) {
            val sum = row.sum()

            if (magicConstant == null) {
                magicConstant = sum
            } else if (sum != magicConstant) {
                return false
            }
        }

        check(magicConstant != null)

        // check if columns sum up to magic constant
        for (i in 0 until n) {
            val sum = square.sumOf { it[i] }

            if (sum != magicConstant) {
                return false
            }
        }

        // check left to right diagonal
        fun leftToRightDiagonalCheck(): Boolean {
            var columnCursor = 0

            val sum = square.sumOf {
                val pos = columnCursor
                columnCursor++
                return@sumOf it[pos]
            }

            if (sum != magicConstant) {
                return false
            }

            return true
        }

        // check right to left diagonal
        fun rightToLeftDiagonalCheck(): Boolean {
            var columnCursor = n - 1

            val sum = square.sumOf {
                val pos = columnCursor
                columnCursor--
                return@sumOf it[pos]
            }

            if (sum != magicConstant) {
                return false
            }

            return true
        }

        return leftToRightDiagonalCheck() && rightToLeftDiagonalCheck()
    }

    private fun checkNumbers(square: List<List<Int>>): Boolean {
        val n = square.size
        val numbers = hashSetOf<Int>()
        for (i in 0 until n) {
            val item = square[i / n][i % n]

            if (item <= 0) return false
            if (item > n * n) return false
            if (numbers.contains(item)) return false

            numbers += item
        }
        return true
    }
}
