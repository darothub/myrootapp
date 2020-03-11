package com.decagon.myrootapp.data.models.tree


data class TreeResponse(
    var message: String,
    var payload: List<Tree>,
    var status: Int
)