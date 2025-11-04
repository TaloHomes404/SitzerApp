package wolf.north.sitzer.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import wolf.north.sitzer.mvvm.view.HomeScreen
import wolf.north.sitzer.mvvm.view.LoginScreen
import wolf.north.sitzer.mvvm.view.PlanSelectScreen
import wolf.north.sitzer.mvvm.view.ProfileScreen
import wolf.north.sitzer.mvvm.view.RegisterScreen
import wolf.north.sitzer.mvvm.view.SplashScreen
import wolf.north.sitzer.mvvm.view.WorkoutHubScreen


@Composable
fun AppNavigation(navController: NavHostController = rememberNavController()) {
    NavHost(
        navController = navController,
        startDestination = Screens.SplashScreen
    ) {
        composable(Screens.WorkoutHub) { WorkoutHubScreen (navController = navController) }
        composable(Screens.Home) { HomeScreen(navController = navController) }
        composable(Screens.Login) {
            LoginScreen(
                navController = navController
            )
        }
        composable(Screens.Register) { RegisterScreen(navController = navController) }
        composable(Screens.Plans) { PlanSelectScreen(navController = navController) }
        composable(Screens.Profile) { ProfileScreen(navController = navController) }
        composable(Screens.SplashScreen) { SplashScreen(navController = navController) }

    }
}