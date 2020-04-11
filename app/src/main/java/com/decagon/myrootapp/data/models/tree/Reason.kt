package com.decagon.myrootapp.data.models.tree


import com.google.gson.annotations.SerializedName

data class Reason(
    var isGift: Boolean = false,
    var isOcassion: Boolean = false,
    var isClimate:Boolean = false,
    var isJob:Boolean = false
)