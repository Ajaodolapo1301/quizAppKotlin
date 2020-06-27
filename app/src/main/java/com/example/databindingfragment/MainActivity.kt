package com.example.databindingfragment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.databindingfragment.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)

        var binding  = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)



//        DISPLAYING BACK BUTTON

        val navController = this.findNavController(R.id.myNavHostFrag)
        NavigationUI.setupActionBarWithNavController(this, navController)
//
    }
    //        DISPLAYING BACK BUTTON AND GETTING IT TO WORK
    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.myNavHostFrag)

        return navController.navigateUp()
    }


//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//
//        var menuInflater = menuInflater
//
//
//        menuInflater.inflate(R.menu.menu, menu)
//
//        return super.onCreateOptionsMenu(menu)
//    }
//
//
//
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//
//        if (item?.itemId == R.id.menu){
//            var intent = Intent(applicationContext, Main2Activity::class.java)
//            startActivity(intent)
//        }
//        return super.onOptionsItemSelected(item)
//    }


}
