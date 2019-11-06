package com.example.meatbowl.calculator


import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.FrameLayout
import android.widget.Toast
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager

import com.example.meatbowl.R
import com.example.meatbowl.main.MainActivity
import com.example.meatbowl.model.Diet
import com.google.android.material.tabs.TabLayout
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.calculator_setting.*
import kotlinx.android.synthetic.main.calculator_setting.view.*
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class CalculateFragment : Fragment() {

    var setPetName : String =""
    var setPetAge:String =""
    var setPetWeight : String =""
    var setStartDate : String =""
    var setTermType : String=""
    var setActiveType : String=""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.calculator_setting,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.btn_setting_calculate.setOnClickListener {
            val bundle = Bundle()

            if(TextUtils.isEmpty(view.setting_pet_name.text.toString())||
                TextUtils.isEmpty(view.setting_pet_weight.text.toString())||
                    TextUtils.isEmpty(view.txt_term.text.toString())){
                Toast.makeText(requireContext(), "모든 정보를 입력해주세요",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            setCalculateData()

            //Daily Amount 계산을 위한 데이터 전달
            bundle.putStringArrayList(
                "dailyFeedingAmount",
                ArrayList(PMRDietMaker.calculateDailyAmount(setPetAge,setPetWeight,setActiveType))
            )

            //Term Total Amount 계산을 위한 데이터 전달
            bundle.putStringArrayList(
                "termFeedingAmount",
                ArrayList(PMRDietMaker.calculateTermAmount(setTermType))
            )

            //Start and End Date 계산을 위한 데이터 전달
            bundle.putStringArrayList(
                "startAndEndDate",
                ArrayList(PMRDietMaker.getEndDate(setStartDate,setTermType))
            )

            //Result에 셋팅할 데이터 전달
            bundle.putString("petName", setPetName)
            bundle.putString("petWeight", setPetWeight)
            bundle.putString("petAge",setPetAge)
            bundle.putString("petActivity",setActiveType)
            bundle.putString("startDate",setStartDate)


            (requireActivity() as MainActivity).moveToResultFragment(bundle)
        }

    }
    //[Set Data to Variable]
    private fun setCalculateData(){
        setPetName = setting_pet_name.text.toString()
        age_group.setOnCheckedChangeListener { radioGroup, i ->
            when(age_group.checkedRadioButtonId){
                R.id.age_puppy -> {setPetAge = "자견"}
                R.id.age_adult -> {setPetAge = "성견"}
                R.id.age_old -> {setPetAge = "노견"}
            }
        }
        setPetWeight =  setting_pet_weight.text.toString()
        setStartDate = txt_term.text.toString()
        term_type_group.setOnCheckedChangeListener { radioGroup, i ->
            when(term_type_group.checkedRadioButtonId){
                R.id.termtype_2week -> {setTermType = "2주"}
                R.id.termtype_1month ->{setTermType="1달"}
            }
        }
        diet_group.setOnCheckedChangeListener { radioGroup, i ->
            when(diet_group.checkedRadioButtonId){
                R.id.diet_type_less ->{setActiveType="덜 활동적"}
                R.id.diet_type_normal->{setActiveType="보통"}
                R.id.diet_type_active->{setActiveType="매우 활동적"}
            }
        }
    }

}
