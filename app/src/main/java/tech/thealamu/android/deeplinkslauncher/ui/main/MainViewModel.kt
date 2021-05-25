package tech.thealamu.android.deeplinkslauncher.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import tech.thealamu.android.deeplinkslauncher.data.DeepLink
import tech.thealamu.android.deeplinkslauncher.data.DeepLinkDao

class MainViewModel(val dao: DeepLinkDao) : ViewModel() {
    fun getDeeplinks(): LiveData<List<DeepLink>> {
        return dao.getDeeplinks()
    }
}