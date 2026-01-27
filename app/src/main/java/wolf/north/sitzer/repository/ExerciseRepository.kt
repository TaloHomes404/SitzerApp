package wolf.north.sitzer.repository

import wolf.north.sitzer.R
import wolf.north.sitzer.enums.MuscleGroup
import wolf.north.sitzer.mvvm.model.Exercise

object ExerciseRepository {

    //Simple implement
    //TODO: zaimplementować dobrą liste ćwiczeń i odpowiednie metody


    val exerciseList = listOf(
        Exercise(
            id = 1,
            name = "Bicycle Crunch",
            description = "Targets obliques and builds rotational core strength with alternating knee-to-elbow movement",
            muscleGroup = MuscleGroup.CORE,
            videoUrl = R.raw.bicycle_crunch
        ),
        Exercise(
            id = 2,
            name = "Standing Calves Raises",
            description = "Strengthens calf muscles and improves ankle stability for better posture",
            muscleGroup = MuscleGroup.LEGS,
            videoUrl = R.raw.side_plank
        ),
        Exercise(
            id = 3,
            name = "Dead Bug",
            description = "Trains core stability while moving limbs independently - essential for functional strength",
            muscleGroup = MuscleGroup.CORE,
            videoUrl = R.raw.deadbug
        ),
        Exercise(
            id = 4,
            name = "Single Leg Glute March",
            description = "Activates glutes and improves single-leg stability and hip control",
            muscleGroup = MuscleGroup.GLUTES,
            videoUrl = R.raw.single_leg_glute_march
        ),
        Exercise(
            id = 5,
            name = "Bodyweight Squats",
            description = "Fundamental lower body exercise strengthening quads, glutes and improving knee stability",
            muscleGroup = MuscleGroup.LEGS,
            videoUrl = R.raw.bodyweight_squat
        ),
        Exercise(
            id = 6,
            name = "Side Plank",
            description = "Strengthens oblique muscles and lateral core for better stability and injury prevention",
            muscleGroup = MuscleGroup.CORE,
            videoUrl = R.raw.side_plank
        ),
        Exercise(
            id = 7,
            name = "Push-ups",
            description = "Classic upper body compound movement targeting chest, shoulders and triceps",
            muscleGroup = MuscleGroup.CHEST,
            videoUrl = R.raw.pushups
        ),
        Exercise(
            id = 8,
            name = "Russian Twists",
            description = "Dynamic rotational core exercise building oblique strength and anti-rotation power",
            muscleGroup = MuscleGroup.CORE,
            videoUrl = R.raw.russian_twists
        ),
        Exercise(
            id = 9,
            name = "Wall Angels",
            description = "Corrects forward shoulder posture, opens chest and improves shoulder mobility",
            muscleGroup = MuscleGroup.SHOULDERS,
            videoUrl = R.raw.pushups
        ),
        Exercise(
            id = 10,
            name = "Wall Sit",
            description = "Isometric hold building quad endurance, mental toughness and lower body stamina",
            muscleGroup = MuscleGroup.LEGS,
            videoUrl = R.raw.side_plank
        ),
        Exercise(
            id = 11,
            name = "Reverse Plank",
            description = "Builds posterior chain strength, core stability and opens hip flexors",
            muscleGroup = MuscleGroup.CORE,
            videoUrl = R.raw.reverse_crunch
        ),
        Exercise(
            id = 12,
            name = "Donkey Kicks",
            description = "Isolates and activates glute muscles while maintaining core stability",
            muscleGroup = MuscleGroup.GLUTES,
            videoUrl = R.raw.bicycle_crunch
        ),
        Exercise(
            id = 13,
            name = "Donkey Kicks Variation",
            description = "Alternative glute activation pattern for complete posterior chain development",
            muscleGroup = MuscleGroup.GLUTES,
            videoUrl = R.raw.bodyweight_squat
        ),
        Exercise(
            id = 14,
            name = "Cobra Pose",
            description = "Gentle back extension that stretches hip flexors, opens chest and strengthens lower back",
            muscleGroup = MuscleGroup.BACK,
            videoUrl = R.raw.cobra_pose
        ),
        Exercise(
            id = 15,
            name = "Walking Lunges",
            description = "Dynamic lunge variation building leg strength, balance and functional movement patterns",
            muscleGroup = MuscleGroup.LEGS,
            videoUrl = R.raw.walking_lunges
        ),
        Exercise(
            id = 16,
            name = "Close-Grip Push-ups",
            description = "Tricep-focused push-up variation that also engages chest and core",
            muscleGroup = MuscleGroup.CHEST,
            videoUrl = R.raw.closegrip_pushups
        ),
        Exercise(
            id = 17,
            name = "Crunches",
            description = "Classic abdominal exercise targeting the upper rectus abdominis",
            muscleGroup = MuscleGroup.CORE,
            videoUrl = R.raw.crunches
        ),
        Exercise(
            id = 18,
            name = "Kneeling Push-ups",
            description = "Modified push-up perfect for building upper body strength progressively",
            muscleGroup = MuscleGroup.CHEST,
            videoUrl = R.raw.kneeling_pushups
        ),
        Exercise(
            id = 19,
            name = "Superman Hold",
            description = "Strengthens entire posterior chain and promotes proper spinal alignment",
            muscleGroup = MuscleGroup.BACK,
            videoUrl = R.raw.superman_hold
        ),
        Exercise(
            id = 20,
            name = "Sumo Squat",
            description = "Wide-stance squat emphasizing inner thighs, glutes and hip mobility",
            muscleGroup = MuscleGroup.LEGS,
            videoUrl = R.raw.sumo_squat
        ),
        Exercise(
            id = 21,
            name = "Single Leg Quad Stretch",
            description = "Stretches front thigh muscles and hip flexors, improves flexibility",
            muscleGroup = MuscleGroup.LEGS,
            videoUrl = R.raw.hamstring_stretch_walk
        ),
        Exercise(
            id = 22,
            name = "Hamstrings Stretch Walk",
            description = "Dynamic hamstring stretch with movement for improved flexibility and mobility",
            muscleGroup = MuscleGroup.LEGS,
            videoUrl = R.raw.hamstring_stretch_walk
        ),
        Exercise(
            id = 23,
            name = "Reverse Lunges",
            description = "Knee-friendly lunge variation targeting quads, glutes and improving balance",
            muscleGroup = MuscleGroup.LEGS,
            videoUrl = R.raw.reverse_lunges
        ),
        Exercise(
            id = 24,
            name = "Lying Hamstrings Stretch",
            description = "Gentle hamstring stretch that relieves lower back tension and improves flexibility",
            muscleGroup = MuscleGroup.LEGS,
            videoUrl = R.raw.hamstring_lying_stretch
        ),
        Exercise(
            id = 25,
            name = "Knee-raises Crunch",
            description = "Dynamic crunch variation engaging upper abs with knee movement",
            muscleGroup = MuscleGroup.CORE,
            videoUrl = R.raw.crunch_handtoknees
        ),
        Exercise(
            id = 26,
            name = "Cat-Cow Pose",
            description = "Spinal mobility flow promoting back health, flexibility and core awareness",
            muscleGroup = MuscleGroup.BACK,
            videoUrl = R.raw.cat_cow_pose
        ),
        Exercise(
            id = 27,
            name = "Reverse Crunches",
            description = "Targets lower abdominals and hip flexors with controlled leg movement",
            muscleGroup = MuscleGroup.CORE,
            videoUrl = R.raw.reverse_crunch
        ),
        Exercise(
            id = 28,
            name = "Wall Flexors Stretch",
            description = "Stretches wrist and forearm flexors, essential for desk workers",
            muscleGroup = MuscleGroup.WRISTS,
            videoUrl = R.raw.hamstring_stretch_walk
        )
    )


    //methods for exercise list


}