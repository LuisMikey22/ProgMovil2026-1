package com.luismikey22.loginandsignin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.BlendMode.Companion.Color
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.compose.material3.MaterialTheme
import com.luismikey22.loginandsignin.ui.theme.LoginAndSignInTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LoginAndSignInTheme {
                val navController = rememberNavController()
                MainNavigation(navController)
            }
        }
    }
}

@Composable
fun MainNavigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "welcome") {
        composable("welcome") { WelcomeScreen(navController) }
        composable("login") { LoginScreen(navController) }
        composable("register") { SignInScreen(navController) }
    }
}

@Composable
fun WelcomeScreen(navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF5E4AE3)),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .clip(RoundedCornerShape(40.dp))
                .background(Color(0xFFFFFFE3))
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.greetingandroid),
                contentDescription = null,
                modifier = Modifier.height(220.dp)
            )

            Spacer(modifier = Modifier.height(20.dp))
            Text("Hello", fontSize = 28.sp, fontWeight = FontWeight.Bold, color = Color(0x000000E3))
            Spacer(modifier = Modifier.height(8.dp))
            Text("Welcome To Little Drop, where you manage your daily tasks", fontSize = 14.sp,
                fontWeight = FontWeight.Bold, color = Color(0x404040E2))
            Spacer(modifier = Modifier.height(30.dp))

            // Botón de Login
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(55.dp)
                    .clip(RoundedCornerShape(30.dp))
                    .background(Color(0xFF5E4AE3))
                    .clickable { navController.navigate("login") },
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Login", color = Color(0xFFFFFFE3), fontSize = 16.sp)
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Botón de Sign Up
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(55.dp)
                    .clip(RoundedCornerShape(30.dp))
                    .border(BorderStroke(2.dp, Color(0xFF5E4AE3)), shape = RoundedCornerShape(30.dp))
                    .background(Color(0xFFFFFFE3))
                    .clickable { navController.navigate("register") },
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Sign Up", color = Color(0xFF5E4AE3), fontSize = 16.sp)
            }

            Spacer(modifier = Modifier.height(30.dp))

            Text("Sign up using", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = Color(0x404040E3))
            Spacer(modifier = Modifier.height(16.dp))

            SocialMediaButtons()
            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WelcomeScreenPreview() {
    LoginAndSignInTheme {
        WelcomeScreen(rememberNavController())
    }
}

@Composable
fun SocialMediaButtons() {
    Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
        SocialMediaButton("f", Color(0xFF3b5998))
        SocialMediaButton("G+", Color(0xFFDB4437))
        SocialMediaButton("in", Color(0xFF0A66C2))
    }
}

@Composable
fun SocialMediaButton(text: String, backgroundColor: Color) {
    Box(
        modifier = Modifier
            .size(40.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(backgroundColor),
        contentAlignment = Alignment.Center
    ) {
        Text(text = text, color = Color(0xFFFFFFE3))
    }
}

@Composable
fun LoginScreen(navController: NavHostController) {
    Box(
        modifier = Modifier.fillMaxSize().background(Color(0xFF5E4AE3)),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .clip(RoundedCornerShape(40.dp))
                .background(Color(0xFFFFFFE3))
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(painter = painterResource(id = R.drawable.signinandroid), contentDescription = null, modifier = Modifier.height(220.dp))
            Text("Login", fontSize = 30.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(20.dp))
            InputField("User")
            Spacer(modifier = Modifier.height(10.dp))
            InputField("Password")
            Spacer(modifier = Modifier.height(20.dp))

            // Botón de Login
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(55.dp)
                    .clip(RoundedCornerShape(30.dp))
                    .background(Color(0xFF5E4AE3))
                    .clickable { navController.navigate("welcome") },
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Login", color = Color(0xFFFFFFE3), fontSize = 16.sp)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    LoginAndSignInTheme {
        LoginScreen(rememberNavController())
    }
}

@Composable
fun InputField(label: String) {
    OutlinedTextField(
        value = "",
        onValueChange = {},
        label = { Text(label) },
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun SignInScreen(navController: NavHostController) {
    Box(
        modifier = Modifier.fillMaxSize().background(Color(0xFF5E4AE3)),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .clip(RoundedCornerShape(40.dp))
                .background(Color(0xFFFFFFE3))
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Sign In", fontSize = 30.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(20.dp))
            InputField("User")
            Spacer(modifier = Modifier.height(10.dp))
            InputField("Email")
            Spacer(modifier = Modifier.height(10.dp))
            InputField("Password")
            Spacer(modifier = Modifier.height(10.dp))
            InputField("Confirm Password")
            Spacer(modifier = Modifier.height(10.dp))
            InputField("Phone")
            Spacer(modifier = Modifier.height(20.dp))

            // Botón de Sign Up
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(55.dp)
                    .clip(RoundedCornerShape(30.dp))
                    .background(Color(0xFF5E4AE3))
                    .clickable { navController.navigate("welcome") },
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Sign Up", color = Color(0xFFFFFFE3), fontSize = 16.sp)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SignInScreenPreview() {
    LoginAndSignInTheme {
        SignInScreen(rememberNavController())
    }
}
