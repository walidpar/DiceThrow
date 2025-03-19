package edu.temple.dicethrow

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.rollDiceButton).setOnClickListener {

            val dieFragment1 = supportFragmentManager
                .findFragmentById(R.id.fragmentContainerView1) as DieFragment

            val dieFragment2 = supportFragmentManager
                .findFragmentById(R.id.fragmentContainerView2) as DieFragment

            dieFragment1.throwDie()
            dieFragment2.throwDie()
        }
    }
}