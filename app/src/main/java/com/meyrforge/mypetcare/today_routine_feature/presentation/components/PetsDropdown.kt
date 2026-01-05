package com.meyrforge.mypetcare.today_routine_feature.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.meyrforge.mypetcare.R
import com.meyrforge.mypetcare.ui.theme.background
import com.meyrforge.mypetcare.ui.theme.mainColor
import com.meyrforge.mypetcare.ui.theme.secondaryColor

@Preview
@Composable
fun PetsDrowpdown() {
    val isDropDownExpanded = remember { mutableStateOf(false) }
    val itemPosition = remember { mutableIntStateOf(0) }
    val pets = listOf("Pipa", "Rocco", "Willow")
    Row(
        modifier = Modifier,
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .background(
                    secondaryColor,
                    RoundedCornerShape(5.dp)
                )
                .padding(10.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth(fraction = 0.6f)
                    .clickable { isDropDownExpanded.value = true }
            ) {
                Row {
                    Image(
                        painterResource(R.drawable.nine),
                        "pet image",
                        modifier = Modifier.size(30.dp)
                    )
                    Text(
                        pets[itemPosition.intValue],
                        color = background,
                        fontSize = 24.sp,
                        style = MaterialTheme.typography.titleLarge
                    )
                }
                Icon(
                    Icons.Filled.ArrowDropDown,
                    "Desplegar",
                    tint = background,
                    modifier = Modifier.size(24.dp)
                )
            }
            DropdownMenu(
                containerColor = background,
                expanded = isDropDownExpanded.value,
                onDismissRequest = { isDropDownExpanded.value = false }
            ) {
                pets.forEachIndexed { index, pet ->
                    DropdownMenuItem(
                        leadingIcon = { Image(painterResource(R.drawable.four), "pet image", modifier = Modifier.size(30.dp)) },
                        text = { Text(pet, color = mainColor, style = MaterialTheme.typography.labelMedium) },
                        onClick = {
                            itemPosition.intValue = index
                            isDropDownExpanded.value = false
                        }
                    )
                }
            }
        }
    }
}