package com.example.firebasetest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.firebasetest.databinding.ActivityFirestoreBinding
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.firestore.*
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class FirestoreActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFirestoreBinding
    private val db: FirebaseFirestore = Firebase.firestore



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFirestoreBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //1. 레퍼런스 가져오기
        val md = db.collection("items").document("melon")
        val col = db.collection("items")

        col.addSnapshotListener{
            value, error ->
            for(d in value!!.documentChanges){
                println("------------ ${d.type}, ${d.document.id},${d.document.data["price"]}")
            }
        }

        md.get().addOnSuccessListener{
          //  println("############## ${it.id}, ${it["price"]}")
        }
        col.get().addOnSuccessListener {
            for(d in it){
             //   println("------------ ${d.id}, ${d["price"]}")
            }
        }
       val itemMap = hashMapOf(
            "price" to 100
        )
       // col.add(itemMap)
      col.document("apple").set(itemMap)

        col.whereGreaterThan("price", 50).get().addOnSuccessListener {
            for(d in it){
              //  println("qqqqqqqqqqqqqqqq ${d.id}, ${d["price"]}")
            }
        }

    }
}
