package ecb.manifest.kowalski.qr_reader.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.lifecycle.ViewModelProvider
import ecb.manifest.kowalski.qr_reader.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainActivityViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]

        setupClickListeners()
    }

    private fun setupClickListeners() {
        setButtonClick(binding.qrCodeButton) { viewModel.onQrCodeButtonClick() }
        setButtonClick(binding.numericCodeButton) { viewModel.onNumericCodeButtonClick() }
    }

    private fun setButtonClick(button: Button, clickAction: () -> Unit) {
        button.setOnClickListener { clickAction.invoke() }
    }
}