package ecb.manifest.kowalski.qr_reader.ui.main

import android.widget.Button
import ecb.manifest.kowalski.qr_reader.base.BaseViewModel

class MainActivityViewModel : BaseViewModel() {
    fun setButtonClick(button: Button, navAction: () -> Unit) {
        button.setOnClickListener { navAction.invoke() }
    }
}