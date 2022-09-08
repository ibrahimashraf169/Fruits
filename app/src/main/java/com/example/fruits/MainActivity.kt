package com.example.fruits

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.edit
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.app3.Fruit
import com.example.app3.FruitAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView : RecyclerView
    private lateinit var mySharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mySharedPreferences = getSharedPreferences("com.example.app3.SHARED_PREF", MODE_PRIVATE)
        mySharedPreferences.edit {
            putInt("temp",3)
            commit()
            //or apply() which is better but slower
        }

        mySharedPreferences.getInt("temp",3)

        recyclerView = findViewById(R.id.rview)
        recyclerView.layoutManager= GridLayoutManager(this,2)

        val listOfFruits = getFruits()
        val fruitAdapter = FruitAdapter(listOfFruits)

        recyclerView.adapter = fruitAdapter

    }

    private fun getFruits(): List<Fruit>{
        var fruitsList =  mutableListOf<Fruit>()
        fruitsList.add(Fruit("Apple",R.drawable.istockphoto_184276818_612x612,"This is an apple"))
        fruitsList.add(Fruit("Strawberry",R.drawable.p11,"This is a strawberry"))
        fruitsList.add(Fruit("Star Fruit",R.drawable._00377519,"This is a starfruit"))
        fruitsList.add(Fruit("Banana",R.drawable._00377497,"This is a banana"))
        fruitsList.add(Fruit("Pineapple",R.drawable.pineapple,"This is a pineapple"))
        fruitsList.add(Fruit("Mango",R.drawable.download,"This is a mango"))
        fruitsList.add(Fruit("Grape",R.drawable.red_white_table_grapes_fresh_fruit_from_which_wine_is_made_vector_illustration_273828_311,"This is a Grape"))
        fruitsList.add(Fruit("Orange",R.drawable.orange,"This is an orange"))
        fruitsList.add(Fruit("Lemon",R.drawable.lemon_seeds_c_limon,"This is a Lemon"))
        fruitsList.add(Fruit("Pincer",R.drawable.pin,"This is a pincer"))
        fruitsList.add(Fruit("Pumpkin",R.drawable.pumpkin_fruit,"This is a Pumpkin"))
        fruitsList.add(Fruit("Watermelon",R.drawable.water,"This is a Watermelon"))
        return fruitsList
    }
}