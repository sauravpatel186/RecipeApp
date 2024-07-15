package com.example.recipeapp

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    var bulletSymbol: Char = '\u2023'
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val headText = findViewById<TextView>(R.id.headText)
        val spinnerR = findViewById<Spinner>(R.id.spinnerR)
        val btnShow = findViewById<Button>(R.id.showBtn)
        val recipeText = findViewById<TextView>(R.id.recipeText)
//        val headText2 = findViewById<TextView>(R.id.headText2)
        var recipe= arrayOf("Please select a recipe","Veggie Burger","Caesar Salad","Chinese")

        var recipeList = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,recipe)
        var selectedReceipe = "Please select a recipe"
        spinnerR.adapter = recipeList
        spinnerR.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>,
                                        view: View, position: Int, id: Long) {
                selectedReceipe = recipe.get(position)
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // write code to perform some action
            }
        }
       btnShow.setOnClickListener { view->
            when(selectedReceipe){
                 "Caesar Salad"->{recipeText.text = recipeCeasersalad()
                     headText.text = "Here is your \nceasar salad recipe"
//                     headText2.text = "Ceasar Salad Receipe"
                 }
                 "Veggie Burger"->{
                     recipeText.text = recipeBurger()
                     headText.text = "Here is your \nveggie burger recipe"
//                     headText2.text = "Veggie Burger Receipe"
                 }

                "Chinese"->{
                    recipeText.text =  recipeChinese()
                    headText.text = "Here is your \nchinese recipe"
//                    headText2.text = "Chinese Receipe"
                }



                else -> {recipeText.text = "Please select any one option"
                headText.text ="Spin & Cook\nYour Recipe Picker"}
            }
    }

    }
    fun recipeCeasersalad():String{

        var recipe:String = "To make Caesar salad follow the steps\n"+"${bulletSymbol} 1 large romaine lettuce\n" +
                "${bulletSymbol } Shredded or shaved Parmesan cheese\n" +
                "${bulletSymbol} Add Crisp croutons in the salad\n" +
                "${bulletSymbol} Add Caesar salad dressing\n"+
                "${bulletSymbol}Enjoy it"
        return recipe
    }
    fun recipeBurger():String{
    var recipe:String = "To make veggie burger follow the steps\n"+"${bulletSymbol} Take one sliced cheese\n" +
            "${bulletSymbol} Take 2 or 3 tomato slices and 1 or 2 onion slices\n" +
            "${bulletSymbol} Take 8 or 9 slices of Cucumber\n" +
            "${bulletSymbol} Heat the pan on low flame apply butter and then toast the bun\n"+
            "${bulletSymbol} Put onion slices then put tomato slices on top of that after that put cucumber slices on top add sauces such as thousand islands,mayonnaise, ranch sauce\n"+
            "${bulletSymbol} Put cheese slice then enjoy\n"
    return recipe
}
    fun recipeChinese():String{
        var recipe:String = "To make chinese follow the steps\n"+"${bulletSymbol} Cut the onions and make thin slices of it\n" +
                "${bulletSymbol} Chop bell peppers,carrots and cabbage also garlic and chilli also\n" +
                "${bulletSymbol} Boil the noodles in large pan for around 10 to 15 minutes\n" +
                "${bulletSymbol} Rinse the noodles with water then add 1tbsp so that noodles do not become sticky\n"+
                "${bulletSymbol} Take a pan and add 2 or 3 tbsp oil and heat on high flame then add chopped garlic and chilli after 1 minute\n"+
                "${bulletSymbol} Add bell peppers,carrots and cabbage saute it for 1 minute and add salt according to your taste\n"+
                "${bulletSymbol} Add boiled noodles then pour green chilli, red chilli, soy sauce and vinegar according to your taste \n"+
                "${bulletSymbol} Enjoy, it"
        return recipe
    }
}