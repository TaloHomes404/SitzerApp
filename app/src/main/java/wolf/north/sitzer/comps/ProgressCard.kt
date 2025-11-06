package wolf.north.sitzer.comps

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.MoreVert
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import wolf.north.sitzer.comps.ui.theme.SitzerTheme

@Composable
fun ProgressCard(
    progress: Float,
    workoutsCountWeekly: String,
    progressCardTitle: String,
    progressCardDescription: String
) {
    Card(
        modifier = Modifier.run {
            width(160.dp)
                .height(160.dp)
                .padding(horizontal = 8.dp)
        },
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(1.dp),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            // Główny wskaźnik
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.weight(1f)
            ) {
                CircularProgressIndicator(
                    progress = { progress },
                    modifier = Modifier.size(60.dp),
                    color = Color(0xFF4B6FFF),
                    strokeWidth = 6.dp,
                    trackColor = Color(0xFFE8EAF0),
                    gapSize = 0.dp
                )
                Text(
                    text = workoutsCountWeekly,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 3.sp,
                    color = Color(0xFF1A1A1A)
                )
            }

            // Opisy
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.wrapContentHeight()
            ) {
                Text(
                    text = progressCardTitle,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color(0xFF1A1A1A),
                    textAlign = TextAlign.Center,
                    maxLines = 1
                )
                Text(
                    text = progressCardDescription,
                    fontSize = 12.sp,
                    color = Color(0xFF8E8E93),
                    textAlign = TextAlign.Center,
                    maxLines = 1
                )
            }
        }
    }

}


@Composable
fun ProgressCardNumberIndicator(
    caloriesBurned: Int,
    progressCardTitle: String,
    progressCardDescription: String
) {
    Card(
        modifier = Modifier
            .width(160.dp)
            .height(160.dp)
            .padding(horizontal = 8.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(1.dp),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            // Główny wskaźnik
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = "$caloriesBurned🔥",
                    fontSize = 36.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Red,
                    letterSpacing = 1.5.sp
                )
            }

            // Opisy
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.wrapContentHeight()
            ) {
                Text(
                    text = progressCardTitle,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color(0xFF1A1A1A),
                    textAlign = TextAlign.Center,
                    maxLines = 1
                )
                Text(
                    text = progressCardDescription,
                    fontSize = 12.sp,
                    color = Color(0xFF8E8E93),
                    textAlign = TextAlign.Center,
                    maxLines = 1
                )
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true, apiLevel = 34)
@Composable
fun ProgressCardPreview() {
    SitzerTheme {
        Row {
            ProgressCardNumberIndicator(531, "Calories Burned", "This Week")
            ProgressCard(0.55F, "5/10", "test", "test")
        }
    }
}