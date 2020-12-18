package com.tapaafandi.mvvmrecipeapplication.di

import com.tapaafandi.mvvmrecipeapplication.network.RecipeService
import com.tapaafandi.mvvmrecipeapplication.network.model.RecipeDtoMapper
import com.tapaafandi.mvvmrecipeapplication.repository.RecipeRepository
import com.tapaafandi.mvvmrecipeapplication.repository.RecipeRepository_Impl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideRecipeRepository(
        recipeService: RecipeService,
        recipeDtoMapper: RecipeDtoMapper
    ): RecipeRepository{
        return RecipeRepository_Impl(recipeService, recipeDtoMapper)
    }
}