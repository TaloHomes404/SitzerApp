package wolf.north.sitzer.mvvm.view


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowRightAlt
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import wolf.north.sitzer.R
import wolf.north.sitzer.navigation.AppNavigation
import wolf.north.sitzer.navigation.Screens

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppNavigation()
        }
    }
}

@Composable
fun SplashScreen( navController: NavHostController  = rememberNavController() ) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(R.color.welcome_screen_bg))
    ) {
        // Spacer wypełniający górną część ekranu
        Spacer(modifier = Modifier.weight(1f))

        // Obrazek na dole
        Image(
            painter = painterResource(R.drawable.man_stretch), // tutaj musisz wstawić własny obrazek
            contentDescription = "Welcome Image",
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .align(Alignment.End), // Ustawienie obrazka na dole
            contentScale = ContentScale.FillWidth
        )

        // Zaokrąglona karta z tekstem i przyciskiem
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    Color.White,
                    shape = RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp)
                )
                .padding(24.dp), // padding wewnątrz karty
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Spacer(modifier = Modifier.height(32.dp)) // Większa przestrzeń na górze

            Text(
                text = "Shift your position, \n  uplift your spirit!",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier.align(Alignment.CenterHorizontally) // Wyrównanie do lewej
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = stringResource(R.string.welcome_screen_desc),
                fontSize = 18.sp,
                color = Color.Gray,
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .align(Alignment.CenterHorizontally),
                lineHeight = 20.sp
            )

            Spacer(modifier = Modifier.weight(1f)) // Wypełnia przestrzeń, aby przycisk był na dole

            Button(
                onClick = { navController.navigate(Screens.Login ) {
                    popUpTo(Screens.SplashScreen) {inclusive = true}
                } },
                colors = ButtonDefaults.buttonColors(containerColor = colorResource(R.color.welcome_screen_bg)), // przycisk fioletowy
                shape = RoundedCornerShape(10.dp), // zaokrąglenie przycisku
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = "Get Started", color = Color.White, fontSize = 24.sp)
                    Icon(
                        Icons.Default.ArrowRightAlt,
                        contentDescription = "Register Icon",

                        modifier = Modifier
                            .padding(end = 8.dp)

                    )
                }

            }

            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SplashScreenPreview() {
    SplashScreen()
}

