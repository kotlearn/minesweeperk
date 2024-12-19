package com.kotlearn.minesweeperk.feature.play

sealed class TileState {

    data class Hidden(val flagged: Boolean) : TileState()

    sealed class Revealed : TileState() {

        data object Mine : Revealed()

        data class Number(val value: Int?) : Revealed()

    }

}