package wolf.north.sitzer.repository

import wolf.north.sitzer.R
import wolf.north.sitzer.mvvm.model.Plan

object PlansRepository {

    //Method to load all plans
    fun getAllPlans(): List<Plan> {
        return listOf(
            Plan(
                id = "1",
                name = "Posture Fix",
                category = "Full Body",
                imageRes = R.drawable.stretch_img,
                exerciseCount = 8,
                duration = 15,
                difficulty = "Beginner"
            ),
            Plan(
                id = "2",
                name = "Neck Pain Relief",
                category = "Upper Body",
                imageRes = R.drawable.neck_exercise,
                exerciseCount = 6,
                duration = 10,
                difficulty = "Beginner"
            ),
            Plan(
                id = "3",
                name = "Strong Lower Back",
                category = "Lower Body",
                imageRes = R.drawable.lowerback_exercise,
                exerciseCount = 10,
                duration = 20,
                difficulty = "Intermediate"
            ),
        )
    }

    //Method to load plans sorted by category
    fun getPlansSortByCategory(category: String): List<Plan> {
        return if (category == "All") getAllPlans() else getAllPlans().filter { it.category == category }
    }

    //Load all premium plans
    fun getPlansOnlyPremium(): List<Plan> {
        return getAllPlans().filter { it.isPremium }
    }
}