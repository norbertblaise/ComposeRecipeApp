package com.example.composerecipeapp.presentation.components

import androidx.compose.animation.*
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.unit.dp
import com.example.composerecipeapp.R
import com.example.composerecipeapp.util.LoadPicture

enum class HeartButtonState {
    IDLE, ACTIVE
}

object HeartAnimationDefinition {


}


//@Composable
//private fun HeartButton(
//    modifier: Modifier,
//    buttonState: HeartButtonState,
//    state: Transition.TransitionAnimationState,
//    onToggle: () -> Unit
//) {
//    if (buttonState == buttonState) {
//        LoadPicture(drawable = R.drawable.heart_red).value?.let { image ->
//            Image(
//                bitmap = image.asImageBitmap(),
//                modifier = modifier
//                    .clickable(
//                        onClick = onToggle,
//                    )
//                    .width(state[heartSize])
//            )
//        }
//    } else {
//        LoadPicture(drawable = R.drawable.heart_grey).value?.let { image ->
//            Image(
//                bitmap = image.asImageBitmap(),
//                modifier = modifier
//                    .clickable(
//                        onClick = onToggle,
//                        indication = null
//                    )
//                    .width(state[heartSize])
//            )
//        }
//    }
//    }


@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AnimatedHeartButton(
//    modifier: Modifier,
    heartButtonState: HeartButtonState,
    onToggle: () -> Unit
) {

//    var heartButtonState by remember { mutableStateOf(HeartButtonState.IDLE) }
    val idleIconSize = 50.dp
    val expandedIconSize = 80.dp

    val heartTransitionDefinition = updateTransition(targetState = heartButtonState, label = "")

    AnimatedContent(targetState = heartButtonState,
        transitionSpec = {
            fadeIn(animationSpec = tween(500)) with
                    fadeOut(animationSpec = tween(500)) using
                    SizeTransform { idleSize, expandedSize ->
                        keyframes {
                            idleSize at 0
                            expandedSize at 100
                            idleSize at 200
                            durationMillis = 500

                        }

                    }
        }
    ) {
        targetState ->
        if (targetState == HeartButtonState.ACTIVE) {
            LoadPicture(drawable = R.drawable.heart_red).value?.let { image ->
                Image(
                    bitmap = image.asImageBitmap(),
                    modifier = Modifier
                        .clickable(
                            onClick = onToggle,
                        )
                        .width(idleIconSize),
                    contentDescription = null
                )
            }
        } else {
            LoadPicture(drawable = R.drawable.heart_grey).value?.let { image ->
                Image(
                    bitmap = image.asImageBitmap(),
                    modifier = Modifier
                        .clickable(
                            onClick = onToggle,
                        )
                        .width(idleIconSize),
                    contentDescription = null,
                )

            }
        }
    }

}