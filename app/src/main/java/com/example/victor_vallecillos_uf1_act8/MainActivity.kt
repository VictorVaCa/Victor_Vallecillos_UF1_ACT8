package com.example.victor_vallecillos_uf1_act8

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val pspCB = findViewById<CheckBox>(R.id.cbPsp);
        val interfacesCB = findViewById<CheckBox>(R.id.cbInterfaces);
        val designCB = findViewById<CheckBox>(R.id.cbDesign);
        val programCB = findViewById<CheckBox>(R.id.cbProgram);
        val confirmButton = findViewById<Button>(R.id.confirmButton);
        val morningRB = findViewById<RadioButton>(R.id.rbMorning);
        val afternoonRb = findViewById<RadioButton>(R.id.rbAfternoon);

        confirmButton.setOnClickListener {
            val selectedSubjects = mutableListOf<String>();

            if (pspCB.isChecked) selectedSubjects.add(pspCB.text.toString());
            if (interfacesCB.isChecked) selectedSubjects.add(interfacesCB.text.toString());
            if (designCB.isChecked) selectedSubjects.add(designCB.text.toString());
            if (programCB.isChecked) selectedSubjects.add(programCB.text.toString());

            val turn = when {
                morningRB.isChecked -> morningRB.text;
                afternoonRb.isChecked -> afternoonRb.text;
                else -> "No has seleccionat cap torn"
            }

            val message = "Assignatures seleccionades: ${selectedSubjects.joinToString(", ")}\nTorn: $turn"
            Toast.makeText(this, message, Toast.LENGTH_LONG).show();
            Log.d("Missatge", message)
        }

    }
}