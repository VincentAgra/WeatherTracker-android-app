package viewholders

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.semesterproject.R

class ForecastViewholder(val view: View) : RecyclerView.ViewHolder(view) {
    val cityNameTextView: TextView = view.findViewById(R.id.city_name_textview)
    val lastUpdateTextView: TextView = view.findViewById(R.id.last_update_textview)
    val windSpeedTextView: TextView = view.findViewById(R.id.wind_speed_textview)
    val windDirectionTextView: TextView = view.findViewById(R.id.wind_direction_textview)
    val currentCelciusTextView: TextView = view.findViewById(R.id.weather_temp)

    fun resetViews() {
        cityNameTextView.text = ""
        lastUpdateTextView.text = ""
        windSpeedTextView.text = ""
        windDirectionTextView.text = ""
        currentCelciusTextView.text = ""
    }
}