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
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.pluralStringResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import wolf.north.sitzer.R
import wolf.north.sitzer.enums.MuscleGroup
import wolf.north.sitzer.ui.theme.SitzerTheme

@Composable
fun CategoriesCarousel(
    selectedCategory: MuscleGroup?,
    onCategorySelected: (MuscleGroup) -> Unit
) {
    val categories = MuscleGroup.entries.toTypedArray()

    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) {
        items(categories) { category ->
            FilterChip(
                selected = (selectedCategory == category),
                onClick = { onCategorySelected(category) },
                label = {
                    Text(
                        category.name.lowercase().replaceFirstChar { it.uppercase() }
                    )
                },
                colors = FilterChipDefaults.filterChipColors(
                    selectedContainerColor = MaterialTheme.colorScheme.primary,
                    selectedLabelColor = MaterialTheme.colorScheme.onPrimary
                ),
                border = FilterChipDefaults.filterChipBorder(
                    borderColor = MaterialTheme.colorScheme.outline,
                    selectedBorderColor = MaterialTheme.colorScheme.primary,
                    enabled = true,
                    selected = selectedCategory == category
                )
            )
        }
    }
}

@Composable
fun DifficultyCarousel(selectedDifficulty: String, onDifficultySelected: (String) -> Unit) {

    //List of difficulties
    val difficulties = listOf(
        stringResource(R.string.difficulty_beginner),
        stringResource(R.string.difficulty_intermediate),
        stringResource(R.string.difficulty_advanced)
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
fun ExercisePlan(
    image: Int,
    planName: String,
    duration: Int,
    exercisesCount: Int
) {
    Card(
        modifier = Modifier
            .width(320.dp)
            .height(200.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        )
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            Image(
                painter = painterResource(image),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )

            // Orange-tinted gradient overlay
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.horizontalGradient(
                            colors = listOf(
                                MaterialTheme.colorScheme.primary.copy(alpha = 0.7f),  // Orange tint
                                Color.Transparent
                            ),
                            startX = 0f,
                            endX = 500f
                        )
                    )
            ) {
                Column(
                    modifier = Modifier
                        .align(Alignment.CenterStart)
                        .padding(20.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(
                        planName,
                        style = MaterialTheme.typography.headlineSmall,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )

                    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        InfoChip(
                            icon = Icons.Outlined.SportsGymnastics,
                            text = "$exercisesCount exercises"
                        )
                        InfoChip(
                            icon = Icons.Outlined.Timer,
                            text = "$duration min"
                        )
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