package com.devspace.recyclerview

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val rvlist = findViewById<RecyclerView>(R.id.rv_list)
        val ivList = findViewById<ImageView>(R.id.iv_list)
        val ivGrid = findViewById<ImageView>(R.id.iv_grid)
        val adapter = ContactListAdapter()

        rvlist.adapter = adapter
        rvlist.layoutManager = LinearLayoutManager(this)
        adapter.submitList(contacts)

        ivGrid.setOnClickListener {
            rvlist.layoutManager = GridLayoutManager(this,2)
        }

        ivList.setOnClickListener {
            rvlist.layoutManager = LinearLayoutManager(this)
        }

        adapter.setOnClickListener {contact ->
            val intent = Intent (this,ContactDetails::class.java)
            intent.putExtra("name", contact.name)
            intent.putExtra("phone", contact.phone)
            intent.putExtra("icon", contact.icon)

            startActivity(intent)
            Log.d("Pernas", contact.toString())
        }

    }
}

val contacts = listOf(
    Contact (name = "Cleiton",
        phone = "(55)79 955698655",
        R.drawable.sample2
    ),
    Contact (name = "Cleidir",
        phone = "(55)79 955788655",
        R.drawable.sample14
    ),
    Contact (name = "Isadora",
        phone = "(55)79 888698655",
        R.drawable.sample11
    ),
    Contact (name = "Luciana",
        phone = "(55)79 955688622",
        R.drawable.sample3
    ),
    Contact (name = "Chimbinha",
        phone = "(55)79 955697454",
        R.drawable.sample12
    ),
    Contact (name = "Craque Neto",
        phone = "(55)79 955688555",
        R.drawable.sample10
    ),
    Contact (name = "Carminha",
        phone = "(55)79 922688622",
        R.drawable.sample7
    ),
    Contact (name = "Malu",
        phone = "(55)79 000488622",
        R.drawable.sample4
    ),
    Contact (name = "Rita",
        phone = "(55)79 955688777",
        R.drawable.sample15
    ),
    Contact (name = "Robert Niro",
        phone = "(55)79 955688440",
        R.drawable.sample9
    ),
    Contact (name = "Lais",
        phone = "(55)79 024688622",
        R.drawable.sample5
    ),
    Contact (name = "Clóvis",
        phone = "(55)79 955612122",
        R.drawable.sample8
    ),
    Contact (name = "Marymar",
        phone = "(55)79 575688622",
        R.drawable.sample6
    ),

)