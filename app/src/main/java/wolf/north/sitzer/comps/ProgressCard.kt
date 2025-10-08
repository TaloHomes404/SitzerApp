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
        modifier = Modifier
            .width(160.dp)
            .height(180.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(6.dp),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(2.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 6.dp, end = 4.dp),
                horizontalArrangement = Arrangement.End
            ) {
                Icon(
                    Icons.Outlined.MoreVert,
                    contentDescription = "display more progress card",
                    tint = Color.Black,
                    modifier = Modifier
                        .size(24.dp)
                        .clickable { }
                )
            }

            Box(contentAlignment = Alignment.Center) {
                CircularProgressIndicator(
                    progress = { progress },
                    modifier = Modifier.size(100.dp),
                    color = Color.Blue,
                    strokeWidth = 6.dp,
                    trackColor = Color.LightGray,
                    gapSize = 0.dp
                )
                Text(
                    text = workoutsCountWeekly,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold, letterSpacing = 3.sp
                )
            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(bottom = 8.dp)
            ) {
                Text(
                    text = progressCardTitle,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 2.dp)
                )
                Text(
                    text = progressCardDescription,
                    fontSize = 12.sp,
                    color = Color.DarkGray,
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
            .height(180.dp),
        shape = RoundedCornerShape(10.dp),
        elevation = CardDefaults.cardElevation(6.dp),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(2.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 6.dp, end = 4.dp),
                horizontalArrangement = Arrangement.End
            ) {
                Icon(
                    Icons.Outlined.MoreVert,
                    contentDescription = "display more progress card",
                    tint = Color.Black,
                    modifier = Modifier
                        .size(24.dp)
                        .clickable { }
                )
            }


            Box(contentAlignment = Alignment.Center) {

                Text(
                    text = "$caloriesBurned🔥",
                    fontSize = 36.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Red,
                    letterSpacing = 1.5.sp
                )
            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(bottom = 8.dp)
            ) {
                Text(
                    text = progressCardTitle,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 2.dp)
                )
                Text(
                    text = progressCardDescription,
                    fontSize = 12.sp,
                    color = Color.DarkGray,
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