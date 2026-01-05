package com.meyrforge.mypetcare

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.meyrforge.mypetcare.today_routine_feature.presentation.TodayRoutineScreen
import com.meyrforge.mypetcare.ui.theme.MyPetCareTheme
import com.meyrforge.mypetcare.ui.theme.mainColor

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyPetCareTheme {
                Scaffold(modifier = Modifier.fillMaxSize(), containerColor = mainColor) { innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding)) {
                        TodayRoutineScreen()
                    }
                }
            }
        }
    }
}
