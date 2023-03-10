package com.example.tutorial_4.model

sealed class ValidationResult{
    data class Empty (val errorMassage:String):ValidationResult()
    data class Invalid (val errorMassage:String):ValidationResult()
    object Valid:ValidationResult()












}
