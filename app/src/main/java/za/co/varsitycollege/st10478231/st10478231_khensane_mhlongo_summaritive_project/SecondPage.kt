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
        val txeInputSongTitle = intent.getStringArrayExtra("txeInputSongTitle")
        val txeInputArtists = intent.getStringArrayExtra("txeInputArtists")
        val txeInputRatings = intent.getStringArrayExtra("txeInputRatings")
        val txeInputComments = intent.getStringArrayExtra("txeInputComments")
        val btnView = findViewById<Button>(R.id.btnView)
        val txeShowcasePlaylist = findViewById<TextView>(R.id.txeShowcasePlaylist)
        val btnBack = findViewById<Button>(R.id.btnBack)
        val btnExit2 = findViewById<Button>(R.id.btnExit2)


        btnView.setOnClickListener {
            if (txeInputSongTitle != null && txeInputArtists != null && txeInputRatings != null && txeInputComments != null) {
                val builder = StringBuilder()
                val count = txeInputSongTitle.size
                for (i in 0 until count) {
                    builder.append("Song Title: ${txeInputSongTitle[i]}\n")
                    builder.append("Artist: ${txeInputSongTitle.getOrNull(i) ?: ""}\n")
                    builder.append("Rating : ${txeInputSongTitle.getOrNull(i) ?: ""}\n")
                    builder.append("Comment: ${txeInputSongTitle.getOrNull(i) ?: ""}\n\n")
                }
                txeShowcasePlaylist.text = builder.toString()
            }else {
                txeShowcasePlaylist.text = "There was no information provided."
            }
            btnBack.setOnClickListener {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
            btnExit2.setOnClickListener {
                finishAffinity()
            }
        }
    }
}
