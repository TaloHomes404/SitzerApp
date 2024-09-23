package wolf.north.sitzer

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Key
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import wolf.north.sitzer.comps.GoogleButton
import wolf.north.sitzer.ui.theme.SitzerTheme


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen() {
    Scaffold(
        topBar = {
            Column {
                // Pierwszy biały pasek z napisem "Coffee"
                TopAppBar(
                    title = {
                        Text(text = "Posture Training", fontSize = 28.sp, color = Color.Black)
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = Color.White
                    )
                )
                // Czarny pasek z napisem "house"
                TopAppBar(
                    title = {
                        Text(
                            text = "Mobile Application Login Site",
                            fontSize = 20.sp,
                            color = Color.White
                        )
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = colorResource(R.color.welcome_screen_bg)
                    )
                )
            }
        }
    ) { paddingValues ->
        // Layout contentu

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues) // Dodaj padding do layoutu
                .background(colorResource(R.color.welcome_screen_bg)), // Białe tło z lekkim odcieniem
            horizontalAlignment = Alignment.CenterHorizontally,

            ) {
            var email by remember { mutableStateOf("") }
            var password by remember { mutableStateOf("") }


            Spacer(modifier = Modifier.height(16.dp))
            // Container na białym tle z zaokrąglonymi rogami
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .clip(
                        RoundedCornerShape(
                            topStart = 80.dp,
                            topEnd = 80.dp,
                            bottomEnd = 0.dp,
                            bottomStart = 0.dp
                        )
                    )
                    .background(Color.White)
                    .padding(16.dp)
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = "Login",
                        fontSize = 30.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(bottom = 32.dp)
                    )

                    // Pola tekstowe
                    OutlinedTextField(
                        value = email,
                        onValueChange = { email = it },
                        leadingIcon = {
                            Icon(Icons.Default.Email, contentDescription = null)
                        },
                        label = { Text(text = "Email") },
                        placeholder = { Text(text = "abc@gmail.com") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 16.dp)
                    )

                    OutlinedTextField(
                        value = password,
                        onValueChange = { password = it },
                        leadingIcon = {
                            Icon(Icons.Default.Key, contentDescription = null)
                        },
                        trailingIcon = {
                            Icon(Icons.Default.VisibilityOff, contentDescription = null)
                        },
                        label = { Text(text = "Password") },
                        placeholder = { Text(text = "*******") },
                        visualTransformation = PasswordVisualTransformation(),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 16.dp)
                    )

                    // Linki pod formularzem
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(text = "Forgot password?", color = Color.Gray)
                        Text(text = "Create an account", color = Color.Gray)
                    }

                    // Przycisk logowania
                    ElevatedButton(
                        onClick = { /* Action */ },
                        colors = ButtonDefaults.buttonColors(containerColor = colorResource(R.color.welcome_screen_bg)),
                        modifier = Modifier
                            .fillMaxWidth(0.5f) // Zmniejszenie szerokości przycisku
                            .padding(top = 36.dp)
                            .height(48.dp),
                        shape = RoundedCornerShape(24.dp) // Zaokrąglone krawędzie
                    ) {
                        Text(text = "Sign in", fontSize = 24.sp)
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 8.dp, bottom = 8.dp),
                        horizontalArrangement = Arrangement.Center
                    ) {
                    }
                    GoogleButton()
                }
            }
        }
    }
}


@Preview(showSystemUi = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen()
}
