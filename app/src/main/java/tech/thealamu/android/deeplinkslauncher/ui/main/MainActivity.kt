package tech.thealamu.android.deeplinkslauncher.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import tech.thealamu.android.deeplinkslauncher.data.getAppDatabase
import tech.thealamu.android.deeplinkslauncher.databinding.ActivityMainBinding
import tech.thealamu.android.deeplinkslauncher.ui.edit.EditActivity
import tech.thealamu.android.deeplinkslauncher.ui.edit.EditViewModel
import tech.thealamu.android.deeplinkslauncher.ui.edit.EditViewModelFactory

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Init viewModel
        val appDao = getAppDatabase(this).deeplinksDao()
        val viewModelFactory = MainViewModelFactory(appDao)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)

        val adapter = DeeplinksListAdapter(object: OnLinkClickListener {
            override fun onLinkClick(linkId: Int?) {
                navigateToEdit(linkId)
            }
        })

        binding.content.deeplinksRecyclerview.adapter = adapter
        viewModel.getDeeplinks().observe(this, Observer {
            it?.let {
                adapter.submitList(it)
            }
        })

        binding.btnNew.setOnClickListener {
            navigateToEdit()
        }
    }

    private fun navigateToEdit(linkId: Int? = null) {
        // navigate to edit activity
        val intent = Intent(this, EditActivity::class.java)
        // send linkId if it exists
        linkId?.let {
            intent.putExtra(MainActivity.EXTRA_LINK_ID, linkId)
        }
        startActivity(intent)
    }

    companion object {
        val EXTRA_LINK_ID = "extra_link_id"

        interface OnLinkClickListener {
            fun onLinkClick(linkId: Int?)
        }
    }
}