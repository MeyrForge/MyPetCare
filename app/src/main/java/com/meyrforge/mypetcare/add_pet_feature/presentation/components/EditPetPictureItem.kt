package com.meyrforge.mypetcare.add_pet_feature.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Edit
import androidx.compose.material.icons.rounded.Pets
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.meyrforge.mypetcare.add_pet_feature.presentation.utils.BackgroundColorProvider
import com.meyrforge.mypetcare.add_pet_feature.presentation.utils.PetDataProvider
import com.meyrforge.mypetcare.ui.theme.details
import com.meyrforge.mypetcare.ui.theme.lightBlue
import com.meyrforge.mypetcare.ui.theme.secondaryColor


@Composable
fun EditPetPictureItem() {
    var openPicSelectionCard by remember { mutableStateOf(false) }
    Box(modifier = Modifier
        .padding(12.dp)
        .background(lightBlue, CircleShape)
        .padding(30.dp), contentAlignment = Alignment.Center) {
        Icon(Icons.Rounded.Pets, "Icono de Mascota", tint = secondaryColor.copy(alpha = 0.3f), modifier = Modifier.size(50.dp))
        Box(modifier = Modifier
            .offset(35.dp, 35.dp)
            .background(details, CircleShape)
            .padding(4.dp).clickable{
                openPicSelectionCard = true
            }) {
            Icon(Icons.Rounded.Edit, "Seleccionar Icono de Mascota", tint = Color.White)
        }
    }

    if(openPicSelectionCard){
        Dialog(onDismissRequest = { openPicSelectionCard = false }) {
            Column(modifier = Modifier.background(Color.White.copy(alpha = 0.9f))) {
                Text("Icono")
                LazyVerticalGrid(columns = GridCells.Fixed(3)) {
                    items(PetDataProvider.petPictures.size) {
                        Image(painterResource(PetDataProvider.petPictures[it].imageRes), "Mascota", modifier = Modifier.size(100.dp))
                    }
                }
                Text("Fondo")
                LazyVerticalGrid(GridCells.Fixed(3)) {
                    items(BackgroundColorProvider.backgroundColors.size){
                        Box(modifier = Modifier.padding(12.dp).size(80.dp).background(BackgroundColorProvider.backgroundColors[it].color, CircleShape))
                    }
                }
            }
        }
    }
}