package com.example.databindingfragment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.databindingfragment.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
        private  lateinit var drawerLayout: DrawerLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)

        var binding  = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
                drawerLayout =  binding.drawerLayout


//        DISPLAYING BACK BUTTON

        val navController = this.findNavController(R.id.myNavHostFrag)

//        HOOKING UP THE HAMBURGER
        NavigationUI.setupActionBarWithNavController(this, navController, drawerLayout)

//        SETTING UP DRAWER

        NavigationUI.setupWithNavController(binding.navView, navController)




        navController.addOnDestinationChangedListener { nc, destination, arguments ->
            if (destination.id == nc.graph.startDestination) {
                drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED)
            } else {
                drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)
            }


        }

//
    }
    //        DISPLAYING BACK BUTTON AND GETTING IT TO WORK
    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.myNavHostFrag)

        return  NavigationUI.navigateUp(navController, drawerLayout)
    }




}
