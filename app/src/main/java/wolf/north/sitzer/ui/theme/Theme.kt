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
    primary = Color(0xFF1A7F8A),
    onPrimary = Color.White,
    primaryContainer = Color(0xFFA8D6DC),
    onPrimaryContainer = Color(0xFF002023),
    secondary = Color(0xFFE9C46A),
    onSecondary = Color(0xFF3D2E00),
    secondaryContainer = Color(0xFF6A592B),
    onSecondaryContainer = Color.White,
    tertiary = Color(0xFFE76F51),
    onTertiary = Color.White,
    tertiaryContainer = Color(0xFFD4A798),
    onTertiaryContainer = Color(0xFF3D1B11),
    error = Color(0xFFBA1A1A),
    onError = Color.White,
    errorContainer = Color(0xFFFFDAD6),
    onErrorContainer = Color(0xFF410002),
    background = Color(0xFFF8F9FA),
    onBackground = Color(0xFF1A1A1A),
    surface = Color.White,
    onSurface = Color(0xFF1A1A1A),
    surfaceVariant = Color(0xFFDDE4E7),
    onSurfaceVariant = Color(0xFF41494C),
    outline = Color(0xFF71797C)
)

private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFF8BD9DF),
    onPrimary = Color(0xFF00363A),
    primaryContainer = Color(0xFF004F54),
    onPrimaryContainer = Color(0xFFA8D6DC),
    secondary = Color(0xFFE9C46A),
    onSecondary = Color(0xFF3D2E00),
    secondaryContainer = Color(0xFF6A592B),
    onSecondaryContainer = Color.White,
    tertiary = Color(0xFFEFB39E),
    onTertiary = Color(0xFF5D2B20),
    tertiaryContainer = Color(0xFF854336),
    onTertiaryContainer = Color(0xFFFFDAD6),
    error = Color(0xFFFFB4AB),
    onError = Color(0xFF690005),
    errorContainer = Color(0xFF93000A),
    onErrorContainer = Color(0xFFFFDAD6),
    background = Color(0xFF121212),
    onBackground = Color(0xFFE1E1E1),
    surface = Color(0xFF1E1E1E),
    onSurface = Color(0xFFE1E1E1),
    surfaceVariant = Color(0xFF41494C),
    onSurfaceVariant = Color(0xFFC1C9CC),
    outline = Color(0xFF8B9396)
)

@Composable
fun SitzerTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true,
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