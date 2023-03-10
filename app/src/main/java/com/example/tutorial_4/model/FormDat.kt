package com.example.tutorial_4.model

class FormDat(private var studentID:String
                ,private var year:String
              ,private var semester:String
              ,private var agreement:Boolean,) {


    fun validateStudentID():ValidationResult {
        return if (studentID.isEmpty()) {
            ValidationResult.Empty("student ID is Empty")
        } else if (!studentID.startsWith("IT")) {
            ValidationResult.Invalid("should be start with : IT")
        } else if (studentID.length < 10 || studentID.length != 10) {
            ValidationResult.Invalid("must be 10 chatacters")
        } else {
            ValidationResult.Valid
        }
    }

    fun validateYear():ValidationResult{

        return if (year.isEmpty()){
            ValidationResult.Empty("year is empty")
        } else {
            ValidationResult.Valid
        }
    }

    fun validateSemester():ValidationResult{

        return if (semester.isEmpty()){
            ValidationResult.Empty("semester is empty")
        } else {
            ValidationResult.Valid
        }
    }

    fun validateAgreement():ValidationResult{
        return if (!agreement){
            ValidationResult.Invalid("must agree for the terms and")
        } else {
            ValidationResult.Valid
        }

    }


}