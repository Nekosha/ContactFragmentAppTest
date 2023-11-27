package edu.hust.it4875.hungvt.ContactFragmentAppTest

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView

class ContactListAdapter(
    private val values: ContactList,
    private val manager: FragmentManager
) : RecyclerView.Adapter<ContactListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val item = LayoutInflater.from(parent.context).inflate(R.layout.contact_entry, parent, false)
        return ViewHolder(item)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view), View.OnClickListener,
        View.OnLongClickListener {
        init {
            view.isClickable = true
            view.setOnClickListener(this)
            view.setOnLongClickListener(this)
        }
        override fun onClick(view: View) {
            Log.v("contact entry", "clicked")
            val args = Bundle()
            args.putString("name", (view as TextView).text.toString())
            val detail_fragment = ContactDetailFragment.newInstance(args)
            manager.beginTransaction()
                .add(R.id.fragment_view, detail_fragment, "contact_detail")
                .addToBackStack("contact_detail")
                .commit()
        }

        override fun onLongClick(v: View?): Boolean {
            Log.v("contact entry", "held")
            return true
        }
    }
}