package tech.thealamu.android.deeplinkslauncher.ui.edit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import tech.thealamu.android.deeplinkslauncher.data.AppDatabase
import tech.thealamu.android.deeplinkslauncher.data.DeepLink
import tech.thealamu.android.deeplinkslauncher.data.getAppDatabase
import tech.thealamu.android.deeplinkslauncher.databinding.ActivityEditBinding

class EditActivity : AppCompatActivity() {
    lateinit var binding: ActivityEditBinding
    lateinit var viewModel: EditViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Init viewModel
        val appDao = getAppDatabase(this).deeplinksDao()
        val viewModelFactory = EditViewModelFactory(appDao)
        viewModel = ViewModelProvider(this, viewModelFactory).get(EditViewModel::class.java)

        binding.btnDone.setOnClickListener {
            updateAndFinish()
        }
    }

    private fun updateAndFinish() {
        val title = binding.content.editTitle.text.toString()
        val desc = binding.content.editDesc.text.toString()
        val link = binding.content.editDeeplink.text.toString()

        var deepLink = DeepLink(title, desc, link)
        viewModel.saveDeeplink(deepLink)
        finish()
    }
}