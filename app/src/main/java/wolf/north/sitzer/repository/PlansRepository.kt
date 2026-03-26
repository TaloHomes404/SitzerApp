package wolf.north.sitzer.repository

import wolf.north.sitzer.R
import wolf.north.sitzer.enums.MuscleGroup
import wolf.north.sitzer.enums.PlanDifficulty
import wolf.north.sitzer.mvvm.model.Plan
import java.util.Calendar

object PlansRepository {

    //mock object for holding local plan list
    //TODO: room implement in future for statistics/analize

    val plansList = listOf(

        Plan(
            id = 1,
            name = "Core Crusher",
            description = "Intensive core workout hitting all abdominal angles. Build a rock-solid midsection with dynamic crunches, twists and holds.",
            category = MuscleGroup.CORE,
            imageRes = R.drawable.corecrusher_plan_imageres,
            exercises = listOf(
                ExerciseRepository.exerciseList[16],  // Crunches
                ExerciseRepository.exerciseList[0],   // Bicycle Crunch
                ExerciseRepository.exerciseList[7],   // Russian Twists
                ExerciseRepository.exerciseList[26],  // Reverse Crunches
                ExerciseRepository.exerciseList[5]    // Side Plank
            ),
            exerciseCount = 5,
            duration = 12,
            difficulty = PlanDifficulty.MEDIUM,
            isPremium = false
        ),

        Plan(
            id = 2,
            name = "Beginner Core Foundation",
            description = "Perfect starting point for abs training. Gentle movements that build fundamental strength without overwhelming beginners.",
            category = MuscleGroup.CORE,
            imageRes = R.drawable.beginner_core_foundation_imageres,
            exercises = listOf(
                ExerciseRepository.exerciseList[2],   // Dead Bug
                ExerciseRepository.exerciseList[16],  // Crunches
                ExerciseRepository.exerciseList[24],  // Knee-raises Crunch
                ExerciseRepository.exerciseList[10],  // Reverse Plank
                ExerciseRepository.exerciseList[26]   // Reverse Crunches
            ),
            exerciseCount = 5,
            duration = 10,
            difficulty = PlanDifficulty.BEGINNER,
            isPremium = false
        ),

        Plan(
            id = 3,
            name = "Lower Body Blaster",
            description = "Complete leg workout combining squats, lunges and calf work. Build powerful legs and improve stability from ground up.",
            category = MuscleGroup.LEGS,
            imageRes = R.drawable.lower_body_blaster_imageres,
            exercises = listOf(
                ExerciseRepository.exerciseList[4],   // Bodyweight Squats
                ExerciseRepository.exerciseList[22],  // Reverse Lunges
                ExerciseRepository.exerciseList[19],  // Sumo Squat
                ExerciseRepository.exerciseList[9],   // Wall Sit
                ExerciseRepository.exerciseList[1]    // Standing Calf Raises
            ),
            exerciseCount = 5,
            duration = 15,
            difficulty = PlanDifficulty.MEDIUM,
            isPremium = false
        ),

        Plan(
            id = 4,
            name = "Glutes Activation",
            description = "Focused glute workout that lifts, shapes and strengthens. Perfect for building posterior chain power and aesthetics.",
            category = MuscleGroup.GLUTES,
            imageRes = R.drawable.glutesactivation_imageres,
            exercises = listOf(
                ExerciseRepository.exerciseList[11],  // Donkey Kicks
                ExerciseRepository.exerciseList[12],  // Donkey Kicks Variation
                ExerciseRepository.exerciseList[3],   // Single Leg Glute March
                ExerciseRepository.exerciseList[19],  // Sumo Squat
                ExerciseRepository.exerciseList[14]   // Walking Lunges
            ),
            exerciseCount = 5,
            duration = 12,
            difficulty = PlanDifficulty.BEGINNER,
            isPremium = false
        ),

        Plan(
            id = 5,
            name = "Upper Body Push Power",
            description = "Chest, shoulders and triceps destroyer using push-up variations. Build impressive upper body strength with bodyweight only.",
            category = MuscleGroup.CHEST,
            imageRes = R.drawable.upper_body_push_imageres,
            exercises = listOf(
                ExerciseRepository.exerciseList[17],  // Kneeling Push-ups
                ExerciseRepository.exerciseList[6],   // Push-ups
                ExerciseRepository.exerciseList[15],  // Close-Grip Push-ups
                ExerciseRepository.exerciseList[10],  // Reverse Plank
                ExerciseRepository.exerciseList[8]    // Wall Angels
            ),
            exerciseCount = 5,
            duration = 10,
            difficulty = PlanDifficulty.MEDIUM,
            isPremium = false
        ),

        Plan(
            id = 6,
            name = "Mobility & Stretch Flow",
            description = "Gentle full-body stretching routine to release tension and improve flexibility. Perfect post-workout or morning routine.",
            category = MuscleGroup.BACK,
            imageRes = R.drawable.mobility_stretch_pose_imageres,
            exercises = listOf(
                ExerciseRepository.exerciseList[25],  // Cat-Cow Pose
                ExerciseRepository.exerciseList[13],  // Cobra Pose
                ExerciseRepository.exerciseList[23],  // Lying Hamstrings Stretch
                ExerciseRepository.exerciseList[20],  // Single Leg Quad Stretch
                ExerciseRepository.exerciseList[8]    // Wall Angels
            ),
            exerciseCount = 5,
            duration = 8,
            difficulty = PlanDifficulty.BEGINNER,
            isPremium = false
        ),

        Plan(
            id = 7,
            name = "Full Body Express",
            description = "Time-efficient total body workout hitting all major muscle groups. Maximum results in minimum time.",
            category = MuscleGroup.CORE,
            imageRes = R.drawable.fullbody_express_imageres,
            exercises = listOf(
                ExerciseRepository.exerciseList[4],   // Bodyweight Squats
                ExerciseRepository.exerciseList[6],   // Push-ups
                ExerciseRepository.exerciseList[2],   // Dead Bug
                ExerciseRepository.exerciseList[14],  // Walking Lunges
                ExerciseRepository.exerciseList[18]   // Superman Hold
            ),
            exerciseCount = 5,
            duration = 12,
            difficulty = PlanDifficulty.MEDIUM,
            isPremium = false
        ),

        Plan(
            id = 8,
            name = "Back Health & Posture",
            description = "Strengthen and stretch back muscles to prevent pain and correct posture. Essential for desk workers and athletes alike.",
            category = MuscleGroup.BACK,
            imageRes = R.drawable.backworkout_imageres,
            exercises = listOf(
                ExerciseRepository.exerciseList[18],  // Superman Hold
                ExerciseRepository.exerciseList[13],  // Cobra Pose
                ExerciseRepository.exerciseList[25],  // Cat-Cow Pose
                ExerciseRepository.exerciseList[10],  // Reverse Plank
                ExerciseRepository.exerciseList[8]    // Wall Angels
            ),
            exerciseCount = 5,
            duration = 10,
            difficulty = PlanDifficulty.BEGINNER,
            isPremium = false
        ),

        Plan(
            id = 9,
            name = "Leg Day Inferno",
            description = "Advanced lower body assault with dynamic movements and brutal holds. Build serious leg strength and mental fortitude.",
            category = MuscleGroup.LEGS,
            imageRes = R.drawable.legday_inferno_imageres,
            exercises = listOf(
                ExerciseRepository.exerciseList[14],  // Walking Lunges
                ExerciseRepository.exerciseList[19],  // Sumo Squat
                ExerciseRepository.exerciseList[9],   // Wall Sit
                ExerciseRepository.exerciseList[22],  // Reverse Lunges
                ExerciseRepository.exerciseList[1]    // Standing Calf Raises
            ),
            exerciseCount = 5,
            duration = 18,
            difficulty = PlanDifficulty.ADVANCED,
            isPremium = false
        ),

        Plan(
            id = 10,
            name = "Morning Wake-Up",
            description = "Energizing morning routine combining mobility and light activation. Start your day feeling loose, strong and ready.",
            category = MuscleGroup.CORE,
            imageRes = R.drawable.mobility_stretch_pose_imageres,
            exercises = listOf(
                ExerciseRepository.exerciseList[25],  // Cat-Cow Pose
                ExerciseRepository.exerciseList[13],  // Cobra Pose
                ExerciseRepository.exerciseList[21],  // Hamstrings Stretch Walk
                ExerciseRepository.exerciseList[2],   // Dead Bug
                ExerciseRepository.exerciseList[4]    // Bodyweight Squats
            ),
            exerciseCount = 5,
            duration = 8,
            difficulty = PlanDifficulty.BEGINNER,
            isPremium = false
        ),

        Plan(
            id = 11,
            name = "Abs Definition Circuit",
            description = "High-intensity core circuit designed to carve out visible abs. Combines crunch variations with anti-rotation work.",
            category = MuscleGroup.CORE,
            imageRes = R.drawable.abs_definition_circuit_imageres,
            exercises = listOf(
                ExerciseRepository.exerciseList[0],   // Bicycle Crunch
                ExerciseRepository.exerciseList[7],   // Russian Twists
                ExerciseRepository.exerciseList[24],  // Knee-raises Crunch
                ExerciseRepository.exerciseList[5],   // Side Plank
                ExerciseRepository.exerciseList[2]    // Dead Bug
            ),
            exerciseCount = 5,
            duration = 14,
            difficulty = PlanDifficulty.ADVANCED,
            isPremium = false
        ),

        Plan(
            id = 12,
            name = "Desk Worker Rescue",
            description = "Combat sitting all day with this targeted mobility routine. Opens hips, releases shoulders and strengthens posture muscles.",
            category = MuscleGroup.BACK,
            imageRes = R.drawable.officeworker_imageres,
            exercises = listOf(
                ExerciseRepository.exerciseList[8],   // Wall Angels
                ExerciseRepository.exerciseList[25],  // Cat-Cow Pose
                ExerciseRepository.exerciseList[20],  // Single Leg Quad Stretch
                ExerciseRepository.exerciseList[27],  // Wall Flexors Stretch
                ExerciseRepository.exerciseList[13]   // Cobra Pose
            ),
            exerciseCount = 5,
            duration = 10,
            difficulty = PlanDifficulty.BEGINNER,
            isPremium = false
        )
    )

