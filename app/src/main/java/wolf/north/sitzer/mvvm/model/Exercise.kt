package wolf.north.sitzer.mvvm.model

import wolf.north.sitzer.enums.MuscleGroup

data class Exercise(
    val id: Int,
    val nameResId: Int,
    val descriptionResId: Int,
    val muscleGroup: MuscleGroup,
    val videoUrl: Int,
    val instructionsResId: Int? = null,
    val tipsResId: Int? = null
)