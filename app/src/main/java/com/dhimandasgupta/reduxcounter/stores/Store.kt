package com.dhimandasgupta.reduxcounter.stores

import com.dhimandasgupta.reduxcounter.reducers.counterReducer
import org.rekotlin.Store

/**
 * Store connects the reducer and state.
 * Also store has to be subscribed in the view
 * to get the App State changes.
 * */
val mainStore = Store(
    reducer = ::counterReducer,
    state = null
)