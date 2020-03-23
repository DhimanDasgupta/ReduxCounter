package com.dhimandasgupta.reduxcounter.actions

import org.rekotlin.Action

/**
 * All app Actions are here
 * */
data class CounterIncreaseAction(val unit: Unit = Unit): Action

data class CounterDecreaseAction(val unit: Unit = Unit): Action