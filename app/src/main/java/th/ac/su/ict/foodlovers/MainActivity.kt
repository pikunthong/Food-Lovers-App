package th.ac.su.ict.foodlovers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_main.*
import th.ac.su.ict.foodlovers.Data.Food
import th.ac.su.ict.foodlovers.Data.FoodAdapter
import th.ac.su.ict.foodlovers.Utils.getJsonDataFromAsset

class MainActivity : AppCompatActivity() {

    var itemList:ArrayList<Food> = ArrayList<Food>()
    lateinit var arrayAdapter: ArrayAdapter<Food>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val jsonFileString = getJsonDataFromAsset(applicationContext,"Food_data.json")

        Log.i("data",jsonFileString)

        val gson = Gson()
        val listItemType = object : TypeToken<ArrayList<Food>>(){}.type

        var foodList : ArrayList<Food> = gson.fromJson(jsonFileString,listItemType)

        itemList = foodList

        val adapter = FoodAdapter(this@MainActivity,itemList)

        listView.adapter = adapter


    }
}
