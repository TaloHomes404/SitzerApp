package wolf.north.sitzer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircleOutline
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.NotificationAdd
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Timer
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import wolf.north.sitzer.ui.theme.SitzerTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserProfileScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        // Duże zdjęcie użytkownika w formie koła
                        Image(
                            painter = painterResource(id = R.drawable.profilepfp), // Wstaw własny obrazek
                            contentDescription = null,
                            modifier = Modifier
                                .size(80.dp) // Rozmiar zdjęcia
                                .clip(CircleShape), // Zaokrąglone zdjęcie
                            contentScale = ContentScale.Fit
                        )
                        Spacer(modifier = Modifier.width(16.dp))
                        Column {
                            Text(
                                text = "Hello, User name",
                                fontSize = 24.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Text(text = "First Timer", fontSize = 14.sp, color = Color.White)
                                Spacer(modifier = Modifier.width(8.dp))
                                LinearProgressIndicator(
                                    progress = 0.2f, // Przykładowy postęp
                                    color = Color.White,
                                    trackColor = Color.Black,
                                    strokeCap = StrokeCap.Square,
                                    modifier = Modifier
                                        .weight(1f)
                                        .height(8.dp)
                                )
                                Text(text = "Beginner", fontSize = 14.sp, color = Color.White)
                            }
                        }
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
                    .background(Color(0xFFECEFF1))
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp) // Przestrzenie między elementami
            ) {
                // Nagłówek "Statistics"
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = "Statistics", fontSize = 24.sp, fontWeight = FontWeight.Bold)
                    Text(text = "Show all", color = Color.Gray, fontSize = 16.sp)
                }
                Text(text = "Exercises: 6", color = Color.Black, fontSize = 16.sp, fontWeight = FontWeight.Bold)
                Text(text = "Calories burned: 129,9kcal", color = Color.Black, fontSize = 16.sp, fontWeight = FontWeight.Bold)

                // Dodanie wykresu pod nagłówkiem "Statistics"
                SimpleBarChart() // Wstawienie wykresu zajmującego całą szerokość ekranu

                // Nagłówek "Trainings"
                Text(text = "Last trainings sessions", fontSize = 24.sp, fontWeight = FontWeight.Bold)

                // Pierwsza karta
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp),
                    shape = RoundedCornerShape(16.dp),
                    elevation = CardDefaults.cardElevation(4.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxSize(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column(
                            modifier = Modifier
                                .weight(1f)
                                .padding(16.dp),
                            verticalArrangement = Arrangement.SpaceEvenly
                        ) {
                            Text(text = "Lower Back Exercises", fontSize = 18.sp, fontWeight = FontWeight.Bold)
                            Text(text = "Plan made for strenghtening lower back", fontSize = 14.sp)
                            Text(text = "Exercises made: 5", fontSize = 14.sp)
                        }
                        // Mały kwadracik z obrazkiem ćwiczenia
                        Image(
                            painter = painterResource(id = R.drawable.stretch_img), // Wstaw własny obrazek
                            contentDescription = null,
                            modifier = Modifier
                                .size(80.dp)
                                .clip(RoundedCornerShape(8.dp))
                                .padding(end = 8.dp),
                            contentScale = ContentScale.Crop
                        )
                    }
                }

                // Druga karta
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp),
                    shape = RoundedCornerShape(16.dp),
                    elevation = CardDefaults.cardElevation(4.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxSize(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column(
                            modifier = Modifier
                                .weight(1f)
                                .padding(16.dp),
                            verticalArrangement = Arrangement.SpaceEvenly
                        ) {
                            Text(text = "Neck Pain Relief", fontSize = 18.sp, fontWeight = FontWeight.Bold)
                            Text(
                                text = "Series of exercises for tightened neck muscles",
                                fontSize = 14.sp
                            )
                            Text(text = "Exercises made: 1", fontSize = 14.sp)
                        }
                        // Mały kwadracik z obrazkiem ćwiczenia
                        Image(
                            painter = painterResource(id = R.drawable.neck_exercise), // Wstaw własny obrazek
                            contentDescription = null,
                            modifier = Modifier
                                .size(80.dp)
                                .clip(RoundedCornerShape(8.dp))
                                .padding(end = 8.dp),
                            contentScale = ContentScale.Crop
                        )
                    }
                }

                Spacer(modifier = Modifier.height(8.dp))

                // Prostokąt z ikonami i tekstem
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                        .background(colorResource(id = R.color.welcome_screen_bg))
                        .padding(horizontal = 16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    IconButton(onClick = { /* Akcja lewa ikona */ }) {
                        Icon(
                            Icons.Default.NotificationAdd,
                            contentDescription = "Notification icon",
                            tint = Color.White
                        )
                    }
                    Text(text = "Notification options", fontSize = 22.sp, color = Color.White)
                    IconButton(onClick = { /* Akcja prawa ikona */ }) {
                        Icon(
                            Icons.Default.AddCircleOutline,
                            contentDescription = "Settings",
                            tint = Color.White
                        )
                    }
                }

                Spacer(modifier = Modifier.height(8.dp))

                // Drugi prostokąt z ikonami i tekstem
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                        .background(colorResource(id = R.color.welcome_screen_bg))
                        .padding(horizontal = 16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    IconButton(onClick = { /* Akcja lewa ikona */ }) {
                        Icon(
                            Icons.Default.Person,
                            contentDescription = "edit icon",
                            tint = Color.White
                        )
                    }
                    Text(text = "Edit profile informations", fontSize = 22.sp, color = Color.White)
                    IconButton(onClick = { /* Akcja prawa ikona */ }) {
                        Icon(
                            Icons.Default.Edit,
                            contentDescription = "Settings",
                            tint = Color.White
                        )
                    }
                }
            }
        },
        bottomBar = {
            BottomAppBar(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)),
                containerColor = colorResource(R.color.welcome_screen_bg),
                contentColor = Color.Gray,
                tonalElevation = 5.dp,
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 20.dp),
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(onClick = { /* Handle Menu click */ }) {
                        Icon(
                            imageVector = Icons.Outlined.Menu,
                            contentDescription = "Menu",
                            tint = Color.Gray
                        )
                    }
                    IconButton(onClick = { /* Handle Favorite click */ }) {
                        Icon(
                            imageVector = Icons.Outlined.Timer,
                            contentDescription = "Favorite",
                            tint = Color.Gray
                        )
                    }
                    IconButton(onClick = { /* Handle Profile click */ }) {
                        Icon(
                            imageVector = Icons.Outlined.Person,
                            contentDescription = "Profile",
                            tint = Color.White
                        )
                    }
                }
            }
        }
    )
}
@Composable
fun SimpleBarChart() {
    val daysOfWeek = listOf("Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun")
    val values = listOf(1f, 2f, 0f, 1f, 2f, 0f, 1f) // Losowe wartości

    Canvas(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .padding(16.dp)
    ) {
        val barWidth = size.width / (values.size * 2)
        val maxValue = values.maxOrNull() ?: 0f
        val barHeightRatio = size.height / maxValue

        values.forEachIndexed { index, value ->
            val x = barWidth * (1 + index * 2)
            val y = size.height - (value * barHeightRatio)

            // Rysowanie słupka
            drawRect(
                color = Color.Blue,
                topLeft = Offset(x, y),
                size = Size(barWidth, value * barHeightRatio)
            )

            // Rysowanie podpisów dni tygodnia
            drawContext.canvas.nativeCanvas.drawText(
                daysOfWeek[index],
                x + barWidth / 4,
                size.height + 22f, // Mały odstęp pod wykresem
                android.graphics.Paint().apply {
                    textAlign = android.graphics.Paint.Align.CENTER
                    textSize = 35f
                    color = android.graphics.Color.BLACK
                }
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun UserProfileScreenPreview() {
    UserProfileScreen()
}