package app.olauncher

import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.ScaleGestureDetector
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.lifecycle.lifecycleScope
import app.olauncher.databinding.ActivityNewWindowBinding
import app.olauncher.helper.MarcoApi
import app.olauncher.helper.Todo
import kotlinx.coroutines.Delay
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json



class NewWindowActivity : AppCompatActivity() {
    private lateinit var scaleGestureDetector: ScaleGestureDetector
    private lateinit var myTextView: TextView
    private var currentTextSize = 15f // Starttextgröße
    private lateinit var binding: ActivityNewWindowBinding
    private lateinit var marcoApi: MarcoApi


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        marcoApi = MarcoApi()
        binding = ActivityNewWindowBinding.inflate(layoutInflater)
        setContentView(binding.root)
        myTextView = binding.editTextTextMultiLine3
        myTextView.text = ""
        myTextView.textSize = currentTextSize

        lifecycleScope.launch(Dispatchers.IO) {

            while (isActive) { // Automatische Prüfung auf Activity-Lebenszyklus
                getDataFromMarcoApi()
                delay(5000) // Alle 5 Sekunden
            }
        }
    }


    @OptIn(InternalSerializationApi::class)
    private fun getDataFromMarcoApi(){
        lifecycleScope.launch {
            val deferredData = async { marcoApi.fetchData() }
            val result = deferredData.await() // Wartet auf Ergebnis
            try {
                if (result != null){
                    val todos = Json.decodeFromString<ArrayList<Todo>>(result)
                    var textString = ""
                    for ((index, todo) in todos.withIndex()) {
                        textString = textString + todo.Beschreibung + "\n"
                    }
                    myTextView.text = textString
                    Log.d("Marco-Api","abc"+result)
                }
            }catch (e: Exception){
                //Der Server ist hier entweder nicht erreichbar oder der Benutzer ist nicht eingelogged.
                Log.d("Marco-Api","abc"+e)
            }

        }

    }
}