package com.boriskunda.boriskundainterview27520.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.boriskunda.boriskundainterview27520.model.Country
import com.boriskunda.boriskundainterview27520.CountryAdapter
import com.boriskunda.boriskundainterview27520.R
import com.boriskunda.boriskundainterview27520.viewmodel.SharedViewModel
import kotlinx.android.synthetic.main.fragment_countries_list.*

/**
 * A simple [Fragment] subclass.
 */
class CountriesListFragment : Fragment(),
    CountryAdapter.OnRVItemClickListener {

    private val sharedViewModel: SharedViewModel by activityViewModels()//access ViewModel of activity,which fragment associates with

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

        val countryAdapter =
            CountryAdapter(this)

        countries_rv.apply {
            layoutManager = LinearLayoutManager(context)
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

    override fun onRVItemClick(country: Country) {

        sharedViewModel.apply {
            setCurrentCountry(country)
            openDetailsScreen()
        }

    }



}
