package com.example.niklasjang.bottomnavigationbar_with_fragment_example.Fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.niklasjang.bottomnavigationbar_with_fragment_example.Models.ImageModel
import com.example.niklasjang.bottomnavigationbar_with_fragment_example.R
import java.util.ArrayList
import android.graphics.BitmapFactory
import android.graphics.Bitmap
import android.R.attr.src
import android.support.design.R.attr.height


class ImageFragment() : Fragment() {
    private var imageModelArrayList = ArrayList<ImageModel>()
    private val myImageList = intArrayOf(
        R.drawable.songgolmae_book_text,
        R.drawable.songgolmae_notebook_text,
        R.drawable.songgolmae_phone_text
    )
    private var mIndex: Int = 0
    fun newInstance(position: Int): ImageFragment {
        val imageFragment = ImageFragment()
        mIndex = position
        //Supply index input as an argument.
        val args = Bundle()
        args.putInt("index", position)
        imageFragment.arguments = args
//        Log.d("ImageFragment", "newInstance ${imageFragment.arguments}")
        return imageFragment
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        Log.d("ImageFragment", "onCreateView ${this.arguments}")

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_image, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        Log.d("ImageFragment", "onViewCreated, ${this.arguments}")

        val options = BitmapFactory.Options()
        options.inSampleSize = 4



        imageModelArrayList = populateList()


        val ivPhoto = view.findViewById<ImageView>(R.id.ivPhoto)


        ivPhoto?.setImageResource(imageModelArrayList[arguments!!.getInt("index")].getImage_drawables())



    }


    private fun populateList(): ArrayList<ImageModel> {
        val list = ArrayList<ImageModel>()
        for (i in myImageList.indices) {
            val imageModel = ImageModel()
            imageModel.setImage_drawables(myImageList[i])
            list.add(imageModel)
        }
        return list
    }

}
