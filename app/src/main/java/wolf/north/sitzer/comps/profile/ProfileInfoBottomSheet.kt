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
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.PasswordVisualTransformation
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

    // image picker
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
        // header
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
            // placeholder so title is centered
            Box(modifier = Modifier.size(48.dp))
        }

        Spacer(modifier = Modifier.height(12.dp))

        // Avatar + change
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

        // Username row
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth()) {
            if (uiState.isEditingUsername) {
                TextField(
                    value = uiState.username,
                    onValueChange = { viewModel.onUsernameChange(it) },
                    modifier = Modifier.weight(1f),
                    singleLine = true,
                    label = { Text("Username") }
                )
            } else {
                Text(uiState.username.ifEmpty { "Your name" }, modifier = Modifier.weight(1f))
            }
            IconButton(onClick = { viewModel.toggleEditUsername() }) {
                Icon(imageVector = Icons.Default.Edit, contentDescription = "Edit username")
            }
        }

        // Email row
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth()) {
            if (uiState.isEditingEmail) {
                TextField(
                    value = uiState.email,
                    onValueChange = { viewModel.onEmailChange(it) },
                    modifier = Modifier.weight(1f),
                    singleLine = true,
                    label = { Text("Email") },
                    isError = uiState.email.isNotEmpty() && !android.util.Patterns.EMAIL_ADDRESS.matcher(
                        uiState.email
                    ).matches()
                )
            } else {
                Text(
                    uiState.email.ifEmpty { "no-email@example.com" },
                    modifier = Modifier.weight(1f)
                )
            }
            IconButton(onClick = { viewModel.toggleEditEmail() }) {
                Icon(imageVector = Icons.Default.Edit, contentDescription = "Edit email")
            }
        }

        // Password section (collapsed until edit)
        Spacer(modifier = Modifier.height(8.dp))
        Text("Password", style = MaterialTheme.typography.titleSmall)
        if (uiState.isEditingPassword) {
            OutlinedTextField(
                value = uiState.newPassword,
                onValueChange = { viewModel.onNewPasswordChange(it) },
                modifier = Modifier.fillMaxWidth(),
                label = { Text("New password") },
                visualTransformation = PasswordVisualTransformation()
            )
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(
                value = uiState.confirmPassword,
                onValueChange = { viewModel.onConfirmPasswordChange(it) },
                modifier = Modifier.fillMaxWidth(),
                label = { Text("Confirm password") },
                visualTransformation = PasswordVisualTransformation(),
                isError = uiState.newPassword != uiState.confirmPassword && uiState.confirmPassword.isNotEmpty()
            )
        } else {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("••••••••", modifier = Modifier.weight(1f))
                IconButton(onClick = { viewModel.toggleEditPassword() }) {
                    Icon(imageVector = Icons.Default.Edit, contentDescription = "Edit password")
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Error message
        uiState.errorMessage?.let {
            Text(it, color = MaterialTheme.colorScheme.error)
            Spacer(modifier = Modifier.height(8.dp))
        }

        // Action buttons
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            OutlinedButton(onClick = { /* optional: reset fields to original */ }) {
                Text("Cancel")
            }

            Button(
                onClick = {
                    viewModel.onSubmitChanges { success, msg ->
                        // handle result (toast/snackbar)
                    }
                },
                enabled = viewModel.canSubmitChanges()
            ) {
                if (uiState.isLoading) {
                    CircularProgressIndicator(modifier = Modifier.size(18.dp), strokeWidth = 2.dp)
                    Spacer(Modifier.width(8.dp))
                }
                Text("Change")
            }
        }
    }
}
