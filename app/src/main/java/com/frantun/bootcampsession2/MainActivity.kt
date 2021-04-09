package com.frantun.bootcampsession2

import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.frantun.bootcampsession2.adapter.TeamAdapter
import com.frantun.bootcampsession2.interfaces.IOnEventClick

class MainActivity : AppCompatActivity() {

    private lateinit var teamRecycler: RecyclerView
    private lateinit var adapter: TeamAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        teamRecycler = findViewById(R.id.team_recycler_view)

        val team = listOf("Daniela", "Danny", "Gerardo", "Joel", "Daniela", "Danny", "Gerardo", "Joel", "Daniela", "Danny", "Gerardo", "Joel", "Daniela", "Danny", "Gerardo", "Joel", "Daniela", "Danny", "Gerardo", "Joel", "Daniela", "Danny", "Gerardo", "Joel", "Daniela", "Danny", "Gerardo", "Joel", "Daniela", "Danny", "Gerardo", "Joel", "Daniela", "Danny", "Gerardo", "Joel")
        adapter = TeamAdapter(team, object : IOnEventClick {
            override fun onClick(position: Int) {
                Toast.makeText(applicationContext, "$position", Toast.LENGTH_LONG).show()
            }
        })

//        teamRecycler.layoutAnimation = AnimationUtils.loadLayoutAnimation(this, R.anim.layout_animation_left_to_right)
        teamRecycler.layoutManager = LinearLayoutManager(this)
//        teamRecycler.layoutManager = GridLayoutManager(this, 3)
        teamRecycler.adapter = adapter
    }
}