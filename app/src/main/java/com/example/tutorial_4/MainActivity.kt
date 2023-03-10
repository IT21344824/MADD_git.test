package com.example.tutorial_4

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import com.example.tutorial_4.model.FormDat
import com.example.tutorial_4.model.FormData
import com.example.tutorial_4.model.ValidationResult
import java.text.Normalizer.Form
import java.time.Year

class MainActivity : AppCompatActivity() {

    lateinit var editStudentID:EditText
    lateinit var spmYear: Spinner
    lateinit var spnSemester:Spinner
    lateinit var btnAgree:CheckBox
    lateinit var btnSubmit:Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        editStudentID=findViewById(R.id.inputId)
        spmYear=findViewById(R.id.spnYear)
        spnSemester=findViewById(R.id.spnSemester)
        btnAgree=findViewById(R.id.CheckAgree)
        btnSubmit=findViewById(R.id.btmSubmit)



    }
    fun displayAlert(title:String, message:String) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle(title)
        builder.setMessage(message)
        builder.setPositiveButton("OK") { dialog, which ->
            // Do something when the "OK" button is clicked
        }
        val dialog = builder.create()
        dialog.show()
    }


    override fun onResume() {
        super.onResume()

        private var count=0

            btnSubmit.setOnClickListener(View.OnClickListener {
            val myForm=FormDat(editStudentID.text.toString(),
            spmYear.selectedItem.toString(),
            spnSemester.selectedItem.toString(),
            btnAgree.isChecked)

            val studentIDValidation=myForm.validateStudentID()
            val yearValidation=myForm.validateYear()
            val semesterValidation=myForm.validateSemester()
            val agreeValidation=myForm.validateAgreement()


                when(studentIDValidation){
                    is ValidationResult.Valid->{//valid
                        count++
                    }
                    is ValidationResult.Invalid->{
                        editStudentID.error=studentIDValidation.errorMassage
                    }
                    is ValidationResult.Empty->{
                        editStudentID.error=studentIDValidation.errorMassage
                    }

                }

                when(yearValidation){
                    is ValidationResult.Valid->{//valid
                        count++
                    }
                    is ValidationResult.Invalid->{
                        val tv:TextView=spmYear.selectedView as TextView
                        tv.error=""
                        tv.text=yearValidation.errorMassage
                    }
                    is ValidationResult.Empty->{
                        val tv:TextView=spmYear.selectedView as TextView
                        tv.error=""
                        tv.text=yearValidation.errorMassage
                    }

                }


                when(semesterValidation){
                    is ValidationResult.Valid->{//valid
                        count++
                    }
                    is ValidationResult.Invalid->{
                        val tv:TextView=spnSemester.selectedView as TextView
                        tv.error=""
                        tv.text=semesterValidation.errorMassage
                    }
                    is ValidationResult.Empty->{
                        val tv:TextView=spnSemester.selectedView as TextView
                        tv.error=""
                        tv.text=semesterValidation.errorMassage
                    }

                }

                when(agreeValidation){
                    is ValidationResult.Valid->{//valid
                        count++
                    }
                    is ValidationResult.Invalid->{
                        displayAlert("error" , agreeValidation.errorMassage)
                    }
                    is ValidationResult.Empty->{
                        displayAlert("error" , agreeValidation.errorMassage)
                    }

                }


                if (count==4)
                {
                    displayAlert("success","you have succuesfully registered")

                    FormData(editStudentID.text.toString(),
                        Integer.parseInt(spmYear.selectedItem.toString()),
                        spnSemester.selectedItem.toString(),
                        btnAgree.isChecked

                    )
                }



            })
    }















}