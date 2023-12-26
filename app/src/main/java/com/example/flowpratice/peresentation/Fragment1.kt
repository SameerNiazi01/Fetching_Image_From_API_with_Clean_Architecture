package com.example.flowpratice.peresentation

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.flowpratice.databinding.Fragment1Binding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class Fragment1 : Fragment() {
        lateinit var binding:Fragment1Binding
    val newViewModel: ViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       binding=Fragment1Binding.inflate(layoutInflater)
        return  binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        CoroutineScope(Dispatchers.IO).launch {
          //  delay(5000)
            newViewModel.gettingData("yellow flowers")

        }
         viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                newViewModel.UiState.collectLatest {
                    if (it.isLoading==true){
                        binding.progress.visibility=View.VISIBLE
                        binding.text.visibility=View.GONE
                        Log.e("checkinguistate","loading")
                    }
                    else if (it.error!=null){
                        binding.progress.visibility=View.GONE
                        binding.text.visibility=View.VISIBLE
                        binding.text.text=" error in image fetching  ${it.response.total} "
                        Log.e("checkinguistate","error ${ it.error.toString() }")
                    }
                    else if (it.response!=null){
                        binding.progress.visibility=View.GONE
                        binding.text.visibility=View.VISIBLE
                        binding.text.text=" ${it.response.total} image fetched"
                        Log.e("checkinguistate","data  ${ it.response.total }")
                    }
                }
            }
         }

    }


}