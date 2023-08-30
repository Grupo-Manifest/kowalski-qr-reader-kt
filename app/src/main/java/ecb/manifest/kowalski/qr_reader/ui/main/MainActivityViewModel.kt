package ecb.manifest.kowalski.qr_reader.ui.main

import android.widget.Button
import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {
    fun setButtonClick(button: Button, navAction: () -> Unit) {
        button.setOnClickListener { navAction.invoke() }
    }
}