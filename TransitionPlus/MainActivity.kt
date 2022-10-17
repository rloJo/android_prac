package com.example.transition

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.RadioGroup
import androidx.lifecycle.ViewModelProvider
import androidx.transition.*
import com.example.transition.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MyViewModel
    private lateinit var scene1: Scene
    private lateinit var scene2: Scene

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this)[MyViewModel::class.java]
        scene1 = Scene.getSceneForLayout(binding.sceneRoot, R.layout.scene1, this)
        scene2 = Scene.getSceneForLayout(binding.sceneRoot, R.layout.scene2, this)
        binding.rdg.setOnCheckedChangeListener { _, checked ->
            when(checked) {
                R.id.student -> {
                    TransitionManager.go(scene1, Fade())
                    val nameEditText1 = findViewById<EditText>(R.id.editName1)
                    val radioGroup = findViewById<RadioGroup>(R.id.numgroup)
                    nameEditText1.setText(viewModel.str1)
                    if(viewModel.checked > 0) {
                        when(viewModel.checked) {
                            1 -> radioGroup.check(R.id.num1)
                            2 -> radioGroup.check(R.id.num2)
                            3 -> radioGroup.check(R.id.num3)
                            4 -> radioGroup.check(R.id.num4)
                        }
                    }
                }
                R.id.work -> {
                    val nameEditText1 = findViewById<EditText>(R.id.editName1)
                    val radioGroup = findViewById<RadioGroup>(R.id.numgroup)
                    viewModel.str1 = nameEditText1.text.toString()
                    when(radioGroup.checkedRadioButtonId){
                        R.id.num1 -> viewModel.checked = 1
                        R.id.num2 -> viewModel.checked = 2
                        R.id.num3 -> viewModel.checked = 3
                        R.id.num4 -> viewModel.checked = 4
                    }
                    TransitionManager.go(scene2, ChangeBounds())
                }
            }
        }
    }
}
