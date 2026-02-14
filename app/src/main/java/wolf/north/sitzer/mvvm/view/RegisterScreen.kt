package wolf.north.sitzer.mvvm.view

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Key
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import wolf.north.sitzer.R
import wolf.north.sitzer.mvvm.viewmodel.RegisterScreenViewModel
import wolf.north.sitzer.navigation.Screens


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreen(
    navController: NavHostController = rememberNavController(),
    viewModel: RegisterScreenViewModel = hiltViewModel()
) {
    LaunchedEffect(viewModel.registrationSuccess) {
        if (viewModel.registrationSuccess) {
            navController.navigate(Screens.Home) {
                popUpTo(Screens.Register) { inclusive = true }
            }
        }
    }

    Scaffold(
        containerColor = MaterialTheme.colorScheme.primary
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {

            // Logo na górze
            Image(
                painter = painterResource(R.drawable.sitzer_logo_nobg),
                contentDescription = "register site Sitzer logo",
                contentScale = ContentScale.Crop,
                modifier = Modifier.padding(top = 48.dp, bottom = 24.dp)
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .clip(
                        RoundedCornerShape(
                            topStart = 32.dp,
                            topEnd = 32.dp
                        )
                    )
                    .background(MaterialTheme.colorScheme.surface)
                    .padding(24.dp)
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxHeight()
                ) {
                    Text(
                        text = stringResource(R.string.register_title),
                        fontSize = 30.sp,
                        color = MaterialTheme.colorScheme.onSurface,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(bottom = 16.dp)
                    )

                    AnimatedVisibility(visible = viewModel.errorMessage.isNotEmpty()) {
                        Text(
                            text = viewModel.errorMessage,
                            fontSize = 14.sp,
                            color = MaterialTheme.colorScheme.error,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(vertical = 8.dp)
                        )
                    }

                    // Formularz rejestracji
                    Column(modifier = Modifier.padding(horizontal = 8.dp)) {
                        OutlinedTextField(
                            leadingIcon = {
                                Icon(Icons.Default.Person, contentDescription = null)
                            },
                            value = viewModel.firstName,
                            onValueChange = { viewModel.firstName = it },
                            label = { Text(text = stringResource(R.string.register_first_name_label)) },
                            placeholder = { Text(text = stringResource(R.string.register_first_name_placeholder)) },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 16.dp)
                        )

                        OutlinedTextField(
                            leadingIcon = {
                                Icon(Icons.Default.Email, contentDescription = null)
                            },
                            value = viewModel.email,
                            onValueChange = { viewModel.email = it },
                            label = { Text(text = stringResource(R.string.register_email_label)) },
                            placeholder = { Text(text = stringResource(R.string.register_email_placeholder)) },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 12.dp),
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
                        )

                        OutlinedTextField(
                            leadingIcon = {
                                Icon(Icons.Default.Key, contentDescription = null)
                            },
                            trailingIcon = {
                                Icon(
                                    imageVector = if (viewModel.passwordVisibility)
                                        Icons.Default.Visibility
                                    else
                                        Icons.Default.VisibilityOff,
                                    contentDescription = if (viewModel.passwordVisibility) "Hide password" else "Show password",
                                    modifier = Modifier.clickable {
                                        viewModel.togglePasswordVisibility()
                                    }
                                )
                            },
                            value = viewModel.password,
                            onValueChange = { viewModel.password = it },
                            label = { Text(text = stringResource(R.string.register_password_label)) },
                            placeholder = { Text(text = stringResource(R.string.register_password_placeholder)) },
                            visualTransformation = if (viewModel.passwordVisibility)
                                VisualTransformation.None
                            else
                                PasswordVisualTransformation(),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 12.dp),
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
                        )

                        OutlinedTextField(
                            leadingIcon = {
                                Icon(Icons.Default.Close, contentDescription = null)
                            },
                            value = viewModel.confirmPassword,
                            onValueChange = { viewModel.confirmPassword = it },
                            label = { Text(text = stringResource(R.string.register_confirm_password_label)) },
                            placeholder = { Text(text = stringResource(R.string.register_confirm_password_placeholder)) },
                            visualTransformation = if (viewModel.passwordVisibility)
                                VisualTransformation.None
                            else
                                PasswordVisualTransformation(),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 24.dp),
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
                        )

                        ElevatedButton(
                            onClick = {
                                viewModel.RegisterUser()
                            },
                            elevation = ButtonDefaults.elevatedButtonElevation(
                                defaultElevation = 4.dp,
                                pressedElevation = 8.dp
                            ),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = MaterialTheme.colorScheme.primary,
                                contentColor = MaterialTheme.colorScheme.onPrimary
                            ),
                            modifier = Modifier
                                .fillMaxWidth(0.5f)
                                .padding(top = 8.dp)
                                .height(48.dp)
                                .align(Alignment.CenterHorizontally),
                            shape = RoundedCornerShape(24.dp)
                        ) {
                            Text(text = stringResource(R.string.register_button), fontSize = 20.sp)
                        }
                    }
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun RegisterScreenPreview() {
    RegisterScreen()
}

