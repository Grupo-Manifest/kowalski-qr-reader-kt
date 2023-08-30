package ecb.manifest.kowalski.qr_reader.ui.numericcode_reader

import android.widget.Toast
import androidx.lifecycle.ViewModel
import java.lang.Double.parseDouble
import java.lang.NumberFormatException

class OCRViewModel : ViewModel() {
    fun onTextFound(foundText: String): String? {
        return if (foundText.isNumeric()) foundText
        else null
    }

    private fun String.isNumeric(): Boolean {
        var numeric = true

        try {
            parseDouble(this)
        } catch (e: NumberFormatException) {
            numeric = false
        }

        return numeric
    }
}