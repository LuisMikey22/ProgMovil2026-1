package com.luismikey22.loginandsignin.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.luismikey22.loginandsignin.R
import com.luismikey22.loginandsignin.SocialMediaButtons

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

            Button(
                onClick = {
                    navController.navigate("login")
                }
            ){
                Text(text = "Login", color = Color(0xFFFFFFE3), fontSize = 16.sp)
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    navController.navigate("signup")
                }
            ) {
                Text(text = "Sign Up", color = Color(0xFFFFFFE3), fontSize = 16.sp)
            }

            Spacer(modifier = Modifier.height(30.dp))

            Text("Sign up using", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = Color(0x404040E3))
            Spacer(modifier = Modifier.height(16.dp))

            SocialMediaButtons()
            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}

@Composable
@Preview(showBackground = true, showSystemUi = false)
fun WelcomeScreenPreview(){
    val navController = rememberNavController()
    WelcomeScreen(navController = navController)
}

