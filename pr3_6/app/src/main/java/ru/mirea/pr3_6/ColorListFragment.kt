package ru.mirea.pr3_6

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity


class ColorListFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val view = inflater.inflate(R.layout.fragment_color_list, container, false)
        val listView = view.findViewById<ListView>(R.id.listView)
        val colorNames = resources.getStringArray(R.array.colorNames)

        val adapter =
            ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, colorNames)
        listView.adapter = adapter


        listView.setOnItemClickListener { adapterView, view, i, l ->
            val bundle = Bundle()
            bundle.putInt("id",i)
            val fragment = ColoredFragment()
            fragment.arguments = bundle
            fragmentManager?.beginTransaction()?.replace(R.id.fragment2,fragment)?.commit()
        }

        return view
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            ColorListFragment().apply {}
    }
}