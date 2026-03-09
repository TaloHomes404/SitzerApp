package wolf.north.sitzer.enums

import wolf.north.sitzer.R

enum class MuscleGroup {
    NECK,
    SHOULDERS,
    BACK,
    CORE,
    HIPS,
    GLUTES,
    KNEES,
    LEGS,
    WRISTS,
    CHEST

}

fun MuscleGroup.getIconRes(): Int {
    return when (this) {
        MuscleGroup.NECK -> R.drawable.neck
        MuscleGroup.SHOULDERS -> R.drawable.shoulders
        MuscleGroup.BACK -> R.drawable.back
        MuscleGroup.CORE -> R.drawable.core
        MuscleGroup.HIPS -> R.drawable.hips
        MuscleGroup.GLUTES -> R.drawable.glutes
        MuscleGroup.KNEES -> R.drawable.knees
        MuscleGroup.LEGS -> R.drawable.legs
        MuscleGroup.WRISTS -> R.drawable.wrists
        MuscleGroup.CHEST -> R.drawable.chest
    }
}

enum class Difficulty {
    BEGINNER,
    INTERMEDIATE,
    ADVANCED
}