package com.tapaafandi.mvvmrecipeapplication.presentation.ui.recipe_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.tapaafandi.mvvmrecipeapplication.presentation.components.RecipeCard
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RecipeListFragment : Fragment() {

    private val viewModel: RecipeListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {

                val recipes = viewModel.recipes.value

                val query = viewModel.query.value

                Column {
                    Surface(
                            modifier = Modifier
                                    .fillMaxWidth(),
                            color = MaterialTheme.colors.primary,
                            elevation = 8.dp
                    ) {
                        Row(
                                modifier = Modifier.fillMaxWidth()
                        ) {
                            TextField(
                                    modifier = Modifier
                                            .fillMaxWidth(0.9f)
                                            .padding(8.dp),
                                    value = query,
                                    onValueChange = { newValue ->
                                        viewModel.onQueryChanged(newValue)
                                    },
                                    label = {
                                        Text(text = "Search")
                                    },
                                    keyboardOptions = KeyboardOptions(
                                            keyboardType = KeyboardType.Text,
                                            imeAction = ImeAction.Search
                                    ),
                                    leadingIcon = {
                                        Icon(Icons.Filled.Search)
                                    },
                                    onImeActionPerformed = { action, softKeyboardController ->
                                        if (action == ImeAction.Search) {
                                            viewModel.newSearch(query)
                                            softKeyboardController?.hideSoftwareKeyboard()
                                        }
                                    },
                                    textStyle = TextStyle(color = MaterialTheme.colors.onSurface),
                                    backgroundColor = MaterialTheme.colors.surface,
                            )
                        }
                    }
                    LazyColumn {
                        itemsIndexed(
                                items = recipes
                        ){ index, recipe ->
                            RecipeCard(recipe = recipe, onClick = {})
                        }
                    }
                }

            }
        }
    }
}