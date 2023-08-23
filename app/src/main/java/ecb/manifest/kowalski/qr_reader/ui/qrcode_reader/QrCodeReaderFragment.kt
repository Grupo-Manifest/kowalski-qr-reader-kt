package ecb.manifest.kowalski.qr_reader.ui.qrcode_reader

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import ecb.manifest.kowalski.qr_reader.R
import ecb.manifest.kowalski.qr_reader.databinding.FragmentQrCodeReaderBinding

class QrCodeReaderFragment : Fragment() {
    private lateinit var binding: FragmentQrCodeReaderBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentQrCodeReaderBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.qrReturnButton.setOnClickListener {
            findNavController().navigate(R.id.action_qrCodeReaderFragment_to_mainScreenFragment)
        }
    }
}