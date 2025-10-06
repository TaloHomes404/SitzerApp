package wolf.north.sitzer.comps

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronLeft
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import wolf.north.sitzer.R
import wolf.north.sitzer.comps.ui.theme.SitzerTheme


@Composable
fun OnboardingIntroductionOverlay() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black.copy(alpha = 0.82f)),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Card(
                modifier = Modifier
                    .width(320.dp)
                    .padding(bottom = 4.dp),
                shape = RoundedCornerShape(24.dp),
                elevation = CardDefaults.cardElevation(8.dp)
            ) {
                Column(
                    modifier = Modifier.padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Text(
                        "Welcome to Sitzer! ❤👋",
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                        letterSpacing = 0.5.sp,
                    )
                    Text(
                        "Your personal guide to pain relief and better posture.\n We're here to help you feel better with personalized exercise programs.",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        letterSpacing = 0.5.sp,
                        textAlign = TextAlign.Center
                    )

                }
            }
            ElevatedButton(onClick = {}, Modifier.width(160.dp)) {
                Text("Continue")
            }
        }

    }
}

@Composable
fun FinalOnboardingInfo() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black.copy(alpha = 0.82f)),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Card(
                modifier = Modifier
                    .width(320.dp)
                    .padding(bottom = 4.dp),
                shape = RoundedCornerShape(24.dp),
                elevation = CardDefaults.cardElevation(8.dp)
            ) {
                Column(
                    modifier = Modifier.padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Text(
                        "You're all set ❤👋",
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                        letterSpacing = 0.5.sp,
                    )
                    Text(
                        "Ready to start? Your body will thank you. \n Select workout and let the transformation begin! 💪",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        letterSpacing = 0.5.sp,
                        textAlign = TextAlign.Center
                    )

                }
            }
            ElevatedButton(onClick = {}, Modifier.width(160.dp)) {
                Text("Ready")
            }
        }

    }
}

@Composable
fun OurMissionCard() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black.copy(alpha = 0.82f)),
        contentAlignment = Alignment.Center
    ) {

        Icon(
            imageVector = Icons.Filled.ChevronLeft,
            contentDescription = "Previous",
            tint = Color.White,
            modifier = Modifier
                .align(Alignment.CenterStart)
                .padding(end = 8.dp)
                .size(32.dp)
                .clickable { }
        )


        Icon(
            imageVector = Icons.Filled.ChevronRight,
            contentDescription = "Next",
            tint = Color.White,
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .padding(start = 8.dp)
                .size(32.dp)
                .clickable { }
        )

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Card(
                modifier = Modifier
                    .width(325.dp)
                    .height(400.dp)
                    .padding(bottom = 2.dp),
                shape = RoundedCornerShape(6.dp),
                elevation = CardDefaults.cardElevation(8.dp)
            ) {
                Box(modifier = Modifier.fillMaxSize()) {

                    Image(
                        painter = painterResource(R.drawable.placeholderimg),
                        contentDescription = "Nasza misja",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                    )

                    Box(
                        modifier = Modifier
                            .align(Alignment.BottomStart)
                            .fillMaxWidth()
                            .background(
                                Brush.verticalGradient(
                                    colors = listOf(
                                        Color.Transparent,
                                        Color.Black.copy(alpha = 0.7f)
                                    )
                                )
                            )
                            .padding(16.dp)
                    ) {
                        Column(verticalArrangement = Arrangement.Bottom) {
                            Text(
                                "Nasza Misja",
                                color = Color.White,
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                "Profesjonalne wsparcie w poprawie postawy i łagodzeniu bólu pleców",
                                color = Color.White,
                                fontSize = 14.sp
                            )

                            ElevatedButton(onClick = {}, Modifier.width(160.dp)) {
                                Text("Continue")
                            }
                        }
                    }
                }

            }


        }
    }
}

@Composable
fun HomeOnboardingInfo() {
    Box(
        contentAlignment = Alignment.BottomStart,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black.copy(alpha = 0.82f))
            .padding(start = 8.dp, bottom = 64.dp),

        ) {


        Icon(
            imageVector = Icons.Filled.ChevronRight,
            contentDescription = "Next",
            tint = Color.White,
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(start = 8.dp)
                .size(32.dp)
                .clickable { }
        )

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Card(
                modifier = Modifier
                    .width(320.dp)
                    .padding(bottom = 4.dp),
                shape = RoundedCornerShape(24.dp),
                elevation = CardDefaults.cardElevation(8.dp)
            ) {
                Column(
                    modifier = Modifier.padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Text(
                        "Welcome to Sitzer! ❤👋",
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                        letterSpacing = 0.5.sp,
                    )
                    Text(
                        "Your personal guide to pain relief and better posture.\n We're here to help you feel better with personalized exercise programs.",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        letterSpacing = 0.5.sp,
                        textAlign = TextAlign.Center
                    )

                }
            }
            ElevatedButton(onClick = {}, Modifier.width(160.dp)) {
                Text("Continue")
            }
        }

    }
}

@Composable
fun WorkoutOnboardingInfo() {
    Box(
        contentAlignment = Alignment.BottomCenter,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black.copy(alpha = 0.82f))
            .padding(start = 8.dp, bottom = 64.dp),

        ) {


        Icon(
            imageVector = Icons.Filled.ChevronRight,
            contentDescription = "Next",
            tint = Color.White,
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(start = 8.dp)
                .size(32.dp)
                .clickable { }
        )

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Card(
                modifier = Modifier
                    .width(320.dp)
                    .padding(bottom = 4.dp),
                shape = RoundedCornerShape(24.dp),
                elevation = CardDefaults.cardElevation(8.dp)
            ) {
                Column(
                    modifier = Modifier.padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Text(
                        "Welcome to Sitzer! ❤👋",
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                        letterSpacing = 0.5.sp,
                    )
                    Text(
                        "Your personal guide to pain relief and better posture.\n We're here to help you feel better with personalized exercise programs.",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        letterSpacing = 0.5.sp,
                        textAlign = TextAlign.Center
                    )

                }
            }
            ElevatedButton(onClick = {}, Modifier.width(160.dp)) {
                Text("Continue")
            }
        }

    }
}

@Composable
fun ProfileOnboardingInfo() {
    Box(
        contentAlignment = Alignment.BottomEnd,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black.copy(alpha = 0.82f))
            .padding(end = 8.dp, bottom = 64.dp),

        ) {


        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Card(
                modifier = Modifier
                    .width(320.dp)
                    .padding(bottom = 4.dp),
                shape = RoundedCornerShape(24.dp),
                elevation = CardDefaults.cardElevation(8.dp)
            ) {
                Column(
                    modifier = Modifier.padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Text(
                        "Welcome to Sitzer! ❤👋",
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                        letterSpacing = 0.5.sp,
                    )
                    Text(
                        "Your personal guide to pain relief and better posture.\n We're here to help you feel better with personalized exercise programs.",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        letterSpacing = 0.5.sp,
                        textAlign = TextAlign.Center
                    )

                }
            }
            ElevatedButton(onClick = {}, Modifier.width(160.dp)) {
                Text("Continue")
            }
        }

    }
}


@Preview(showBackground = true, showSystemUi = true, apiLevel = 34)
@Composable
fun GreetingPreview() {
    SitzerTheme {
        FinalOnboardingInfo()
    }
}