package br.ufrn.eaj.tads.adaptersexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.MultiAutoCompleteTextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private val FRUTAS = arrayOf(
        "Banana",
        "Maça",
        "Pera",
        "Abacaxi",
        "Tomate",
        "Uva",
        "Melão",
        "Goiaba",
        "Caja",
        "Caju",
        "Manga"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var fruitToListAdapter = ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, FRUTAS)

        autocomplete.setAdapter(fruitToListAdapter)
        autocomplete.setOnItemClickListener { adapterView, view, i, l ->
            var selected = adapterView.getItemAtPosition(i)
            Toast.makeText(this, "$selected $l", Toast.LENGTH_SHORT).show()
        }

        multiautocomplete.setAdapter(fruitToListAdapter)
        multiautocomplete.setTokenizer(MultiAutoCompleteTextView.CommaTokenizer())

        var fruitToSpinnerAdapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, FRUTAS)
        spinner.adapter = fruitToSpinnerAdapter
        spinner.onItemSelectedListener = object  : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(adapterView: AdapterView<*>?) {

            }

            override fun onItemSelected(adapterView: AdapterView<*>, view: View?, position: Int, id: Long) {
                var selected = adapterView.getItemAtPosition(position)
                Toast.makeText(this@MainActivity, "$selected", Toast.LENGTH_SHORT).show()
            }

        }
    }
}
