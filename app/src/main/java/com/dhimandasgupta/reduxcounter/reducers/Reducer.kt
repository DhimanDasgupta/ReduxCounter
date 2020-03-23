package com.dhimandasgupta.reduxcounter.reducers

import com.dhimandasgupta.reduxcounter.actions.CounterDecreaseAction
import com.dhimandasgupta.reduxcounter.actions.CounterIncreaseAction
import com.dhimandasgupta.reduxcounter.states.AppState
import org.rekotlin.Action

/**
 * Reducer is used to change the state from one to another and vice-versa
 * */
fun counterReducer(action: Action, state: AppState?): AppState {
    val state = state ?: AppState()

    return when (action) {
        is CounterIncreaseAction -> state.copy(counter = state.counter + 1)
        is CounterDecreaseAction -> state.copy(counter = state.counter - 1)
        else -> state
    }
}