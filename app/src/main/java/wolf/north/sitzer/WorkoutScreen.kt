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
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.ArrowForward
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material.icons.outlined.MoreVert
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Timer
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomSelectionScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(
                        modifier = Modifier.padding(8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text = "Selected:", fontSize = 28.sp, color = Color.White)
                        Spacer(modifier = Modifier.width(16.dp))
                        Row(
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Card(
                                modifier = Modifier
                                    .height(80.dp)
                                    .width(120.dp),
                                shape = RoundedCornerShape(12.dp),
                                elevation = CardDefaults.cardElevation(2.dp),
                                colors = CardDefaults.cardColors(Color(0xFFFDD835))
                            ) {
                                Box(
                                    contentAlignment = Alignment.Center,
                                    modifier = Modifier.fillMaxSize()
                                ) {
                                    Icon(
                                        painter = painterResource(id = R.drawable.pain),
                                        contentDescription = null,
                                        modifier = Modifier.size(70.dp),
                                        tint = Color.Unspecified
                                    )
                                }
                            }
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = "Lower back Exercises",
                                fontSize = 18.sp,
                                color = Color.White
                            )
                        }
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = colorResource(id = R.color.welcome_screen_bg))
            )
        },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .background(Color(0xFFECEFF1)),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 24.dp, start = 16.dp, end = 16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = "Practice", fontSize = 24.sp, fontWeight = FontWeight.SemiBold)
                    Text(
                        text = "All",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.Gray
                    )
                }

                Spacer(modifier = Modifier.height(32.dp))

                // Karty z unikalnymi danymi
                Card(
                    modifier = Modifier
                        .fillMaxWidth(0.9f)
                        .height(150.dp),
                    shape = RoundedCornerShape(16.dp),
                    elevation = CardDefaults.cardElevation(4.dp),
                    colors = CardDefaults.cardColors(Color.White)
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
                            Text(text = "Plank", fontSize = 24.sp, fontWeight = FontWeight.SemiBold)
                            Text(text = "Strenghten whole body", fontSize = 16.sp)
                            Text(text = "1-5 min", fontSize = 14.sp, color = Color.Gray)
                        }
                        Image(
                            painter = painterResource(id = R.drawable._1146416),
                            contentDescription = null,
                            modifier = Modifier
                                .fillMaxHeight()
                                .weight(1f)
                                .clip(RoundedCornerShape(16.dp))
                                .padding(8.dp),
                            contentScale = ContentScale.Fit
                        )
                    }
                }
                Spacer(modifier = Modifier.height(12.dp))

                Card(
                    modifier = Modifier
                        .fillMaxWidth(0.9f)
                        .height(150.dp),
                    shape = RoundedCornerShape(16.dp),
                    elevation = CardDefaults.cardElevation(4.dp),
                    colors = CardDefaults.cardColors(Color.White)
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
                            Text(
                                text = "Cobra stretch",
                                fontSize = 24.sp,
                                fontWeight = FontWeight.SemiBold
                            )
                            Text(text = "Target whole lower back muscles", fontSize = 16.sp)
                            Text(text = "1-5 min", fontSize = 14.sp, color = Color.Gray)
                        }
                        Image(
                            painter = painterResource(id = R.drawable._1146434),
                            contentDescription = null,
                            modifier = Modifier
                                .fillMaxHeight()
                                .weight(1f)
                                .clip(RoundedCornerShape(16.dp))
                                .padding(8.dp),
                            contentScale = ContentScale.Crop
                        )
                    }
                }
                Spacer(modifier = Modifier.height(12.dp))

                Card(
                    modifier = Modifier
                        .fillMaxWidth(0.9f)
                        .height(150.dp),
                    shape = RoundedCornerShape(16.dp),
                    elevation = CardDefaults.cardElevation(4.dp),
                    colors = CardDefaults.cardColors(Color.White)
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
                            Text(
                                text = "Cat-Cow Pose",
                                fontSize = 24.sp,
                                fontWeight = FontWeight.SemiBold
                            )
                            Text(text = "Strenghten neck, shoulders and spine", fontSize = 16.sp)
                            Text(text = "10-20 reps", fontSize = 14.sp, color = Color.Gray)
                        }
                        Image(
                            painter = painterResource(id = R.drawable._1146414),
                            contentDescription = null,
                            modifier = Modifier
                                .fillMaxHeight()
                                .weight(1f)
                                .clip(RoundedCornerShape(16.dp))
                                .padding(8.dp),
                            contentScale = ContentScale.Crop
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
                            tint = Color.White
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
        }
    )
}

@Preview(showSystemUi = true)
@Composable
fun CustomSelectionScreenPreview() {
    CustomSelectionScreen()
}