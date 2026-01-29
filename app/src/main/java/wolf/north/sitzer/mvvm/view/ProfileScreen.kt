package wolf.north.sitzer.mvvm.view

import androidx.appcompat.app.AppCompatDelegate
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Help
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.SportsGymnastics
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import wolf.north.sitzer.comps.profile.HelpBottomSheet
import wolf.north.sitzer.comps.profile.NotificationsBottomSheet
import wolf.north.sitzer.comps.profile.ProfileInfoBottomSheet
import wolf.north.sitzer.comps.profile.SettingsBottomSheet
import wolf.north.sitzer.mvvm.viewmodel.ProfileScreenViewModel
import wolf.north.sitzer.navigation.Screens
import wolf.north.sitzer.ui.theme.SitzerTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
) {
    val viewmodel: ProfileScreenViewModel = hiltViewModel()

    var showProfileBottomSheet by remember { mutableStateOf(false) }
    val profileSheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)

    var showSettingsBottomSheet by remember { mutableStateOf(false) }
    val settingsSheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)

    var showNotificationBottomSheet by remember { mutableStateOf(false) }
    val notificationsSheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)

    var showSettings by remember { mutableStateOf(false) }
    var selectedTheme by remember {
        mutableStateOf(
            when (AppCompatDelegate.getDefaultNightMode()) {
                AppCompatDelegate.MODE_NIGHT_YES -> "Dark"
                AppCompatDelegate.MODE_NIGHT_NO -> "Light"
                else -> "System"
            }
        )
    }
    var selectedLanguage by remember {
        mutableStateOf("English")
    }

    var showHelpBottomSheet by remember { mutableStateOf(false) }
    val helpSheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)


    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(
                        modifier = Modifier.padding(8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text("Profile", color = MaterialTheme.colorScheme.onPrimary)
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary
                )
            )
        },
        bottomBar = {
            BottomAppBar(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)),
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = MaterialTheme.colorScheme.onSurfaceVariant,
                tonalElevation = 5.dp,
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 20.dp),
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.Home,
                            contentDescription = "Menu",
                            tint = MaterialTheme.colorScheme.onSurfaceVariant,
                            modifier = Modifier.clickable { navController.navigate(Screens.Home) }
                        )
                        Text("Home", color = MaterialTheme.colorScheme.onSurfaceVariant)
                    }

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.SportsGymnastics,
                            contentDescription = "Workouts list bottom icon",
                            tint = MaterialTheme.colorScheme.onSurfaceVariant,
                            modifier = Modifier.clickable { navController.navigate(Screens.Plans) }
                        )
                        Text("Workouts", color = MaterialTheme.colorScheme.onSurfaceVariant)
                    }

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.Person,
                            contentDescription = "Profile",
                            tint = MaterialTheme.colorScheme.onPrimary,
                            modifier = Modifier.clickable { navController.navigate(Screens.Profile) }
                        )
                        Text("Profile", color = MaterialTheme.colorScheme.onPrimary)
                    }
                }
            }
        }
    ) { paddingValues ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(MaterialTheme.colorScheme.background)
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(16.dp))

            Box(
                modifier = Modifier.size(120.dp),
                contentAlignment = Alignment.BottomEnd
            ) {
                Box(
                    modifier = Modifier
                        .size(120.dp)
                        .clip(CircleShape)
                        .background(MaterialTheme.colorScheme.surfaceVariant),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = "Zdjęcie profilowe",
                        modifier = Modifier.size(60.dp),
                        tint = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }

                Surface(
                    modifier = Modifier
                        .size(36.dp)
                        .border(3.dp, MaterialTheme.colorScheme.background, CircleShape),
                    shape = CircleShape,
                    color = MaterialTheme.colorScheme.primary
                ) {
                    IconButton(
                        onClick = {},
                        modifier = Modifier.size(36.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Edit,
                            contentDescription = "Edytuj profil",
                            tint = Color.White,
                            modifier = Modifier.size(18.dp)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "userName",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = "userEmail",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Spacer(modifier = Modifier.height(32.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                StatisticItem(
                    icon = "⏱️",
                    value = "0h 0m",
                    label = "Total time"
                )
                StatisticItem(
                    icon = "🔥",
                    value = "2124 cal",
                    label = "Calories burned"
                )
                StatisticItem(
                    icon = "🏋️‍♀️",
                    value = "420",
                    label = "Sessions"
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surface
                ),
                elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
            ) {
                Column(
                    modifier = Modifier.padding(8.dp)
                ) {
                    MenuOption(
                        icon = Icons.Default.Person,
                        text = "Profile info",
                        onClick = { showProfileBottomSheet = true }
                    )
                    MenuOption(
                        icon = Icons.Default.Settings,
                        text = "Settings",
                        onClick = { showSettingsBottomSheet = true }
                    )
                    MenuOption(
                        icon = Icons.Default.Notifications,
                        text = "Notification",
                        onClick = { showNotificationBottomSheet = true }
                    )
                    MenuOption(
                        icon = Icons.Default.Help,
                        text = "Help",
                        onClick = { showHelpBottomSheet = true },
                        showDivider = false
                    )
                }
            }
        }
    }

    if (showProfileBottomSheet) {
        ModalBottomSheet(
            onDismissRequest = { showProfileBottomSheet = false },
            sheetState = profileSheetState,
            containerColor = MaterialTheme.colorScheme.surface
        ) {
            ProfileInfoBottomSheet(viewmodel, onDismiss = { showProfileBottomSheet = false })
        }
    }

    if (showHelpBottomSheet) {
        ModalBottomSheet(
            onDismissRequest = { showHelpBottomSheet = false },
            sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true),
            containerColor = MaterialTheme.colorScheme.surface
        ) {
            HelpBottomSheet(onClose = { showHelpBottomSheet = false })
        }
    }

    if (showSettingsBottomSheet) {
        ModalBottomSheet(
            sheetState = settingsSheetState,
            onDismissRequest = { showSettingsBottomSheet = false },
            containerColor = MaterialTheme.colorScheme.surface
        ) {
            SettingsBottomSheet(
                viewModel = viewmodel,
                onDismiss = { showSettingsBottomSheet = false })
        }
    }

    if (showNotificationBottomSheet) {
        ModalBottomSheet(
            sheetState = notificationsSheetState,
            onDismissRequest = { showNotificationBottomSheet = false },
            containerColor = MaterialTheme.colorScheme.surface
        ) {
            NotificationsBottomSheet(
                viewModel = viewmodel,
                onDismiss = { showNotificationBottomSheet = false })
        }
    }


}

@Composable
private fun StatisticItem(
    icon: String,
    value: String,
    label: String
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = icon,
            fontSize = 28.sp
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = value,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = label,
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

@Composable
private fun MenuOption(
    icon: ImageVector,
    text: String,
    onClick: () -> Unit,
    showDivider: Boolean = true
) {
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable(onClick = onClick)
                .padding(horizontal = 8.dp, vertical = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = icon,
                contentDescription = text,
                tint = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))

            Text(
                text = text,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.weight(1f)
            )

            Icon(
                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                contentDescription = "Przejdź do $text",
                tint = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier.size(16.dp)
            )
        }

        if (showDivider) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(1.dp)
                    .padding(horizontal = 16.dp)
                    .background(MaterialTheme.colorScheme.surfaceVariant)
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun ProfileScreenPreview() {
    SitzerTheme {
        ProfileScreen()
    }
}