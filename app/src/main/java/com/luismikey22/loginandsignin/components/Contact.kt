package com.luismikey22.loginandsignin.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.luismikey22.loginandsignin.R

@Composable
fun Contact(name:String, phone:String){
    Row{
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = "Foto de contacto",
            modifier = Modifier.size(64.dp)
        )
        Spacer(modifier = Modifier.height(12.dp))
        Column {
            Text(name, fontSize = 30.sp, fontWeight = FontWeight.Bold)
            Text(phone, fontSize = 30.sp, fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
@Preview(showBackground = true, showSystemUi = false)
fun ContactPreview(){
    Contact("Luis", "6122170991")
}