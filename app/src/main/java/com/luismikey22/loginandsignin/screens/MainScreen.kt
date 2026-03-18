package com.luismikey22.loginandsignin.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.luismikey22.loginandsignin.components.Contact

@Composable
fun MainScreen(navController: NavController){
    var name by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }

    var contactsList = remember { mutableStateListOf<Pair<String, String>>() }
    //val contacts = listOf(Pair("Luis", "612170991"), Pair("Martin", "612175564"))

    Column(
        modifier = Modifier
            .fillMaxWidth(0.9f)
            .clip(RoundedCornerShape(40.dp))
            .background(Color(0xFFFFFFE3))
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Name") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = phone,
            onValueChange = { phone = it },
            label = { Text("Phone") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(10.dp))

        // Botón de agregar contacto
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp)
                .clip(RoundedCornerShape(30.dp))
                .background(Color(0xFF5E4AE3))
                .clickable {
                    if(name.isNotBlank() && phone.isNotBlank()) {
                        contactsList.add(Pair(name, phone))
                        name = ""
                        phone = ""
                    }
                },
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Agregar Contacto", color = Color(0xFFFFFFE3), fontSize = 16.sp)
        }

        // Botón de limpiar campos
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp)
                .clip(RoundedCornerShape(30.dp))
                .background(Color.Gray)
                .clickable {
                    name = ""
                    phone = ""
                },
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Limpiar Campos", color = Color(0xFFFFFFE3), fontSize = 16.sp)
        }

        Spacer(modifier = Modifier.height(10.dp))

        LazyColumn {
            items(contactsList) { contact ->
                Contact(name = contact.first, phone = contact.second)
            }
        }
    }
}

@Composable
@Preview(showBackground = true, showSystemUi = false)
fun MainScreenPreview(){
    val navController = rememberNavController()
    MainScreen(navController)
}