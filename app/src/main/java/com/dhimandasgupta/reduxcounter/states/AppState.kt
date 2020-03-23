package com.dhimandasgupta.reduxcounter.states

import org.rekotlin.StateType

/**
 * Object which represents the Whole App State
 * */
data class AppState(val counter: Int = 0): StateType