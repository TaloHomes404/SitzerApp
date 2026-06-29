package wolf.north.sitzer.utils


import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.activity.ComponentActivity
import java.util.Locale

object LegacyLocaleHelper {

    fun setLocaleAndRestart(context: Context, languageCode: String) {
        val activity = findComponentActivity(context) ?: return
        updateResources(activity, languageCode)
        restartActivity(activity)
    }

    private fun findComponentActivity(context: Context): ComponentActivity? {
        return when (context) {
            is ComponentActivity -> context
            is android.view.ContextThemeWrapper -> findComponentActivity(context.baseContext)
            else -> null
        }
    }

    private fun updateResources(activity: ComponentActivity, languageCode: String) {
        val locale = Locale(languageCode)
        Locale.setDefault(locale)

        val resources = activity.resources
        val config = resources.configuration

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            config.setLocale(locale)
            activity.createConfigurationContext(config)
        } else {
            config.locale = locale
            resources.updateConfiguration(config, resources.displayMetrics)
        }
    }

    private fun restartActivity(activity: ComponentActivity) {
        activity.finish()
        val intent = activity.intent
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
        activity.overridePendingTransition(0, 0)
        activity.startActivity(intent)
        activity.overridePendingTransition(0, 0)
    }
}