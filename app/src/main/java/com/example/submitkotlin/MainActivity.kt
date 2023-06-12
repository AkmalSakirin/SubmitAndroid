package com.example.submitkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TableLayout
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.submitkotlin.databinding.ActivityMainBinding
import com.example.submitkotlin.fragment.HomeFragment
import com.example.submitkotlin.fragment.ListFragment
import com.example.submitkotlin.fragment.ProfileFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    val framentHome: Fragment = HomeFragment()
    val fragmentProfile: Fragment = ProfileFragment()
    val fm:FragmentManager = supportFragmentManager
    var active:Fragment = framentHome

    private lateinit var bottomNavigationView: BottomNavigationView
    private lateinit var menu: Menu
    private lateinit var menuItem: MenuItem

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //setContentView(R.layout.activity_main)

        val tabLayout = findViewById<TabLayout>(R.id.tabsLayout)
        val viewPager = findViewById<ViewPager2>(R.id.viewPager2)

        val listFragment = arrayListOf(
            HomeFragment(),
            ListFragment(),
        )

        viewPager.adapter = ViewPager(listFragment,supportFragmentManager,lifecycle)

        TabLayoutMediator(tabLayout,viewPager){
            tab,position ->
            when(position){
               1 -> {
                   tab.text = "Home fragment"
               }
                2 -> {
                    tab.text = "List Fragment"
                }
            }
        }.attach()

        bottomNavigation()
        //imageAdapter()
        //textAdapter()
        //numberAdapter()
        modelAdapter()
    }

    private fun bottomNavigation() {
        fm.beginTransaction().add(R.id.container, framentHome).show(framentHome).commit()
        fm.beginTransaction().add(R.id.container, fragmentProfile).hide(fragmentProfile).commit()

        bottomNavigationView = binding.navView
        menu = bottomNavigationView.menu
        menuItem = menu.getItem(0)
        menuItem.isChecked = true

        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId){
                R.id.navigation_home -> {
                    callFragment(0, framentHome)
                }
                R.id.navigation_profile -> {
                    callFragment(1, fragmentProfile)
                }
            }
            false
        }
    }

    private fun callFragment(index:Int,fragment: Fragment){
        menuItem = menu.getItem(index)
        menuItem.isChecked = true
        fm.beginTransaction().hide(active).show(fragment).commit()
        active = fragment
    }

    private fun modelAdapter(){
        val marvel = listOf<MarvelModel>(
            MarvelModel(1, "Captain", R.drawable.marvel_1),
            MarvelModel(2, "Thor", R.drawable.marvel_2),
            MarvelModel(3, "Deadpool", R.drawable.marvel_3),
            MarvelModel(4, "Ironman", R.drawable.marvel_4),
            MarvelModel(5, "Spiderman", R.drawable.marvel_5),
            MarvelModel(6, "Hulk", R.drawable.marvel_6),
        )
        val marvelAdapter =MarvelAdapter(marvel, object : MarvelAdapter.OnAdapterListener{
            override fun onClick(marvel: MarvelModel) {
                Log.e("MainActivity", marvel.toString())
            }
        })
        findViewById<RecyclerView>(R.id.recyclerView).adapter = marvelAdapter
    }

    private fun imageAdapter(){
        val images = listOf<Int>(
            R.drawable.marvel_1,
            R.drawable.marvel_2,
            R.drawable.marvel_3,
            R.drawable.marvel_4,
            R.drawable.marvel_5,
            R.drawable.marvel_6,
        )

        val imageAdapter = ImageAdapter( images )
        findViewById<RecyclerView>(R.id.recyclerView).adapter = imageAdapter
    }

    private fun textAdapter(){
        val names = listOf<String>(
            "Akmal",
            "Birrul",
            "Anandito",
            "Fahrizul",
            "Rama",
            "Hermawan",
        )

        Log.e("MainActivity", "size ${names.size}")
        Log.e("MainActivity", names[1])
        names.forEach{name ->
            Log.e("MainActivity", name)
        }

        val textAdapter = TextAdapter(names, object : TextAdapter.OnAdapterListener{
            override fun onClick(name: String) {
                Toast.makeText(applicationContext, name, Toast.LENGTH_SHORT).show()
            }
        })
        findViewById<RecyclerView>(R.id.recyclerView).adapter = textAdapter
    }

    private fun numberAdapter(){

        val numbers = listOf<Int>(
            1,
            2,
            3,
            4,
            5,
            6,
        )

        val numberAdapter = NumberAdapter(numbers)
        findViewById<RecyclerView>(R.id.recyclerView).adapter = numberAdapter
    }

}