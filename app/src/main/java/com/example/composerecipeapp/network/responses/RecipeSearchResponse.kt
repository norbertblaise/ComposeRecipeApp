package com.example.composerecipeapp.network.responses

import com.example.composerecipeapp.network.model.RecipeNetworkEntity
import com.google.gson.annotations.SerializedName

class RecipeSearchResponse(
    @SerializedName("count")
    var count: Int,

    @SerializedName("results")
    var recipes: List<RecipeNetworkEntity>,

    )