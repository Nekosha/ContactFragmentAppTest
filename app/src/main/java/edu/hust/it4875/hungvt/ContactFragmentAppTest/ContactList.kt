package edu.hust.it4875.hungvt.ContactFragmentAppTest

class ContactList: ArrayList<ContactEntry>() {
    init {
        for (i in 1..10) add(ContactEntry(i.toString(),"placeholder #" + i, ""))
    }
}