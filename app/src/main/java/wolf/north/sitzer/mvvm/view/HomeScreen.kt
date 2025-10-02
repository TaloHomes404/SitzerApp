package wolf.north.sitzer.mvvm.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material.icons.outlined.MoreVert
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Timer
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import wolf.north.sitzer.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        IconButton(onClick = { /* Back action */ }) {
                            Icon(Icons.Default.ArrowBack, contentDescription = "Back", tint = Color.White)
                        }
                        Spacer(modifier = Modifier.width(25.dp))
                        Text(text = "Select your workout", color = Color.White)
                    }
                },
                actions = {
                    IconButton(onClick = { /* Obsługa kliknięcia ikony */ }) {
                        Icon(Icons.Outlined.MoreVert, contentDescription = "More", tint = Color.White)
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
                    .padding(8.dp)
            ) {
                // First LazyRow Section (e.g. "Select group")
                SectionTitle("Select desired muscle group")
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    // Używamy różnych elementów z określonymi kolorami dla kart
                    itemsIndexed(
                        listOf(
                            Triple(R.drawable.pain, "Lower Back", Color(0xFFB0EACD)),
                            Triple(R.drawable.injury, "Neck", Color(0xFFFDD835)),
                            Triple(R.drawable.curve, "Posture", Color(0xFFFFAB91)),
                            Triple(R.drawable.curve, "Posture", Color(0xFF80CBC4))
                        )
                    ) { index, item ->
                        WorkoutCardFirst(
                            imageRes = item.first,
                            title = item.second,
                            cardColor = item.third
                        )
                    }
                }

                Spacer(modifier = Modifier.height(8.dp))

                // Second LazyRow Section (e.g. "ready programs")
                SectionTitle("Free ready exercise programs!")
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    itemsIndexed(
                        listOf(
                            R.drawable.stretch_img to "Posture Fix",
                            R.drawable.neck_exercise to "Neck Pain Relief",
                            R.drawable.lowerback_exercise to "Strong Lower Back"
                        )
                    ) { index, item ->
                        WorkoutCardSecond(
                            imageRes = item.first,
                            title = item.second
                        )
                    }
                }

                Spacer(modifier = Modifier.height(8.dp))

                // Third LazyRow Section (e.g. "premium section")
                SectionTitle("Premium plans (associated with professional physiotherapists) 👑")
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    // Karty jak w drugim LazyRow (zdjęcie na całej powierzchni)
                    itemsIndexed(
                        listOf(
                            R.drawable.holdingdbm to "Lower Body",
                            R.drawable.takingdb to "Upper Body",
                            R.drawable.exercise_premium1 to "Full Body"
                        )
                    ) { index, item ->
                        WorkoutCardSecond(
                            imageRes = item.first,
                            title = item.second
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
                            tint = Color.White
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
                            tint = Color.Gray
                        )
                    }
                }
            }
        },
    )
}

@Composable
fun SectionTitle(title: String) {
    Text(
        text = title,
        fontSize = 20.sp,
        color = Color.Black,
        modifier = Modifier.padding(vertical = 8.dp)
    )
}

// First LazyRow Card - Kolor dopasowany do każdej karty
@Composable
fun WorkoutCardFirst(imageRes: Int, title: String, cardColor: Color) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Card(
            modifier = Modifier
                .height(80.dp)
                .width(120.dp), // Lekko większy rozmiar
            shape = RoundedCornerShape(12.dp),
            elevation = CardDefaults.cardElevation(2.dp),
            colors = CardDefaults.cardColors(cardColor)

        ) {
            // Wyśrodkowanie ikony
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                Icon(
                    painter = painterResource(id = imageRes),
                    contentDescription = title,
                    modifier = Modifier.size(70.dp), // Dostosowanie rozmiaru
                    tint = Color.Unspecified
                )
            }
        }
        // Tytuł umieszczony poniżej karty
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = title,
            fontSize = 14.sp,
            color = Color.Black,
        )
    }
}

// Second LazyRow Card - Wyższy "Słupek" ze zdjęciem i tytułem poniżej
@Composable
fun WorkoutCardSecond(imageRes: Int, title: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Card(
            modifier = Modifier
                .width(120.dp) // Węższa szerokość dla słupka
                .height(200.dp) // Wyższa wysokość
                .padding(2.dp),
            shape = RoundedCornerShape(16.dp),
            elevation = CardDefaults.cardElevation(4.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = title,
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(), // Obraz zajmuje większość karty
                contentScale = ContentScale.Crop // Obraz wypełnia kartę z przycięciem
            )
        }
        // Tytuł umieszczony poniżej karty
        Spacer(modifier = Modifier.height(2.dp))
        Text(
            text = title,
            fontSize = 14.sp,
            color = Color.Black
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewWorkoutSelectionScreen() {
    HomeScreen()
}