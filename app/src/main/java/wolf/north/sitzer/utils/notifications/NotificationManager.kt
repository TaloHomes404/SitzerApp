package wolf.north.sitzer.utils.notifications

import android.Manifest
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.annotation.RequiresPermission
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import wolf.north.sitzer.R


object AppNotificationManager {

    // ✅ Osobny kanał dla każdego typu
    const val CHANNEL_DAILY = "channel_daily"
    const val CHANNEL_PLAN = "channel_plan"
    const val CHANNEL_WEEKLY = "channel_weekly"

    fun createChannels(context: Context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val manager = context.getSystemService(NotificationManager::class.java)

            listOf(
                NotificationChannel(
                    CHANNEL_DAILY,
                    "Daily Reminder",
                    NotificationManager.IMPORTANCE_DEFAULT
                ),
                NotificationChannel(
                    CHANNEL_PLAN,
                    "Plan for Today",
                    NotificationManager.IMPORTANCE_DEFAULT
                ),
                NotificationChannel(
                    CHANNEL_WEEKLY,
                    "Weekly Summary",
                    NotificationManager.IMPORTANCE_DEFAULT
                )
            ).forEach { manager.createNotificationChannel(it) }
        }
    }

    @RequiresPermission(Manifest.permission.POST_NOTIFICATIONS)
    fun sendNotification(
        context: Context,
        channelId: String,
        notificationId: Int,
        title: String,
        message: String
    ) {
        val notification = NotificationCompat.Builder(context, channelId)
            .setSmallIcon(R.drawable.sitzer_logo_nobg)
            .setContentTitle(title)
            .setContentText(message)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setAutoCancel(true)
            .build()

        NotificationManagerCompat.from(context).notify(notificationId, notification)
    }
}