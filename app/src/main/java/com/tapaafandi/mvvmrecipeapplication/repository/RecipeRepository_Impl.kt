package com.tapaafandi.mvvmrecipeapplication.repository

import com.tapaafandi.mvvmrecipeapplication.domain.model.Recipe
import com.tapaafandi.mvvmrecipeapplication.domain.util.DomainMapper
import com.tapaafandi.mvvmrecipeapplication.network.RecipeService
import com.tapaafandi.mvvmrecipeapplication.network.model.RecipeDtoMapper

class RecipeRepository_Impl(
    private val recipeService: RecipeService,
    private val mapper: RecipeDtoMapper
) : RecipeRepository {

    override suspend fun search(token: String, page: Int, query: String): List<Recipe> {
        return mapper.toDomainList(recipeService.search(token, page, query).recipes)
    }

    override suspend fun get(token: String, id: Int): Recipe {
        return mapper.mapToDomainModel(recipeService.get(token, id))
    }
}