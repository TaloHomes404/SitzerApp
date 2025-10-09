package wolf.north.sitzer.mvvm.view

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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
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
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import wolf.north.sitzer.R
import wolf.north.sitzer.comps.CategoriesCarousel
import wolf.north.sitzer.comps.ExercisePlan
import wolf.north.sitzer.comps.ProgressCard
import wolf.north.sitzer.comps.ProgressCardNumberIndicator
import wolf.north.sitzer.comps.WorkoutCardButtoned
import wolf.north.sitzer.mvvm.viewmodel.PlansViewModel
import wolf.north.sitzer.navigation.Screens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavHostController = rememberNavController()) {

//    //State to remember selected category
//    var selectedCategory by remember { mutableStateOf("All") }
//
//
//    val allPlans = remember { PlansRepository.getAllPlans() }
//    val filteredPlans = remember(selectedCategory) {
//        PlansRepository.getPlansSortByCategory(selectedCategory)
//    }
    val viewModel: PlansViewModel = viewModel()
    val selectedCategory by viewModel.selectedCategory.collectAsState()
    val filteredPlans = viewModel.getPlansSortByCategory()





    Scaffold(
        containerColor = Color(0xFFF8F9FA),
        topBar = {
            TopAppBar(
                title = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = "Select your workout",
                            color = Color.White,
                            textAlign = TextAlign.Center
                        )
                    }
                },
                actions = {
                    IconButton(onClick = { }) {
                        Icon(
                            Icons.Outlined.Notifications,
                            contentDescription = "notification icon",
                            tint = Color.White
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = colorResource(id = R.color.welcome_screen_bg) // Zmień na żądany kolor
                )
            )
        },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {

                SectionTitle(
                    "Challenge Yourself With Featured \nDaily Workout!",
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    WorkoutCardButtoned(
                        R.drawable.mobilityimgcard,
                        "Mobility Morning",
                        "Start Session"
                    )
                }


                // 2nd row
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    SectionTitle("Weekly Progress")
                    Text("See All", modifier = Modifier.padding(end = 8.dp))
                }


                Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
                    ProgressCard(0.33f, "1/3", "Workout Sessions", "This Week")
                    ProgressCardNumberIndicator(138, "Calories Burned", "This Week")
                }

                //3rd row
                Row(
                    modifier = Modifier
                        .fillMaxWidth().padding(top = 4.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    SectionTitle("Categories")
                    Text("See All", modifier = Modifier.padding(end = 8.dp))
                }

                CategoriesCarousel(
                    selectedCategory = selectedCategory,
                    onCategorySelected = { viewModel.selectedCategory(it) })

                Spacer(modifier = Modifier.height(8.dp))

                // LazyColumn z przefiltrowanymi planami
                LazyColumn (
                    Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    contentPadding = PaddingValues(horizontal = 16.dp)
                ) {
                    items(filteredPlans) { plan ->
                        ExercisePlan(plan.imageRes, plan.name, plan.duration, plan.exerciseCount)
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

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {

                        Icon(
                            imageVector = Icons.Outlined.Home,
                            contentDescription = "Menu",
                            tint = Color.White
                        )

                        Text("Home", color = Color.White)

                    }

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.SportsGymnastics,
                            contentDescription = "Workouts list bottom icon",
                            tint = Color.Gray,
                            modifier = Modifier.clickable { navController.navigate(Screens.Workout) }
                        )
                        Text("Workouts", color = Color.Gray)
                    }

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.Person,
                            contentDescription = "Profile",
                            tint = Color.Gray,
                            modifier = Modifier.clickable { navController.navigate(Screens.Profile) }
                        )
                        Text("Profile", color = Color.Gray)
                    }
                }
            }
        }
    )
}

@Composable
fun SectionTitle(title: String, modifier: Modifier = Modifier) {
    Text(
        text = title,
        fontSize = 22.sp,
        fontWeight = FontWeight.SemiBold,
        color = Color(0xFF1A1A1A),
        lineHeight = 28.sp,
        modifier = Modifier.padding(start = 8.dp, bottom = 2.dp)
    )
}


@Preview(showSystemUi = true)
@Composable
fun PreviewWorkoutSelectionScreen() {
    HomeScreen()
}