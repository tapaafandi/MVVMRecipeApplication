package com.tapaafandi.mvvmrecipeapplication.presentation.components

import androidx.compose.foundation.layout.ConstraintLayout
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.TextUnit

@Composable
fun CircularIndeterminateProgressBar(
        isDisplayed: Boolean
) {
    if (isDisplayed) {
        ConstraintLayout(
                modifier = Modifier.fillMaxSize()
        ) {
            val (progressBar, text) = createRefs()
            CircularProgressIndicator(
                    modifier = Modifier.constrainAs(progressBar) {
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
            )
            Text(
                    text = "Loading...",
                    style = TextStyle(
                            color = Color.Black,
                            fontSize = TextUnit.Companion.Sp(15)
                    ),
                    modifier = Modifier.constrainAs(text) {
                        top.linkTo(progressBar.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
            )
        }
    }
}