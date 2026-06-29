package wolf.north.sitzer.comps.profile


import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Shield
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.media3.common.BuildConfig
import wolf.north.sitzer.R
import wolf.north.sitzer.mvvm.viewmodel.ProfileScreenViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HelpBottomSheet(
    viewModel: ProfileScreenViewModel,
    onClose: () -> Unit,
    modifier: Modifier = Modifier
) {
    var selectedTab by remember { mutableStateOf(HelpTab.FAQ) }
    var expandedFaq by remember { mutableStateOf(-1) }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp, horizontal = 16.dp)
    ) {
        // Header
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = onClose) {
                Icon(
                    Icons.Default.Close,
                    contentDescription = stringResource(R.string.close_cd),
                    tint = MaterialTheme.colorScheme.onSurface
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            Text(
                stringResource(R.string.support_title),
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onSurface,
                fontWeight = FontWeight.Medium
            )
            Spacer(modifier = Modifier.weight(1f))
            Box(modifier = Modifier.size(48.dp))
        }

        Spacer(modifier = Modifier.height(12.dp))

        // Tab navigation
        TabRow(
            selectedTabIndex = selectedTab.ordinal,
            containerColor = Color.Transparent,
            contentColor = MaterialTheme.colorScheme.onSurface,
            divider = { /* no divider */ }
        ) {
            HelpTab.values().forEachIndexed { index, tab ->
                Tab(
                    selected = selectedTab.ordinal == index,
                    onClick = { selectedTab = tab },
                    text = {
                        Text(
                            stringResource(tab.titleRes),
                            color = if (selectedTab.ordinal == index) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    },
                    unselectedContentColor = MaterialTheme.colorScheme.onSurfaceVariant,
                    selectedContentColor = MaterialTheme.colorScheme.primary
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Content area
        when (selectedTab) {
            HelpTab.FAQ -> FAQSection(expandedFaq) { expandedFaq = it }
            HelpTab.REPORT -> ReportSection(viewModel = viewModel)
            HelpTab.CONTACT -> ContactSection()
            HelpTab.ABOUT -> AboutSection()
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Action button
        Button(
            onClick = onClose,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(stringResource(R.string.close))
        }
    }
}

private enum class HelpTab(
    val titleRes: Int
) {
    FAQ(R.string.tab_faq),
    REPORT(R.string.tab_report),
    CONTACT(R.string.tab_contact),
    ABOUT(R.string.tab_about)
}

@Composable
private fun FAQSection(
    expandedIndex: Int,
    onExpand: (Int) -> Unit
) {
    val faqItems = listOf(
        FaqItem(
            question = stringResource(R.string.faq_q1),
            answer = stringResource(R.string.faq_a1)
        ),
        FaqItem(
            question = stringResource(R.string.faq_q2),
            answer = stringResource(R.string.faq_a2)
        ),
        FaqItem(
            question = stringResource(R.string.faq_q3),
            answer = stringResource(R.string.faq_a3)
        )
    )

    LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        items(faqItems.size) { index ->
            val item = faqItems[index]
            val isExpanded = expandedIndex == index

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { onExpand(if (isExpanded) -1 else index) }
                    .padding(vertical = 8.dp)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        if (isExpanded) Icons.Default.ExpandLess else Icons.Default.ExpandMore,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.onSurfaceVariant,
                        modifier = Modifier.size(20.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        item.question,
                        style = MaterialTheme.typography.bodyLarge,
                        fontWeight = FontWeight.Medium,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }
                if (isExpanded) {
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        item.answer,
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        }
    }
}

data class FaqItem(val question: String, val answer: String)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun ReportSection(viewModel: ProfileScreenViewModel) {
    var reportTitle by remember { mutableStateOf("") }
    var reportDescription by remember { mutableStateOf("") }
    var reportTypeRes by remember {
        mutableStateOf(R.string.report_type_bug)
    }
    val reportTypes = listOf(
        R.string.report_type_bug,
        R.string.report_type_ui_issue,
        R.string.report_type_missing_feature,
        R.string.report_type_other
    )
    var expanded by remember { mutableStateOf(false) }
    val context = LocalContext.current

    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {

        // Select report type
        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = { expanded = !expanded }
        ) {
            OutlinedTextField(
                readOnly = true,
                value = stringResource(reportTypeRes),
                onValueChange = {},
                label = { Text(stringResource(R.string.report_type)) },
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                modifier = Modifier
                    .fillMaxWidth()
                    .menuAnchor()
            )
            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                reportTypes.forEach { typeRes ->
                    DropdownMenuItem(
                        text = { Text(stringResource(typeRes)) },
                        onClick = {
                            reportTypeRes = typeRes
                            expanded = false
                        }
                    )
                }
            }
        }

        // Title of report
        OutlinedTextField(
            value = reportTitle,
            onValueChange = { reportTitle = it },
            label = { Text(stringResource(R.string.report_title)) },
            placeholder = { Text(stringResource(R.string.report_title_placeholder)) },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )

        // Problem description
        OutlinedTextField(
            value = reportDescription,
            onValueChange = { reportDescription = it },
            label = { Text(stringResource(R.string.report_issue_label)) },
            placeholder = { Text(stringResource(R.string.report_issue_placeholder)) },
            minLines = 3,
            maxLines = 5,
            modifier = Modifier.fillMaxWidth()
        )

        Text(
            stringResource(R.string.report_desc),
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        //Send report
        Button(
            onClick = {
                val intent = viewModel.buildReportEmailIntent(
                    reportType = context.getString(reportTypeRes),
                    reportTitle = reportTitle,
                    reportDescription = reportDescription
                )

                try {
                    context.startActivity(
                        Intent.createChooser(
                            intent,
                            context.getString(R.string.choose_email_client)
                        )
                    )
                } catch (e: Exception) {
                    Toast.makeText(
                        context,
                        context.getString(R.string.no_email_client),
                        Toast.LENGTH_SHORT
                    ).show()
                }

            },
            enabled = reportTitle.isNotBlank(),  //Enable button only if fields are filled
            modifier = Modifier.fillMaxWidth()
        ) {
            Icon(
                Icons.Default.Email,
                contentDescription = null,
                modifier = Modifier.size(18.dp)
            )
            Spacer(Modifier.width(8.dp))
            Text(stringResource(R.string.send_report))
        }
    }
}


@Composable
private fun ContactSection() {
    Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
        SupportItem(
            icon = Icons.Default.Email,
            title = stringResource(R.string.contact_email),
            subtitle = "support@sitzer.app"
        )
        SupportItem(
            icon = Icons.Default.Info,
            title = stringResource(R.string.app_version),
            subtitle = "v${BuildConfig.BUILD_TYPE}"
        )
        SupportItem(
            icon = Icons.Default.Shield,
            title = stringResource(R.string.privacy_policy),
            subtitle = stringResource(R.string.privacy_policy_desc)
        )
    }
}

@Composable
private fun AboutSection() {
    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        Text(
            stringResource(R.string.about_app),
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Text(
            "Sitzer — Your daily planning companion",
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.Medium,
            color = MaterialTheme.colorScheme.onSurface
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            stringResource(R.string.developer_info),
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Text(
            "Wolf North Studio",
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.Medium,
            color = MaterialTheme.colorScheme.onSurface
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            "© 2026 Wolf North. All rights reserved.",
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

@Composable
private fun SupportItem(
    icon: ImageVector,
    title: String,
    subtitle: String
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        Icon(
            icon,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.primary,
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(12.dp))
        Column {
            Text(
                title,
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Medium,
                color = MaterialTheme.colorScheme.onSurface
            )
            Text(
                subtitle,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}