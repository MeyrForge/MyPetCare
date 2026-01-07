package com.meyrforge.mypetcare.common

sealed class Screen(val route: String){
    object TodayRoutineScreen: Screen("today_routine_screen")
    object AddRoutineScreen: Screen("add_routine_screen")
    object AddPetScreen: Screen("add_pet_screen")
    object LoginScreen: Screen("login_screen")
}
