package wolf.north.sitzer.mvvm.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import wolf.north.sitzer.enums.MuscleGroup
import wolf.north.sitzer.mvvm.model.Plan
import wolf.north.sitzer.repository.PlansRepository

class HomeScreenViewModel : ViewModel() {

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