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
    // Primary - Ten sam pomarańcz
    primary = Color(0xFFFF6B35),
    onPrimary = Color.White,
    primaryContainer = Color(0xFFFFE0D0),
    onPrimaryContainer = Color(0xFF3D1A00),

    // Secondary
    secondary = Color(0xFFFFB347),
    onSecondary = Color(0xFF3D2A00),
    secondaryContainer = Color(0xFFFFF0D9),
    onSecondaryContainer = Color(0xFF3D2A00),

    // Tertiary
    tertiary = Color(0xFFE53935),
    onTertiary = Color.White,

    // Error
    error = Color(0xFFE53935),
    onError = Color.White,
    errorContainer = Color(0xFFFFCDD2),
    onErrorContainer = Color(0xFF5F0000),

    // Background - Czysta biel
    background = Color(0xFFFAFAFA),
    onBackground = Color(0xFF1A1A1A),

    // Surface
    surface = Color.White,
    onSurface = Color(0xFF1A1A1A),
    surfaceVariant = Color(0xFFF5F5F5),
    onSurfaceVariant = Color(0xFF666666),

    // Outline
    outline = Color(0xFFCCCCCC),
    outlineVariant = Color(0xFFF0F0F0),

    // Inverse
    inverseSurface = Color(0xFF1A1A1A),
    inverseOnSurface = Color(0xFFFAFAFA),
    inversePrimary = Color(0xFFFFB590)
)

private val DarkColorScheme = darkColorScheme(
    // Primary - Vibrant Orange (główny accent)
    primary = Color(0xFFFF6B35),              // Główny pomarańcz
    onPrimary = Color(0xFF1A0A00),           // Ciemny tekst na pomarańczu
    primaryContainer = Color(0xFF3D1A00),    // Ciemny pomarańcz container
    onPrimaryContainer = Color(0xFFFFB590),  // Jasny pomarańcz text

    // Secondary - Amber/Gold dla wyróżnienia
    secondary = Color(0xFFFFB347),            // Złoty amber
    onSecondary = Color(0xFF1A0A00),
    secondaryContainer = Color(0xFF3D2A00),
    onSecondaryContainer = Color(0xFFFFD9A0),

    // Tertiary - Deep Orange dla warnings
    tertiary = Color(0xFFFF4444),
    onTertiary = Color.White,

    // Error
    error = Color(0xFFFF5252),
    onError = Color(0xFF1A0000),
    errorContainer = Color(0xFF5D0000),
    onErrorContainer = Color(0xFFFFCDD2),

    // Background - Głęboka czerń (premium feel)
    background = Color(0xFF0D0D0D),           // Prawie czarna
    onBackground = Color(0xFFFAFAFA),         // Jasny text

    // Surface - Lekko jaśniejsza dla kart
    surface = Color(0xFF1A1A1A),              // Dark grey
    onSurface = Color(0xFFFAFAFA),

    // Surface Variant - Dla elementów wyróżnionych
    surfaceVariant = Color(0xFF262626),       // Średni dark
    onSurfaceVariant = Color(0xFFB3B3B3),     // Szary text

    // Outline
    outline = Color(0xFF404040),
    outlineVariant = Color(0xFF262626),

    // Inverse - dla elementów invertowanych
    inverseSurface = Color(0xFFFAFAFA),
    inverseOnSurface = Color(0xFF1A1A1A),
    inversePrimary = Color(0xFFFF6B35)
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