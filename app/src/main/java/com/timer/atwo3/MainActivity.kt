package com.timer.atwo3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    //Variables
    var adapter:Adapter? = null
    var intId = 0
    var stringDescription = ""
    var intImage = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //List Array Coding
        var list = ArrayList<List>()
        list.add(List(1, R.drawable.horse, "Horse", resources.getString(R.string.Horse)))
        list.add(List(2, R.drawable.lion, "Lion", resources.getString(R.string.Lion)))
        list.add(List(3, R.drawable.tiger, "Tiger", resources.getString(R.string.Tiger)))
        list.add(List(4, R.drawable.camel, "Camel", resources.getString(R.string.Camel)))
        list.add(List(5, R.drawable.cheetah, "Cheetah", resources.getString(R.string.Cheetah)))

        //Show Data And Send Data Coding
        adapter = Adapter(this,list, object : Adapter.OnClickListener{
            override fun onClick(position: Int, image:Int, description:String) {
                //Variables
                intId = position
                intImage = image
                //Send Data Coding
                var intent = Intent(this@MainActivity, DescriptionActivity::class.java)
                intent.putExtra("Id", intId)
                intent.putExtra("description", description)
                intent.putExtra("image", intImage)
                startActivity(intent)
            }
        })
        main_Rc.adapter = adapter
        main_Rc.layoutManager = LinearLayoutManager(this)
    }
}