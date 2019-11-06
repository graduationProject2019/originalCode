package com.example.meatbowl.model

import com.google.firebase.database.Exclude
import com.google.firebase.database.IgnoreExtraProperties
import java.time.LocalDate

@IgnoreExtraProperties
data class Diet(
    var userId:String?="",
    var petName: String?="",
    var totalTerm:String?="",
    var activeType:String?="",
    var totalAmount:String?="",
    var mmAmount:String?="",
    var ebAmount:String?="",
    var orAmount:String?="",
    var plantAmount:String?="",
    var mmName:String?="",
    var ebName:String?="",
    var orName:String?="",
    var vgName:String?="",
    var frName:String?="",
    var otName:String?=""

){
    @Exclude
    fun toMap():Map<String,Any?>{
        return mapOf(
            "userId" to userId,
            "petName" to  petName,
            "totalTerm" to totalTerm,
            "activeType" to activeType,
            "totalAmount" to totalAmount,
            "mmAmount" to mmAmount,
            "ebAmount" to ebAmount,
            "orAmount" to orAmount,
            "plantAmount" to plantAmount,
            "mmName" to mmName,
            "ebName" to ebName,
            "orName" to orName,
            "vgName" to vgName,
            "frName" to frName,
            "otName" to otName

        )
    }
}