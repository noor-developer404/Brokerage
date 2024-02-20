package com.example.brokerage.ui.property_details

import android.graphics.drawable.GradientDrawable.Orientation
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.brokerage.R
import com.example.brokerage.ui.Image
import com.example.brokerage.ui.ImageAdapter


class GalleryFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
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

        val view = inflater.inflate(R.layout.fragment_gallery, container, false)
        // Inflate the layout for this fragment

        view?.findViewById<RecyclerView>(R.id.recyclerViewGal)?.layoutManager = GridLayoutManager(context,2)
        val adapter = ImageAdapter(requireContext(),images)
            view?.findViewById<RecyclerView>(R.id.recyclerViewGal)?.adapter = adapter
//        activity?.findViewById<RecyclerView>(R.id.recyclerViewGal)?.layoutManager = GridLayoutManager(context,2)
//        activity?.findViewById<RecyclerView>(R.id.recyclerViewGal)?.adapter = adapter
        return view
    }


    }
