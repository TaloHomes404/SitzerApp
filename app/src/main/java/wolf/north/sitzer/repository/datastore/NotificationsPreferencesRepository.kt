package wolf.north.sitzer.repository.datastore

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

data class NotificationPrefs(
    val daily: Boolean,
    val plan: Boolean,
    val weekly: Boolean
)

@Singleton
class NotificationsPreferencesRepository @Inject constructor(@ApplicationContext private val context: Context) {

    companion object {
        private val DAILY_KEY = booleanPreferencesKey("notifications_daily")
        private val PLAN_KEY = booleanPreferencesKey("notifications_plan_daily")
        private val WEEKLY_KEY = booleanPreferencesKey("notifications_weekly_summary")
    }

    val notificationPrefs: Flow<NotificationPrefs> =
        context.dataStore.data.map { prefs ->
            NotificationPrefs(
                daily = prefs[DAILY_KEY] ?: true,
                plan = prefs[PLAN_KEY] ?: true,
                weekly = prefs[WEEKLY_KEY] ?: true
            )
        }

    suspend fun setDaily(enabled: Boolean) {
        context.dataStore.edit { it[DAILY_KEY] = enabled }
    }

    suspend fun setPlan(enabled: Boolean) {
        context.dataStore.edit { it[PLAN_KEY] = enabled }
    }

    suspend fun setWeekly(enabled: Boolean) {
        context.dataStore.edit { it[WEEKLY_KEY] = enabled }
    }

}

