package wolf.north.sitzer.mvvm.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import wolf.north.sitzer.mvvm.model.Exercise
import wolf.north.sitzer.mvvm.model.Plan
import wolf.north.sitzer.repository.PlansRepository

class WorkoutHubScreenViewModel : ViewModel() {

    private val _currentPlan = MutableStateFlow<Plan?>(null)
    val currentPlan: StateFlow<Plan?> = _currentPlan.asStateFlow()

    private val _currentExerciseIndex = MutableStateFlow(0)
    val currentExerciseIndex: StateFlow<Int> = _currentExerciseIndex.asStateFlow()

    private val _isWorkoutPlaying = MutableStateFlow(false)
    val isWorkoutPlaying: StateFlow<Boolean> = _isWorkoutPlaying.asStateFlow()


    //computed stateflow for next exercise name (ui update in workouthub)
    val nextExercise: StateFlow<Exercise?> = combine(
        _currentPlan,
        _currentExerciseIndex
    ) { plan, index ->
        plan?.exercises?.getOrNull(index + 1)
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), null)


    //Load plan into workout hub and set first exercise
    fun loadPlanIntoHub(planId: Int) {
        viewModelScope.launch {
            val plan = PlansRepository.plansList.find { it.id == planId }
            _currentPlan.value = plan
            _currentExerciseIndex.value = 0
        }
    }

    fun getCurrentExercise(): Exercise? {
        val plan = _currentPlan.value
        val index = _currentExerciseIndex.value
        return plan?.exercises?.getOrNull(index)
    }

    fun getNextExercise(): Exercise? {
        val plan = _currentPlan.value
        val index = _currentExerciseIndex.value + 1
        return plan?.exercises?.getOrNull(index)
    }


    //Pick next exercise from plan and reset timer
    fun goToNextExercise() {
        val plan = _currentPlan.value
        val currentIndex = _currentExerciseIndex.value

        Log.d(
            "WorkoutViewModel",
            "Next clicked. Current: $currentIndex, Total: ${plan?.exercises?.size}"
        )

        if (currentIndex < (plan?.exercises?.size ?: 0) - 1) {
            _currentExerciseIndex.value = currentIndex + 1
            Log.d("WorkoutViewModel", "Moved to: ${_currentExerciseIndex.value}")
            resetTimer()
        }
    }

    //Return to previous exercise and reset timer
    fun goToPreviousExercise() {
        val plan = _currentPlan.value
        val currentIndex = _currentExerciseIndex.value

        Log.d("WorkoutViewModel", "Previous clicked. Current: $currentIndex")

        if (currentIndex > 0) {
            _currentExerciseIndex.value = currentIndex - 1
            Log.d("WorkoutViewModel", "Moved to: ${_currentExerciseIndex.value}")
            resetTimer()
        }
    }


    //Video player
    //Timer
    //helper methods
    fun playExerciseVideo() {
        _isWorkoutPlaying.value = !_isWorkoutPlaying.value
    }

    fun startTimer() {

    }

    fun pauseTimer() {

    }

    fun resetTimer() {

    }


}