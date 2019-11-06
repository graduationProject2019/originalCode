package com.example.meatbowl.fragments


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.meatbowl.R
import com.example.meatbowl.model.Diet
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.fragment_feeding.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class FeedingFragment : Fragment() {

    companion object {
        private const val TAG = "FeedingFragment"
    }
    private val database by lazy { FirebaseDatabase.getInstance() }
    private val feedingRef = database.getReference("dietData")

    private val planListener:ValueEventListener?=null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_feeding, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val planListener = object :ValueEventListener{
            override fun onDataChange(p0: DataSnapshot) {
                val feedingPlan = p0.getValue(Diet::class.java)

                feedingPlan?.let {
                    diet_pet_name.text = it.petName
                    term.text = it.totalTerm
                    txt_activity.text = it.activeType
                    total_weight.text = it.totalAmount
                    feeding_meat_weight.text = it.mmAmount
                    feeding_bone_weight.text = it.ebAmount
                    feeding_organ_weight.text = it.orAmount
                    feeding_plant_weight.text = it.plantAmount
                    meat_ingredient.text = it.mmName
                    bone_ingredient.text = it.ebName
                    organ_ingredient.text = it.orName
                    veggie_ingredient.text = it.vgName
                    fruit_ingredient.text= it.frName
                    extra_ingredient.text = it.otName
                }
            }

            override fun onCancelled(p0: DatabaseError) {
                Log.w(TAG,"loadPost:onCancelled",p0.toException())
            }
        }



    }
}

