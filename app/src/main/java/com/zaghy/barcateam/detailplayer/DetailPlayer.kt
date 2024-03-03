package com.zaghy.barcateam.detailplayer

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.bumptech.glide.Glide
import com.zaghy.barcateam.MainActivity
import com.zaghy.barcateam.R
import com.zaghy.barcateam.databinding.ActivityDetailPlayerBinding
import com.zaghy.barcateam.playerlist.Player

class DetailPlayer : AppCompatActivity() {
    private lateinit var binding:ActivityDetailPlayerBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailPlayerBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val dataPlayer = if (Build.VERSION.SDK_INT >= 33){
            intent.getParcelableExtra<Player>(MainActivity.DETAIL_PLAYER,Player::class.java)
        }else{
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Player>(MainActivity.DETAIL_PLAYER)
        }



        if(dataPlayer!=null){
            binding.titleName.text = dataPlayer.name
            binding.descLong.text = dataPlayer.longDesc
            binding.detailPosition.text = dataPlayer.position
            Glide.with(this@DetailPlayer)
                .load(dataPlayer.photo)
                .into(binding.playerDetailPhoto)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_detail_player,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.action_share ->{
                val sendIntent: Intent = Intent().apply {
                    action = Intent.ACTION_SEND
                    putExtra(Intent.EXTRA_TEXT,"${binding.titleName.text} (${binding.detailPosition.text})\n${binding.descLong.text}")
                    type = "text/plain"
                }
                val shareIntent = Intent.createChooser(sendIntent, null)
                startActivity(shareIntent)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}