    // Daily plans - jeden na każdy dzień tygodnia
    val dailyPlansList = listOf(
        // MONDAY
        Plan(
            id = 101,
            name = "Monday Momentum",
            description = "Kickstart your week with this energizing mobility and strength combo. Set the tone for a productive week ahead.",
            category = MuscleGroup.CORE,
            imageRes = R.drawable.monday_daily_plan_resphoto,
            exercises = listOf(
                ExerciseRepository.exerciseList[25],  // Cat-Cow Pose
                ExerciseRepository.exerciseList[8],   // Wall Angels
                ExerciseRepository.exerciseList[4],   // Bodyweight Squats
                ExerciseRepository.exerciseList[2],   // Dead Bug
                ExerciseRepository.exerciseList[13]   // Cobra Pose
            ),
            exerciseCount = 5,
            duration = 10,
            difficulty = PlanDifficulty.BEGINNER,
            isPremium = false
        ),
        // TUESDAY
        Plan(
            id = 102,
            name = "Tuesday Power",
            description = "Build strength and endurance with this balanced full-body routine focused on core and upper body.",
            category = MuscleGroup.CHEST,
            imageRes = R.drawable.tuesday_daily_plan_resphoto,
            exercises = listOf(
                ExerciseRepository.exerciseList[6],   // Push-ups
                ExerciseRepository.exerciseList[5],   // Side Plank
                ExerciseRepository.exerciseList[16],  // Crunches
                ExerciseRepository.exerciseList[7],   // Russian Twists
                ExerciseRepository.exerciseList[10]   // Reverse Plank
            ),
            exerciseCount = 5,
            duration = 12,
            difficulty = PlanDifficulty.MEDIUM,
            isPremium = false
        ),
        // WEDNESDAY
        Plan(
            id = 103,
            name = "Midweek Mobility",
            description = "Restore flexibility and recover with gentle stretches and mobility work. Perfect for midweek recovery.",
            category = MuscleGroup.LEGS,
            imageRes = R.drawable.wednesday_daily_plan_resphoto,
            exercises = listOf(
                ExerciseRepository.exerciseList[21],  // Hamstring Stretch Walk
                ExerciseRepository.exerciseList[23],  // Lying Hamstring Stretch
                ExerciseRepository.exerciseList[20],  // Single Leg Quad Stretch
                ExerciseRepository.exerciseList[25],  // Cat-Cow Pose
                ExerciseRepository.exerciseList[13]   // Cobra Pose
            ),
            exerciseCount = 5,
            duration = 8,
            difficulty = PlanDifficulty.BEGINNER,
            isPremium = false
        ),
        // THURSDAY
        Plan(
            id = 104,
            name = "Thursday Thrive",
            description = "High-intensity leg and glute workout to boost your metabolism and build lower body strength.",
            category = MuscleGroup.LEGS,
            imageRes = R.drawable.thursday_daily_plan_resphoto,
            exercises = listOf(
                ExerciseRepository.exerciseList[4],   // Bodyweight Squats
                ExerciseRepository.exerciseList[14],  // Walking Lunges
                ExerciseRepository.exerciseList[22],  // Reverse Lunges
                ExerciseRepository.exerciseList[11],  // Donkey Kicks
                ExerciseRepository.exerciseList[9]    // Wall Sit
            ),
            exerciseCount = 5,
            duration = 15,
            difficulty = PlanDifficulty.MEDIUM,
            isPremium = false
        ),
        // FRIDAY
        Plan(
            id = 105,
            name = "Feel-Good Friday",
            description = "End your week strong with a balanced routine combining strength, core work, and feel-good movement.",
            category = MuscleGroup.CORE,
            imageRes = R.drawable.friday_daily_plan_resphoto,
            exercises = listOf(
                ExerciseRepository.exerciseList[0],   // Bicycle Crunch
                ExerciseRepository.exerciseList[6],   // Push-ups
                ExerciseRepository.exerciseList[5],   // Side Plank
                ExerciseRepository.exerciseList[18],  // Superman Hold
                ExerciseRepository.exerciseList[26]   // Reverse Crunches
            ),
            exerciseCount = 5,
            duration = 12,
            difficulty = PlanDifficulty.MEDIUM,
            isPremium = false
        ),
        // SATURDAY
        Plan(
            id = 106,
            name = "Weekend Warrior",
            description = "Challenge yourself with this advanced full-body workout. Perfect for weekend training sessions.",
            category = MuscleGroup.CHEST,
            imageRes = R.drawable.saturday_daily_plan_resphoto,
            exercises = listOf(
                ExerciseRepository.exerciseList[6],   // Push-ups
                ExerciseRepository.exerciseList[15],  // Close-Grip Push-ups
                ExerciseRepository.exerciseList[4],   // Bodyweight Squats
                ExerciseRepository.exerciseList[19],  // Sumo Squat
                ExerciseRepository.exerciseList[0]    // Bicycle Crunch
            ),
            exerciseCount = 5,
            duration = 18,
            difficulty = PlanDifficulty.ADVANCED,
            isPremium = false
        ),
        // SUNDAY
        Plan(
            id = 107,
            name = "Sunday Reset",
            description = "Gentle recovery session with stretching and mobility to prepare your body for the week ahead.",
            category = MuscleGroup.BACK,
            imageRes = R.drawable.sunday_daily_plan_resphoto,
            exercises = listOf(
                ExerciseRepository.exerciseList[25],  // Cat-Cow Pose
                ExerciseRepository.exerciseList[13],  // Cobra Pose
                ExerciseRepository.exerciseList[8],   // Wall Angels
                ExerciseRepository.exerciseList[23],  // Lying Hamstring Stretch
                ExerciseRepository.exerciseList[27]   // Wall Flexor Stretch
            ),
            exerciseCount = 5,
            duration = 10,
            difficulty = PlanDifficulty.BEGINNER,
            isPremium = false
        )
    )


    //Method to filter plans later in program
    //example: click category/difficulty (or both) on carousel
    //load plans sorted by one/both/none filter
    fun getPlansFiltered(
        category: MuscleGroup? = null,
        difficulty: PlanDifficulty? = null
    ): List<Plan> {
        return plansList.filter { plan ->
            (category == null || plan.category == category) &&
                    (difficulty == null || plan.difficulty == difficulty)
        }
    }

    // Helper function - get daily plan based on day of week
    fun getDailyPlan(): Plan {
        val calendar = Calendar.getInstance()
        val dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK)
        // Calendar.DAY_OF_WEEK: Sunday=1, Monday=2, ..., Saturday=7
        // Our list: Monday=0, Tuesday=1, ..., Sunday=6
        val index = when (dayOfWeek) {
            Calendar.MONDAY -> 0
            Calendar.TUESDAY -> 1
            Calendar.WEDNESDAY -> 2
            Calendar.THURSDAY -> 3
            Calendar.FRIDAY -> 4
            Calendar.SATURDAY -> 5
            Calendar.SUNDAY -> 6
            else -> 0
        }
        return dailyPlansList[index]
    }
}

