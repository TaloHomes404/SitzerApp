package wolf.north.sitzer.mvvm.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import wolf.north.sitzer.R
import wolf.north.sitzer.comps.CategoriesCarousel
import wolf.north.sitzer.comps.DifficultyCarousel
import wolf.north.sitzer.comps.ExercisePlan
import wolf.north.sitzer.comps.MoreFiltersDialog
import wolf.north.sitzer.comps.SelectedPlanBottomSheet
import wolf.north.sitzer.enums.PlanDifficulty
import wolf.north.sitzer.mvvm.model.Plan
import wolf.north.sitzer.mvvm.viewmodel.PlanSelectScreenViewModel
import wolf.north.sitzer.navigation.Screens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlanSelectScreen(navController: NavHostController = rememberNavController()) {
    val viewModel: PlanSelectScreenViewModel = viewModel()
    val selectedCategory by viewModel.selectedCategory.collectAsState()
    val selectedDifficulty by viewModel.selectedDifficulty.collectAsState()
    val filteredPlans by viewModel.plans.collectAsState()

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
                        modifier = Modifier.padding(8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            "Select Plan",
                            color = MaterialTheme.colorScheme.onPrimary
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary
                ),
                actions = {
                    Text(
                        "More Filters",
                        modifier = Modifier.clickable { showMoreFiltersDialog = true },
                        color = MaterialTheme.colorScheme.primary,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium
                    )
                }
            )
        },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {
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
                        Box(
                            modifier = Modifier.clickable {
                                selectedPlan = plan
                                showBottomSheet = true
                            }
                        ) {
                            ExercisePlan(
                                plan.imageRes,
                                plan.name,
                                plan.duration,
                                plan.exerciseCount
                            )
                        }
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
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier.clickable { navController.navigate(Screens.Home) }
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.Home,
                            contentDescription = "Menu",
                            tint = Color.Gray
                        )
                        Text("Home", color = Color.Gray)
                    }

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier.clickable { navController.navigate(Screens.Plans) }
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.SportsGymnastics,
                            contentDescription = "Workouts",
                            tint = MaterialTheme.colorScheme.onPrimary
                        )
                        Text("Workouts", color = Color.Gray)
                    }

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier.clickable { navController.navigate(Screens.Profile) }
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.Person,
                            contentDescription = "Profile",
                            tint = Color.Gray
                        )
                        Text("Profile", color = Color.Gray)
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