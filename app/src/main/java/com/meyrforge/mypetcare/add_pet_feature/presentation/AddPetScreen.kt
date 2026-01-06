package com.meyrforge.mypetcare.add_pet_feature.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.meyrforge.mypetcare.add_pet_feature.presentation.components.AddPetForm
import com.meyrforge.mypetcare.add_pet_feature.presentation.components.EditPetPictureItem
import com.meyrforge.mypetcare.ui.theme.details
import com.meyrforge.mypetcare.ui.theme.lightBlue

@Composable
fun AddPetScreen() {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Icon(Icons.AutoMirrored.Rounded.ArrowBack, "Ir Atras", tint = lightBlue)
                Text(
                    "Agregar Mascota",
                    style = MaterialTheme.typography.displayLarge,
                    fontSize = 26.sp,
                    fontWeight = FontWeight.Bold,
                    color = lightBlue
                )
                Box() {}
            }

        }
        item { EditPetPictureItem() }
        item { AddPetForm() }
        item {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(22.dp),
                contentAlignment = Alignment.BottomCenter
            ) {
                FloatingActionButton(
                    {}, containerColor = details, contentColor = Color.White,
                    modifier = Modifier.fillMaxWidth(fraction = 0.8f)
                ) {
                    Text(
                        "Guardar",
                        style = MaterialTheme.typography.bodyLarge,
                        fontWeight = FontWeight.SemiBold
                    )

                }
            }
        }
    }
}