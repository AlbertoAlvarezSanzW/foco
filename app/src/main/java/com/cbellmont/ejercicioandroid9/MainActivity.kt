package com.cbellmont.ejercicioandroid9

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button.isEnabled = false

        editText1.addTextChangedListener(getTextWatcher())
        editText2.addTextChangedListener(getTextWatcher())

        button.setOnClickListener{
            val newContent = editText1.text.toString() + editText2.text.toString()
            editText1.setText(newContent)
        }

        button.setOnFocusChangeListener { _, _ ->
            textView.text = button.tag.toString()
        }

        editText1.setOnFocusChangeListener { _, _ ->
            textView.text = editText1.tag.toString()
        }

        editText2.setOnFocusChangeListener { _, _ ->
            textView.text = editText2.tag.toString()
        }
    }

    private fun enableButton() {
        button.isEnabled = editText1.text.isNotEmpty() && editText2.text.isNotEmpty()
    }

    private fun getTextWatcher() : TextWatcher {
        return object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                enableButton()
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
        }
    }
}