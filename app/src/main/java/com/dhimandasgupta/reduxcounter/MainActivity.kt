package com.dhimandasgupta.reduxcounter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import com.dhimandasgupta.reduxcounter.actions.CounterDecreaseAction
import com.dhimandasgupta.reduxcounter.actions.CounterIncreaseAction
import com.dhimandasgupta.reduxcounter.databinding.ActivityMainBinding
import com.dhimandasgupta.reduxcounter.states.AppState
import com.dhimandasgupta.reduxcounter.stores.mainStore
import org.rekotlin.StoreSubscriber

class MainActivity : AppCompatActivity(), StoreSubscriber<AppState> {
    private val mainActivityMainBinding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mainActivityMainBinding.root)

        mainStore.subscribe(this)
    }

    override fun onStart() {
        super.onStart()

        mainStore.subscribe(this)
    }

    override fun onStop() {
        mainStore.unsubscribe(this)

        super.onStop()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.activity_main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.pos -> {
                mainStore.dispatch(CounterIncreaseAction())
                true
            }
            R.id.neg -> {
                mainStore.dispatch(CounterDecreaseAction())
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun newState(state: AppState) {
        mainActivityMainBinding.textView.text = "${state.counter}"
    }
}
