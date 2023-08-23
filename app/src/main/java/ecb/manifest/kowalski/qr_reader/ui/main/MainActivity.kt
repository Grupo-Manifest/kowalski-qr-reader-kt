package ecb.manifest.kowalski.qr_reader.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ecb.manifest.kowalski.qr_reader.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}