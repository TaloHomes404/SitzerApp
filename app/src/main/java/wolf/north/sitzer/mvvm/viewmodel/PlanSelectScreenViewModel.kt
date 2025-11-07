package wolf.north.sitzer.mvvm.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import wolf.north.sitzer.enums.MuscleGroup
import wolf.north.sitzer.enums.PlanDifficulty
import wolf.north.sitzer.mvvm.model.Plan
import wolf.north.sitzer.repository.PlansRepository
import wolf.north.sitzer.repository.PlansRepository.plansList

class PlanSelectScreenViewModel : ViewModel() {

    private val _selectedCategory = MutableStateFlow<MuscleGroup?>(null)
    val selectedCategory: StateFlow<MuscleGroup?> = _selectedCategory.asStateFlow()

    private val _selectedDifficulty = MutableStateFlow<PlanDifficulty?>(null)
    val selectedDifficulty: StateFlow<PlanDifficulty?> = _selectedDifficulty.asStateFlow()

    private val _plans = MutableStateFlow<List<Plan>>(emptyList())
    val plans: StateFlow<List<Plan>> = _plans.asStateFlow()


    init {
        loadPlans()
    }

    fun loadPlans() {
        _plans.value = PlansRepository.getPlansFiltered(
            category = _selectedCategory.value,
            difficulty = _selectedDifficulty.value
        )
    }

    fun selectedCategory(category: MuscleGroup?) {
        _selectedCategory.value = category
        loadPlans()
    }

    fun selectedDifficulty(difficulty: PlanDifficulty?) {
        _selectedDifficulty.value = difficulty
        loadPlans()
    }


    fun getPlansFiltered(
        category: MuscleGroup? = null,
        difficulty: PlanDifficulty? = null
    ): List<Plan> {
        return plansList.filter { plan ->
            (category == null || plan.category == category) &&
                    (difficulty == null || plan.difficulty == difficulty)
        }
    }

}