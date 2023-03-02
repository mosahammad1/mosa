package com.example.testfirebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase



class MainActivity : AppCompatActivity() {

    val db = Firebase.firestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)





        //mosa
        findViewById<Button>(R.id.save).setOnClickListener {

            val name = findViewById<EditText>(R.id.PersonName).text.toString()
            val id = findViewById<EditText>(R.id.PersonID).text.toString()
            val age = findViewById<EditText>(R.id.PersonAge).text.toString()


            val person = hashMapOf(
                "name" to name,
                "id" to id,
                "age" to age
            )

            db.collection("Persons")
                .add(person)
                .addOnSuccessListener { documentReference ->
                    Toast.makeText(applicationContext,"${documentReference.id}",Toast.LENGTH_SHORT).show()

                }
                .addOnFailureListener { e ->
                    Toast.makeText(applicationContext,"$e",Toast.LENGTH_SHORT).show()


                }


        }
    }
}