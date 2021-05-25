package tech.thealamu.android.deeplinkslauncher.ui.edit

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import tech.thealamu.android.deeplinkslauncher.data.DeepLinkDao

@Suppress("UNCHECKED_CAST")
class EditViewModelFactory(val dao: DeepLinkDao) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(EditViewModel::class.java)) {
            return EditViewModel(dao) as T
        }
        throw IllegalArgumentException("viewmodel not found")
    }
}