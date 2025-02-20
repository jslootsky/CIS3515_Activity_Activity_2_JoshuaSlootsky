package edu.temple.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts

const val TEXT_SIZE_KEY = "text size"

class DisplayActivity : AppCompatActivity() {

    // TODO Step 1: Launch TextSizeActivity when button clicked to
    //  allow selection of text size value
    //create an instance of a launcher, used to start the activity
    //registerForActivity registers the launcher and specifies the type of contract
    //ActivityResultsContact.StartActivityForResult
        //type of contract that tells the launcher it will start an activity
        //and expect a result
    //lambda function inside runs upon the conclusion of the activity
        //checks the result code, if OK, modifies the text
    val launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        if(it.resultCode == RESULT_OK){
            val newSize = it.data?.getFloatExtra(TEXT_SIZE_KEY, 22f)
            if (newSize != null) {
                lyricsDisplayTextView.textSize = newSize
            }
        }
    }

    // TODO Step 3: Use returned value for lyricsDisplayTextView text size

    private lateinit var lyricsDisplayTextView: TextView
    private lateinit var textSizeSelectorButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display)

        lyricsDisplayTextView = findViewById(R.id.lyricsDisplayTextView)
        textSizeSelectorButton = findViewById(R.id.textSizeSelectorButton)

    }
}