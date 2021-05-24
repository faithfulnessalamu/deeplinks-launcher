package tech.thealamu.android.deeplinkslauncher.ui.edit

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import tech.thealamu.android.deeplinkslauncher.data.AppDatabase
import tech.thealamu.android.deeplinkslauncher.data.DeepLink
import tech.thealamu.android.deeplinkslauncher.data.DeepLinkDao

class EditViewModel(val dao: DeepLinkDao): ViewModel() {
    fun saveDeeplink(d: DeepLink) {
        viewModelScope.launch {
            dao.insertDeeplink(d)
        }
    }
}