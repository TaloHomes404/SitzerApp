package wolf.north.sitzer.mvvm.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.SportsGymnastics
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import wolf.north.sitzer.R
import wolf.north.sitzer.comps.CategoriesCarousel
import wolf.north.sitzer.comps.DifficultyCarousel
import wolf.north.sitzer.comps.MoreFiltersDialog
import wolf.north.sitzer.comps.SelectedPlanBottomSheet
import wolf.north.sitzer.comps.WorkoutCard
import wolf.north.sitzer.enums.PlanDifficulty
import wolf.north.sitzer.mvvm.model.Plan
import wolf.north.sitzer.mvvm.viewmodel.PlanSelectScreenViewModel
import wolf.north.sitzer.navigation.Screens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlanSelectScreen(navController: NavHostController = rememberNavController()) {
    val viewModel: PlanSelectScreenViewModel = hiltViewModel()
    val selectedCategory by viewModel.selectedCategory.collectAsState()
    val selectedDifficulty by viewModel.selectedDifficulty.collectAsState()
    val filteredPlans by viewModel.plans.collectAsState()

    val avatarUri by viewModel.avatarUri.collectAsState()

    // bottom sheet control vals
    var showBottomSheet by remember { mutableStateOf(false) }
    var selectedPlan by remember { mutableStateOf<Plan?>(null) }
    // more filters dialogbox
    var showMoreFiltersDialog by remember { mutableStateOf(false) }
    // more filters sorting options show vals
    var showDifficultyCarousel by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(end = 8.dp)
                    ) {
                        Column {
                            Text(
                                text = stringResource(R.string.topbar_plan_select),
                                style = MaterialTheme.typography.titleLarge,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.onPrimary
                            )
                            Text(
                                text = stringResource(R.string.topbar_plan_description),
                                style = MaterialTheme.typography.bodyMedium,
                                color = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.75f)
                            )
                        }

                        val avatarPainter = avatarUri?.let { rememberAsyncImagePainter(it) }
                            ?: painterResource(R.drawable.pfpp)

                        Image(
                            painter = avatarPainter,
                            contentDescription = "Avatar",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .size(40.dp)
                                .clip(CircleShape)
                                .background(MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.15f))
                                .clickable { navController.navigate(Screens.Profile) }
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary
                )
            )
        },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Categories",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                    Text(
                        text = "More Filters",
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.Medium,
                        color = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.clickable { showMoreFiltersDialog = true }
                    )
                }

                CategoriesCarousel(
                    selectedCategory = selectedCategory,
                    onCategorySelected = { viewModel.selectedCategory(it) }
                )

                if (showDifficultyCarousel) {
                    DifficultyCarousel(
                        selectedDifficulty = selectedDifficulty?.name ?: "",
                        onDifficultySelected = { difficultyName ->
                            viewModel.selectedDifficulty(
                                PlanDifficulty.valueOf(difficultyName)
                            )
                        }
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    contentPadding = PaddingValues(horizontal = 16.dp)
                ) {
                    items(filteredPlans) { plan ->
                        WorkoutCard(
                            image = plan.imageRes,
                            workoutName = plan.name,
                            description = plan.description,
                            difficulty = plan.difficulty.name,
                            exerciseCount = plan.exerciseCount,
                            duration = plan.duration,
                            onClick = {
                                selectedPlan = plan
                                showBottomSheet = true
                            }
                        )
                    }
                }

                if (showMoreFiltersDialog) {
                    MoreFiltersDialog(
                        onDismiss = { showMoreFiltersDialog = false },
                        onClear = { showMoreFiltersDialog = false },
                        onDone = { showMoreFiltersDialog = false }
                    )
                }
            }
        },
        bottomBar = {
            BottomAppBar(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)),
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = Color.Gray,
                tonalElevation = 5.dp,
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 20.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .weight(1f)
                            .clickable { navController.navigate(Screens.Home) }
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.Home,
                            contentDescription = "Menu",
                            tint = Color.Gray
                        )
                        Text(stringResource(R.string.nav_home), color = Color.Gray)
                    }

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .weight(1f)
                            .clickable { navController.navigate(Screens.Plans) }
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.SportsGymnastics,
                            contentDescription = "Workouts",
                            tint = MaterialTheme.colorScheme.onPrimary
                        )
                        Text(stringResource(R.string.nav_workouts), color = Color.Gray)
                    }

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .weight(1f)
                            .clickable { navController.navigate(Screens.Profile) }
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.Person,
                            contentDescription = "Profile",
                            tint = Color.Gray
                        )
                        Text(stringResource(R.string.nav_profile), color = Color.Gray)
                    }
                }
            }
        }
    )

    // Bottom sheet
    if (showBottomSheet && selectedPlan != null) {
        SelectedPlanBottomSheet(
            plan = selectedPlan!!,
            onDismiss = { showBottomSheet = false },
            onStartWorkout = {
                showBottomSheet = false
                navController.navigate(Screens.createWorkoutHubRoute(selectedPlan!!.id))
            },
            exercises = selectedPlan!!.exercises
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun CustomSelectionScreenPreview() {
    PlanSelectScreen()
}