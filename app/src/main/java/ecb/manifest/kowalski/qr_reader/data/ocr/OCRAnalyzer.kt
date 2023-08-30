package ecb.manifest.kowalski.qr_reader.data.ocr

import androidx.camera.core.ImageAnalysis
import androidx.camera.core.ImageProxy

class OCRAnalyzer(
    private val textFoundListener: (String) -> Unit
) : ImageAnalysis.Analyzer {
    override fun analyze(image: ImageProxy) {
      // TODO
    }
}