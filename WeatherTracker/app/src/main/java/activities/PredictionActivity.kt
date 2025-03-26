package activities

import adapters.ForecastResponseAdapter
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import api.WeatherRetrofitApi
import com.example.semesterproject.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import models.ForecastResponse
import persistence.AppDatabase
import persistence.EntityModelConverter
import persistence.entities.ForecastResponseEntity

class PredictionActivity : AppCompatActivity() {

    private lateinit var forecastResponseRecyclerView: RecyclerView
    private lateinit var progressBar: ProgressBar

    private val coroutineContext = Job() + Dispatchers.Default
    private val coroutineScope = CoroutineScope(coroutineContext)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_prediction)

        setSupportActionBar(findViewById(R.id.activity_prediction_toolbar1))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        progressBar = findViewById(R.id.activity_prediction_progressBar)

        configureApi()
    }

    private fun configureApi() {
        val name = intent.getStringExtra(EXTRA_NAME)

        val location = name
        val numberOfDays = 1

        progressBar.visibility = View.VISIBLE

        coroutineScope.launch {
            try {
                val latestForecast = WeatherRetrofitApi.getWeatherForecast(location, numberOfDays)

                persistForecast(latestForecast)

                val forecasts = fetchDataAndRender()

                runOnUiThread {
                    initializeRecyclerView(forecasts)
                    progressBar.visibility = View.INVISIBLE
                }
            } catch (e: Exception) {
                runOnUiThread {
                    errorDetector(e)
                    progressBar.visibility = View.INVISIBLE
                }
            }
        }
    }

    private suspend fun persistForecast(forecastResponse: ForecastResponse) {
        val forecastResponseEntity = EntityModelConverter.convertToEntity(forecastResponse)
        AppDatabase.getDatabase(this).forecastDao().insertForecast(forecastResponseEntity)
    }

    private suspend fun fetchDataAndRender(): List<ForecastResponse> {
        try {
            val forecastEntities: List<ForecastResponseEntity> = AppDatabase
                .getDatabase(this@PredictionActivity)
                .forecastDao()
                .getAllForecasts()

            return forecastEntities.map { EntityModelConverter.convertToModel(it) }
        } catch (e: Exception) {
            errorDetector(e)
            return emptyList()
        }
    }

    private fun initializeRecyclerView(forecast: List<ForecastResponse>) {
        forecastResponseRecyclerView = findViewById(R.id.activity_prediction_recyclerView)
        forecastResponseRecyclerView.layoutManager = LinearLayoutManager(this)
        forecastResponseRecyclerView.adapter = ForecastResponseAdapter(forecast)
    }


    private fun errorDetector(e: Exception) {
        val toast = Toast(this@PredictionActivity)
        toast.duration = Toast.LENGTH_LONG
        toast.setText("Error fetching endpoint data")
        toast.show()
    }

    companion object {
        const val EXTRA_NAME = "extra_name"

        fun newIntent(context: Context, name: String): Intent {
            val intent = Intent(context, PredictionActivity::class.java)
            intent.putExtra(EXTRA_NAME, name)
            return intent
        }
    }
}