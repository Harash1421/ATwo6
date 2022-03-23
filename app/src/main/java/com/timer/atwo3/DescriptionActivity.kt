package com.timer.atwo3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_description.*

class DescriptionActivity : AppCompatActivity() {
    //Variables
    var intId = 0
    var intImage = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_description)
        //Variables
        var id = intent.getIntExtra("Id", intId)
        var image = intent.getIntExtra("image", intImage)
        var description = intent.getStringExtra("description")
        //Show Data Here
        dn_tvPhoto.setImageResource(image)
        dn_tvDscription.text = description.toString()
    }
}