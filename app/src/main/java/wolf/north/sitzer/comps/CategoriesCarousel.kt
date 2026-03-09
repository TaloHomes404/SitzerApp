package wolf.north.sitzer.comps

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import wolf.north.sitzer.R
import wolf.north.sitzer.enums.MuscleGroup
import wolf.north.sitzer.enums.getIconRes
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
                shape = RoundedCornerShape(50),
                selected = (selectedCategory == category),
                onClick = { onCategorySelected(category) },

                leadingIcon = {
                    Icon(
                        painter = painterResource(category.getIconRes()),
                        contentDescription = category.name,
                        tint = Color.Unspecified,
                        modifier = Modifier.size(26.dp)
                    )
                },
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


@Preview(showBackground = true, showSystemUi = true, apiLevel = 34)
@Composable
fun CategoriesPreview() {
    SitzerTheme {
        Row {
            //ExercisePlan(R.drawable.cobraposeimg, "Lower Back", 25, 8)
        }
    }
}