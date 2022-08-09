package com.example.mapapplication.view

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.mapapplication.R
import com.example.mapapplication.pojo.Results
import com.example.mapapplication.viewmodels.MainViewModel
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.LatLngBounds
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MapsFragment : Fragment(), GoogleMap.OnMarkerClickListener {

    private val viewModel: MainViewModel by activityViewModels()
    private var resultsList:ArrayList<Results> = ArrayList(1)
    private var gmap:GoogleMap? = null

    private val callback = OnMapReadyCallback { googleMap ->
        gmap = googleMap
        googleMap.setOnMarkerClickListener(this)
        markLocations(googleMap)
    }

    private fun markLocations(googleMap: GoogleMap) {
        if (resultsList.isNotEmpty()) {
            val builder = LatLngBounds.Builder()
            for (result: Results in resultsList) {
                val addressInfo = result.AddressInfo
                val latitude = addressInfo?.Latitude
                val longitude = addressInfo?.Longitude
                val latLng = LatLng(latitude!!, longitude!!)
                val addressLine1 = "Address: " + addressInfo.AddressLine1 +
                        "\n" + addressInfo.Town
                val charginPoints = "Charging Points: " + result.NumberOfPoints
                val message = addressLine1 + "\n" + charginPoints
                val markerOptions = MarkerOptions().position(latLng)
                    .snippet(message)
                googleMap.addMarker(markerOptions)
                builder.include(markerOptions.position)
            }
            val bounds = builder.build()
            val padding = 0 // offset from edges of the map in pixels

            val cu = CameraUpdateFactory.newLatLngBounds(bounds, padding)
            googleMap.animateCamera(cu);
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_maps, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapFragment = childFragmentManager.findFragmentById(R.id.mapview) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)
        viewModel.repeatFun()
        getPOIData()
    }

    private fun getPOIData() {
        viewModel.getResult().observe(viewLifecycleOwner) { resultList->
            resultsList.clear()
            resultsList.addAll(resultList)
            gmap?.let { map -> markLocations(map) }
        }
    }

    override fun onMarkerClick(marker: Marker): Boolean {
        val builder = AlertDialog.Builder(requireContext())
        builder.setMessage(marker.snippet).show()
        return false
    }

    override fun onDetach() {
        super.onDetach()
        viewModel.repeatFun().cancel()
    }
}