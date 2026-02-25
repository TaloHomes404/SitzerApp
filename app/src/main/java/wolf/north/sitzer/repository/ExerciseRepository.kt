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
            nameResId = R.string.ex_bicycle_crunch_name,
            descriptionResId = R.string.ex_bicycle_crunch_desc,
            muscleGroup = MuscleGroup.CORE,
            videoUrl = R.raw.bicycle_crunch,
            instructionsResId = R.array.ex_bicycle_crunch_instructions,
            tipsResId = R.array.ex_bicycle_crunch_tips
        ),
        Exercise(
            id = 2,
            nameResId = R.string.ex_standing_calf_raises_name,
            descriptionResId = R.string.ex_standing_calf_raises_desc,
            muscleGroup = MuscleGroup.LEGS,
            videoUrl = R.raw.side_plank,
            instructionsResId = R.array.ex_standing_calf_raises_instructions,
            tipsResId = R.array.ex_standing_calf_raises_tips
        ),
        Exercise(
            id = 3,
            nameResId = R.string.ex_dead_bug_name,
            descriptionResId = R.string.ex_dead_bug_desc,
            muscleGroup = MuscleGroup.CORE,
            videoUrl = R.raw.deadbug,
            instructionsResId = R.array.ex_dead_bug_instructions,
            tipsResId = R.array.ex_dead_bug_tips
        ),
        Exercise(
            id = 4,
            nameResId = R.string.ex_single_leg_glute_march_name,
            descriptionResId = R.string.ex_single_leg_glute_march_desc,
            muscleGroup = MuscleGroup.GLUTES,
            videoUrl = R.raw.single_leg_glute_march,
            instructionsResId = R.array.ex_single_leg_glute_march_instructions,
            tipsResId = R.array.ex_single_leg_glute_march_tips
        ),
        Exercise(
            id = 5,
            nameResId = R.string.ex_bodyweight_squats_name,
            descriptionResId = R.string.ex_bodyweight_squats_desc,
            muscleGroup = MuscleGroup.LEGS,
            videoUrl = R.raw.bodyweight_squat,
            instructionsResId = R.array.ex_bodyweight_squats_instructions,
            tipsResId = R.array.ex_bodyweight_squats_tips
        ),
        Exercise(
            id = 6,
            nameResId = R.string.ex_side_plank_name,
            descriptionResId = R.string.ex_side_plank_desc,
            muscleGroup = MuscleGroup.CORE,
            videoUrl = R.raw.side_plank,
            instructionsResId = R.array.ex_side_plank_instructions,
            tipsResId = R.array.ex_side_plank_tips
        ),
        Exercise(
            id = 7,
            nameResId = R.string.ex_pushups_name,
            descriptionResId = R.string.ex_pushups_desc,
            muscleGroup = MuscleGroup.CHEST,
            videoUrl = R.raw.pushups,
            instructionsResId = R.array.ex_pushups_instructions,
            tipsResId = R.array.ex_pushups_tips
        ),
        Exercise(
            id = 8,
            nameResId = R.string.ex_russian_twists_name,
            descriptionResId = R.string.ex_russian_twists_desc,
            muscleGroup = MuscleGroup.CORE,
            videoUrl = R.raw.russian_twists,
            instructionsResId = R.array.ex_russian_twists_instructions,
            tipsResId = R.array.ex_russian_twists_tips
        ),
        Exercise(
            id = 9,
            nameResId = R.string.ex_wall_angels_name,
            descriptionResId = R.string.ex_wall_angels_desc,
            muscleGroup = MuscleGroup.SHOULDERS,
            videoUrl = R.raw.pushups,
            instructionsResId = R.array.ex_wall_angels_instructions,
            tipsResId = R.array.ex_wall_angels_tips
        ),
        Exercise(
            id = 10,
            nameResId = R.string.ex_wall_sit_name,
            descriptionResId = R.string.ex_wall_sit_desc,
            muscleGroup = MuscleGroup.LEGS,
            videoUrl = R.raw.side_plank,
            instructionsResId = R.array.ex_wall_sit_instructions,
            tipsResId = R.array.ex_wall_sit_tips
        ),
        Exercise(
            id = 11,
            nameResId = R.string.ex_reverse_plank_name,
            descriptionResId = R.string.ex_reverse_plank_desc,
            muscleGroup = MuscleGroup.CORE,
            videoUrl = R.raw.reverse_crunch,
            instructionsResId = R.array.ex_reverse_plank_instructions,
            tipsResId = R.array.ex_reverse_plank_tips
        ),
        Exercise(
            id = 12,
            nameResId = R.string.ex_donkey_kicks_name,
            descriptionResId = R.string.ex_donkey_kicks_desc,
            muscleGroup = MuscleGroup.GLUTES,
            videoUrl = R.raw.bicycle_crunch,
            instructionsResId = R.array.ex_donkey_kicks_instructions,
            tipsResId = R.array.ex_donkey_kicks_tips
        ),
        Exercise(
            id = 13,
            nameResId = R.string.ex_donkey_kicks_variation_name,
            descriptionResId = R.string.ex_donkey_kicks_variation_desc,
            muscleGroup = MuscleGroup.GLUTES,
            videoUrl = R.raw.bodyweight_squat,
            instructionsResId = R.array.ex_donkey_kicks_variation_instructions,
            tipsResId = R.array.ex_donkey_kicks_variation_tips
        ),
        Exercise(
            id = 14,
            nameResId = R.string.ex_cobra_pose_name,
            descriptionResId = R.string.ex_cobra_pose_desc,
            muscleGroup = MuscleGroup.BACK,
            videoUrl = R.raw.cobra_pose,
            instructionsResId = R.array.ex_cobra_pose_instructions,
            tipsResId = R.array.ex_cobra_pose_tips
        ),
        Exercise(
            id = 15,
            nameResId = R.string.ex_walking_lunges_name,
            descriptionResId = R.string.ex_walking_lunges_desc,
            muscleGroup = MuscleGroup.LEGS,
            videoUrl = R.raw.walking_lunges,
            instructionsResId = R.array.ex_walking_lunges_instructions,
            tipsResId = R.array.ex_walking_lunges_tips
        ),
        Exercise(
            id = 16,
            nameResId = R.string.ex_close_grip_pushups_name,
            descriptionResId = R.string.ex_close_grip_pushups_desc,
            muscleGroup = MuscleGroup.CHEST,
            videoUrl = R.raw.closegrip_pushups,
            instructionsResId = R.array.ex_close_grip_pushups_instructions,
            tipsResId = R.array.ex_close_grip_pushups_tips
        ),
        Exercise(
            id = 17,
            nameResId = R.string.ex_crunches_name,
            descriptionResId = R.string.ex_crunches_desc,
            muscleGroup = MuscleGroup.CORE,
            videoUrl = R.raw.crunches,
            instructionsResId = R.array.ex_crunches_instructions,
            tipsResId = R.array.ex_crunches_tips
        ),
        Exercise(
            id = 18,
            nameResId = R.string.ex_kneeling_pushups_name,
            descriptionResId = R.string.ex_kneeling_pushups_desc,
            muscleGroup = MuscleGroup.CHEST,
            videoUrl = R.raw.kneeling_pushups,
            instructionsResId = R.array.ex_kneeling_pushups_instructions,
            tipsResId = R.array.ex_kneeling_pushups_tips
        ),
        Exercise(
            id = 19,
            nameResId = R.string.ex_superman_hold_name,
            descriptionResId = R.string.ex_superman_hold_desc,
            muscleGroup = MuscleGroup.BACK,
            videoUrl = R.raw.superman_hold,
            instructionsResId = R.array.ex_superman_hold_instructions,
            tipsResId = R.array.ex_superman_hold_tips
        ),
        Exercise(
            id = 20,
            nameResId = R.string.ex_sumo_squat_name,
            descriptionResId = R.string.ex_sumo_squat_desc,
            muscleGroup = MuscleGroup.LEGS,
            videoUrl = R.raw.sumo_squat,
            instructionsResId = R.array.ex_sumo_squat_instructions,
            tipsResId = R.array.ex_sumo_squat_tips
        ),
        Exercise(
            id = 21,
            nameResId = R.string.ex_single_leg_quad_stretch_name,
            descriptionResId = R.string.ex_single_leg_quad_stretch_desc,
            muscleGroup = MuscleGroup.LEGS,
            videoUrl = R.raw.hamstring_stretch_walk,
            instructionsResId = R.array.ex_single_leg_quad_stretch_instructions,
            tipsResId = R.array.ex_single_leg_quad_stretch_tips
        ),
        Exercise(
            id = 22,
            nameResId = R.string.ex_hamstring_stretch_walk_name,
            descriptionResId = R.string.ex_hamstring_stretch_walk_desc,
            muscleGroup = MuscleGroup.LEGS,
            videoUrl = R.raw.hamstring_stretch_walk,
            instructionsResId = R.array.ex_hamstring_stretch_walk_instructions,
            tipsResId = R.array.ex_hamstring_stretch_walk_tips
        ),
        Exercise(
            id = 23,
            nameResId = R.string.ex_reverse_lunges_name,
            descriptionResId = R.string.ex_reverse_lunges_desc,
            muscleGroup = MuscleGroup.LEGS,
            videoUrl = R.raw.reverse_lunges,
            instructionsResId = R.array.ex_reverse_lunges_instructions,
            tipsResId = R.array.ex_reverse_lunges_tips
        ),
        Exercise(
            id = 24,
            nameResId = R.string.ex_lying_hamstring_stretch_name,
            descriptionResId = R.string.ex_lying_hamstring_stretch_desc,
            muscleGroup = MuscleGroup.LEGS,
            videoUrl = R.raw.hamstring_lying_stretch,
            instructionsResId = R.array.ex_lying_hamstring_stretch_instructions,
            tipsResId = R.array.ex_lying_hamstring_stretch_tips
        ),
        Exercise(
            id = 25,
            nameResId = R.string.ex_knee_raise_crunch_name,
            descriptionResId = R.string.ex_knee_raise_crunch_desc,
            muscleGroup = MuscleGroup.CORE,
            videoUrl = R.raw.crunch_handtoknees,
            instructionsResId = R.array.ex_knee_raise_crunch_instructions,
            tipsResId = R.array.ex_knee_raise_crunch_tips
        ),
        Exercise(
            id = 26,
            nameResId = R.string.ex_cat_cow_pose_name,
            descriptionResId = R.string.ex_cat_cow_pose_desc,
            muscleGroup = MuscleGroup.BACK,
            videoUrl = R.raw.cat_cow_pose,
            instructionsResId = R.array.ex_cat_cow_pose_instructions,
            tipsResId = R.array.ex_cat_cow_pose_tips
        ),
        Exercise(
            id = 27,
            nameResId = R.string.ex_reverse_crunches_name,
            descriptionResId = R.string.ex_reverse_crunches_desc,
            muscleGroup = MuscleGroup.CORE,
            videoUrl = R.raw.reverse_crunch,
            instructionsResId = R.array.ex_reverse_crunches_instructions,
            tipsResId = R.array.ex_reverse_crunches_tips
        ),
        Exercise(
            id = 28,
            nameResId = R.string.ex_wall_flexor_stretch_name,
            descriptionResId = R.string.ex_wall_flexor_stretch_desc,
            muscleGroup = MuscleGroup.WRISTS,
            videoUrl = R.raw.hamstring_stretch_walk,
            instructionsResId = R.array.ex_wall_flexor_stretch_instructions,
            tipsResId = R.array.ex_wall_flexor_stretch_tips
        )
    )


    //methods for exercise list


}