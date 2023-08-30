package ecb.manifest.kowalski.qr_reader.ui.numericcode_reader

import androidx.lifecycle.ViewModel
import java.lang.Double.parseDouble
import java.lang.NumberFormatException

class OCRViewModel : ViewModel() {
    fun onTextFound(foundText: String) {
        // TODO
    }

    private fun String.isNumeric(): Boolean {
        var numeric = true

        try {
            val _num = parseDouble(this)
        } catch (e: NumberFormatException) {
            numeric = false
        }

        return numeric
    }
}