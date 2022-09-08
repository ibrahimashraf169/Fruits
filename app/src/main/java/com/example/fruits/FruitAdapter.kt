package com.example.app3

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fruits.R

class FruitAdapter(private val fruits : List<Fruit>) : RecyclerView.Adapter<FruitAdapter.FruitViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FruitViewHolder {
        val itemFruitView = LayoutInflater.from(parent.context).inflate(R.layout.fruit,parent,false)
        return FruitViewHolder(itemFruitView)
    }

    override fun onBindViewHolder(holder: FruitViewHolder, position: Int) {
        val current = fruits[position]
        holder.bind(current)
    }

    override fun getItemCount(): Int {
        return fruits.size
    }

    inner class FruitViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        private val name: TextView
        private val image: ImageView

        init{
            name = itemView.findViewById(R.id.name)
            image = itemView.findViewById(R.id.pic)

        }

        fun bind(fruit: Fruit) {
            name.text = fruit.name
            image.setImageResource(fruit.image)
        }
    }

}