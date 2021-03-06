package com.github.lagiilein.playground.jvm.exception

class NoSolutionException(
    override val message: String = "no solution could be determined",
    override val cause: Throwable? = null,
) : Exception()
