package tech.thealamu.android.deeplinkslauncher.ui.edit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import tech.thealamu.android.deeplinkslauncher.databinding.ActivityEditBinding

class EditActivity : AppCompatActivity() {
    lateinit var binding: ActivityEditBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnDone.setOnClickListener {
            updateAndFinish()
        }
    }

    private fun updateAndFinish() {
        //TODO: Update repository with data
        finish()
    }
}