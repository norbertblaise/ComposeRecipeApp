package com.example.composerecipeapp.presentation.components

import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.unit.dp


@Composable
fun PulsingDemo() {
    val color = colors.primary

    val infiniteTransition = rememberInfiniteTransition()

    val floatValues by infiniteTransition.animateFloat(
        initialValue = 40f,
        targetValue = 50f,
        animationSpec = infiniteRepeatable(
            animation = tween(500, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Restart
        ),
    )
    Canvas(
        modifier = Modifier
            .fillMaxWidth()
            .height(55.dp)
    ) {
        drawCircle(
            radius = floatValues,
            brush = SolidColor(color)
        )
    }
}

