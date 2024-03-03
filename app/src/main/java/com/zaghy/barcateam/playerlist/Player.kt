package com.zaghy.barcateam.playerlist

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Player(val name:String, val position:String, val shortDesc:String, val longDesc:String, val photo:String) :
    Parcelable
