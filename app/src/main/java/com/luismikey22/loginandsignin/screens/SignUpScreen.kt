package com.luismikey22.loginandsignin.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.compose.runtime.*
import androidx.compose.ui.text.input.PasswordVisualTransformation
@Composable
fun SignInScreen(navController: NavController) {

    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var isFormValid by remember { mutableStateOf(false) }

    //validar formulario
    fun validateForm(): Boolean {
        val isNameValid = name.all { it.isLetter() }
        val isEmailValid = android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
        val isPhoneValid = phone.length == 10 && phone.all { it.isDigit() }
        val arePasswordsSame = password == confirmPassword

        return isNameValid && isEmailValid && isPhoneValid && arePasswordsSame
    }

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

            OutlinedTextField(
                value = name,
                onValueChange = {
                    name = it
                    isFormValid = validateForm()
                },
                label = { Text("Name") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(10.dp))

            OutlinedTextField(
                value = email,
                onValueChange = {
                    email = it
                    isFormValid = validateForm()
                },
                label = { Text("Email") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(10.dp))

            OutlinedTextField(
                value = password,
                onValueChange = {
                    password = it
                    isFormValid = validateForm()
                },
                label = { Text("Password") },
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(10.dp))

            OutlinedTextField(
                value = confirmPassword,
                onValueChange = {
                    confirmPassword = it
                    isFormValid = validateForm()
                },
                label = { Text("Confirm password") },
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(10.dp))

            OutlinedTextField(
                value = phone,
                onValueChange = {
                    phone = it
                    isFormValid = validateForm()
                },
                label = { Text("Phone") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(20.dp))

            // Botón de Sign Up
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(55.dp)
                    .clip(RoundedCornerShape(30.dp))
                    .background(if (isFormValid) Color(0xFF5E4AE3) else Color.Gray)
                    .clickable(enabled = isFormValid) {
                        if (isFormValid) navController.navigate("welcome")
                    },
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Sign Up", color = Color(0xFFFFFFE3), fontSize = 16.sp)
            }
        }
    }
}

@Composable
@Preview(showBackground = true, showSystemUi = false)
fun SignUpScreenPreview(){
    val navController = rememberNavController()
    SignInScreen(navController = navController)
}