package com.momongah.android.rngen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.momongah.android.rngen.databinding.ActivityMainBinding
import java.lang.NumberFormatException
import java.util.Random

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
   // private val generator = RNG()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        //binding.generator = generator

//        val lambda: () -> String = {
//            val min = try {Integer.parseInt(binding.lowerBound.text.toString())
//            } catch (e: NumberFormatException) {1}
//            val max = try {Integer.parseInt(binding.upperBound.text.toString())
//            } catch (e: NumberFormatException) {10}
//            when (max >= min) {
//                true -> (Random().nextInt((max - min) + 1) + min).toString()
//                else -> {
//                    Toast.makeText(this, "Invalid range", Toast.LENGTH_SHORT).show()
//                    ""
//                }
//            }
//        }
        binding.genButton.setOnClickListener {
            val min = try {Integer.parseInt(binding.lowerBound.text.toString())
            } catch (e: NumberFormatException) {1}
            val max = try {Integer.parseInt(binding.upperBound.text.toString())
            } catch (e: NumberFormatException) {10}

            binding.randomNum = when (max >= min) {
                true -> (Random().nextInt((max - min) + 1) + min).toString()
                else -> {
                    Toast.makeText(this, "Invalid range", Toast.LENGTH_SHORT).show()
                    ""
                }
            }
            //binding.result.text = num
        }
    }
}

//data class RNG(var min: Int = 1, var max: Int = 10) {
//    var ranNum: Int = Random().nextInt((max - min) + 1) + min
//}
