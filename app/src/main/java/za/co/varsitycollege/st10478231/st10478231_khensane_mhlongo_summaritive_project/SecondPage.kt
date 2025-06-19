package za.co.varsitycollege.st10478231.st10478231_khensane_mhlongo_summaritive_project

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SecondPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second_page)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main2)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val txeInputSongTitle = intent.getStringArrayExtra("txeInputSongTitle")//Getting the information from the first screen
        val txeInputArtists = intent.getStringArrayExtra("txeInputArtists")//Getting the information from the first screen
        val txeInputRatings = intent.getStringArrayExtra("txeInputRatings")//Getting the information from the first screen
        val txeInputComments = intent.getStringArrayExtra("txeInputComments")//Getting the information from the first screen
        val btnView = findViewById<Button>(R.id.btnView) //Declarations that follow
        val txeShowcasePlaylist = findViewById<TextView>(R.id.txeShowcasePlaylist)
        val btnBack = findViewById<Button>(R.id.btnBack)
        val btnExit2 = findViewById<Button>(R.id.btnExit2)

        btnView.setOnClickListener {
            if (txeInputSongTitle != null && txeInputArtists != null && txeInputRatings != null && txeInputComments != null) { //this is to say if there is empty arrays then do the following
                val builder = StringBuilder()
                val count = txeInputSongTitle.size
                for (i in 0 until count) { //will loop through the users answers and display it
                    builder.append("Song Title: ${txeInputSongTitle[i]}\n")//Show the users song title input
                    builder.append("Artist: ${txeInputArtists.getOrNull(i) ?: ""}\n") //Shows the users input artist
                    builder.append("Rating : ${txeInputRatings.getOrNull(i) ?: ""}\n") //Shows the users input
                    builder.append("Comment: ${txeInputComments.getOrNull(i) ?: ""}\n\n")
                }
                txeShowcasePlaylist.text = builder.toString()
            }else {
                txeShowcasePlaylist.text = "There was no information provided." // Error that will show if the user did not enter any information
            }
            btnBack.setOnClickListener {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent) //Goes back to the first page
            }
            btnExit2.setOnClickListener {
                finishAffinity()//Exits the app
            }
        }
    }
}
