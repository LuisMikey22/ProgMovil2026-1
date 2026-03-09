package com.luismikey22.loginandsignin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.luismikey22.loginandsignin.navigation.AppNavigation
import com.luismikey22.loginandsignin.ui.theme.LoginAndSignInTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LoginAndSignInTheme {
                AppNavigation()
            }
        }
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
fun InputField(label: String) {
    OutlinedTextField(
        value = "",
        onValueChange = {},
        label = { Text(label) },
        modifier = Modifier.fillMaxWidth()
    )
}
