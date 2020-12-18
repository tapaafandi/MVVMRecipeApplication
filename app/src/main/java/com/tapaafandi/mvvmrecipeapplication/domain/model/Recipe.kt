package com.tapaafandi.mvvmrecipeapplication.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Recipe(
        var id: Int? = null,
        var title: String? = null,
        var publisher: String? = null,
        var featuredImage: String? = null,
        var rating: Int? = 0,
        var sourceUrl: String? = null,
        var description: String? = null,
        var cookingInstructions: String? = null,
        var ingredients: List<String> = listOf(),
        var dateAdded: String? = null,
        var dateUpdated: String? = null,
): Parcelable