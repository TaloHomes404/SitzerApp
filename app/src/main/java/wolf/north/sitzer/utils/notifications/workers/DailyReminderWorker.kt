package wolf.north.sitzer.utils.notifications.workers

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import wolf.north.sitzer.utils.notifications.AppNotificationManager

class DailyReminderWorker(
    context: Context,
    params: WorkerParameters
) : CoroutineWorker(context, params) {

    override suspend fun doWork(): Result {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (applicationContext.checkSelfPermission(
                    Manifest.permission.POST_NOTIFICATIONS
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                return Result.failure()
            }
        }

        AppNotificationManager.sendNotification(
            context = applicationContext,
            channelId = AppNotificationManager.CHANNEL_DAILY,
            notificationId = 1001,
            title = "Daily Reminder 💪",
            message = "Time to check your training plan for today!"
        )
        return Result.success()
    }
}