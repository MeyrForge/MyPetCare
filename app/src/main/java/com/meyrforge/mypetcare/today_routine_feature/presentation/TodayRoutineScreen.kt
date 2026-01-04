package com.meyrforge.mypetcare.today_routine_feature.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import com.meyrforge.mypetcare.ui.theme.background
import com.meyrforge.mypetcare.ui.theme.details
import com.meyrforge.mypetcare.ui.theme.mainColor
import com.meyrforge.mypetcare.ui.theme.secondaryColor

@Preview(showBackground = true, backgroundColor = 0xFFBDC7F1)
@Composable
fun TodayRoutineScreen() {
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            "Hoy - Martes 3 de Febrero",
            style = MaterialTheme.typography.displayLarge,
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold,
            color = secondaryColor,
            modifier = Modifier.padding(8.dp)
        )
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(horizontal = 6.dp)) {
            PetsDrowpdown()
            Button(
                {},
                colors = ButtonDefaults.buttonColors(
                    containerColor = details,
                    contentColor = Color.White
                ),
                shape = RoundedCornerShape(5.dp),
                modifier = Modifier.padding(end = 6.dp)
            ) { Text("Actualizar",
                style = MaterialTheme.typography.bodyLarge)}
        }
    }
}

