package wolf.north.sitzer.repository

import wolf.north.sitzer.mvvm.model.Exercise

object ExerciseRepository {

    //Simple implement
    //TODO: zaimplementować dobrą liste ćwiczeń i odpowiednie metody

    val exercises = listOf(
        Exercise("Push Ups"),
        Exercise("Squats"),
        Exercise("Plank"),
        Exercise("Running"),
        Exercise("Jumping Jacks")
    )


    fun getExercisesForPlan(planId: Int): List<Exercise> {
        return exercises
    }

}