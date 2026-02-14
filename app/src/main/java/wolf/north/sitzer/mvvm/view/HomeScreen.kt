package wolf.north.sitzer.mvvm.view

import androidx.compose.foundation.Image
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
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.SportsGymnastics
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.delay
import wolf.north.sitzer.R
import wolf.north.sitzer.comps.CategoriesCarousel
import wolf.north.sitzer.comps.ExercisePlan
import wolf.north.sitzer.comps.ProgressCard
import wolf.north.sitzer.comps.ProgressCardNumberIndicator
import wolf.north.sitzer.comps.WorkoutCardButtoned
import wolf.north.sitzer.comps.onboarding.OnboardingManager
import wolf.north.sitzer.mvvm.viewmodel.HomeScreenViewModel
import wolf.north.sitzer.navigation.Screens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavHostController = rememberNavController()) {
    val viewModel: HomeScreenViewModel = hiltViewModel()
    val plans by viewModel.plans.collectAsState()
    val selectedCategory by viewModel.selectedCategory.collectAsState()
    val filteredPlans = if (selectedCategory != null) {
        viewModel.getPlansForCategory(selectedCategory).take(2)
    } else {
        plans
    }.take(2)

    val hasSeenOnboarding by viewModel.hasSeenOverboarding.collectAsState()
    val onboardingStep by viewModel.currentOnboardingStep.collectAsState()
    var showOnboarding by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        if (!hasSeenOnboarding) {
            delay(1000)
            showOnboarding = true
        }
    }

    Scaffold(
        containerColor = MaterialTheme.colorScheme.background,
        topBar = {
            TopAppBar(
                title = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceAround,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Image(
                            painter = painterResource(R.drawable.sitzer_logo_nobg),
                            contentDescription = "login site Sitzer logo ",
                            contentScale = ContentScale.Crop,
                            alignment = Alignment.Center
                        )
                    }
                },
                actions = {
                    IconButton(onClick = { }) {
                        Icon(
                            Icons.Outlined.Notifications,
                            contentDescription = "notification icon ",
                            tint = Color.White
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary
                )
            )
        },
        content = { paddingValues ->
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                contentPadding = PaddingValues(bottom = 80.dp)
            ) {
                item {
                    Spacer(Modifier.height(6.dp))
                    SectionTitle(stringResource(R.string.home_featured_workout_title))
                }

                item {
                    WorkoutCardButtoned(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 12.dp, vertical = 2.dp),
                        image = R.drawable.mobilityimgcard,
                        workoutName = "Mobility Morning ",
                        buttonText = "Start Session "
                    )
                }

                item {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        SectionTitle(stringResource(R.string.home_weekly_progress))
                        Text(
                            stringResource(R.string.home_see_all),
                            modifier = Modifier
                                .padding(end = 16.dp)
                                .clickable { },
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Medium,
                            color = MaterialTheme.colorScheme.primary
                        )
                    }
                }

                item {
                    Row(
                        Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 8.dp, vertical = 4.dp),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        ProgressCard(0.00f, "0/3 ", stringResource(R.string.home_workout_sessions), "This Week ")
                        ProgressCardNumberIndicator(0, stringResource(R.string.home_calories_burned), "This Week ")
                    }
                }

                item {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 8.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        SectionTitle("Categories ")
                        Text(
                            stringResource(R.string.home_see_all),
                            modifier = Modifier
                                .padding(end = 16.dp)
                                .clickable { },
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Medium,
                            color = MaterialTheme.colorScheme.primary
                        )
                    }
                }

                item {
                    CategoriesCarousel(
                        selectedCategory = selectedCategory,
                        onCategorySelected = { viewModel.onCategorySelected(it) }
                    )
                }

                items(filteredPlans) { plan ->
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        ExercisePlan(
                            plan.imageRes,
                            plan.name,
                            plan.duration,
                            plan.exerciseCount
                        )
                    }
                }

                item {
                    if (showOnboarding && !hasSeenOnboarding) {
                        OnboardingManager(
                            viewModel = viewModel,
                            currentStep = onboardingStep
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
                        verticalArrangement = Arrangement.Center
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.Home,
                            contentDescription = "Menu ",
                            tint = Color.White
                        )
                        Text(stringResource(R.string.nav_home), color = Color.White)
                    }

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier.clickable { navController.navigate(Screens.Plans) }
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.SportsGymnastics,
                            contentDescription = "Workouts list bottom icon ",
                            tint = Color.Gray,
                        )
                        Text(stringResource(R.string.nav_workouts), color = Color.Gray)
                    }

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier.clickable { navController.navigate(Screens.Profile) }
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.Person,
                            contentDescription = "Profile ",
                            tint = Color.Gray,
                        )
                        Text(stringResource(R.string.nav_profile), color = Color.Gray)
                    }
                }
            }
        }
    )
}

@Composable
fun SectionTitle(title: String) {
    Text(
        text = title,
        fontSize = 22.sp,
        fontWeight = FontWeight.SemiBold,
        color = MaterialTheme.colorScheme.onBackground,
        lineHeight = 28.sp,
        letterSpacing = 0.25.sp,
        modifier = Modifier.padding(start = 16.dp, bottom = 2.dp, top = 2.dp)
    )
}

@Preview(showSystemUi = true)
@Composable
fun PreviewWorkoutSelectionScreen() {
    HomeScreen()
}