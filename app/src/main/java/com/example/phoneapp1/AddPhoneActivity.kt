package com.example.phoneapp1

import Utils.MySharedPreference
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.phoneapp1.databinding.ActivityAddPhoneBinding
import models.Phone

class AddPhoneActivity : AppCompatActivity() {
    lateinit var binding: ActivityAddPhoneBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddPhoneBinding.inflate(layoutInflater)
        setContentView(binding.root)

        MySharedPreference.init(this)
        val type = intent.getIntExtra("type", -1)

        binding.btnSave.setOnClickListener {
            val name = binding.edtPhoneName.text.toString().trim()
            val features = binding.edtFeatures.text.toString().trim()

            if (name!="" && features!="" && type!=-1){
               val list= MySharedPreference.obyektString
                list.add(Phone(type, name, features))
                MySharedPreference.obyektString = list
                Toast.makeText(this, "Save", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
            }
        }
    }
}