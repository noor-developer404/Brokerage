package com.example.brokerage.ui.gallery

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.brokerage.R

class gallery : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gallery)

        val images = listOf<Image>(
            Image("Image 1", R.drawable.img1),
            Image("Image 2",  R.drawable.img2),
            Image("Image 3", R.drawable.img3),
            Image("Image 4", R.drawable.img4),
            Image("Image 5", R.drawable.img1),
            Image("Image 6",  R.drawable.img2),
            Image("Image 7", R.drawable.img3),
            Image("Image 8", R.drawable.img4),
            Image("Image 9", R.drawable.img1),
            Image("Image 10",  R.drawable.img2),
            Image("Image 11", R.drawable.img3),
            Image("Image 12", R.drawable.img4),
            Image("Image 13", R.drawable.img1),
            Image("Image 14",  R.drawable.img2),
            Image("Image 15", R.drawable.img3),
            Image("Image 16", R.drawable.img4),
            Image("Image 17", R.drawable.img1),
            Image("Image 18",  R.drawable.img2),
            Image("Image 19", R.drawable.img3),
            Image("Image 20", R.drawable.img4),
            Image("Image 21", R.drawable.img1),
            Image("Image 22",  R.drawable.img2),
            Image("Image 23", R.drawable.img3),
            Image("Image 24", R.drawable.img4)
        )
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(this,2)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = ImageAdapter(this, images)
    }
}