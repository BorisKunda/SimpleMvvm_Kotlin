package com.boriskunda.boriskundainterview27520

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    private val sharedViewModel: SharedViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*

               observeViewModel(viewModel);
    }

    private void observeViewModel(final ProjectViewModel viewModel) {
        // Observe project data
        viewModel.getObservableProject().observe(this, new Observer<Project>() {
            @Override
            public void onChanged(@Nullable Project project) {
                if (project != null) {
                    binding.setIsLoading(false);
                    viewModel.setProject(project);
                }
            }
        });
    }

         */



      supportFragmentManager.beginTransaction().replace(R.id.container_fr, CountriesListFragment()).commit()

       // sharedViewModel.openDetailsScreen()

        sharedViewModel.openDetailsFragmentLd.observe(this, Observer(fun(it: Int?) {
            print("df")
            supportFragmentManager.beginTransaction().replace(R.id.container_fr, DetailsFragment())
                .addToBackStack(null).commit()
        }))


    }
}
