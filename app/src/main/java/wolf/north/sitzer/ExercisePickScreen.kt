package wolf.north.sitzer

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.ArrowForward
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material.icons.outlined.MoreVert
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.QuestionMark
import androidx.compose.material.icons.outlined.Timer
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExercisePickScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        IconButton(onClick = { /* Back action */ }) {
                            Icon(
                                Icons.Default.ArrowBack,
                                contentDescription = "Back",
                                tint = Color.White
                            )
                        }
                        Spacer(modifier = Modifier.width(25.dp))
                        Text(text = "Stretching Exercises", color = Color.White)
                    }
                },
                actions = {
                    IconButton(onClick = { /* Obsługa kliknięcia ikony */ }) {
                        Icon(
                            Icons.Outlined.QuestionMark,
                            contentDescription = "More",
                            tint = Color.White
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = colorResource(id = R.color.welcome_screen_bg) // Zmień na żądany kolor
                )
            )
        },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .background(Color(0xFFECEFF1)),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                // Zdjęcie na pół ekranu
                Image(
                    painter = painterResource(id = R.drawable._1146416), // Ustaw odpowiedni resource
                    contentDescription = "Sample Image",
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp) // Połowa ekranu (zależnie od urządzenia może to być mniej lub więcej)
                )

                // Solidny Spacer po zdjęciu
                Spacer(modifier = Modifier.height(20.dp))

                // Wyśrodkowany pogrubiony tekst
                Text(
                    text = "Plank Hold",
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )

                // Szary opis
                Text(
                    text = stringResource(R.string.plank_desc),
                    fontSize = 16.sp,
                    color = Color.Gray,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .padding(top = 8.dp)
                )


                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "1 Set - 40 seconds",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Medium
                    )

                }


                ExerciseTimer()


            }
        },


        )
}

@Preview(showSystemUi = true)
@Composable
fun ExercisePickScreenPreviev() {
    ExercisePickScreen()
}

@Composable
fun ExerciseTimer(
    totalTime: Long = 60L,  // Total time in seconds
    onTimerFinish: () -> Unit = {}
) {
    var timeLeft by remember { mutableStateOf(totalTime) }

    // Timer logic
    LaunchedEffect(key1 = timeLeft) {
        if (timeLeft > 0) {
            delay(1000L) // 1 second delay
            timeLeft -= 1
        } else {
            onTimerFinish()
        }
    }

    // UI
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Time Left:",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        Text(
            text = "${timeLeft}s",
            fontSize = 40.sp,
            fontWeight = FontWeight.SemiBold,
            color = MaterialTheme.colorScheme.primary
        )

        Spacer(modifier = Modifier.height(4.dp))

        // Optionally, a button to reset the timer
        Row {
            Button(onClick = { timeLeft = totalTime }) {
                Text(text = "Restart Timer")
            }
            Spacer(modifier = Modifier.width(16.dp))
            Button(onClick = {}) {
                Text(text = "Start Timer")
            }
        }
    }
}