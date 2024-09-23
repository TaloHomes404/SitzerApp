package wolf.north.sitzer


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.ArrowRightAlt
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import wolf.north.sitzer.R

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WelcomeScreen()
        }
    }
}

@Composable
fun WelcomeScreen() {
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
                onClick = { /* Action */ },
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
fun WelcomeScreenPreview() {
    WelcomeScreen()
}

