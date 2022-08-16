package com.example.myapplication

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.*
import androidx.databinding.DataBindingUtil
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var diceImg: ImageView
    lateinit var numberText: TextView
    lateinit var editPlayerName: EditText
    lateinit var  playerNameTV : TextView
    lateinit var binding: ActivityMainBinding // P4 -> name activity with main
    private val gameInfo: MyName = MyName("DKKKZ")  // declare Myname = Myname is DKKKZ (P4)
    lateinit var accumulateNum : TextView
    private var numberCount = 0;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
//        setContentView(R.layout.activity_main)
        diceImg = findViewById(R.id.diceImg)
        numberText = findViewById(R.id.numberText)
        editPlayerName = findViewById(R.id.editPlayerName)
        playerNameTV = findViewById(R.id.playerName)
//        val rollButton = findViewById<Button>(R.id.rollButton)
        binding.gameInfo= gameInfo // binding gameInfo = gameInfo with data
        binding.rollButton
            .setOnClickListener { rollDice() }
//        val updateButton = findViewById<Button>(R.id.updatePlayerNameBtn)
        binding.updatePlayerNameBtn.setOnClickListener{updatePlayerName(it)}
    }

    private fun rollDice() {
      val randomNumb = (1..6).random()
//        val numberText: TextView = findViewById(R.id.numberText)
//        val diceImg: ImageView = findViewById(R.id.diceImg)
        binding.numberText.text = randomNumb.toString()

        val imgSrc = when (randomNumb){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        binding.diceImg.setImageResource(imgSrc)

        numberCount += randomNumb;
        binding.accNum.text = numberCount.toString();

        Toast.makeText(this, randomNumb.toString()
        ,Toast.LENGTH_SHORT).show()
    }

    private fun updatePlayerName(view : View) {
        binding.apply {
            //way 1
            //gameInfo2.playerName = binding.editplayerName.text.tostring

            gameInfo?.playerName = editPlayerName.text.toString()
            invalidateAll()
        }
        // binding.playerName.text = binding.EditPlayerName.text
        // playerNameTxt.text = nameTxt.text

//        playerNameTV.text =  editPlayerName.text
//        editPlayerName.setText(" ")
//        editPlayerName.clearFocus()
//        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
//        imm.hideSoftInputFromWindow(view.windowToken, 0)


    }
}