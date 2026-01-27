package wolf.north.sitzer.mvvm.model

import wolf.north.sitzer.enums.MuscleGroup

data class Exercise(
    val id: Int,
    val name: String,
    val description: String,
    val muscleGroup: MuscleGroup,
    val videoUrl: Int
) {

}