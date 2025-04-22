package app.olauncher.helper

import android.R.string
import android.util.Log
import app.olauncher.BuildConfig
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.Serializable
import java.net.HttpURLConnection
import java.net.URL

class MarcoApi {
    suspend fun fetchData(): String = withContext(Dispatchers.IO) {
        try {
            val url = URL("https://api.marcokittel.de/api/task")
            val connection = url.openConnection() as HttpURLConnection
            connection.apply {
                requestMethod = "GET"
                setRequestProperty("ApiKey", BuildConfig.MARCO_API_KEY)
                connectTimeout = 5000  // 5 Sekunden Timeout
                readTimeout = 10000    // 10 Sekunden Timeout
            }

            val responseCode = connection.responseCode
            if (responseCode == HttpURLConnection.HTTP_OK) {
                //Mein Return Statement
                connection.inputStream.bufferedReader().use { it.readText() }
            } else {
                throw ApiException("HTTP Error: $responseCode")
            }
        } catch (e: Exception) {
            throw ApiException("Network error: ${e.message}")
        }
    }

   suspend fun login(): String = withContext(Dispatchers.IO) {
        try {
            var urlStr = "https://api.marcokittel.de/api/user/login?name=_VAR1_&passwort=_VAR2_"
            urlStr = urlStr.replace("_VAR1_", BuildConfig.API_USERNAME)
            urlStr = urlStr.replace("_VAR2_", BuildConfig.API_PASSWORD)
            Log.d("MarcoApi", "Login URL: $urlStr")
            val url = URL(urlStr)
            val connection = url.openConnection() as HttpURLConnection
            connection.apply {
                requestMethod = "GET"
                connectTimeout = 5000  // 5 Sekunden Timeout
                readTimeout = 10000    // 10 Sekunden Timeout
            }
            val responseCode = connection.responseCode
            if (responseCode == HttpURLConnection.HTTP_OK) {
                //Mein Return Statement
                connection.inputStream.bufferedReader().use { it.readText() }
            } else {
                throw ApiException("HTTP Error: $responseCode")
            }
        }catch (e: Exception) {
            throw ApiException("Network error: ${e.message}")
        }

    }
}

@InternalSerializationApi @Serializable
data class ApiKey(
    val Apikey: String
)

@InternalSerializationApi @Serializable
data class Todo(
    val Beschreibung: String
)

// Custom Exception für Fehlerbehandlung
class ApiException(message: String) : Exception(message)