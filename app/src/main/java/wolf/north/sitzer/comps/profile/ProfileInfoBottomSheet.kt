package wolf.north.sitzer.comps.profile

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import wolf.north.sitzer.R
import wolf.north.sitzer.mvvm.viewmodel.ProfileScreenViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileInfoBottomSheet(
    viewModel: ProfileScreenViewModel,
    onDismiss: () -> Unit
) {
    val uiState by viewModel.uiState.collectAsState()

    //Password visibility state holder


    val context = LocalContext.current
    val pickImageLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        uri?.let { viewModel.setAvatar(it) }
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp, horizontal = 16.dp)
    ) {
        // Header
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = onDismiss) {
                Icon(
                    Icons.Default.Close,
                    contentDescription = "Close",
                    tint = MaterialTheme.colorScheme.onSurface
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            Text("Profile Info", style = MaterialTheme.typography.titleLarge)
            Spacer(modifier = Modifier.weight(1f))
            Box(modifier = Modifier.size(48.dp))
        }

        Spacer(modifier = Modifier.height(12.dp))

        // Avatar
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ) {
            val avatarPainter = uiState.avatarUri?.let { rememberAsyncImagePainter(it) }
                ?: rememberAsyncImagePainter(R.drawable.pfpp)

            Image(
                painter = avatarPainter,
                contentDescription = "Profile photo",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(104.dp)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.surfaceVariant)
                    .clickable { pickImageLauncher.launch("image/*") }
            )

            TextButton(onClick = { pickImageLauncher.launch("image/*") }) {
                Text("Change photo")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        //Username
        OutlinedTextField(
            value = uiState.username,
            onValueChange = { viewModel.onUsernameChange(it) },
            modifier = Modifier.fillMaxWidth(),
            label = { Text("Username") },
            placeholder = { Text("Your name") },
            singleLine = true,
            enabled = uiState.isEditingUsername,
            trailingIcon = {
                IconButton(onClick = { viewModel.toggleEditUsername() }) {
                    Icon(
                        imageVector = if (uiState.isEditingUsername) Icons.Default.Check else Icons.Default.Edit,
                        contentDescription = if (uiState.isEditingUsername) "Save" else "Edit"
                    )
                }
            },
            colors = OutlinedTextFieldDefaults.colors(
                disabledTextColor = MaterialTheme.colorScheme.onSurface,
                disabledBorderColor = MaterialTheme.colorScheme.outline.copy(alpha = 0.5f),
                disabledLabelColor = MaterialTheme.colorScheme.onSurfaceVariant
            )
        )

        Spacer(modifier = Modifier.height(12.dp))

        //Email
        OutlinedTextField(
            value = uiState.email,
            onValueChange = { viewModel.onEmailChange(it) },
            modifier = Modifier.fillMaxWidth(),
            label = { Text("Email") },
            placeholder = { Text("no-email@example.com") },
            singleLine = true,
            enabled = uiState.isEditingEmail,
            trailingIcon = {
                IconButton(onClick = { viewModel.toggleEditEmail() }) {
                    Icon(
                        imageVector = if (uiState.isEditingEmail) Icons.Default.Check else Icons.Default.Edit,
                        contentDescription = if (uiState.isEditingEmail) "Save" else "Edit"
                    )
                }
            },
            isError = uiState.isEditingEmail && uiState.email.isNotEmpty() &&
                    !android.util.Patterns.EMAIL_ADDRESS.matcher(uiState.email).matches(),
            colors = OutlinedTextFieldDefaults.colors(
                disabledTextColor = MaterialTheme.colorScheme.onSurface,
                disabledBorderColor = MaterialTheme.colorScheme.outline.copy(alpha = 0.5f),
                disabledLabelColor = MaterialTheme.colorScheme.onSurfaceVariant
            )
        )

        Spacer(modifier = Modifier.height(12.dp))

        //Password
        if (uiState.isEditingPassword) {
            // New password
            OutlinedTextField(
                value = uiState.newPassword,
                onValueChange = { viewModel.onNewPasswordChange(it) },
                modifier = Modifier.fillMaxWidth(),
                label = { Text("New password") },
                singleLine = true,
                visualTransformation = if (viewModel.passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    IconButton(onClick = { viewModel.toggleEditPassword() }) {
                        Icon(
                            imageVector = Icons.Default.Close,
                            contentDescription = "Cancel editing"
                        )
                    }
                }
            )

            Spacer(modifier = Modifier.height(12.dp))

            // Confirm password
            OutlinedTextField(
                value = uiState.confirmPassword,
                onValueChange = { viewModel.onConfirmPasswordChange(it) },
                modifier = Modifier.fillMaxWidth(),
                label = { Text("Confirm password") },
                singleLine = true,
                visualTransformation = if (viewModel.passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
                isError = uiState.newPassword != uiState.confirmPassword && uiState.confirmPassword.isNotEmpty(),
                trailingIcon = {
                    IconButton(onClick = { viewModel.togglePasswordVisibility() }) {
                        Icon(
                            imageVector = if (viewModel.passwordVisibility) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                            contentDescription = if (viewModel.passwordVisibility) "Hide password" else "Show password",
                            modifier = Modifier.clickable {
                                viewModel.togglePasswordVisibility()
                            }
                        )
                    }
                },
                supportingText = if (uiState.newPassword != uiState.confirmPassword && uiState.confirmPassword.isNotEmpty()) {
                    { Text("Passwords don't match") }
                } else null
            )
        } else {
            // Password field (disabled)
            OutlinedTextField(
                value = "••••••••",
                onValueChange = {},
                modifier = Modifier.fillMaxWidth(),
                label = { Text("Password") },
                singleLine = true,
                enabled = false,
                visualTransformation = if (viewModel.passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    Row {
                        IconButton(onClick = { viewModel.toggleEditPassword() }) {
                            Icon(
                                imageVector = Icons.Default.Edit,
                                contentDescription = "Edit password"
                            )
                        }
                    }
                },
                colors = OutlinedTextFieldDefaults.colors(
                    disabledTextColor = MaterialTheme.colorScheme.onSurface,
                    disabledBorderColor = MaterialTheme.colorScheme.outline.copy(alpha = 0.5f),
                    disabledLabelColor = MaterialTheme.colorScheme.onSurfaceVariant
                )
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Error message
        uiState.errorMessage?.let {
            Text(it, color = MaterialTheme.colorScheme.error)
            Spacer(modifier = Modifier.height(8.dp))
        }

        // Action buttons
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            OutlinedButton(
                onClick = onDismiss,
                modifier = Modifier.weight(1f)
            ) {
                Text("Cancel")
            }

            Button(
                onClick = {
                    viewModel.onSubmitChanges { success, msg ->
                        // handle result
                    }
                },
                enabled = viewModel.canSubmitChanges(),
                modifier = Modifier.weight(1f)
            ) {
                if (uiState.isLoading) {
                    CircularProgressIndicator(
                        modifier = Modifier.size(18.dp),
                        strokeWidth = 2.dp,
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                    Spacer(Modifier.width(8.dp))
                }
                Text("Change")
            }
        }
    }
}