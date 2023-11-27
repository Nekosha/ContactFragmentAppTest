package edu.hust.it4875.hungvt.ContactFragmentAppTest

data class ContactEntry(val id: String, val content: String, val details: String) {
    override fun toString(): String = content
}