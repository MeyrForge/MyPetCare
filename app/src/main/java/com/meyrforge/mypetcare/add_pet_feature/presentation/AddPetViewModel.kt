package com.meyrforge.mypetcare.add_pet_feature.presentation

import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.meyrforge.mypetcare.add_pet_feature.domain.usecases.AddPetUsecase
import com.meyrforge.mypetcare.add_pet_feature.presentation.utils.Species
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddPetViewModel @Inject constructor(private val addPetUsecase: AddPetUsecase) : ViewModel() {

    private val _petName = mutableStateOf("")
    var petName = _petName

    private val _species = mutableStateOf<Species?>(null)
    var species = _species

    private val _imageRes = mutableIntStateOf(0)
    var imageRes = _imageRes

    private val _backgroundColor = mutableStateOf("")
    var backgroundColor = _backgroundColor

    var message = mutableStateOf("")

    fun onPetNameChange(value: String) {
        _petName.value = value
    }

    fun onSpeciesChange(value: Species) {
        _species.value = value
    }

    fun onBackgroundColorChange(value: String) {
        _backgroundColor.value = value
    }

    fun onImageResChange(value: Int) {
        _imageRes.intValue = value
    }


    fun savePet() {
        if (_petName.value.isEmpty() || _species.value == null){
            message.value = "Por favor, llenar los campos obligatorios"
            return
        }else if (_imageRes.intValue == 0 || _backgroundColor.value == ""){
            message.value = "Por favor, seleccionar un ícono para la mascota"
            return
        }
        viewModelScope.launch {
            addPetUsecase(
                _petName.value,
                _species.value ?: Species.DOG,
                _imageRes.intValue,
                _backgroundColor.value
            )
        }
    }
}
