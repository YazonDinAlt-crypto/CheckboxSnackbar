package com.example.checkboxsnackbar

import android.content.DialogInterface
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var inputEditText: EditText
    private lateinit var outputTextView: TextView
    private lateinit var saveButton: Button
    private lateinit var deleteButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        inputEditText = findViewById(R.id.inputEditText)
        outputTextView = findViewById(R.id.outputTextView)
        saveButton = findViewById(R.id.saveButton)
        deleteButton = findViewById(R.id.deleteButton)

        saveButton.setOnClickListener {
            val inputText = inputEditText.text.toString()
            outputTextView.text = inputText
            inputEditText.text.clear()
        }

        deleteButton.setOnClickListener {
            showDeleteConfirmationDialog()
        }
    }

    private fun showDeleteConfirmationDialog() {
        val builder = AlertDialog.Builder(this)
        val title = builder.setTitle(/* title = */ "Подтвердите удаление")
        builder.setMessage("Вы уверены, что хотите удалить данные?")
        builder.setPositiveButton("Удалить") { _: DialogInterface, _: Int ->
            outputTextView.text = ""
            Snackbar.make(findViewById(android.R.id.content), "Данные удалены", Snackbar.LENGTH_SHORT).show()
        }
        builder.setNegativeButton("Отмена") { dialog: DialogInterface, _: Int ->
            dialog.dismiss()
        }
        builder.show()
    }
}
