package wolf.north.sitzer.mvvm.view


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatDelegate
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import wolf.north.sitzer.R
import wolf.north.sitzer.navigation.AppNavigation
import wolf.north.sitzer.navigation.Screens
import wolf.north.sitzer.ui.theme.SitzerTheme
import wolf.north.sitzer.utils.notifications.AppNotificationManager

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val nightMode = AppCompatDelegate.getDefaultNightMode()
            val isDark = when (nightMode) {
                AppCompatDelegate.MODE_NIGHT_YES -> true
                AppCompatDelegate.MODE_NIGHT_NO -> false
                else -> isSystemInDarkTheme() // System default
            }

            //Create notifications channels
            AppNotificationManager.createChannels(this)

            SitzerTheme(darkTheme = isDark) {
                AppNavigation()
            }
        }
    }
}

@Composable
fun SplashScreen(navController: NavHostController = rememberNavController()) {
    var startAnimation by remember { mutableStateOf(false) }
    var showProgress by remember { mutableStateOf(false) }

    // Animacje
    LaunchedEffect(Unit) {
        delay(100)
        startAnimation = true
        delay(600)
        showProgress = true
        delay(2500)
        navController.navigate(Screens.Login) {
            popUpTo(Screens.SplashScreen) { inclusive = true }
        }
    }

    val logoAlpha by animateFloatAsState(
        targetValue = if (startAnimation) 1f else 0f,
        animationSpec = tween(durationMillis = 800, easing = FastOutSlowInEasing),
        label = "logo_alpha"
    )

    val logoScale by animateFloatAsState(
        targetValue = if (startAnimation) 1f else 0.7f,
        animationSpec = tween(durationMillis = 800, easing = FastOutSlowInEasing),
        label = "logo_scale"
    )

    val textAlpha by animateFloatAsState(
        targetValue = if (startAnimation) 1f else 0f,
        animationSpec = tween(
            durationMillis = 800,
            delayMillis = 300,
            easing = FastOutSlowInEasing
        ),
        label = "text_alpha"
    )

    val progressAlpha by animateFloatAsState(
        targetValue = if (showProgress) 1f else 0f,
        animationSpec = tween(durationMillis = 400, easing = FastOutSlowInEasing),
        label = "progress_alpha"
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primary),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = painterResource(R.drawable.sitzer_logo_nobg),
                contentDescription = stringResource(R.string.cd_app_logo),
                modifier = Modifier
                    .size(180.dp)
                    .alpha(logoAlpha)
                    .scale(logoScale)
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = stringResource(R.string.splash_tagline),
                fontSize = 22.sp,
                fontWeight = FontWeight.Medium,
                color = MaterialTheme.colorScheme.onPrimary,
                textAlign = TextAlign.Center,
                lineHeight = 28.sp,
                modifier = Modifier
                    .padding(horizontal = 32.dp)
                    .alpha(textAlpha)
            )

            Spacer(modifier = Modifier.height(48.dp))

            //For testing it's only loading
            //Add user credentail save + auto-log-on
            CircularProgressIndicator(
                modifier = Modifier
                    .size(40.dp)
                    .alpha(progressAlpha),
                color = MaterialTheme.colorScheme.onPrimary,
                strokeWidth = 3.dp
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SplashScreenPreview() {
    SitzerTheme {
        SplashScreen()
    }
}

