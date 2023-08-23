package ecb.manifest.kowalski.qr_reader.ui.main

import ecb.manifest.kowalski.qr_reader.base.BaseViewModel

class MainActivityViewModel : BaseViewModel() {
    fun onQrCodeButtonClick() {
        println("Switching to Qr code screen")
    }

    fun onNumericCodeButtonClick() {
        println("Switching to Numeric code screen")
    }
}