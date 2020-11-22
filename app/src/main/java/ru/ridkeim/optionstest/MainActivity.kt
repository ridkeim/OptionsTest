package ru.ridkeim.optionstest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.PopupMenu
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val text = findViewById<TextView>(R.id.textView)
        text.setOnClickListener {
            showPopupMenu(it)
        }
    }

    private fun showPopupMenu(view: View?) {
        val popupMenu = PopupMenu(this, view)
        popupMenu.inflate(R.menu.popup_menu)
        popupMenu.setOnMenuItemClickListener {
            val stringId = when(it.itemId){
                R.id.action_item1 -> R.string.action_item1
                R.id.action_item2 -> R.string.action_item2
                R.id.action_item3 -> R.string.action_item3
                else -> R.string.action_nothing
            }
            val selectedString = getString(stringId)
            Toast.makeText(applicationContext,selectedString,Toast.LENGTH_SHORT).show()
            return@setOnMenuItemClickListener true
        }
        popupMenu.setOnDismissListener {
            Toast.makeText(applicationContext,"Popup menu dismissed",Toast.LENGTH_SHORT).show()
        }
        popupMenu.show()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val stringId = when(item.itemId){
            R.id.action_settings -> R.string.action_settings
            R.id.action_item1 -> R.string.action_item1
            R.id.action_item2 -> R.string.action_item2
            R.id.action_item3 -> R.string.action_item3
            else -> R.string.action_nothing
        }
        val text = findViewById<TextView>(R.id.textView)
        val selectedString = getString(stringId)
        text.text = resources.getString(R.string.choose_result, selectedString)
        return super.onOptionsItemSelected(item)
    }

}