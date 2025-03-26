package adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.semesterproject.R
import models.ForecastResponse
import viewholders.ForecastViewholder

class ForecastResponseAdapter(private val forecastResponseModels: List<ForecastResponse>): RecyclerView.Adapter<ForecastViewholder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ForecastViewholder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_holder_forecast_response, parent, false)

        return ForecastViewholder(view)
    }

    override fun onBindViewHolder(holder: ForecastViewholder, position: Int) {

        holder.resetViews()

        val forecastResponseModel = forecastResponseModels[position]

        holder.apply {
            cityNameTextView.text = forecastResponseModel.location.name
            lastUpdateTextView.text = holder.view.context.getString(R.string.last_update_text, forecastResponseModel.current.last_updated)
            windSpeedTextView.text = holder.view.context.getString(R.string.wind_speed, forecastResponseModel.current.wind_kph.toString())
            windDirectionTextView.text = holder.view.context.getString(R.string.wind_direction, forecastResponseModel.current.wind_dir)
            currentCelciusTextView.text = holder.view.context.getString(R.string.current_temperature, forecastResponseModel.current.temp_c.toString())
        }
    }

    override fun getItemCount(): Int = forecastResponseModels.size

    companion object {
        const val TAG = "ForecastResponseAdapter"
    }
}