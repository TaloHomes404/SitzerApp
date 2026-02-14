package wolf.north.sitzer.mvvm.view

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Key
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
import wolf.north.sitzer.mvvm.viewmodel.LoginScreenViewModel
import wolf.north.sitzer.navigation.Screens


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    navController: NavHostController = rememberNavController(),
    viewModel: LoginScreenViewModel = hiltViewModel()
) {
    //Inicjacja nawigacji gdy logowanie sie powiedzie
    LaunchedEffect(viewModel.loginSuccess) {
        if (viewModel.loginSuccess) {
            navController.navigate(Screens.Home) {
                popUpTo(Screens.Login) { inclusive = true }
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
            // Logo in login section
            Image(
                painter = painterResource(R.drawable.sitzer_logo_nobg),
                contentDescription = stringResource(R.string.cd_login_logo),
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
                        text = stringResource(R.string.login_title),
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
                            fontWeight = FontWeight.Medium,
                            modifier = Modifier.padding(vertical = 8.dp)
                        )
                    }

                    // Email text field
                    OutlinedTextField(
                        value = viewModel.email,
                        onValueChange = viewModel::changeEmail,
                        leadingIcon = {
                            Icon(Icons.Default.Email, contentDescription = null)
                        },
                        label = { Text(stringResource(R.string.login_email_label)) },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 16.dp)
                    )

                    // Password Text field
                    OutlinedTextField(
                        value = viewModel.password,
                        onValueChange = viewModel::changePassword,
                        leadingIcon = {
                            Icon(Icons.Default.Key, contentDescription = null)
                        },
                        trailingIcon = {
                            Icon(
                                imageVector = if (viewModel.passwordVisibility)
                                    Icons.Default.Visibility
                                else
                                    Icons.Default.VisibilityOff,
                                contentDescription = if (viewModel.passwordVisibility) stringResource(
                                    R.string.cd_hide_password
                                ) else stringResource(R.string.cd_show_password),
                                modifier = Modifier.clickable {
                                    viewModel.togglePasswordVisibility()
                                }
                            )
                        },
                        label = { Text(text = stringResource(R.string.login_password_label)) },
                        visualTransformation = if (viewModel.passwordVisibility)
                            VisualTransformation.None
                        else
                            PasswordVisualTransformation(),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 16.dp)
                    )

                    // Action text under forms (password reset and create account)
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                    ) {
                        Text(
                            text = stringResource(R.string.login_forgot_password),
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )

                        Text(
                            text = stringResource(R.string.login_create_account),
                            color = MaterialTheme.colorScheme.primary,
                            modifier = Modifier.clickable {
                                navController.navigate(Screens.Register)
                            }
                        )
                    }

                    // Login button
                    ElevatedButton(
                        onClick = { viewModel.login() },
                        enabled = viewModel.email.isNotBlank() && viewModel.password.isNotBlank(),
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
                            .padding(top = 36.dp)
                            .height(48.dp),
                        shape = RoundedCornerShape(24.dp)
                    ) {
                        Text(text = stringResource(R.string.login_sign_in), fontSize = 24.sp)
                    }
                }
            }
        }
    }
}

@Preview(showSystemUi = true, apiLevel = 34)
@Composable
fun LoginScreenPreview() {
    LoginScreen()
}




