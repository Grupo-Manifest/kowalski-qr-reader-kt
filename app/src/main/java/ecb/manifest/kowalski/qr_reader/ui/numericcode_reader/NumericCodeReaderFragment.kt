package ecb.manifest.kowalski.qr_reader.ui.numericcode_reader

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import ecb.manifest.kowalski.qr_reader.R
import ecb.manifest.kowalski.qr_reader.databinding.FragmentNumericCodeReaderBinding

class NumericCodeReaderFragment : Fragment() {
    private lateinit var binding: FragmentNumericCodeReaderBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNumericCodeReaderBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.ocrReturnButton.setOnClickListener {
            findNavController().navigate(R.id.action_numericCodeReaderFragment_to_mainScreenFragment)
        }
    }
}