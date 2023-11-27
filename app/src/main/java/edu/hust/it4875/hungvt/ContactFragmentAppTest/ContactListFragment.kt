package edu.hust.it4875.hungvt.ContactFragmentAppTest

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class ContactListFragment : Fragment() {
    private val list: ContactList = ContactList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.contact_list, container, false)
        Log.v("list view create", view.toString())
        with(view as RecyclerView) {
            layoutManager = LinearLayoutManager(context)
            adapter = ContactListAdapter(list, parentFragmentManager)
        }

        return view
    }

    fun add(name: String) {
        list.add(ContactEntry(list.size.toString(), name, ""))
        with (view as RecyclerView) {
            adapter!!.notifyItemInserted(list.size)
        }
        Log.v("contact list", "added contact $name")
    }
}