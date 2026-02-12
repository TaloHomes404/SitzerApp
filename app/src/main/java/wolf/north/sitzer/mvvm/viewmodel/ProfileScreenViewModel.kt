package wolf.north.sitzer.mvvm.viewmodel

import android.net.Uri
import android.util.Patterns
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import wolf.north.sitzer.repository.datastore.NotificationsPreferencesRepository
import javax.inject.Inject


data class ProfileUiState(
    val avatarUri: Uri? = null,
    val username: String = "",
    val email: String = "",
    val isEditingUsername: Boolean = false,
    val isEditingEmail: Boolean = false,
    val isEditingPassword: Boolean = false,
    val newPassword: String = "",
    val confirmPassword: String = "",
    val isLoading: Boolean = false,
    val errorMessage: String? = null,
    val selectedTheme: String? = "System",
    val selectedLanguage: String? = "Polski",
    val notificationMethod: String = "Push"
)

data class NotificationSettingsUi(
    val daily: Boolean = true,
    val planOfTheDay: Boolean = true,
    val weeklySummary: Boolean = true
)

@HiltViewModel
class ProfileScreenViewModel @Inject constructor(private val notificationRepo: NotificationsPreferencesRepository) :
    ViewModel() {

    //vals to hold user profile model in uistate
    private val _uiState = MutableStateFlow(ProfileUiState())
    val uiState: StateFlow<ProfileUiState> = _uiState

    private val _selectedLanguage = MutableStateFlow("  ")
    val selectedLanguage: StateFlow<String> = _selectedLanguage

    //Password visibility val
    var passwordVisibility by mutableStateOf(false)

    fun togglePasswordVisibility() {
        passwordVisibility = !passwordVisibility
    }

    fun setNotificationMethod(method: String) {
        _uiState.update { it.copy(notificationMethod = method) }
    }


    //configurations assigned to val (notifications pref flow)
    val notificationSettings: StateFlow<NotificationSettingsUi> =
        notificationRepo.notificationPrefs.map { prefs ->
            NotificationSettingsUi(
                daily = prefs.daily,
                planOfTheDay = prefs.plan,
                weeklySummary = prefs.weekly
            )
        }
            .stateIn(
                viewModelScope,
                SharingStarted.WhileSubscribed(5000),
                NotificationSettingsUi()
            )

    //initial method to load data from repo/model/db TODO: zrobić dobrze ( w sensie metode...)
    fun loadProfile(initUsername: String, initEmail: String, avatarUri: Uri?) {
        _uiState.value = _uiState.value.copy(
            username = initUsername,
            email = initEmail,
            avatarUri = avatarUri
        )
    }

    //setters & getters for profile changes
    fun setAvatar(uri: Uri) {
        _uiState.value = _uiState.value.copy(avatarUri = uri)
    }

    //butttons visibility values
    fun toggleEditUsername() {
        _uiState.value = _uiState.value.copy(isEditingUsername = !_uiState.value.isEditingUsername)
    }

    fun toggleEditEmail() {
        _uiState.value = _uiState.value.copy(isEditingEmail = !_uiState.value.isEditingEmail)
    }

    fun toggleEditPassword() {
        _uiState.value = _uiState.value.copy(isEditingPassword = !_uiState.value.isEditingPassword)
    }

    fun onEmailChange(value: String) {
        _uiState.value = _uiState.value.copy(email = value)
    }

    fun onUsernameChange(value: String) {
        _uiState.value = _uiState.value.copy(username = value)
    }

    fun onNewPasswordChange(value: String) {
        _uiState.value = _uiState.value.copy(newPassword = value)
    }

    fun onConfirmPasswordChange(value: String) {
        _uiState.value = _uiState.value.copy(confirmPassword = value)
    }

    //simple validation on email - using android utils
    private fun validateEmail(email: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    private fun validatePassword(password: String): Boolean {
        return password.length >= 5
    }

    //validate function before enabling confirm button
    fun canSubmitChanges(): Boolean {
        val state = _uiState.value
        val emailOK = !state.isEditingEmail || validateEmail(state.email)
        val passwordOK =
            !state.isEditingPassword || validatePassword(state.newPassword) && state.newPassword == state.confirmPassword

        return emailOK && passwordOK && !state.isLoading
    }

    fun onSubmitChanges(onResult: (success: Boolean, message: String?) -> Unit) {

        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true, errorMessage = null)

            try {
                //TODO: autoryzacja haseł / zapisywanie i convert pfp / update modelu usera w ROOM
                //na potrzeby MVP narazie delay tylko
                delay(1000)

                _uiState.value = _uiState.value.copy(
                    isLoading = false,
                    isEditingUsername = false,
                    isEditingEmail = false,
                    isEditingPassword = false,
                    newPassword = "",
                    confirmPassword = ""
                )
                onResult(true, null)
            } catch (e: Exception) {
                _uiState.value = _uiState.value.copy(isLoading = false, errorMessage = e.message)
                onResult(false, e.message)
            }

        }
    }

    //methods for notifications
    fun toggleDaily(enabled: Boolean) = viewModelScope.launch {
        notificationRepo.setDaily(enabled)
    }

    fun togglePlan(enabled: Boolean) = viewModelScope.launch {
        notificationRepo.setPlan(enabled)
    }

    fun toggleWeekly(enabled: Boolean) = viewModelScope.launch {
        notificationRepo.setWeekly(enabled)
    }


    fun selectTheme(theme: String) {
        _uiState.update { it.copy(selectedTheme = theme) }
    }

    fun selectLanguage(language: String) {
        _uiState.update { it.copy(selectedLanguage = language) }
    }

}
