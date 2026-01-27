package wolf.north.sitzer.comps

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.SportsGymnastics
import androidx.compose.material.icons.outlined.Timer
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import wolf.north.sitzer.comps.ui.theme.SitzerTheme
import wolf.north.sitzer.enums.MuscleGroup

@Composable
fun CategoriesCarousel(selectedCategory: MuscleGroup?, onCategorySelected: (MuscleGroup) -> Unit) {

    //List of category
    val categories = MuscleGroup.entries.toTypedArray()

    //Categories lazyrow
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) {
        items(categories) { category ->
            FilterChip(
                selected = (selectedCategory == category),
                onClick = { onCategorySelected(category) },
                label = {
                    Text(category.name.lowercase().replaceFirstChar { it.uppercase() }) }
            )
        }
    }
}

@Composable
fun DifficultyCarousel(selectedDifficulty: String, onDifficultySelected: (String) -> Unit) {

    //List of difficulties
    val difficulties = listOf(
        "Beginner",
        "Intermediate",
        "Advanced"
    )

    //Difficulty lazyrow with section name (on default this option is hidden)
    //added to filter options on click
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) {
        items(difficulties) { difficulty ->
            FilterChip(
                selected = (selectedDifficulty == difficulty),
                onClick = { onDifficultySelected(difficulty) },
                label = { Text(difficulty) }
            )

        }
    }

}


@Composable
fun ExercisePlan(image: Int, planName: String, duration: Int, exercisesCount: Int) {
    Box(
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Card(
                modifier = Modifier
                    .width(320.dp)
                    .height(200.dp),
                shape = RoundedCornerShape(16.dp),
                elevation = CardDefaults.cardElevation(2.dp)
            ) {
                Box(modifier = Modifier.fillMaxSize()) {
                    Image(
                        painter = painterResource(image),
                        contentDescription = "plan card description",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                    )

                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(
                                Brush.horizontalGradient(
                                    colors = listOf(
                                        Color.Black.copy(alpha = 0.7f),
                                        Color.Transparent
                                    ),
                                    startX = 0f,
                                    endX = 600f
                                )
                            )
                    ) {
                        Column(
                            modifier = Modifier
                                .align(Alignment.CenterStart)
                                .padding(20.dp),
                            verticalArrangement = Arrangement.spacedBy(12.dp)
                        ) {
                            Text(
                                planName,
                                color = Color.White,
                                fontSize = 22.sp,
                                fontWeight = FontWeight.Bold,
                                lineHeight = 28.sp
                            )
                            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                                InfoChip(
                                    icon = Icons.Outlined.SportsGymnastics,
                                    text = "$exercisesCount Exercises"
                                )
                            }
                            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                                InfoChip(
                                    icon = Icons.Outlined.Timer,
                                    text = "$duration Minutes"
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true, apiLevel = 34)
@Composable
fun CategoriesPreview() {
    SitzerTheme {
        Row {
            //ExercisePlan(R.drawable.cobraposeimg, "Lower Back", 25, 8)

        }
    }
}