package wolf.north.sitzer.mvvm.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import wolf.north.sitzer.enums.MuscleGroup
import wolf.north.sitzer.mvvm.model.Plan
import wolf.north.sitzer.repository.PlansRepository
import wolf.north.sitzer.repository.datastore.UserPreferencesRepository

class HomeScreenViewModel(private val userPreferences: UserPreferencesRepository) : ViewModel() {

    //vals for onboarding in homescreen (datastore + overlay)
    val hasSeenOverboarding = userPreferences.hasSeenOnboarding.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(), false
    )

    //onboarding control values (0-5 steps)
    //read-only to navigate between onboarding popups
    private val _currentOnboardingStep = MutableStateFlow(0)
    val currentOnboardingStep: StateFlow<Int> = _currentOnboardingStep.asStateFlow()

    //vals to use in homescreen (plan list /dedicated plans)
    //sets for homescreenplan flow
    private val _plans = MutableStateFlow<List<Plan>>(emptyList())
    val plans: StateFlow<List<Plan>> = _plans.asStateFlow()

    //sets for selected category (home screen carousel) + flow vals
    private val _selectedCategory = MutableStateFlow<MuscleGroup?>(null)
    val selectedCategory: StateFlow<MuscleGroup?> = _selectedCategory.asStateFlow()

    init {
        loadPlansForHome()
    }

    //Launch scope to set datastore sharedprefs with onboarding
    fun setOnboardingSeen() {
        viewModelScope.launch { userPreferences.setOnboardingShown(true) }
    }

    //Increment step by one (next popup displayed)
    fun nextOnboardingStep() {
        _currentOnboardingStep.value += 1
    }


    fun onCategorySelected(category: MuscleGroup?) {
        _selectedCategory.value = category
    }

    private fun loadPlansForHome() {
        _plans.value =
            PlansRepository.getPlansFiltered().take(2) //Load only two for home screen preview
    }

    //Dedicated method to use in homescreen (plan screen dupe)
    fun getPlansForCategory(category: MuscleGroup? = null): List<Plan> {
        return if (category == null) {
            _plans.value
        } else {
            _plans.value.filter { it.category == category }
        }
    }
}