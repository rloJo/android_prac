package com.example.customview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioGroup
import com.example.customview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.rdg.setOnCheckedChangeListener { radioGroup, i ->
            when(i){
                R.id.CircleButton->binding.view.setCir() //view의 setCir() 함수 호출
                R.id.rectButton->binding.view.setRect() //view의 setRect() 함수 호출
            }
        }
    }
}
