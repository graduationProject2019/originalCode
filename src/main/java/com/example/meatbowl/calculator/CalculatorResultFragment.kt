package com.example.meatbowl.calculator


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.meatbowl.R
import com.example.meatbowl.database.Ingredients
import com.example.meatbowl.model.Diet
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.calculator_output.*
import kotlinx.android.synthetic.main.calculator_output.view.*
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class CalculatorResultFragment : Fragment() {
    //DB셋팅
    private val database by lazy { FirebaseDatabase.getInstance() }
    private val user_diet = database.getReference("dietData")
    private val userRef = database.getReference("userData")

    //변수 선언
    var endDate : LocalDate?=null
    var termType : String=""
    var activeType : String=""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.calculator_output, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //현재 로그인한 유저 가져오기.
        val user = FirebaseAuth.getInstance().currentUser
        val myUserId = user?.email

        //Bundle에서 값 가져오기
        val dailyAmountResult = arguments?.getStringArrayList("dailyFeedingAmount") ?: ArrayList()
        val termAmountResult = arguments?.getStringArrayList("termFeedingAmount") ?: ArrayList()
        val petName = arguments?.getString("petName")
        val petWeight = arguments?.getString("petWeight")
        val petAge = arguments?.getString("petAge")
        val petActivity = arguments?.getString("petActivity")
        val startDate = arguments?.getString("startDate")
        val startEndTerm = arguments?.getStringArrayList("startAndEndDate") ?: ArrayList()

        val totalTerm = startEndTerm[0] + " ~ " + startEndTerm[1]
        //Term계산
        startEndTerm?.let{
            view.txt_output_term.text = totalTerm
        }



        //화면에 기본데이터 셋팅
        view.txt_output_name.text = petName
        view.output_pet_weight.text = petWeight
        view.output_pet_age.text = petAge
        view.output_pet_activity.text = petActivity

        //화면에 Daily Feeding Amount 셋팅
        dailyAmountResult.let{
            view.total_weight.text = dailyAmountResult[0]
            view.meat_weight.text = dailyAmountResult[1]
            view.bone_weight.text = dailyAmountResult[2]
            view.organ_weight.text = dailyAmountResult[3]
            view.plant_weight.text = dailyAmountResult[4]
        }

        //화면에 Term Feeding Amount 셋팅
        termAmountResult.let{
            view.term_total_amout.text = termAmountResult[0]
            view.term_mm.text = termAmountResult[1]
            view.term_eb.text = termAmountResult[2]
            view.term_or.text = termAmountResult[3]
            view.term_plant.text = termAmountResult[4]
        }

        //Feeding Ingredient 정하기
        val ingredientResult = PMRDietMaker.getRandomIngredientList()
        val nameOfMM = ingredientResult[0]
        val nameOfEB = ingredientResult[1]
        val nameOfOR = ingredientResult[2]
        val nameOfVG = ingredientResult[3]
        val nameOfFR = ingredientResult[4]
        val nameOfOT = ingredientResult[5]
        //화면에 Feeding Ingredient's Name 셋팅
        ingredientResult.let{
            view.meat_ingredient.text =Ingredients.valueOf(nameOfMM).iKorean
            view.bone_ingredient.text =Ingredients.valueOf(nameOfEB).iKorean
            view.organ_ingredient.text=Ingredients.valueOf(nameOfOR).iKorean
            view.veggie_ingredient.text=Ingredients.valueOf(nameOfVG).iKorean
            view.fruit_ingredient.text=Ingredients.valueOf(nameOfFR).iKorean
            view.extra_ingredient.text=Ingredients.valueOf(nameOfOT).iKorean
        }

        btn_apply.setOnClickListener {
            SettingNewDietData(myUserId,petName,petAge,totalTerm,dailyAmountResult[0],dailyAmountResult[1],dailyAmountResult[2]
            ,dailyAmountResult[3],dailyAmountResult[4],nameOfMM,nameOfEB,nameOfOR,nameOfVG,nameOfFR,nameOfOT)
        }

    }
        //Insert Setting Diet Data to Database
        private fun SettingNewDietData(userId: String?, petName:String? , totalTerm:String?
                                     , activeType:String?, totalAmount:String?, mmAmount:String?,
                                       ebAmount:String?, orAmount:String?, plantAmount:String?,
                                       mmName:String?, ebName:String?, orName:String?, vgName:String?,
                                       frName:String?, otName:String?){
            val key = user_diet.child("diets").push().key
            if(key == null){
                return
            }
            val diet = Diet(userId,petName,totalAmount,activeType,totalAmount, mmAmount, ebAmount, orAmount,
                plantAmount, mmName, ebName, orName, vgName, frName, otName)
            val dietValues = diet.toMap()

            val childUpdates = HashMap<String,Any>()
            childUpdates["/dietData/diets/$key"] = dietValues

            user_diet.updateChildren(childUpdates)
        }
    }
