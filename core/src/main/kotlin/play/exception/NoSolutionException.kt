package play.exception

class NoSolutionException(
    override val message: String = "no solution could be determined",
    override val cause: Throwable? = null
) : Exception()
