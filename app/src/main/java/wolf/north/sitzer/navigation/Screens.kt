package wolf.north.sitzer.navigation

object Screens {
    const val Home = "home"
    const val Login = "login"
    const val Register = "register"
    const val Profile = "profile"
    const val Plans = "plans"
    const val WorkoutHub = "workouthub/{planId}"
    const val SplashScreen = "splashscreen"


    // Helper navigation method to pass args into screen
    fun createWorkoutHubRoute(planId: Int): String {
        return "workouthub/$planId"
    }

}