package tech.thealamu.android.deeplinkslauncher.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import tech.thealamu.android.deeplinkslauncher.databinding.ActivityMainBinding
import tech.thealamu.android.deeplinkslauncher.ui.edit.EditActivity

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.content.deeplinksRecyclerview.adapter = DeeplinksListAdapter()

        binding.btnNew.setOnClickListener {
            navigateToEdit()
        }
    }

    private fun navigateToEdit() {
        // navigate to edit activity
        val intent = Intent(this, EditActivity::class.java)
        startActivity(intent)
    }
}