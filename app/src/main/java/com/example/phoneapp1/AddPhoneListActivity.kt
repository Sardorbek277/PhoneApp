package com.example.phoneapp1

import Adapter.PhoneListAdapter
import Adapter.TypeAdapter
import Utils.MyData
import Utils.MySharedPreference
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.phoneapp1.databinding.ActivityPhoneListBinding

class AddPhoneListActivity : AppCompatActivity() {
    lateinit var binding: ActivityPhoneListBinding

    lateinit var typeAdapter: TypeAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPhoneListBinding.inflate(layoutInflater)
        setContentView(binding.root)


        typeAdapter = TypeAdapter(this, MyData.typeListName,object : TypeAdapter.ItemGridOnClick{
            override fun onClick(type: String, position: Int) {
                val intent = Intent(this@AddPhoneListActivity, AddPhoneActivity::class.java)
                intent.putExtra("type",position)
                startActivity(intent)
            }
        })
        binding.listPhones.adapter = typeAdapter
    }
}