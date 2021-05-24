package tech.thealamu.android.deeplinkslauncher.ui.edit

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import tech.thealamu.android.deeplinkslauncher.data.AppDatabase
import tech.thealamu.android.deeplinkslauncher.data.DeepLink
import tech.thealamu.android.deeplinkslauncher.data.DeepLinkDao

class EditViewModel(val dao: DeepLinkDao): ViewModel() {
    fun saveDeeplink(d: DeepLink) {
        if (d.id == null) {
            insertNewDeeplink(d)
        } else { // if sessionId exists, do update instead
            updateExistingDeeplink(d)
        }
    }

    fun insertNewDeeplink(d: DeepLink) {
        viewModelScope.launch {
            dao.insertDeeplink(d)
        }
    }

    fun updateExistingDeeplink(d: DeepLink){
        viewModelScope.launch {
            dao.updateDeeplink(d)
        }
    }

    fun getDeeplink(id: Int): LiveData<DeepLink> = dao.getDeeplinkWithID(id)
}