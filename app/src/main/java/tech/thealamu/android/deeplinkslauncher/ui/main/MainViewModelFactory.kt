package tech.thealamu.android.deeplinkslauncher.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import tech.thealamu.android.deeplinkslauncher.data.DeepLinkDao

@Suppress("UNCHECKED_CAST")
class MainViewModelFactory(val dao: DeepLinkDao) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(dao) as T
        }
        throw IllegalArgumentException("viewmodel not found")
    }
}