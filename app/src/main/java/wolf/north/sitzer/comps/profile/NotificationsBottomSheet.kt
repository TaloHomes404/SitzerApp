package wolf.north.sitzer.comps.profile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import wolf.north.sitzer.mvvm.viewmodel.NotificationSettingsUi

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NotificationsBottomSheet(
    uiState: NotificationSettingsUi,
    onDismiss: () -> Unit,
    onDailyToggle: (Boolean) -> Unit,
    onPlanToggle: (Boolean) -> Unit,
    onWeeklyToggle: (Boolean) -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp, horizontal = 16.dp)
    ) {

        //top
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = onDismiss) {
                Icon(
                    Icons.Default.Close,
                    contentDescription = "Close",
                    tint = MaterialTheme.colorScheme.onSurface
                )
            }
            Spacer(Modifier.weight(1f))
            Text(
                text = "Notifications",
                style = MaterialTheme.typography.titleLarge
            )
            Spacer(Modifier.weight(1f))
            Box(Modifier.size(48.dp))
        }

        Spacer(modifier = Modifier.height(16.dp))

        // switches for notifications
        NotificationSwitchItem(
            title = "Daily Reminder",
            description = "A short notification every day at your chosen time.",
            checked = uiState.daily,
            onCheckedChange = onDailyToggle
        )

        NotificationSwitchItem(
            title = "Plan for Today",
            description = "Notify me when today’s plan is ready.",
            checked = uiState.planOfTheDay,
            onCheckedChange = onPlanToggle
        )

        NotificationSwitchItem(
            title = "Weekly Summary",
            description = "Get a weekly summary of your activity & progress.",
            checked = uiState.weeklySummary,
            onCheckedChange = onWeeklyToggle
        )
    }
}

@Composable
fun NotificationSwitchItem(
    title: String,
    description: String,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text(title, style = MaterialTheme.typography.titleMedium)
            Text(
                description,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
            )
        }
        Switch(
            checked = checked,
            onCheckedChange = onCheckedChange
        )
    }
}