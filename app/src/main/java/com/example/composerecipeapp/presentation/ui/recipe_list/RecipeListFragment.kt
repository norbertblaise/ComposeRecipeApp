package com.example.composerecipeapp.presentation.ui.recipe_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Column
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.composerecipeapp.presentation.components.PulsingDemo
import com.example.composerecipeapp.presentation.components.SearchAppBar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RecipeListFragment : Fragment() {
    val viewModel: RecipeListViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return ComposeView(requireContext()).apply {
            setContent {
                val recipes = viewModel.recipes.value
                val query =
                     viewModel.query.value

                val categoryScrollPosition = viewModel.categoryScrollPosition
                val selectedCategory = viewModel.selectedCategory.value
                val loading = viewModel.loading.value
                Column {
                    SearchAppBar(
                        query = query,
                        onQueryChanged = viewModel::onQueryChanged,
                        onExecuteSearch = viewModel::newSearch,
                        scrollPosition = categoryScrollPosition,
                        selectedCategory = selectedCategory,
                        onSelectedCategoryChanged = viewModel::onSelectedCategoryChanged ,
                        onCategoryChangePosition = viewModel::onCategoryChangePosition
                    )
                    PulsingDemo()
//                    Box(
//                        modifier = Modifier.fillMaxSize()
//                    )
//                    {
//                        LazyColumn {
//                            itemsIndexed(
//                                items = recipes
//                            ) { index, recipe ->
//                                RecipeCard(
//                                    recipe = recipe,
//                                    onClick = {}
//                                )
//                            }
//                        }
//                        CircularIndeterminateProgressBar(isDisplayed = loading)
//                    }

                }
            }
        }
    }
}