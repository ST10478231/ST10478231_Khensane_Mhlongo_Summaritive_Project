package za.co.varsitycollege.st10478231.st10478231_khensane_mhlongo_summaritive_project

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }//Declarations
        val btnPlaylist = findViewById<Button>(R.id.btnPlaylist)
        val txeSongTitle = findViewById<TextView>(R.id.txeSongTitle)
        val editInputSongTitle = findViewById<EditText>(R.id.editInputSongTitle)
        val txeArtists = findViewById<TextView>(R.id.txeArtist)
        val editInputArtist = findViewById<EditText>(R.id.editInputArtist)
        val txeRating = findViewById<TextView>(R.id.txeRating)
        val editInputRating = findViewById<EditText>(R.id.editInputRating)
        val txeComments = findViewById<TextView>(R.id.txeComments)
        val editInputComments = findViewById<EditText>(R.id.editInputComments)
        val btnNext = findViewById<Button>(R.id.btnNext)
        val btnExit = findViewById<Button>(R.id.btnExit)
        val txeErrors = findViewById<TextView>(R.id.txeErrors)

        btnPlaylist.setOnClickListener { // Makes the questions that the user must input avaliable
            txeSongTitle.visibility = View.VISIBLE
            editInputSongTitle.visibility = View.VISIBLE
            txeArtists.visibility = View.VISIBLE
            editInputArtist.visibility = View.VISIBLE
            txeComments.visibility = View.VISIBLE
            editInputComments.visibility = View.VISIBLE
            txeRating.visibility = View.VISIBLE
            editInputRating.visibility = View.VISIBLE
        }
        btnNext.setOnClickListener {

            val inputSongTitle = editInputSongTitle.text.toString()
            val inputArtist = editInputArtist.text.toString()
            val inputRatingStr = editInputRating.text.toString()
            val inputComments = editInputComments.text.toString()

            if (inputSongTitle.isEmpty() && inputArtist.isEmpty() && inputRatingStr.isEmpty() && inputComments.isEmpty()) {
                txeErrors.text = "Please enter in all the fields" //Error that will be shown if not all fields are complete
            } else if (inputRatingStr.isEmpty() && inputRatingStr.toIntOrNull() == null) {
                txeErrors.text = "Please enter a number for the ratings"// Error that will show when the user inputs a word and not a number
            } else {
                val intent = Intent(this, SecondPage::class.java) //Sending the information below to the next screen
                intent.putExtra("txeInputSongTitle", arrayOf(inputSongTitle))
                intent.putExtra("txeInputArtists", arrayOf(inputArtist))
                intent.putExtra("txeInputRating", intArrayOf(inputRatingStr.toInt()))
                intent.putExtra("txeInputComments", arrayOf(inputComments))
                startActivity(intent) //Starts the transition to one page to the other
            }
        }
        btnExit.setOnClickListener {
            finishAffinity()//Exits the app
        }
    }
}


