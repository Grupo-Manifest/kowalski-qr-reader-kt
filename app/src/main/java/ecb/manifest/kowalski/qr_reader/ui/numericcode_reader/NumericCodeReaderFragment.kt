package ecb.manifest.kowalski.qr_reader.ui.numericcode_reader

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.camera.core.AspectRatio
import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageAnalysis
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import ecb.manifest.kowalski.qr_reader.R
import ecb.manifest.kowalski.qr_reader.data.ocr.OCRAnalyzer
import ecb.manifest.kowalski.qr_reader.databinding.FragmentNumericCodeReaderBinding
import java.lang.IllegalStateException
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class NumericCodeReaderFragment : Fragment() {
    private lateinit var binding: FragmentNumericCodeReaderBinding
    lateinit var viewModel: OCRViewModel

    private val cameraExecutor: ExecutorService by lazy {
        Executors.newSingleThreadExecutor()
    }

    private val imageAnalyzer by lazy {
        ImageAnalysis.Builder()
            .setTargetAspectRatio(AspectRatio.RATIO_16_9)
            .build()
            .also {
                it.setAnalyzer(
                    cameraExecutor,
                    OCRAnalyzer(::onTextFound)
                )
            }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNumericCodeReaderBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this)[OCRViewModel::class.java]
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (allPermissionsGranted()) {
            startCamera()
        } else {
            requestPermissions()
        }

        binding.ocrReturnButton.setOnClickListener {
            findNavController().navigate(R.id.action_numericCodeReaderFragment_to_mainScreenFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        cameraExecutor.shutdown()
    }

    private fun startCamera() {
        val cameraProvider = ProcessCameraProvider.getInstance(requireContext())
        cameraProvider.addListener(
            {
                val preview = Preview.Builder()
                    .build()
                    .also {
                        it.setSurfaceProvider(binding.ocrCameraPreview.surfaceProvider)
                    }
                cameraProvider.get().bind(preview, imageAnalyzer)
            },
            ContextCompat.getMainExecutor(requireContext())
        )
    }

    private fun onTextFound(text: String) {
        val resultMessage = viewModel.onTextFound(text)
        if (resultMessage != null) {
            Toast.makeText(requireContext(), resultMessage, Toast.LENGTH_SHORT)
                .show()
        }
    }

    private fun allPermissionsGranted() = REQUIRED_PERMISSIONS.all {
        ContextCompat
            .checkSelfPermission(requireContext(), it) == PackageManager.PERMISSION_GRANTED
    }

    private fun requestPermissions() {
        ActivityCompat.requestPermissions(
            requireActivity(),
            REQUIRED_PERMISSIONS,
            REQUEST_CODE_PERMISSIONS,
        )
    }

    private fun ProcessCameraProvider.bind(
        preview: Preview,
        imageAnalyzer: ImageAnalysis
    ) = try {
        unbindAll()
        bindToLifecycle(
            requireActivity(),
            CameraSelector.DEFAULT_BACK_CAMERA,
            preview,
            imageAnalyzer,
        )
    } catch (e: IllegalStateException) {
        Log.e(TAG, "Binding failed", e)
    }

    private companion object {
        val TAG = NumericCodeReaderFragment::class.java.simpleName
        const val REQUEST_CODE_PERMISSIONS = 10
        val REQUIRED_PERMISSIONS = arrayOf(Manifest.permission.CAMERA)
    }
}