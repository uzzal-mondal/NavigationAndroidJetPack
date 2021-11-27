package com.cloudeducertios.navhost

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.cloudeducertios.navhost.databinding.FragmentLoginBinding
import com.cloudeducertios.navhost.model.Employee
import com.cloudeducertios.navhost.model.generateEmployeeList


class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    private lateinit var defDesignation: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        //return inflater.inflate(R.layout.fragment_login, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showEmployeeData()
        showDesignationList()

        /*binding.submitBtn.setOnClickListener {
            // go to another fragment with take some data..
            var bundle = Bundle()
            bundle.putString("msg", "Welcome to login data")
            findNavController().navigate(R.id.action_loginFragment_to_homeFragment, bundle)
        }*/
    }

    private fun showEmployeeData() {
        binding.registerBtn.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registrationFragment)
        }
        binding.loginBtn.setOnClickListener {

            var name = binding.etName.text.toString();
            var address = binding.etAddress.text.toString()
            var number = binding.etNumber.text.toString()

            var employee = Employee(
                name = name,
                address = address,
                number = number,
                designation = defDesignation
            )


            if (name.isEmpty() || address.isEmpty() || number.isEmpty()) {
                Toast.makeText(
                    activity, "please, all fill up your registration form.", Toast.LENGTH_SHORT
                ).show()
            } else {
                val bundle = Bundle()
                bundle.putSerializable("employee", employee)
                findNavController().navigate(R.id.action_loginFragment_to_homeFragment, bundle)
                Toast.makeText(activity, "data is going", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun showDesignationList() {
        val listAdapter: ArrayAdapter<String> = ArrayAdapter(
            requireActivity(), android.R.layout.simple_spinner_dropdown_item,
            generateEmployeeList()
        )
        binding.desiginationSp.adapter = listAdapter

        binding.desiginationSp.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    defDesignation = parent?.getItemAtPosition(position).toString()

                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                    Toast.makeText(activity, "nothing selected", Toast.LENGTH_SHORT).show()
                }
            }
    }
}