package com.example.activitylifecyclegitcollaboration

import android.content.SharedPreferences
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.edit

class MainActivity : AppCompatActivity() {

    private lateinit var mainLayout: LinearLayout
    private lateinit var etUserInput: EditText
    private lateinit var tvLifecycleState: TextView
    private lateinit var tvSavedData: TextView
    private lateinit var btnRed: Button
    private lateinit var btnGreen: Button
    private lateinit var btnBlue: Button
    private lateinit var btnWhite: Button
    private lateinit var btnExit: Button

    private lateinit var sharedPreferences: SharedPreferences
    private var currentColor: Int = Color.WHITE

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize Views
        mainLayout = findViewById(R.id.mainLayout)
        etUserInput = findViewById(R.id.etUserInput)
        tvLifecycleState = findViewById(R.id.tvLifecycleState)
        tvSavedData = findViewById(R.id.tvSavedData)
        btnRed = findViewById(R.id.btnRed)
        btnGreen = findViewById(R.id.btnGreen)
        btnBlue = findViewById(R.id.btnBlue)
        btnWhite = findViewById(R.id.btnWhite)
        btnExit = findViewById(R.id.btnExit)

        sharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE)

        // Set Click Listeners for Colors
        btnRed.setOnClickListener { changeBackgroundColor(Color.RED) }
        btnGreen.setOnClickListener { changeBackgroundColor(Color.GREEN) }
        btnBlue.setOnClickListener { changeBackgroundColor(Color.BLUE) }
        btnWhite.setOnClickListener { changeBackgroundColor(Color.WHITE) }

        // Exit Button
        btnExit.setOnClickListener { finish() }

        // Load Saved Data
        loadData()

        updateLifecycleState("onCreate")
    }

    override fun onStart() {
        super.onStart()
        updateLifecycleState("onStart")
    }

    override fun onResume() {
        super.onResume()
        updateLifecycleState("onResume")
    }

    override fun onPause() {
        super.onPause()
        updateLifecycleState("onPause")
        saveData() // Save user input and current background color
    }

    override fun onStop() {
        super.onStop()
        updateLifecycleState("onStop")
    }

    override fun onRestart() {
        super.onRestart()
        updateLifecycleState("onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        updateLifecycleState("onDestroy")
    }

    private fun updateLifecycleState(stateName: String) {
        val stateText = "Current State:\n$stateName"
        tvLifecycleState.text = stateText
        Toast.makeText(this, stateName, Toast.LENGTH_SHORT).show()
    }

    private fun changeBackgroundColor(color: Int) {
        currentColor = color
        mainLayout.setBackgroundColor(currentColor)
    }

    private fun saveData() {
        sharedPreferences.edit {
            putString("savedText", etUserInput.text.toString())
            putInt("savedColor", currentColor)
        }
    }

    private fun loadData() {
        val savedText = sharedPreferences.getString("savedText", "")
        currentColor = sharedPreferences.getInt("savedColor", Color.WHITE)

        etUserInput.setText(savedText)
        val displayText = "Saved Text: $savedText"
        tvSavedData.text = displayText
        mainLayout.setBackgroundColor(currentColor)
    }
}