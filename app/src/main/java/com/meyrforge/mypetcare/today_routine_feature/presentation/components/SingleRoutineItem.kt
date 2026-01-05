package com.meyrforge.mypetcare.today_routine_feature.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Check
import androidx.compose.material3.HorizontalDivider
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
import com.meyrforge.mypetcare.ui.theme.lightBlue
import com.meyrforge.mypetcare.ui.theme.green
import com.meyrforge.mypetcare.ui.theme.secondaryColor

@Preview(showBackground = true, backgroundColor = 0xFFFFEAE6)
@Composable
fun SingleRoutineItem() {
    Column(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .background(
                secondaryColor,
                RoundedCornerShape(10.dp)
            )
            .padding(12.dp)
    ) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.Top) {
            Text("08:00", color = lightBlue, style = MaterialTheme.typography.bodyLarge, fontWeight = FontWeight.Bold)
            Column(modifier = Modifier.padding(horizontal = 12.dp)) {
                Text("Dar de comer", color = lightBlue, style = MaterialTheme.typography.bodyLarge, fontWeight = FontWeight.Bold)
                Text("Una taza de alimento", color = lightBlue, style = MaterialTheme.typography.bodyMedium)
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                //Icon(Icons.Rounded.Check, contentDescription = "Realizado", tint = green)
                Text("Realizado", color = lightBlue, style = MaterialTheme.typography.bodyMedium)
                CustomCheckBox()
            }
        }
        HorizontalDivider(thickness = 2.dp, color = lightBlue.copy(alpha = 0.5f), modifier = Modifier.padding(vertical = 6.dp))
    }
}

@Composable
fun CustomCheckBox(checked: Boolean = true, onCheckedChange: () -> Unit = {}) {
    Box(
        modifier = Modifier
            .padding(4.dp)
            .size(30.dp)
            .background(if (checked) green else Color.Transparent, CircleShape)
            .border(2.dp, if (checked) Color.Transparent else Color.White, CircleShape)
            .clickable { onCheckedChange() },
        contentAlignment = Alignment.Center
    ) {
        if (checked)
            Icon(
                Icons.Rounded.Check,
                "Rutina Realizada",
                tint = Color.White,
                modifier = Modifier.size(26.dp)
            )
    }
}