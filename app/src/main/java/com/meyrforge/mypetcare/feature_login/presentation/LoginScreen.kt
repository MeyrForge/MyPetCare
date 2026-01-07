package com.meyrforge.mypetcare.feature_login.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Password
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.rounded.VisibilityOff
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.meyrforge.mypetcare.R
import com.meyrforge.mypetcare.common.Screen
import com.meyrforge.mypetcare.ui.theme.details
import com.meyrforge.mypetcare.ui.theme.lightBlue
import com.meyrforge.mypetcare.ui.theme.secondaryColor

@Composable
fun LoginScreen(navController: NavController) {
    LazyColumn(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        item {
            Image(painterResource(R.drawable.mypetcare_logo_square), "MyPet Care logo", modifier = Modifier.size(300.dp))
        }
        item {
            Column(
                modifier = Modifier
                    .padding(12.dp)
                    .fillMaxWidth()
                    .background(
                        secondaryColor.copy(alpha = 0.6f),
                        RoundedCornerShape(10.dp)
                    )
                    .padding(12.dp), horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    horizontalArrangement = Arrangement.Start
                ) {
                    Icon(Icons.Rounded.Person, "Especie", tint = lightBlue)
                    Text(
                        "Email",
                        style = MaterialTheme.typography.bodyLarge,
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                        color = lightBlue,
                        modifier = Modifier.padding(start = 8.dp)
                    )
                }
                TextField(
                    "",
                    {},
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp),
                    label = { Text("Email") },
                    colors = TextFieldDefaults.colors(
                        unfocusedContainerColor = lightBlue,
                        focusedContainerColor = lightBlue,
                        unfocusedLabelColor = secondaryColor.copy(alpha = 0.5f),
                        focusedLabelColor = secondaryColor,
                        unfocusedIndicatorColor = lightBlue,
                        focusedIndicatorColor = lightBlue
                    )
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    horizontalArrangement = Arrangement.Start
                ) {
                    Icon(Icons.Rounded.Password, "Especie", tint = lightBlue)
                    Text(
                        "Contrasenia",
                        style = MaterialTheme.typography.bodyLarge,
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                        color = lightBlue,
                        modifier = Modifier.padding(start = 8.dp)
                    )
                }
                TextField(
                    "",
                    {},
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp),
                    label = { Text("Contrasenia") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    trailingIcon = {Icon(Icons.Rounded.VisibilityOff, "Ocultar Contrasenia")},
                    colors = TextFieldDefaults.colors(
                        unfocusedContainerColor = lightBlue,
                        focusedContainerColor = lightBlue,
                        unfocusedLabelColor = secondaryColor.copy(alpha = 0.5f),
                        focusedLabelColor = secondaryColor,
                        unfocusedIndicatorColor = lightBlue,
                        focusedIndicatorColor = lightBlue
                    )
                )
            }
        }
        item {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(22.dp),
                contentAlignment = Alignment.BottomCenter
            ) {
                FloatingActionButton(
                    {navController.navigate(Screen.TodayRoutineScreen.route)}, containerColor = details, contentColor = Color.White,
                    modifier = Modifier.fillMaxWidth(fraction = 0.8f)
                ) {
                    Text(
                        "Iniciar Sesión",
                        style = MaterialTheme.typography.bodyLarge,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }
        }
    }
}