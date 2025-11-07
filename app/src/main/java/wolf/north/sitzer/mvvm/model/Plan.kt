package wolf.north.sitzer.mvvm.model

import wolf.north.sitzer.enums.PlanDifficulty

//Data class (Model) for plans in program

data class Plan(
    val id: Int,
    val name: String,
    val description: String,
    val category: PlanDifficulty,  //For sorting (Full-body, lower, upper etc)
    val imageRes: Int,
    val exercises: List<Exercise>,
    val exerciseCount: Int,
    val duration: Int,
    val difficulty: String, // TODO: for future sorting in exercise list (by difficulty)
    val isPremium: Boolean = false //Potential for subscription/buying plans
)
