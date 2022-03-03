package com.mdc.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.ColorRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import com.mdc.designtoken.R
import com.mdc.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            this.window.statusBarColor = ContextCompat.getColor(this, R.color.primary)
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Column(modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .fillMaxHeight(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    ShoppingCardUi()
                }
            }
        }
    }
}


@Composable
fun ShoppingCardUi() {
    Card(backgroundColor = colorResource(id = R.color.surface),
        elevation = 8.dp,
        shape = RoundedCornerShape(8.dp)) {
        Column {
            headerUi()
            imageUi()
            footer()
        }
    }

}

@Composable
private fun imageUi() {
    Image(painter = painterResource(id = R.drawable.bg),
        modifier = Modifier.width(250.dp),
        contentDescription = "")
}

@Composable
private fun headerUi() {
    Row(horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .width(250.dp)
            .padding(start = 8.dp, top = 4.dp, bottom = 8.dp)) {
        Image(painter = painterResource(id = R.drawable.header),
            contentDescription = "profile picture", colorFilter = if (isSystemInDarkTheme()) {
                ColorFilter.colorMatrix(colorMatrix = grayScaleMatrix)
            } else null)
        Column(verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start) {
            Text(
                text = "Brooklyn Simmons",
                style = MaterialTheme.typography.body1,
                modifier = Modifier.padding(start = 8.dp),
                color = colorResource(
                    id = R.color.secondary),
            )
            Text(
                text = "Mental Health Counselor",
                fontStyle = FontStyle.Normal,
                style = MaterialTheme.typography.body2,
                modifier = Modifier.padding(start = 8.dp),
                color = colorResource(
                    id = R.color.secondary))
        }

        Column(verticalArrangement = Arrangement.Top,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_menu),
                tint = Color.Black, contentDescription = "menu",
            )
        }

    }
}


@Composable
fun footer() {
    Row(horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .width(250.dp)
            .padding(top = 12.dp, bottom = 12.dp, start = 12.dp, end = 12.dp)) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                painter = painterResource(id = R.drawable.ic_heart_like_favorite),
                tint = colorResource(id = R.color.primary), contentDescription = "heart",
            )
            Text(text = "6",
                style = MaterialTheme.typography.subtitle2,
                color = colorResource(id = R.color.secondary),
                modifier = Modifier.padding(start = 4.dp, bottom = 2.dp),
                fontSize = 14.sp)
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                painter = painterResource(id = R.drawable.ic_comment),
                tint = colorResource(id = R.color.primary), contentDescription = "heart",
            )
            Text(text = "6",
                style = MaterialTheme.typography.subtitle2,
                color = colorResource(id = R.color.secondary),
                modifier = Modifier.padding(start = 4.dp, bottom = 4.dp),
                fontSize = 14.sp)
        }
        Icon(
            painter = painterResource(id = R.drawable.ic_camera),
            tint = colorResource(id = R.color.primary), contentDescription = "heart",
        )

        Icon(
            painter = painterResource(id = R.drawable.ic_share),
            tint = colorResource(id = R.color.primary), contentDescription = "heart",
        )
    }
}


val grayScaleMatrix = ColorMatrix(
    floatArrayOf(
        0.33f, 0.33f, 0.33f, 0f, 0f,
        0.33f, 0.33f, 0.33f, 0f, 0f,
        0.33f, 0.33f, 0.33f, 0f, 0f,
        0f, 0f, 0f, 1f, 0f
    )
)


@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        Greeting("Android")
    }
}