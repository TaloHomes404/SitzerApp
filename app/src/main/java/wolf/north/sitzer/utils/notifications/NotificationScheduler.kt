package wolf.north.sitzer.utils.notifications

import android.content.Context
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import wolf.north.sitzer.utils.notifications.workers.DailyReminderWorker
import wolf.north.sitzer.utils.notifications.workers.PlanWorker
import wolf.north.sitzer.utils.notifications.workers.WeeklySummaryWorker
import java.util.Calendar
import java.util.concurrent.TimeUnit

object NotificationScheduler {

    fun scheduleDailyReminder(context: Context) {
        val request = PeriodicWorkRequestBuilder<DailyReminderWorker>(
            24, TimeUnit.HOURS
        )
            .setInitialDelay(calculateDelayUntil(8, 0), TimeUnit.MILLISECONDS) // 8:00
            .addTag("daily_reminder")
            .build()

        WorkManager.getInstance(context).enqueueUniquePeriodicWork(
            "daily_reminder",
            ExistingPeriodicWorkPolicy.UPDATE,
            request
        )
    }

    fun schedulePlanNotification(context: Context) {
        val request = PeriodicWorkRequestBuilder<PlanWorker>(
            24, TimeUnit.HOURS
        )
            .setInitialDelay(calculateDelayUntil(9, 0), TimeUnit.MILLISECONDS) // 9:00
            .addTag("plan_today")
            .build()

        WorkManager.getInstance(context).enqueueUniquePeriodicWork(
            "plan_today",
            ExistingPeriodicWorkPolicy.UPDATE,
            request
        )
    }

    fun scheduleWeeklySummary(context: Context) {
        val request = PeriodicWorkRequestBuilder<WeeklySummaryWorker>(
            7, TimeUnit.DAYS
        )
            .addTag("weekly_summary")
            .build()

        WorkManager.getInstance(context).enqueueUniquePeriodicWork(
            "weekly_summary",
            ExistingPeriodicWorkPolicy.UPDATE,
            request
        )
    }


    fun cancelDailyReminder(context: Context) {
        WorkManager.getInstance(context).cancelUniqueWork("daily_reminder")
    }

    fun cancelPlanNotification(context: Context) {
        WorkManager.getInstance(context).cancelUniqueWork("plan_today")
    }

    fun cancelWeeklySummary(context: Context) {
        WorkManager.getInstance(context).cancelUniqueWork("weekly_summary")
    }


    private fun calculateDelayUntil(hour: Int, minute: Int): Long {
        val now = Calendar.getInstance()
        val target = Calendar.getInstance().apply {
            set(Calendar.HOUR_OF_DAY, hour)
            set(Calendar.MINUTE, minute)
            set(Calendar.SECOND, 0)
            if (before(now)) add(Calendar.DAY_OF_YEAR, 1)
        }
        return target.timeInMillis - now.timeInMillis
    }
}