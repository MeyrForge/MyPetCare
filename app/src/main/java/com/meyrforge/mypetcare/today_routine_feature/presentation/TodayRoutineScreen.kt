package com.meyrforge.mypetcare.today_routine_feature.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.CameraAlt
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import com.meyrforge.mypetcare.today_routine_feature.presentation.components.PetsDrowpdown
import com.meyrforge.mypetcare.today_routine_feature.presentation.components.SingleRoutineItem
import com.meyrforge.mypetcare.ui.theme.lightBlue
import com.meyrforge.mypetcare.ui.theme.details
import com.meyrforge.mypetcare.ui.theme.secondaryColor

@Preview(showBackground = true, backgroundColor = 0xFF252461)
@Composable
fun TodayRoutineScreen() {
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            "Hoy - Martes 3 de Febrero",
            style = MaterialTheme.typography.displayLarge,
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold,
            color = lightBlue,
            modifier = Modifier.padding(8.dp)
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(secondaryColor.copy(alpha = 0.3f))
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Box(modifier = Modifier) {
                PetsDrowpdown()
            }
            Button(
                {},
                colors = ButtonDefaults.buttonColors(
                    containerColor = details,
                    contentColor = Color.White
                ),
                shape = RoundedCornerShape(5.dp),
                modifier = Modifier.padding(start = 8.dp)
            ) {
                Text(
                    "Actualizar",
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
        LazyColumn(modifier = Modifier.padding(8.dp)) {
            item { SingleRoutineItem() }
            item { SingleRoutineItem() }
            item { SingleRoutineItem() }
            item { SingleRoutineItem() }

        }
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(22.dp),
        contentAlignment = Alignment.BottomCenter
    ) {
        FloatingActionButton({}, containerColor = details, contentColor = Color.White) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.padding(horizontal = 22.dp)
            ) {
                Icon(Icons.Rounded.CameraAlt, "Enviar Actualizacion")
                Text(
                    "Enviar Actualización",
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.padding(start = 8.dp)
                )
            }
        }
    }
}

