package com.zaghy.barcateam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.zaghy.barcateam.about.About
import com.zaghy.barcateam.databinding.ActivityMainBinding
import com.zaghy.barcateam.detailplayer.DetailPlayer
import com.zaghy.barcateam.playerlist.ListPlayerAdapter
import com.zaghy.barcateam.playerlist.Player

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var recyclerView: RecyclerView
    private val playerList = ArrayList<Player>()

    companion object {
        const val DETAIL_PLAYER = "detail_player"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.title.text = "FC Barcelona First Team"
        recyclerView = binding.listPlayer
        recyclerView.setHasFixedSize(true)

        playerList.addAll(getListPlayers());
        showRecyclerViewPlayer()

    }

    private fun showRecyclerViewPlayer() {
        recyclerView.layoutManager = LinearLayoutManager(this)
        val listPlayerAdapter = ListPlayerAdapter(playerList)
        recyclerView.adapter = listPlayerAdapter

        listPlayerAdapter.setOnItemCallback(object:ListPlayerAdapter.OnItemClickCallback{
            override fun onItemClicked(data: Player) {
                val intentDetail = Intent(this@MainActivity,DetailPlayer::class.java)
                intentDetail.putExtra(MainActivity.DETAIL_PLAYER,data)
                startActivity(intentDetail)
            }

        })
    }


    private fun getListPlayers(): ArrayList<Player> {
        val dataPlayerPhoto = resources.getStringArray(R.array.data_player_photo)
        val dataplayerName = resources.getStringArray(R.array.data_player_name)
        val dataPlayerPosition = resources.getStringArray(R.array.data_position_name)
        val dataPlayerShortDescription = resources.getStringArray(R.array.data_desc_overview)
        val dataPlayerLongDescription = resources.getStringArray(R.array.data_detail_desc)
        val listPlayer = ArrayList<Player>()
        for(index in dataplayerName.indices){
            listPlayer.add(Player(name=dataplayerName[index], position = dataPlayerPosition[index], shortDesc = dataPlayerShortDescription[index], longDesc = dataPlayerLongDescription[index], photo = dataPlayerPhoto[index]))
        }
        return listPlayer
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.about_page->{
                val aboutIntent = Intent(this@MainActivity,About::class.java)
                startActivity(aboutIntent)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}