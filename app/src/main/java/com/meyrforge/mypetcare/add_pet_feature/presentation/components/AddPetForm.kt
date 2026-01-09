package com.meyrforge.mypetcare.add_pet_feature.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.Note
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.rounded.Badge
import androidx.compose.material.icons.rounded.Pets
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.meyrforge.mypetcare.add_pet_feature.presentation.AddPetViewModel
import com.meyrforge.mypetcare.add_pet_feature.presentation.utils.SpeciesProvider
import com.meyrforge.mypetcare.ui.theme.lightBlue
import com.meyrforge.mypetcare.ui.theme.mainColor
import com.meyrforge.mypetcare.ui.theme.secondaryColor

@Preview
@Composable
fun AddPetForm(viewModel: AddPetViewModel = hiltViewModel()) {
    val name by viewModel.petName

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
            Icon(Icons.Rounded.Badge, "Nombre de la mascota", tint = lightBlue)
            Text(
                "Nombre de la mascota",
                style = MaterialTheme.typography.bodyLarge,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = lightBlue,
                modifier = Modifier.padding(start = 8.dp)
            )
        }
        TextField(
            name,
            {viewModel.onPetNameChange(it)},
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            label = { Text("Nombre de la mascota") },
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
            Icon(Icons.Rounded.Pets, "Especie", tint = lightBlue)
            Text(
                "Especie",
                style = MaterialTheme.typography.bodyLarge,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = lightBlue,
                modifier = Modifier.padding(start = 8.dp)
            )
        }
        SpeciesDropdown()
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.Start
        ) {
            Icon(Icons.AutoMirrored.Rounded.Note, "Notas", tint = lightBlue)
            Text(
                "Notas (opcional)",
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
                .heightIn(min = 120.dp)
                .padding(bottom = 16.dp),
            label = { Text("Notas sobre la mascota") },
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = lightBlue,
                focusedContainerColor = lightBlue,
                unfocusedLabelColor = secondaryColor.copy(alpha = 0.5f),
                focusedLabelColor = secondaryColor,
                unfocusedIndicatorColor = lightBlue,
                focusedIndicatorColor = lightBlue
            )
        )
        Text(
            "Ejemplo: 'No se acerca a desconocidos', 'Le gusta dormir en el sillón'",
            style = MaterialTheme.typography.labelMedium,
            color = lightBlue
        )
    }
}

@Composable
fun SpeciesDropdown(viewModel: AddPetViewModel = hiltViewModel()) {
    val isDropDownExpanded = remember { mutableStateOf(false) }
    val itemPosition = remember { mutableIntStateOf(0) }
    val species = SpeciesProvider.speciesTranslated
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .padding(bottom = 16.dp)
                .background(
                    lightBlue,
                    RoundedCornerShape(5.dp)
                )
                .padding(10.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { isDropDownExpanded.value = true }
            ) {
                Row {
                    Text(
                        species[itemPosition.intValue].first,
                        color = secondaryColor.copy(alpha = 0.5f),
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold,
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
                Icon(
                    Icons.Filled.ArrowDropDown,
                    "Desplegar",
                    tint = secondaryColor,
                    modifier = Modifier.size(24.dp)
                )
            }
            DropdownMenu(
                modifier = Modifier.fillMaxWidth(),
                containerColor = lightBlue,
                expanded = isDropDownExpanded.value,
                onDismissRequest = { isDropDownExpanded.value = false }
            ) {
                species.forEachIndexed { index, especie ->
                    DropdownMenuItem(
                        text = {
                            Text(
                                especie.first,
                                color = mainColor,
                                style = MaterialTheme.typography.bodyLarge
                            )
                        },
                        onClick = {
                            itemPosition.intValue = index
                            isDropDownExpanded.value = false
                            viewModel.onSpeciesChange(especie.second)
                        }
                    )
                }
            }
        }
    }
}