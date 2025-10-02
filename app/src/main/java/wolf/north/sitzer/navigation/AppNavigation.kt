package wolf.north.sitzer.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import wolf.north.sitzer.mvvm.view.ExercisePickScreen
import wolf.north.sitzer.mvvm.view.HomeScreen
import wolf.north.sitzer.mvvm.view.LoginScreen
import wolf.north.sitzer.mvvm.view.ProfileScreen
import wolf.north.sitzer.mvvm.view.RegisterScreen
import wolf.north.sitzer.mvvm.view.SplashScreen
import wolf.north.sitzer.mvvm.view.WorkoutScreen


@Composable
fun AppNavigation(navController: NavHostController = rememberNavController()) {
    NavHost(
        navController = navController,
        startDestination = Screens.SplashScreen
    ){
        composable(Screens.Exercises) { ExercisePickScreen() }
        composable(Screens.Home) { HomeScreen() }
        composable(Screens.Login) { LoginScreen() }
        composable(Screens.Register) { RegisterScreen() }
        composable(Screens.Workout) { WorkoutScreen() }
        composable(Screens.Profile) { ProfileScreen() }
        composable(Screens.SplashScreen) { SplashScreen() }

    }
}