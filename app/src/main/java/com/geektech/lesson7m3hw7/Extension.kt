package com.geektech.lesson7m3hw7

import android.app.Activity
import android.content.Context
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity

fun Fragment.showToast(msg: String){
    Toast.makeText(requireContext(), msg, Toast.LENGTH_SHORT).show()
}

fun Context.showToast(msg: String){
    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
}

fun Activity.showToast(msg: String){
    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
}

fun FragmentActivity.addFragment(fragment: Fragment){
    supportFragmentManager.beginTransaction().add(R.id.container, fragment).commit()
}

fun FragmentActivity.replaceFragment(fragment: Fragment){
    supportFragmentManager.beginTransaction().replace(R.id.container, fragment).addToBackStack(null).commit()
}