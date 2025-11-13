package wolf.north.sitzer.repository.datastore

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


//datastore context val
//user preferences file
private val Context.dataStore by preferencesDataStore(name = "user_prefs")

class UserPreferencesRepository(private val context: Context) {

    private val ONBOARDING_SHOWN = booleanPreferencesKey("onboarding_shown")

    val hasSeenOnboarding: Flow<Boolean> = context.dataStore.data
        .map { prefs -> prefs[ONBOARDING_SHOWN] ?: false }

    suspend fun setOnboardingShown(shown: Boolean) {
        context.dataStore.edit { prefs ->
            prefs[ONBOARDING_SHOWN] = shown
        }
    }
}