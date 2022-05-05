package com.example.composerecipeapp.network.model

import com.example.composerecipeapp.domain.model.Recipe
import com.example.composerecipeapp.domain.util.EntityMapper

class RecipeNetworkMapper : EntityMapper<RecipeNetworkEntity, Recipe> {
    override fun mapFromEntity(entity: RecipeNetworkEntity): Recipe {
        return Recipe(
            pk = entity.pk,
            title = entity.title,
            featuredImage = entity.featuredImage,
            rating = entity.rating,
            publisher = entity.publisher,
            sourceUrl = entity.sourceUrl,
            description = entity.description,
            cookingInstructions = entity.cookingInstructions,
            ingredients = entity.ingredients ?: listOf(),
            dateAdded = entity.dateAdded,
            dateUpdated = entity.dateUpdated

        )
    }

    override fun mapToEntity(domainModel: Recipe): RecipeNetworkEntity {
        return RecipeNetworkEntity(
            pk = domainModel.pk,
            title = domainModel.title,
            featuredImage = domainModel.featuredImage,
            rating = domainModel.rating,
            publisher = domainModel.publisher,
            sourceUrl = domainModel.sourceUrl,
            description = domainModel.description,
            cookingInstructions = domainModel.cookingInstructions,
            ingredients = domainModel.ingredients ?: listOf(),
            dateAdded = domainModel.dateAdded,
            dateUpdated = domainModel.dateUpdated
        )
    }

    fun fromEntityList(initial: List<RecipeNetworkEntity>): List<Recipe>{
        return initial.map{ mapFromEntity(it)}
    }

    fun toEntityList(initial: List<Recipe>): List<RecipeNetworkEntity>{
        return initial.map{mapToEntity(it)}
    }
}