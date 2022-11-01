package kr.ac.kumoh.s20170392.example.test001binding

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.activity.viewModels
import kr.ac.kumoh.s20170392.example.test001binding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val model: CountView by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        model.count.observe(this, Observer{ binding.countText.text = it.toString() })

        binding.countPlus.setOnClickListener() {
            model.add()
            //model.count.observe(this, Observer { binding.countText.text = it.toString() })
        }
        binding.countMinus.setOnClickListener() {
            model.sub()
            //model.count.observe(this, Observer { binding.countText.text = it.toString() })
        }

        binding.intenOther.setOnClickListener() {
            val intent = Intent(this, IntentActivity::class.java)
            startActivity(intent)
        }

        binding.intenYoutube.setOnClickListener() {
            var str = "fasdf"
            val uri = Uri.parse("https://www.youtube.com/results?search_query=" + str)
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }
    }
}