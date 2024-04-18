package com.example.proj_phase2.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.proj_phase2.data.entities.Login
import com.example.proj_phase2.data.repository.LoginRepository
import kotlinx.coroutines.launch

class LoginViewModel(private val loginRepository: LoginRepository) : ViewModel() {
    fun getLoginList(): List<Login> {
        var returnList: List<Login> = listOf()

        try {
            viewModelScope.launch {
                loginRepository.getAllLoginsStream().collect {
                    returnList = it
                }
            }
        }
        catch (e: Error) {
            return emptyList()
        }

        return returnList
    }
}