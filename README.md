<h1>Weather Tracker | Android Application</h1>

<p>A modern weather tracking Android application built with Android Studio using Kotlin and XML.</p>
<p>This app provides real-time weather information from around the world using the OpenWeatherMap API.</p>

<h2>Features</h2>
<ul>
  <li><strong>Current Weather</strong> - View real-time weather conditions for any location</li>
  <li><strong>5-Day Forecast</strong> - Plan ahead with detailed multi-day weather predictions</li>
  <li><strong>Location Search</strong> - Find weather for any city worldwide</li>
  <li><strong>Saved Locations</strong> - Keep track of multiple favorite locations</li>
  <li><strong>Weather Alerts</strong> - Receive notifications about severe weather conditions</li>
  <li><strong>Detailed Metrics</strong> - Access temperature, humidity, wind speed, pressure, and more</li>
  <li><strong>Offline Support</strong> - View previously loaded weather data when offline</li>
  <li><strong>Dynamic Themes</strong> - UI adapts based on current weather conditions and time of day</li>
</ul>

<h2>Installation</h2>
<pre>
# Clone the repository
git clone https://github.com/VincentAgra/WeatherTracker-android-app.git

# Open the project in Android Studio

# Sync Gradle and install dependencies

# Add your OpenWeatherMap API key to local.properties:
# OPEN_WEATHER_API_KEY=your_api_key_here

# Build and run on an emulator or physical device
</pre>

<h2>Requirements</h2>
<ul>
  <li>Android Studio Arctic Fox or newer</li>
  <li>Minimum SDK version: API 21 (Android 5.0 Lollipop)</li>
  <li>Target SDK version: API 33 (Android 13)</li>
  <li>OpenWeatherMap API key</li>
  <li>Kotlin 1.6.0 or higher</li>
</ul>

<h2>Usage</h2>
<p>After installing the app on your device:</p>
<ol>
  <li>Grant location permissions when prompted for local weather</li>
  <li>Use the search bar to find weather for any location</li>
  <li>Save favorite locations by tapping the star icon</li>
  <li>Swipe down to refresh weather data</li>
  <li>Tap on a day in the forecast to see detailed hourly information</li>
  <li>Access settings via the gear icon to customize units and notification preferences</li>
</ol>

<h2>Project Structure</h2>
<ul>
  <li><strong>app/src/main/</strong>
    <ul>
      <li><strong>kotlin/</strong> - Kotlin source files
        <ul>
          <li><strong>activities/</strong> - Activity classes for different screens</li>
          <li><strong>adapters/</strong> - RecyclerView and ViewPager adapters</li>
          <li><strong>data/</strong> - Data models and entities</li>
          <li><strong>database/</strong> - Room database setup and DAOs</li>
          <li><strong>network/</strong> - API service and network utilities</li>
          <li><strong>repositories/</strong> - Repository pattern implementation</li>
          <li><strong>utils/</strong> - Helper classes and extensions</li>
          <li><strong>viewmodels/</strong> - ViewModels for MVVM architecture</li>
        </ul>
      </li>
      <li><strong>res/</strong> - XML resources
        <ul>
          <li><strong>layout/</strong> - UI layout files</li>
          <li><strong>drawable/</strong> - Icons and graphics</li>
          <li><strong>values/</strong> - Strings, colors, and styles</li>
          <li><strong>navigation/</strong> - Navigation graph</li>
        </ul>
      </li>
    </ul>
  </li>
</ul>

<h2>Technologies Used</h2>
<ul>
  <li><strong>Kotlin</strong> - Primary programming language</li>
  <li><strong>MVVM Architecture</strong> - Separation of concerns with ViewModels</li>
  <li><strong>Room Database</strong> - Local storage of weather data and user preferences</li>
  <li><strong>Retrofit</strong> - HTTP client for API requests</li>
  <li><strong>LiveData & Flow</strong> - Observable data holders</li>
  <li><strong>Coroutines</strong> - Asynchronous programming</li>
  <li><strong>Data Binding</strong> - Declarative UI binding</li>
  <li><strong>Navigation Component</strong> - Fragment navigation</li>
  <li><strong>OpenWeatherMap API</strong> - Weather data source</li>
</ul>

<h2>Screenshots</h2>
<p>[Screenshots will be added here]</p>

<h2>License</h2>
<p>This project is licensed under the MIT License - see the LICENSE file for details.</p>

<h2>Contact</h2>
<p>Vincent Agra - <a href="mailto:vincent.agra@example.com">vincent.agra@example.com</a></p>
<p>Project Link: <a href="https://github.com/VincentAgra/WeatherTracker-android-app">https://github.com/VincentAgra/WeatherTracker-android-app</a></p>

