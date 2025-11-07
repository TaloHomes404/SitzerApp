package wolf.north.sitzer.repository

import wolf.north.sitzer.enums.MuscleGroup
import wolf.north.sitzer.mvvm.model.Exercise

object ExerciseRepository {

    //Simple implement
    //TODO: zaimplementować dobrą liste ćwiczeń i odpowiednie metody


    val exerciseList = listOf(

        Exercise(
            id = 1,
            name = "Plank",
            description = "Builds core stability, supports proper posture",
            muscleGroup = MuscleGroup.CORE,
            videoUrl = "placeholder"
        ),
        Exercise(
            id = 2,
            name = "Bird Dog",
            description = "Improves core coordination and balance",
            muscleGroup = MuscleGroup.CORE,
            videoUrl = "placeholder"
        ),
        Exercise(
            id = 3,
            name = "Dead Bug",
            description = "Trains core stability while moving limbs",
            muscleGroup = MuscleGroup.CORE,
            videoUrl = "placeholder"
        ),
        Exercise(
            id = 4,
            name = "Hip Bridge",
            description = "Activates glutes and improves hip extension",
            muscleGroup = MuscleGroup.HIPS,
            videoUrl = "placeholder"
        ),
        Exercise(
            id = 5,
            name = "Bodyweight Squats",
            description = "Strengthens legs and improves knee stability",
            muscleGroup = MuscleGroup.HIPS,
            videoUrl = "placeholder"
        ),
        Exercise(
            id = 6,
            name = "Side Plank",
            description = "Strengthens oblique muscles for better core support",
            muscleGroup = MuscleGroup.CORE,
            videoUrl = "placeholder"
        ),
        Exercise(
            id = 7,
            name = "Chin Tucks",
            description = "desc",
            muscleGroup = MuscleGroup.NECK,
            videoUrl = "placeholder"
        ),
        Exercise(
            id = 8,
            name = "Neck Curls",
            description = "desc",
            muscleGroup = MuscleGroup.NECK,
            videoUrl = "placeholder"
        ),
        Exercise(
            id = 9,
            name = "Wall Angels",
            description = "Corrects forward shoulder posture, opens chest",
            muscleGroup = MuscleGroup.SHOULDERS,
            videoUrl = "placeholder"
        ),
        Exercise(
            id = 10,
            name = "Y Raises",
            description = "Corrects forward shoulder posture",
            muscleGroup = MuscleGroup.SHOULDERS,
            videoUrl = "placeholder"
        ),
        Exercise(
            id = 11,
            name = "Reverse Plank",
            description = "Builds core stability, supports proper posture",
            muscleGroup = MuscleGroup.CORE,
            videoUrl = "placeholder"
        ),
        Exercise(
            id = 12,
            name = "Glutes Bridge",
            description = "Activates glutes and improves hip extension",
            muscleGroup = MuscleGroup.GLUTES,
            videoUrl = "placeholder"
        ),
        Exercise(
            id = 13,
            name = "Single Leg Glutes Bridge",
            description = "Activates glutes and improves hip extension",
            muscleGroup = MuscleGroup.GLUTES,
            videoUrl = "placeholder"
        ),
        Exercise(
            id = 14,
            name = "Cobra Pose",
            description = "lowerback-glute etc",
            muscleGroup = MuscleGroup.BACK,
            videoUrl = "placeholder"
        ),
        Exercise(
            id = 15,
            name = "Bodyweight Lunges",
            description = "legs quads core",
            muscleGroup = MuscleGroup.LEGS,
            videoUrl = "placeholder"
        ),
        Exercise(
            id = 16,
            name = "Standing Band Pull-Aparts",
            description = "Strengthens rear delts and upper back",
            muscleGroup = MuscleGroup.SHOULDERS,
            videoUrl = "placeholder"
        ),
        Exercise(
            id = 17,
            name = "Child’s Pose",
            description = "Relaxes spine and gently stretches the lower back",
            muscleGroup = MuscleGroup.BACK,
            videoUrl = "placeholder"
        ),
        Exercise(
            id = 18,
            name = "Standing Calf Raises",
            description = "Improves lower leg strength and posture support",
            muscleGroup = MuscleGroup.LEGS,
            videoUrl = "placeholder"
        ),
        Exercise(
            id = 19,
            name = "Superman Hold",
            description = "Strengthens lower back and promotes spinal alignment",
            muscleGroup = MuscleGroup.BACK,
            videoUrl = "placeholder"
        ),
        Exercise(
            id = 20,
            name = "Wrist Flexor Stretch",
            description = "bla bla bla strech",
            muscleGroup = MuscleGroup.WRISTS,
            videoUrl = "placeholder"
        ),
        Exercise(
            id = 21,
            name = "Wrist Extensor Stretch",
            description = "bla bla bla strech",
            muscleGroup = MuscleGroup.WRISTS,
            videoUrl = "placeholder"
        ),
        Exercise(
            id = 22,
            name = "Doorway Stretch",
            description = "bla bla bla strech",
            muscleGroup = MuscleGroup.SHOULDERS,
            videoUrl = "placeholder"
        ),
        Exercise(
            id = 23,
            name = "Wall Sits",
            description = "bla bla bla wall sit",
            muscleGroup = MuscleGroup.LEGS,
            videoUrl = "placeholder"
        ),
        Exercise(
            id = 24,
            name = "Scapular Push-ups",
            description = "bla bla bla wall sit",
            muscleGroup = MuscleGroup.SHOULDERS,
            videoUrl = "placeholder"
        )
    )


    //methods for exercise list


}