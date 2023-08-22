package ecb.manifest.kowalski.qr_reader.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

abstract class BaseViewModel : ViewModel() {
    protected val _uiState = MutableLiveData<UiState>()
    val uiState: LiveData<UiState> = _uiState

    sealed class UiState {}
}