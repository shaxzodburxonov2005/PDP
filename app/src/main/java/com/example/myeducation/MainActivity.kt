package com.example.myeducation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.onNavDestinationSelected
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.myeducation.adapter.AdapterCourse
import com.example.myeducation.database.AppDatabase
import com.example.myeducation.databinding.ActivityMainBinding
import com.example.myeducation.databinding.ItemDialogcourseBinding
import com.example.myeducation.model.Course

class MainActivity : AppCompatActivity() {
    lateinit var navController: NavController
    private lateinit var binding:ActivityMainBinding
    lateinit var database: AppDatabase
    lateinit var list1:ArrayList<Course>
    lateinit var adapter:AdapterCourse

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        database=AppDatabase.getInstance(this)
        list1=ArrayList()
        list1.addAll(database.courseDao().getAllCourse())
        database.courseDao().getAllCourse()

        val navHostController=supportFragmentManager.findFragmentById(R.id.fragmentContainerView2)
        navController=navHostController!!.findNavController()
        setSupportActionBar(binding.toolbar)

        binding.toolbar.setOnMenuItemClickListener {
            when(it.itemId){
                R.id.addCourseFragment->{
                    val alertDialog=AlertDialog.Builder(this).create()
                    val alertDialogView=layoutInflater.inflate(R.layout.item_dialogcourse,binding.root,false)
                    alertDialog.setView(alertDialogView)
                    val bind=ItemDialogcourseBinding.bind(alertDialogView)
                    alertDialog.show()
                    bind.save.setOnClickListener {
                        val name=bind.save.text.toString()
                        val desc=bind.back.text.toString()
                        val course=Course(null,name,desc)
                        database.courseDao().insertCourse(course)
                        val courseByName=database.courseDao().getCourseByName(name)


                    }
                    alertDialog.dismiss()
                }
            }
            true
        }

        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            when (destination.id) {
                R.id.enterFragment -> binding.toolbar.visibility = View.GONE
                else -> binding.toolbar.visibility = View.VISIBLE
            }
        }
            setupActionBarWithNavController(navController)
        }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp()||super.onSupportNavigateUp()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.top_bar_menu,menu)
        navController.addOnDestinationChangedListener{controller,destination,arguments->
            when(destination.id){
                R.id.addCourseFragment->{
                    menu?.findItem(R.id.addCourse)?.isVisible=true
                }
                else->{
                    menu?.findItem(R.id.addCourse)?.isVisible=false
                }
            }
        }
        return true
    }

//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        return item.onNavDestinationSelected(navController)||super.onOptionsItemSelected(item)
//    }

}

