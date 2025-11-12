package wolf.north.sitzer.repository

import wolf.north.sitzer.enums.MuscleGroup
import wolf.north.sitzer.enums.PlanDifficulty
import wolf.north.sitzer.mvvm.model.Plan

object PlansRepository {

    //mock object for holding local plan list
    //TODO: room implement in future for statistics/analize

    val plansList = listOf(

        Plan(
            id = 1,
            name = "Posture Reset",
            description = "Full-body session to release tension and activate postural muscles. Perfect after long hours at a desk.",
            category = MuscleGroup.CORE,
            imageRes = 1,
            exercises = listOf(
                ExerciseRepository.exerciseList[6],  // Chin Tucks
                ExerciseRepository.exerciseList[9],  // Wall Angels
                ExerciseRepository.exerciseList[19], // Superman Hold
                ExerciseRepository.exerciseList[14], // Cobra Pose
                ExerciseRepository.exerciseList[3]   // Dead Bug
            ),
            exerciseCount = 5,
            duration = 10,
            difficulty = PlanDifficulty.BEGINNER,
            isPremium = false
        ),

        Plan(
            id = 4,
            name = "Upper Mobility Flow",
            description = "A gentle sequence that opens the chest, improves shoulder mobility and relieves neck tension.",
            category = MuscleGroup.CORE,
            imageRes = 1,
            exercises = listOf(
                ExerciseRepository.exerciseList[22], // Doorway Stretch
                ExerciseRepository.exerciseList[9],  // Wall Angels
                ExerciseRepository.exerciseList[16], // Band Pull-Aparts
                ExerciseRepository.exerciseList[19], // Superman Hold
                ExerciseRepository.exerciseList[7]   // Neck Curls
            ),
            exerciseCount = 5,
            duration = 10,
            difficulty = PlanDifficulty.BEGINNER,
            isPremium = false
        ),

        Plan(
            id = 3,
            name = "Lower Body Balance",
            description = "Improve hip and leg stability through bodyweight movements that build functional strength and posture.",
            category = MuscleGroup.LEGS,
            imageRes = 1,
            exercises = listOf(
                ExerciseRepository.exerciseList[4],  // Bodyweight Squats
                ExerciseRepository.exerciseList[13], // Single Leg Glutes Bridge
                ExerciseRepository.exerciseList[23], // Wall Sits
                ExerciseRepository.exerciseList[15], // Bodyweight Lunges
                ExerciseRepository.exerciseList[18]  // Standing Calf Raises
            ),
            exerciseCount = 5,
            duration = 15,
            difficulty = PlanDifficulty.BEGINNER,
            isPremium = false
        ),
        Plan(
            id = 2,
            name = "Core Stabilization",
            description = "Strengthen deep core muscles and improve spinal stability for better posture and movement control.",
            category = MuscleGroup.CORE,
            imageRes = 1,
            exercises = listOf(
                ExerciseRepository.exerciseList[0], // Plank
                ExerciseRepository.exerciseList[1], // Bird Dog
                ExerciseRepository.exerciseList[2], // Dead Bug
                ExerciseRepository.exerciseList[5], // Side Plank
                ExerciseRepository.exerciseList[11] // Reverse Plank
            ),
            exerciseCount = 5,
            duration = 12,
            difficulty = PlanDifficulty.BEGINNER,
            isPremium = false
        )
    )


    //daily plans in rotation
    val dailyPlansList = listOf(
        Plan(
            id = 1,
            name = "Monday Stretching",
            description = "No better start of the week than stretching whole body making it ready for week",
            category = MuscleGroup.CORE,
            imageRes = 1,
            exercises = listOf(
                ExerciseRepository.exerciseList[6],  // Chin Tucks
                ExerciseRepository.exerciseList[9],  // Wall Angels
                ExerciseRepository.exerciseList[19], // Superman Hold
                ExerciseRepository.exerciseList[14], // Cobra Pose
                ExerciseRepository.exerciseList[3]   // Dead Bug
            ),
            exerciseCount = 5,
            duration = 10,
            difficulty = PlanDifficulty.BEGINNER,
            isPremium = false
        ),
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


}