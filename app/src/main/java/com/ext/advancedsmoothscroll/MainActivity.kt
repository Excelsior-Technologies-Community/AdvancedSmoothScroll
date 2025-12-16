package com.ext.advancedsmoothscroll

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.ext.smoothscroll.recycler.SmoothRecyclerView
import com.ext.smoothscroll.recycler.UltraSmoothLayoutManager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val recyclerView = findViewById<SmoothRecyclerView>(R.id.recyclerView)

        recyclerView.layoutManager = UltraSmoothLayoutManager(this)

        recyclerView.adapter = SimpleAdapter(
            List(150) { "AdvancedSmoothScroll Item #$it" }
        )

        // OPTIONAL: Test smooth scroll programmatically
        recyclerView.postDelayed({
            recyclerView.smoothScrollToPosition(80)
        }, 1500)
    }
}