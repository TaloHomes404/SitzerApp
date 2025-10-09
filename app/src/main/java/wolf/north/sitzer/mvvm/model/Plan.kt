package wolf.north.sitzer.mvvm.model

//Data class (Model) for plans in program

data class Plan(
    val id: String,
    val name: String,
    val category: String,  //For sorting (Full-body, lower, upper etc)
    val imageRes: Int,
    val exerciseCount: Int,
    val duration: Int,
    val difficulty: String, // TODO: for future sorting in exercise list (by difficulty)
    val isPremium: Boolean = false //Potential for subscription/buying plans
)
