package wolf.north.sitzer.repository.datastore

import android.content.Context
import android.net.Uri
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.util.Locale
import javax.inject.Inject


//datastore context val
//user preferences file
val Context.dataStore by preferencesDataStore(name = "user_prefs")

class UserPreferencesRepository @Inject constructor(@ApplicationContext private val context: Context) {

    private val ONBOARDING_SHOWN = booleanPreferencesKey("onboarding_shown")
    private val SELECTED_THEME = stringPreferencesKey("selected_theme")
    private val SELECTED_LANGUAGE = stringPreferencesKey("selected_language")
    private val AVATAR_URI = stringPreferencesKey("avatar_uri")

    //Profile info preferences
    private val USERNAME = stringPreferencesKey("username")
    private val EMAIL = stringPreferencesKey("email")


    val hasSeenOnboarding: Flow<Boolean> = context.dataStore.data
        .map { prefs -> prefs[ONBOARDING_SHOWN] ?: false }

    suspend fun setOnboardingShown(shown: Boolean) {
        context.dataStore.edit { prefs ->
            prefs[ONBOARDING_SHOWN] = shown
        }
    }


    //Theme preferences
    val selectedTheme: Flow<String> = context.dataStore.data
        .map { prefs -> prefs[SELECTED_THEME] ?: "System" }

    suspend fun setTheme(theme: String) {
        context.dataStore.edit { prefs ->
            prefs[SELECTED_THEME] = theme
        }
    }

    //Language preferences
    val selectedLanguage: Flow<String> = context.dataStore.data
        .map { prefs -> prefs[SELECTED_LANGUAGE] ?: getSystemLanguage() }

    private fun getSystemLanguage(): String {
        val currentLang = Locale.getDefault().language
        return if (currentLang == "pl") "Polski" else "English"
    }

    suspend fun setLanguage(language: String) {
        context.dataStore.edit { prefs ->
            prefs[SELECTED_LANGUAGE] = language
        }
    }

    //Avatar preference set
    val avatarUri: Flow<Uri?> = context.dataStore.data
        .map { prefs -> prefs[AVATAR_URI]?.let { Uri.parse(it) } }


    suspend fun setAvatarUri(uri: Uri) {
        context.dataStore.edit { prefs ->
            prefs[AVATAR_URI] = uri.toString()
        }
    }

    //Username preference set
    val username: Flow<String> = context.dataStore.data
        .map { prefs -> prefs[USERNAME] ?: "" }

    suspend fun setUsername(username: String) {
        context.dataStore.edit { prefs ->
            prefs[USERNAME] = username
        }
    }

    //Email preference set
    val email: Flow<String> = context.dataStore.data
        .map { prefs -> prefs[EMAIL] ?: "" }

    suspend fun setEmail(email: String) {
        context.dataStore.edit { prefs ->
            prefs[EMAIL] = email
        }
    }
}