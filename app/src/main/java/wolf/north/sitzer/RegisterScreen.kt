import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Key
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Password
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import wolf.north.sitzer.R
import wolf.north.sitzer.comps.GoogleButton

/*
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Create your account",
                        fontSize = 24.sp,
                        color = Color.Black,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.SemiBold
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { */
/* Navigate back *//*
 }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.White,
                    titleContentColor = Color.Black
                )
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top // Zmieniono na Top, by umieścić formularz wyżej
        ) {
            var firstName by remember { mutableStateOf("") }
            var email by remember { mutableStateOf("") }
            var password by remember { mutableStateOf("") }
            var confirmPassword by remember { mutableStateOf("") }

            // Zastosowanie OutlinedTextField z poprawnymi labelami
            Column(modifier = Modifier.padding(start = 8.dp, end = 8.dp)) {
                OutlinedTextField(
                    leadingIcon = {
                        Icon(Icons.Default.Person, contentDescription = null)
                    },
                    value = firstName,
                    onValueChange = { firstName = it },
                    label = { Text(text = "First Name") },
                    placeholder = { Text(text = "Enter your first name") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 12.dp)
                )


                OutlinedTextField(
                    value = email,
                    leadingIcon = {
                        Icon(Icons.Default.Email, contentDescription = null)
                    },
                    onValueChange = { email = it },
                    label = { Text(text = "Email") },
                    placeholder = { Text(text = "Enter your email") },
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
                        Icon(Icons.Default.VisibilityOff, contentDescription = null)
                    },
                    value = password,
                    onValueChange = { password = it },
                    label = { Text(text = "Password") },
                    placeholder = { Text(text = "Enter your password") },
                    visualTransformation = PasswordVisualTransformation(),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 12.dp),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
                )

                OutlinedTextField(
                    leadingIcon = {
                        Icon(Icons.Default.Close, contentDescription = null)
                    },
                    value = confirmPassword,
                    onValueChange = { confirmPassword = it },
                    label = { Text(text = "Confirm Password") },
                    placeholder = { Text(text = "Confirm your password") },
                    visualTransformation = PasswordVisualTransformation(),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 24.dp),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
                )
            }

            // Użycie ElevatedButton z poprzedniego ekranu
            // Przycisk logowania
            ElevatedButton(
                onClick = { */
/* Action *//*
 },
                colors = ButtonDefaults.buttonColors(containerColor = colorResource(R.color.welcome_screen_bg)),
                modifier = Modifier
                    .fillMaxWidth(0.5f) // Zmniejszenie szerokości przycisku
                    .padding(top = 8.dp)
                    .height(48.dp),
                shape = RoundedCornerShape(24.dp) // Zaokrąglone krawędzie
            ) {
                Text(text = "Register", fontSize = 20.sp)
            }
        }
    }
}
*/


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
                            text = "Mobile Application Register Site",
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

                var firstName by remember { mutableStateOf("") }
                var email by remember { mutableStateOf("") }
                var password by remember { mutableStateOf("") }
                var confirmPassword by remember { mutableStateOf("") }


                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = "Register new account",
                        fontSize = 30.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(bottom = 32.dp)
                    )
                    // Zastosowanie OutlinedTextField z poprawnymi labelami
                    Column(modifier = Modifier.padding(start = 8.dp, end = 8.dp)) {
                        OutlinedTextField(
                            leadingIcon = {
                                Icon(Icons.Default.Person, contentDescription = null)
                            },
                            value = firstName,
                            onValueChange = { firstName = it },
                            label = { Text(text = "First Name") },
                            placeholder = { Text(text = "Enter your first name") },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 12.dp)
                        )


                        OutlinedTextField(
                            value = email,
                            leadingIcon = {
                                Icon(Icons.Default.Email, contentDescription = null)
                            },
                            onValueChange = { email = it },
                            label = { Text(text = "Email") },
                            placeholder = { Text(text = "Enter your email") },
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
                                Icon(Icons.Default.VisibilityOff, contentDescription = null)
                            },
                            value = password,
                            onValueChange = { password = it },
                            label = { Text(text = "Password") },
                            placeholder = { Text(text = "Enter your password") },
                            visualTransformation = PasswordVisualTransformation(),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 12.dp),
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
                        )

                        OutlinedTextField(
                            leadingIcon = {
                                Icon(Icons.Default.Close, contentDescription = null)
                            },
                            value = confirmPassword,
                            onValueChange = { confirmPassword = it },
                            label = { Text(text = "Confirm Password") },
                            placeholder = { Text(text = "Confirm your password") },
                            visualTransformation = PasswordVisualTransformation(),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 24.dp),
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
                        )

                        ElevatedButton(
                            onClick = {},
                            colors = ButtonDefaults.buttonColors(containerColor = colorResource(R.color.welcome_screen_bg)),
                            modifier = Modifier
                                .fillMaxWidth(0.5f) // Zmniejszenie szerokości przycisku
                                .padding(top = 8.dp)
                                .height(48.dp).align(Alignment.CenterHorizontally),
                            shape = RoundedCornerShape(24.dp) // Zaokrąglone krawędzie
                        ) {
                            Text(text = "Register", fontSize = 20.sp)
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
    LoginScreen()
}
