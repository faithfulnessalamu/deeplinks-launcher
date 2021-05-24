package tech.thealamu.android.deeplinkslauncher.ui.edit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import tech.thealamu.android.deeplinkslauncher.data.DeepLink
import tech.thealamu.android.deeplinkslauncher.data.getAppDatabase
import tech.thealamu.android.deeplinkslauncher.databinding.ActivityEditBinding
import tech.thealamu.android.deeplinkslauncher.ui.main.MainActivity

class EditActivity : AppCompatActivity() {
    lateinit var binding: ActivityEditBinding
    lateinit var viewModel: EditViewModel

    // deep link id for this session if we received any
    var sessionId: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Init viewModel
        val appDao = getAppDatabase(this).deeplinksDao()
        val viewModelFactory = EditViewModelFactory(appDao)
        viewModel = ViewModelProvider(this, viewModelFactory).get(EditViewModel::class.java)

        registerListeners()

        intent?.let { intent ->
            val tmpId = intent.getIntExtra(MainActivity.EXTRA_LINK_ID, -1)
            if (tmpId != -1) {
                sessionId = tmpId
                populateInputs(sessionId!!)
            }
        }
    }

    private fun registerListeners() {
        binding.btnDone.setOnClickListener {
            updateAndFinish()
        }

        binding.menuItemClose.setOnClickListener {
            finish()
        }

        binding.menuItemDelete.setOnClickListener {
            // just close if we aren't editing an existing link
            if (sessionId == null) finish()
            // remove this deep link
            viewModel.deleteDeeplink(DeepLink("", "", "", sessionId))
            finish()
        }
    }

    private fun populateInputs(sessionId: Int) {
        viewModel.getDeeplink(sessionId).observe(this, Observer {
            it?.let {
                with(binding.content) {
                    editTitle.setText(it.title)
                    editDesc.setText(it.description)
                    editDeeplink.setText(it.uri)
                }
            }
        })
    }

    private fun updateAndFinish() {
        val title = binding.content.editTitle.text.toString()
        val desc = binding.content.editDesc.text.toString()
        val link = binding.content.editDeeplink.text.toString()

        viewModel.saveDeeplink(DeepLink(title, desc, link, sessionId))

        finish()
    }
}