package edu.temple.dicethrow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlin.random.Random

class DieFragment : Fragment() {

    companion object {
        private const val DIE_SIDES = "sidenumber"

        fun newInstance(sides: Int): DieFragment {
            val fragment = DieFragment()
            val args = Bundle()
            args.putInt(DIE_SIDES, sides)
            fragment.arguments = args
            return fragment
        }
    }

    lateinit var dieTextView: TextView

    var PREVIOUS_ROLL = -1

    var currentRoll = -1

    var dieSides: Int = 6

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            dieSides = it.getInt(DIE_SIDES, 6)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_die, container, false).apply {
            dieTextView = findViewById(R.id.dieTextView)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (savedInstanceState == null) {
            throwDie()
        } else {
            currentRoll = savedInstanceState.getInt(PREVIOUS_ROLL.toString())
            dieTextView.text = currentRoll.toString()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(PREVIOUS_ROLL.toString(), currentRoll)
    }

    fun throwDie() {
        currentRoll = Random.nextInt(dieSides) + 1
        dieTextView.text = currentRoll.toString()
    }
}