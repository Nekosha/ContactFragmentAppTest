package edu.hust.it4875.hungvt.ContactFragmentAppTest

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class ContactDetailFragment : Fragment() {
    private var contact_name: String? = null
    private var contact_detail: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            contact_name   = it.getString("name")
            contact_detail = it.getString("detail")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.contact_detail, container, false)
        Log.v("detail view create", view.toString())
        view.findViewById<TextView>(R.id.contact_detail_name).text = contact_name
        //view.findViewById<TextView>(R.id.contact_detail_detail).text = contact_detail
        return view
    }
    companion object {
        @JvmStatic
        fun newInstance(args: Bundle) =
            ContactDetailFragment().apply {
                arguments = args
            }
    }
}