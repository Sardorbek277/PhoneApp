package com.example.phoneapp1

import Adapter.PhoneListAdapter
import Utils.MySharedPreference
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.phoneapp1.databinding.ActivityPhoneListBinding
import models.Phone

class PhoneListActivity : AppCompatActivity() {
    lateinit var binding: ActivityPhoneListBinding
    lateinit var phoneListAdapter: PhoneListAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPhoneListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val type = intent.getIntExtra("type", -1)

        MySharedPreference.init(this)
        val list = MySharedPreference.obyektString
        var listSort = ArrayList<Phone>()
        for (phone in list){
            if (phone.type==type){
                listSort.add(phone)
            }
        }

        phoneListAdapter = PhoneListAdapter(this, listSort, object :PhoneListAdapter.ItemClickLislPhones{
            override fun onClick(phone: Phone, position: Int) {

            }
        })

        binding.listPhones.adapter = phoneListAdapter
    }
}