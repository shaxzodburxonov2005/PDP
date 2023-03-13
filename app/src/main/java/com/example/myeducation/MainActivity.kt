package com.example.myeducation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.myeducation.database.AppDatabase
import com.example.myeducation.databinding.ActivityMainBinding
import com.example.myeducation.databinding.ItemDialogcourseBinding
import com.example.myeducation.model.Course
import com.example.myeducation.model.CourseWithMentor
import io.reactivex.rxjava3.core.Completable

class MainActivity : AppCompatActivity(),TeacherFragment.OnItemSelectedListener {
    lateinit var navController: NavController
    private lateinit var binding:ActivityMainBinding
    lateinit var database: AppDatabase
    var course:Course?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        database=AppDatabase.getInstance(this)
        val navHostController=supportFragmentManager.findFragmentById(R.id.fragmentContainerView2)
        navController=navHostController!!.findNavController()
        setSupportActionBar(binding.toolbar)

        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            when (destination.id) {
                R.id.enterFragment -> binding.toolbar.visibility = View.GONE
                else -> binding.toolbar.visibility = View.VISIBLE
            }
        }
        setupActionBarWithNavController(navController)

        binding.toolbar.setOnMenuItemClickListener {
            when(it.itemId){
                R.id.addCourse->{
                    when(navController.currentDestination?.id){
                        R.id.addCourseFragment->{
                            val alertDialog=AlertDialog.Builder(this).create()
                            val alertDialogView=layoutInflater.inflate(R.layout.item_dialogcourse,binding.root,false)
                            alertDialog.setView(alertDialogView)
                            val bind=ItemDialogcourseBinding.bind(alertDialogView)
                            alertDialog.show()

                            bind.save.setOnClickListener {

                                val name=bind.tvName.text.toString()
                                val desc=bind.tvDesc.text.toString()
                                val course=Course(null,name,desc)

                                Completable.fromCallable {
                                    database.courseDao().insertCourse(course)
                                }.subscribe()

                                alertDialog.dismiss()
                            }
                            bind.back.setOnClickListener {
                                alertDialog.dismiss()
                            }
                        }
                        R.id.teacherFragment->{
                            navController.navigate(R.id.addaNewTrainerFragment,
                                bundleOf("course" to course)
                            )
                        }
                    }

                }
            }
            true
        }


        }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp()||super.onSupportNavigateUp()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.top_bar_menu,menu)
        navController.addOnDestinationChangedListener{controller,destination,arguments->
            when(destination.id){
                R.id.addCourseFragment,R.id.teacherFragment->{
                    menu?.findItem(R.id.addCourse)?.isVisible=true
                }
                else->{
                    menu?.findItem(R.id.addCourse)?.isVisible=false
                }
            }
        }
        return true
    }

    override fun onItemSelected(course: CourseWithMentor) {
        this.course=course.course
    }

//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        return item.onNavDestinationSelected(navController)||super.onOptionsItemSelected(item)
//    }

}

