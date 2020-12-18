package com.tapaafandi.mvvmrecipeapplication.network.responses

import com.google.gson.annotations.SerializedName
import com.tapaafandi.mvvmrecipeapplication.network.model.RecipeDto

data class RecipeSearchResponse(

    @SerializedName("count")
    var count: Int,

    @SerializedName("results")
    var recipes: List<RecipeDto>
)