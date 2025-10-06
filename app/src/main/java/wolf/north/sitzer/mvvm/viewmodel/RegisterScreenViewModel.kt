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
class RegisterScreenViewModel @Inject constructor(private val repository: UserRepository) :
    ViewModel() {

    var firstName by mutableStateOf("")
    var email by mutableStateOf("")
    var password by mutableStateOf("")
    var confirmPassword by mutableStateOf("")

    var registrationSuccess by mutableStateOf(false)
    var errorMessage by mutableStateOf("")


    fun RegisterUser() {
        //Podstawowa walidacja dla rejestracji
        if (firstName.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            errorMessage = "Uzupełnij wszystkie pola!"
            return
        }

        if (password != confirmPassword) {
            errorMessage = "Hasła nie są identyczne!"
            return
        }

        if (password.length < 5) {
            errorMessage = "Hasło musi mieć co najmniej 5 znaków!"
            return
        }

        errorMessage = " "

        viewModelScope.launch {

            try {
                repository.registerUserWithCredentials(firstName, email, password)
                registrationSuccess = true

            } catch (e: Exception) {
                errorMessage = "Błąd w rejestracji : ${e.message}"
            }

        }

    }

}