package wolf.north.sitzer.mvvm.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import wolf.north.sitzer.mvvm.model.Plan
import wolf.north.sitzer.repository.PlansRepository

class PlansViewModel : ViewModel() {

    private val _selectedCategory = MutableStateFlow("All")
    val selectedCategory: StateFlow<String> = _selectedCategory.asStateFlow()

    private val _plans = MutableStateFlow<List<Plan>>(emptyList())
    val plans: StateFlow<List<Plan>> = _plans.asStateFlow()

    init {
        loadPlans()
    }

    fun loadPlans() {
        _plans.value = PlansRepository.getAllPlans()
    }

    fun selectedCategory(category: String) {
        _selectedCategory.value = category
    }

    fun getPlansSortByCategory(): List<Plan> {
        return PlansRepository.getPlansSortByCategory(_selectedCategory.value)
    }
}