package ecb.manifest.kowalski.qr_reader.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import ecb.manifest.kowalski.qr_reader.R
import ecb.manifest.kowalski.qr_reader.databinding.FragmentMainScreenBinding

class MainScreenFragment : Fragment() {
    private lateinit var binding: FragmentMainScreenBinding
    private lateinit var viewModel: MainActivityViewModel
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainScreenBinding.inflate(inflater, container, false)
        navController = findNavController()

        viewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]
        setupClickListeners()
        return binding.root
    }

    private fun setupClickListeners() {
        viewModel.setButtonClick(binding.qrCodeButton) {
            navController.navigate(R.id.action_mainScreenFragment_to_qrCodeReaderFragment)
        }
        viewModel.setButtonClick(binding.numericCodeButton) {
            navController.navigate(R.id.action_mainScreenFragment_to_numericCodeReaderFragment)
        }
    }
}