package com.decagon.myrootapp.data.models.tree


import com.google.gson.annotations.SerializedName

data class Reason(
    var isGift: Boolean? = null,
    var isOcassion: Boolean? = null,
    var isClimate:Boolean? = null,
    var isJob:Boolean? = null
)