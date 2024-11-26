package com.architect.kmpessentials.lifecycle

import com.architect.kmpessentials.aliases.DefaultAction
import com.architect.kmpessentials.aliases.DefaultActionAsync
import kotlinx.coroutines.delay

actual class KmpLifecycle {
    actual companion object {
        internal var backgroundAction: DefaultAction? = null
        internal var foregroundAction: DefaultAction? = null

        internal var isInForeground: Boolean = false

        /**
         *  Registers an action that is run after the app enters the background state
         * */
        actual fun setAppLifecycleBackground(action: DefaultAction) {
            backgroundAction = action
        }

        /**
         *  Registers an action that is run after the app reenters the foreground state
         * */
        actual fun setAppLifecycleForeground(action: DefaultAction) {
            foregroundAction = action
        }

        actual suspend fun waitForAppToReturnToForeground(action: DefaultActionAsync) {
            while (!isInForeground) { // checks if the app returns to the foreground
                delay(1000)
            }

            action()
        }

        /**
         *  Resets all the lifecycle actions.
         *  This is essential to invoke if using a fragment, or when an activity gets destroyed.
         *  This could cause a memory leak if not invoked
         *  Please invoke either in activity's or fragment's OnDestroy function to cleanup
         * */
        actual fun resetAppLifecycleActions() {
            backgroundAction = null
            foregroundAction = null
        }
    }
}