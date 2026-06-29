package wolf.north.sitzer.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
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
        composable(
            Screens.WorkoutHub,
            arguments = listOf(navArgument("planId") { type = NavType.IntType })
        ) { backStackEntry ->
            val planId = backStackEntry.arguments?.getInt("planId")
            WorkoutHubScreen(
                navController = navController,
                planId = planId
            )

        }
        composable(Screens.Home) { HomeScreen(navController = navController) }
        composable(Screens.Login) { LoginScreen(navController = navController) }
        composable(Screens.Register) { RegisterScreen(navController = navController) }
        composable(Screens.Plans) { PlanSelectScreen(navController = navController) }
        composable(Screens.Profile) { ProfileScreen(navController = navController) }
        composable(Screens.SplashScreen) { SplashScreen(navController = navController) }


    }
}