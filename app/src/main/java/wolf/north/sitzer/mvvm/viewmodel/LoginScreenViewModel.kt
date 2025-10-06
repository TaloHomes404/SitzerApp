package wolf.north.sitzer.mvvm.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import wolf.north.sitzer.repository.UserRepository
import javax.inject.Inject

@HiltViewModel
class LoginScreenViewModel @Inject constructor(private val repository: UserRepository) :
    ViewModel() {

    var email by mutableStateOf("")
    var password by mutableStateOf("")
    var loginSuccess by mutableStateOf(false)
    var errorMessage by mutableStateOf("")

    fun changePassword(newPassword: String) {
        password = newPassword
    }

    fun changeEmail(newEmail: String) {
        email = newEmail
    }

    fun login() {

        //Prosta walidacja systemu logowania
        if (email.isEmpty() || password.isEmpty()) {
            errorMessage = "Uzupelnij wszystkie pola!"
            return
        }

        errorMessage = ""

        viewModelScope.launch {
            val user = repository.loginUser(email, password)
            if (user != null) {
                loginSuccess = true
                errorMessage = ""
            } else {
                errorMessage = "Zły email lub hasło"
                loginSuccess = false
            }
        }
    }


}