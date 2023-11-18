package com.example.phoneapp1

import Utils.MyData
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.phoneapp1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loadData()
        binding.btnMenu.setOnClickListener {
            startActivity(Intent(this, MenuGridActivity::class.java))
        }
        binding.btnAdd.setOnClickListener {
            startActivity(Intent(this, AddPhoneListActivity::class.java))
        }
    }

    private fun loadData() {
        MyData.typeListName.add("Iphone")
        MyData.typeListName.add("Samsung")
        MyData.typeListName.add("Mi")
        MyData.typeListName.add("Sony")
        MyData.typeListName.add("Huawei")
        MyData.typeListName.add("Artel")

    }
}
