package com.meyrforge.mypetcare

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material.icons.rounded.Pets
import androidx.compose.material.icons.rounded.Today
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.meyrforge.mypetcare.add_pet_feature.presentation.AddPetScreen
import com.meyrforge.mypetcare.common.Screen
import com.meyrforge.mypetcare.today_routine_feature.presentation.TodayRoutineScreen
import com.meyrforge.mypetcare.ui.theme.MyPetCareTheme
import com.meyrforge.mypetcare.ui.theme.background
import com.meyrforge.mypetcare.ui.theme.details
import com.meyrforge.mypetcare.ui.theme.lightBlue
import com.meyrforge.mypetcare.ui.theme.secondaryColor
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyPetCareTheme {
                val navController = rememberNavController()

                val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
                val scope = rememberCoroutineScope()

                ModalNavigationDrawer(
                    drawerState = drawerState,
                    drawerContent = {
                        ModalDrawerSheetComponent(drawerState, scope)
                    }
                ) {
                    Scaffold(
                        modifier = Modifier.fillMaxSize(),
                        containerColor = background,
                        bottomBar = { NavigationBarComponent(navController = navController) },
                        topBar = {
                            TopBarComponent(onMenuClick = {
                                scope.launch { drawerState.open() }
                            })
                        }
                    ) { innerPadding ->
                        Box(modifier = Modifier.padding(innerPadding)) {
                            NavHost(
                                navController = navController,
                                startDestination = Screen.TodayRoutineScreen.route
                            ) {
                                composable(route = Screen.TodayRoutineScreen.route) {
                                    TodayRoutineScreen()
                                }
                                composable(route = Screen.AddPetScreen.route) {
                                    AddPetScreen()
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun NavigationBarComponent(navController: NavController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    NavigationBar(
        modifier = Modifier.clip(RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp)),
        containerColor = secondaryColor.copy(alpha = 0.3f)
    ) {
        val todayRoutineScreen = Screen.TodayRoutineScreen
        NavigationBarItem(
            icon = { Icon(Icons.Rounded.Today, "Pantalla de Rutina de Hoy") },
            selected = currentDestination?.hierarchy?.any { it.route == todayRoutineScreen.route } == true,
            onClick = {
                navController.navigate(todayRoutineScreen.route) {
                    popUpTo(navController.graph.findStartDestination().id) {
                        saveState = true
                    }
                    launchSingleTop = true
                    restoreState = true
                }
            },
            label = { Text("Rutina de Hoy", style = MaterialTheme.typography.bodyLarge) },
            colors = NavigationBarItemDefaults.colors(
                unselectedIconColor = lightBlue,
                unselectedTextColor = lightBlue,
                indicatorColor = Color.Transparent,
                selectedTextColor = details,
                selectedIconColor = details
            )
        )
        val addPetScreen = Screen.AddPetScreen
        NavigationBarItem(
            icon = { Icon(Icons.Rounded.Pets, "Pantalla de Agregar Mascota") },
            selected = currentDestination?.hierarchy?.any { it.route == addPetScreen.route } == true,
            onClick = {
                navController.navigate(addPetScreen.route) {
                    popUpTo(navController.graph.findStartDestination().id) {
                        saveState = true
                    }
                    launchSingleTop = true
                    restoreState = true
                }
            },
            label = { Text("Agregar Mascota", style = MaterialTheme.typography.bodyLarge) },
            colors = NavigationBarItemDefaults.colors(
                unselectedIconColor = lightBlue,
                unselectedTextColor = lightBlue,
                indicatorColor = Color.Transparent,
                selectedTextColor = details,
                selectedIconColor = details
            )
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarComponent(onMenuClick: () -> Unit) {
    TopAppBar(
        title = {
            Text(
                "MyPet Care",
                style = MaterialTheme.typography.displayLarge,
                fontWeight = FontWeight.Bold
            )
        },
        navigationIcon = {
            Icon(
                Icons.Rounded.Menu,
                "Abrir Menu",
                modifier = Modifier.clickable { onMenuClick() })
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = secondaryColor.copy(alpha = 0.3f),
            titleContentColor = lightBlue,
            navigationIconContentColor = lightBlue
        ),
        modifier = Modifier.padding(bottom = 16.dp)
    )
}

@Composable
fun ModalDrawerSheetComponent(drawerState: DrawerState, scope: CoroutineScope) {
    ModalDrawerSheet(drawerContainerColor = background, modifier = Modifier.fillMaxWidth(0.5f)) {
        Text(
            "Menú",
            modifier = Modifier.padding(16.dp),
            style = MaterialTheme.typography.headlineMedium,
            color = lightBlue
        )
        NavigationDrawerItem(
            label = { Text("Crear Mascota") },
            selected = false,
            onClick = { /* Acción aquí */ scope.launch { drawerState.close() } }
        )
        NavigationDrawerItem(
            label = { Text("Mascotas") },
            selected = false,
            onClick = { /* Acción aquí */ scope.launch { drawerState.close() } }
        )
    }
}