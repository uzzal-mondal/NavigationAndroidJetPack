package com.cloudeducertios.navhost

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.cloudeducertios.navhost.databinding.FragmentHomeBinding
import com.cloudeducertios.navhost.databinding.FragmentLoginBinding
import com.cloudeducertios.navhost.model.Employee
import java.lang.Exception


class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        // return inflater.inflate(R.layout.fragment_home, container, false)
        binding.listHomeBtn.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_listFragment)
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var employeeData = arguments?.getSerializable("employee") as Employee// down casting.

        binding.nameUzzal.text = employeeData.name
        binding.eamil1.text = employeeData.address
        binding.phn1.text = employeeData.number
        binding.designationTv.text = employeeData.designation

        binding.nameMuja.text = employeeData.name
        binding.email3.text = employeeData.address
        binding.phn2.text = employeeData.number
        binding.designationTv.text = employeeData.designation


    }
}