package wolf.north.sitzer.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat


private val LightColorScheme = lightColorScheme(
    primary = Color(0xFF006B7D),
    onPrimary = Color.White,
    primaryContainer = Color(0xFFB2EBF2),
    onPrimaryContainer = Color(0xFF00363D),
    secondary = Color(0xFFFFB74D),
    onSecondary = Color(0xFF2D1B00),
    secondaryContainer = Color(0xFFFFE0B2),
    onSecondaryContainer = Color(0xFF2D1B00),
    tertiary = Color(0xFFEF5350),
    onTertiary = Color.White,
    tertiaryContainer = Color(0xFFFFCDD2),
    onTertiaryContainer = Color(0xFF410002),
    error = Color(0xFFD32F2F),
    onError = Color.White,
    errorContainer = Color(0xFFFFCDD2),
    onErrorContainer = Color(0xFF5F0000),
    background = Color(0xFFFAFAFA),
    onBackground = Color(0xFF1C1B1E),
    surface = Color.White,
    onSurface = Color(0xFF1C1B1E),
    surfaceVariant = Color(0xFFE0E3E3),
    onSurfaceVariant = Color(0xFF404943),
    outline = Color(0xFF70787C)
)

private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFF4DD0E1),
    onPrimary = Color(0xFF003640),
    primaryContainer = Color(0xFF004E5A),
    onPrimaryContainer = Color(0xFFB2EBF2),
    secondary = Color(0xFFFFB74D),
    onSecondary = Color(0xFF2D1B00),
    secondaryContainer = Color(0xFF533F00),
    onSecondaryContainer = Color(0xFFFFE0B2),
    tertiary = Color(0xFFFF6F60),
    onTertiary = Color(0xFF5F0000),
    tertiaryContainer = Color(0xFF8B2C23),
    onTertiaryContainer = Color(0xFFFFCDD2),
    error = Color(0xFFEF5350),
    onError = Color(0xFF5F0000),
    errorContainer = Color(0xFF8B1214),
    onErrorContainer = Color(0xFFFFCDD2),
    background = Color(0xFF0F1419),
    onBackground = Color(0xFFE6E1E5),
    surface = Color(0xFF1A1F24),
    onSurface = Color(0xFFE6E1E5),
    surfaceVariant = Color(0xFF3F484B),
    onSurfaceVariant = Color(0xFFBFC8CB),
    outline = Color(0xFF899296)
)


@Composable
fun SitzerTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {


    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = !darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}