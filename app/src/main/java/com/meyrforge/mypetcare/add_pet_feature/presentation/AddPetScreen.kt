package com.meyrforge.mypetcare.add_pet_feature.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.meyrforge.mypetcare.add_pet_feature.presentation.components.EditPetPictureItem

@Composable
fun AddPetScreen(){
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        EditPetPictureItem()
    }
}