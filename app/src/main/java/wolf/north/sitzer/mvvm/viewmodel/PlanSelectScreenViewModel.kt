package wolf.north.sitzer.mvvm.viewmodel

import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import wolf.north.sitzer.enums.MuscleGroup
import wolf.north.sitzer.enums.PlanDifficulty
import wolf.north.sitzer.mvvm.model.Plan
import wolf.north.sitzer.repository.PlansRepository
import wolf.north.sitzer.repository.PlansRepository.plansList
import wolf.north.sitzer.repository.datastore.UserPreferencesRepository
import javax.inject.Inject

@HiltViewModel
class PlanSelectScreenViewModel @Inject constructor(private val userPreferences: UserPreferencesRepository) :
    ViewModel() {

    private val _selectedCategory = MutableStateFlow<MuscleGroup?>(null)
    val selectedCategory: StateFlow<MuscleGroup?> = _selectedCategory.asStateFlow()

    private val _selectedDifficulty = MutableStateFlow<PlanDifficulty?>(null)
    val selectedDifficulty: StateFlow<PlanDifficulty?> = _selectedDifficulty.asStateFlow()

    private val _plans = MutableStateFlow<List<Plan>>(emptyList())
    val plans: StateFlow<List<Plan>> = _plans.asStateFlow()

    val avatarUri: StateFlow<Uri?> = userPreferences.avatarUri.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(),
        null
    )

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