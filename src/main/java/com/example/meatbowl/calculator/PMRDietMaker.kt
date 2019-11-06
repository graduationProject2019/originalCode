package com.example.meatbowl.calculator

import android.icu.text.StringSearch
import com.example.meatbowl.database.Ingredients
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*
import kotlin.collections.ArrayList

object PMRDietMaker {

    val dailyIngredientAmount : MutableList<String>? = null

    //[Make List of Ingredient iCode]
    fun getRandomIngredientList(): MutableList<String> {
        val ingredientNameTable = mutableListOf<String>()

        var MMiCode = 0
        var EBiCode = 0
        var ORiCode = 0
        var VGiCode = 0
        var FRiCode = 0
        var OTiCode = 0


        MMiCode = getMMiCodeNumber()
        ingredientNameTable.add("MM"+MMiCode)
        EBiCode = getEBiCOdeNumber()
        ingredientNameTable.add("EB"+EBiCode)
        ORiCode = getORiCOdeNumber()
        ingredientNameTable.add("OR"+ORiCode)
        VGiCode = getVGiCOdeNumber()
        ingredientNameTable.add("VG"+VGiCode)
        FRiCode = getFRiCOdeNumber()
        ingredientNameTable.add("FR"+FRiCode)
        OTiCode = getOTiCOdeNumber()
        ingredientNameTable.add("OT"+OTiCode)

        return ingredientNameTable
    }

    //[Make Randome Number For Ingredient iCode]
    fun getMMiCodeNumber(): Int {
        return Random().nextInt(2) + 100
    }

    fun getEBiCOdeNumber(): Int {
        return Random().nextInt(2) + 200
    }

    fun getORiCOdeNumber(): Int {
        return Random().nextInt(2) + 500
    }

    fun getVGiCOdeNumber(): Int {
        return Random().nextInt(2) + 600
    }

    fun getFRiCOdeNumber(): Int {
        return Random().nextInt(2) + 700
    }

    fun getOTiCOdeNumber(): Int {
        return Random().nextInt(2) + 900
    }

    fun calculateDailyAmount(petAge: String, petWeight: String, activeType: String): MutableList<String> {
        //[Decide Percentage for Calculating Amount]
        var amountPercentage = 0.00

        when (petAge) {
            "자견" -> {
                when (activeType) {
                    "매우 활동적" -> amountPercentage = 0.06
                    else -> amountPercentage = 0.05
                }
            }
            "성견", "노견" -> {
                when (activeType) {
                    "매우 활동적" -> amountPercentage = 0.025
                    "보통" -> amountPercentage = 0.02
                    "덜 활동적" -> amountPercentage = 0.015
                }
            }
        }
        //[Calculate Ingredients' Amount]
        //[Make it List. [Total,MM,EB,OR,Plant]

        //[SET INGREDIENTS RATIO]
        val mmRatio = 0.7
        val ebRatio = 0.1
        val orRatio = 0.1
        val plantRatio = 0.1

        var totalAmount = 0.0
        var mmAmount = 0.0
        var ebAmount = 0.0
        var orAmount = 0.0
        var plantAmount = 0.0

        //[Calculating Process]
        totalAmount = (petWeight.toDouble() * 1000) * amountPercentage
        dailyIngredientAmount!!.add(totalAmount.toString())
        mmAmount = totalAmount * mmRatio
        dailyIngredientAmount!!.add(mmAmount.toString())
        ebAmount = totalAmount * ebRatio
        dailyIngredientAmount!!.add(ebAmount.toString())
        orAmount = totalAmount * ebRatio
        dailyIngredientAmount!!.add(orAmount.toString())
        plantAmount = totalAmount * plantRatio
        dailyIngredientAmount.add(plantAmount.toString())

        return dailyIngredientAmount
    }

    fun calculateTermAmount(termType: String): MutableList<String> {
        var termToInt = 0
        val termIngredientAmount = mutableListOf<String>()
        val referenceAmount = dailyIngredientAmount

        when (termType) {
            "2주" -> termToInt = 14
            "1달" -> termToInt = 30
        }
        var termTotalAmount = dailyIngredientAmount!![0].toDouble() * termToInt
        termIngredientAmount.add(termTotalAmount.toString())
        var termMMAmount = dailyIngredientAmount[1].toDouble() * termToInt
        termIngredientAmount.add(termMMAmount.toString())
        var termEBAmount = dailyIngredientAmount[2].toDouble() * termToInt
        termIngredientAmount.add(termEBAmount.toString())
        var termORAmount = dailyIngredientAmount[3].toDouble() * termToInt
        termIngredientAmount.add(termORAmount.toString())
        var termPlantAmount = dailyIngredientAmount[4].toDouble() * termToInt
        termIngredientAmount.add(termPlantAmount.toString())

        return termIngredientAmount
    }

    fun getEndDate(startDate:String, termType: String):MutableList<String?>{
        val startAndEndDate = mutableListOf<String?>()
        var startPointString = startDate?.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))
        var startPointDate = LocalDate.parse(startPointString, DateTimeFormatter.ISO_DATE)
        var endPointDate :LocalDate?=null

        when(termType){
            "2주"-> endPointDate = startPointDate.plusDays(14)
            "1달"-> endPointDate = startPointDate.plusMonths(1)
        }

        var endPointString = endPointDate?.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))



        startAndEndDate.add(startPointString)
        startAndEndDate.add(endPointString)

        return startAndEndDate
    }
}