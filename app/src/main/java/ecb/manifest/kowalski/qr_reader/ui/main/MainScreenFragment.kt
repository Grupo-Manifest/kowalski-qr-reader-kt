package ecb.manifest.kowalski.qr_reader.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import ecb.manifest.kowalski.qr_reader.R
import ecb.manifest.kowalski.qr_reader.databinding.FragmentMainScreenBinding

class MainScreenFragment : Fragment() {
    private lateinit var binding: FragmentMainScreenBinding
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainScreenBinding.inflate(inflater, container, false)
        navController = findNavController()

        setupClickListeners()

        return binding.root
    }

    private fun setupClickListeners() {
        setButtonClick(binding.qrCodeButton) {
            navController.navigate(R.id.action_mainScreenFragment_to_qrCodeReaderFragment)
        }
        setButtonClick(binding.numericCodeButton) {
            navController.navigate(R.id.action_mainScreenFragment_to_numericCodeReaderFragment)
        }
    }

    private fun setButtonClick(button: Button, clickAction: () -> Unit) {
        button.setOnClickListener { clickAction.invoke() }
    }
}