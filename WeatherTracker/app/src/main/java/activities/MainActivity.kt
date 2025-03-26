package activities

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.semesterproject.R
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var titleTextView: TextView
    private lateinit var nameEditText: EditText
    private lateinit var predictionButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        randomThemeGenerator()

        setContentView(R.layout.activity_main)

        setSupportActionBar(findViewById(R.id.activity_main_toolbar1))

        initializeViews()

        predictionActivityLauncher()
    }

    private fun randomThemeGenerator() {
        val randomThemeIndex = Random.nextInt(2)
        if (randomThemeIndex == 0) {
            setTheme(R.style.Theme_Custom_Primary)
        } else {
            setTheme(R.style.Theme_Custom_Secondary)
        }
    }

    private fun initializeViews() {
        titleTextView = findViewById(R.id.activity_textview_title)
        predictionButton = findViewById(R.id.prediction_button)
        nameEditText = findViewById(R.id.editText_name)
    }

    private fun predictionActivityLauncher() {
        predictionButton.setOnClickListener {
            val name = nameEditText.text.toString()
            if (name.isNotEmpty()) {
                val intent = PredictionActivity.newIntent(this@MainActivity, name)
                startActivity(intent)
            }
        }
    }
}