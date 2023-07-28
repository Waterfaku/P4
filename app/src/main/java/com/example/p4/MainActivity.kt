package com.example.p4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.p4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var investment: Investment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.button.setOnClickListener{

            val age = binding.spinnerAge.selectedItemPosition

            if(binding.editTextNumberBalance.text.toString().isEmpty()){
                binding.editTextNumberBalance.setError("ValueRequeirend")
                return@setOnClickListener
            }
            val account_balance = binding.editTextNumberBalance.text.toString().toFloat()

            if(account_balance < 5000){
                return@setOnClickListener
            }

            var amount: Float = 0.0f

            when(age){
                0 ->
                    amount = (account_balance - 5000) * 0.3f

                1->
                    amount = (account_balance - 14000) * 0.3f

                2->
                    amount = (account_balance - 29000) * 0.3f

                3->
                    amount = (account_balance - 50000) * 0.3f

                4->
                    amount = (account_balance - 78000) * 0.3f

                5->
                    amount = (account_balance - 116000) * 0.3f

                6->
                    amount = (account_balance - 165000) * 0.3f

                7->
                    amount = (account_balance - 228000) * 0.3f

                else ->
                    amount = 0.0f
            }

            investment = Investment(amount.toString())
            binding.myInvestment = investment

            //if(binding.spinnerAge. = 1)
        }

        binding.buttonReset.setOnClickListener{
            binding.myInvestment = Investment("0.00")
        }
        //setContentView(R.layout.activity_main)
    }
}