package com.boriskunda.boriskundainterview27520

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_countries_list.*

/**
 * A simple [Fragment] subclass.
 */
class CountriesListFragment : Fragment(),CountryAdapter.OnRVItemClickListener {

    private val sharedViewModel: SharedViewModel by viewModels()
    private lateinit var activityFromMain: Activity
    private lateinit var rv:RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedViewModel.loadCountriesList()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_countries_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val countryAdapter = CountryAdapter(activityFromMain, this)

        rv = view.findViewById(R.id.countries_rv)

        rv.apply {
            layoutManager = LinearLayoutManager(activityFromMain)
            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
            adapter = countryAdapter
        }




        sharedViewModel.countriesListLd.observe(viewLifecycleOwner,
            Observer {
                countryAdapter.apply {
                    countriesList = it
                    notifyDataSetChanged()
                }
            })
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        activityFromMain = (context as MainActivity)
    }

    override fun onRVItemClick(country: Country) {
       sharedViewModel.openDetailsScreen()
    }


}
