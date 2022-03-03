package com.mdc.myapplication.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Typography
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.mdc.designtoken.R

/**
 *  Base Application theme.
 *
 * @param darkTheme : When set to true, app will switch to dark theme.
 * @param content Content composable.
 */
@Composable
fun MyApplicationTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {


    val darkColorPalette = darkColors(
        primary = colorResource(id = R.color.primary),
        secondary = colorResource(id = R.color.secondary),
        surface = colorResource(id = R.color.surface),

        )

    val lightColor = lightColors(
        primary = colorResource(id = R.color.primary),
        secondary = colorResource(id = R.color.secondary),
        surface = colorResource(id = R.color.surface),
    )


    val typography = Typography(
        body1 = TextStyle(
            fontFamily = fonts,
            fontWeight = FontWeight.Medium,
            fontSize = dimensionResource(id = R.dimen.fontBodyBaseBold).value.sp,
            lineHeight = 16.sp
        ),

        body2 = TextStyle(
            fontFamily = fonts,
            fontWeight = FontWeight.Light,
            fontSize = dimensionResource(id = R.dimen.fontBodyBase).value.sp,
            lineHeight = 16.sp
        ),

        subtitle2 = TextStyle(
            fontFamily = fonts,
            fontWeight = FontWeight.Light,
            fontSize = dimensionResource(id = R.dimen.fontBodyLabel).value.sp,
            lineHeight = 16.sp
        )
    )


    val colors = if (darkTheme) {
        darkColorPalette
    } else {
        lightColor
    }

    MaterialTheme(
        colors = colors,
        typography = typography,
        shapes = Shapes,
        content = content
    )
}