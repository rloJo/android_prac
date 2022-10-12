package com.example.transition

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.transition.Fade
import androidx.transition.Scene
import androidx.transition.TransitionManager
import com.example.week4_prac.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var scene1: Scene
    private lateinit var scene2: Scene
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        scene1 = Scene.getSceneForLayout(binding.sceneRoot, R.layout.scene1, this)
        scene2 = Scene.getSceneForLayout(binding.sceneRoot, R.layout.scene2, this)
        setContentView(binding.root)

        binding.group.setOnCheckedChangeListener { radioGroup, i ->
            when(i){
                R.id.student -> TransitionManager.go(scene1, Fade())
                R.id.work -> TransitionManager.go(scene2, Fade())
            }
        }
    }
}
