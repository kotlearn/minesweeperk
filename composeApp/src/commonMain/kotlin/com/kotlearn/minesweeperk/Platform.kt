package com.kotlearn.minesweeperk

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform