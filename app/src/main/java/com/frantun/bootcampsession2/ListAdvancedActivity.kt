package com.frantun.bootcampsession2

import android.os.Bundle
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.frantun.bootcampsession2.adapter.AdvancedAdapter

class ListAdvancedActivity: AppCompatActivity() {

    private lateinit var advancedRecycler: RecyclerView
    private lateinit var adapter: AdvancedAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_advanced)

        advancedRecycler = findViewById(R.id.list_advanced_recycler_view)

        val team = listOf("Daniela", "Danny", "Gerardo", "Joel", "Daniela", "Danny", "Gerardo", "Joel", "Daniela", "Danny", "Gerardo", "Joel", "Daniela", "Danny", "Gerardo", "Joel", "Daniela", "Danny", "Gerardo", "Joel", "Daniela", "Danny", "Gerardo", "Joel", "Daniela", "Danny", "Gerardo", "Joel", "Daniela", "Danny", "Gerardo", "Joel", "Daniela", "Danny", "Gerardo", "Joel")
        adapter = AdvancedAdapter(team)

        advancedRecycler.layoutAnimation = AnimationUtils.loadLayoutAnimation(this, R.anim.layout_animation_left_to_right)
//        advancedRecycler.layoutManager = LinearLayoutManager(this)
        advancedRecycler.layoutManager = GridLayoutManager(this, 3)
        advancedRecycler.adapter = adapter
    }
}