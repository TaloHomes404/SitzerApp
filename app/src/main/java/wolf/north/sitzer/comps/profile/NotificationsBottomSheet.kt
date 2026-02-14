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
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import wolf.north.sitzer.R
import wolf.north.sitzer.mvvm.viewmodel.ProfileScreenViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NotificationsBottomSheet(
    viewModel: ProfileScreenViewModel,
    onDismiss: () -> Unit
) {
    val notificationSettings by viewModel.notificationSettings.collectAsState()

    // Local state for notification
    var selectedMethod by remember { mutableStateOf("Push") }  // (Push, Email)
    val methods =
        listOf(stringResource(R.string.method_push_full), stringResource(R.string.method_email))

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp, horizontal = 16.dp)
    ) {
        // Header
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = onDismiss) {
                Icon(
                    Icons.Default.Close,
                    contentDescription = stringResource(R.string.close),
                    tint = MaterialTheme.colorScheme.onSurface
                )
            }
            Spacer(Modifier.weight(1f))
            Text(
                text = stringResource(R.string.menu_notifications),
                style = MaterialTheme.typography.titleLarge
            )
            Spacer(Modifier.weight(1f))
            Box(Modifier.size(48.dp))
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Notification Method Section
        Text(
            stringResource(R.string.notification_method),
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Medium
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Radio buttons group for notification
        methods.forEach { method ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = selectedMethod == method.split(" ").first(),
                    onClick = { selectedMethod = method.split(" ").first() }
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = method,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Divider()

        Spacer(modifier = Modifier.height(16.dp))

        // Notification Frequency
        Text(
            stringResource(R.string.notification_frequency),
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Medium
        )

        Spacer(modifier = Modifier.height(12.dp))

        NotificationSwitchItem(
            title = stringResource(R.string.daily_reminder),
            description = stringResource(R.string.daily_reminder_desc),
            checked = notificationSettings.daily,
            onCheckedChange = { viewModel.toggleDaily(it) }
        )

        NotificationSwitchItem(
            title = stringResource(R.string.plan_for_today),
            description = stringResource(R.string.plan_for_today_desc),
            checked = notificationSettings.planOfTheDay,
            onCheckedChange = { viewModel.togglePlan(it) }
        )

        NotificationSwitchItem(
            title = stringResource(R.string.weekly_summary),
            description = stringResource(R.string.weekly_summary_desc),
            checked = notificationSettings.weeklySummary,
            onCheckedChange = { viewModel.toggleWeekly(it) }
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Action buttons
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            OutlinedButton(
                onClick = onDismiss,
                modifier = Modifier.weight(1f)
            ) {
                Text(stringResource(R.string.cancel))
            }

            Button(
                onClick = {
                    // TODO: Zapisz selectedMethod (Push/Email)
                    onDismiss()
                },
                modifier = Modifier.weight(1f)
            ) {
                Text(stringResource(R.string.save))
            }
        }
    }
}

@Composable
private fun NotificationSwitchItem(
    title: String,
    description: String,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleSmall,
                fontWeight = FontWeight.Medium
            )
            Text(
                text = description,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
        Switch(
            checked = checked,
            onCheckedChange = onCheckedChange
        )
    }
}