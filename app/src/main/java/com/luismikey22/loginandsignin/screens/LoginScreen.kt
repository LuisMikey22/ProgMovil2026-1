package com.luismikey22.loginandsignin.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.luismikey22.loginandsignin.InputField
import com.luismikey22.loginandsignin.R

@Composable
fun LoginScreen(navController: NavController) {
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

@Composable
@Preview(showBackground = true, showSystemUi = false)
fun LoginScreenPreview(){
    val navController = rememberNavController()
    LoginScreen(navController = navController)
}