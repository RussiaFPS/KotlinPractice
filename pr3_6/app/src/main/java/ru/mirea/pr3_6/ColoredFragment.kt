package ru.mirea.pr3_6

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment


class ColoredFragment() : Fragment() {
    private var index:Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_colored, container, false)
        val textView:TextView = view.findViewById(R.id.color)

        val args = this.arguments
        index = args?.getInt("id")?: 0

        val colorValues = resources.getIntArray(R.array.colorValues)
        textView.setBackgroundColor(colorValues[index])

        return view
    }


    companion object {
        @JvmStatic
        fun newInstance() =
            ColoredFragment().apply {}
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("id", index)
    }
}