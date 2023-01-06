package com.openld.composer

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.openld.composer.first.FirstTestActivity
import com.openld.composer.ui.theme.ComposerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background,
                    elevation = 2.dp
                ) {
                    Column() {
                        // TODO: 如何设置margin
                        EntryItem("第一个测试页面", R.drawable.bigenguo, FirstTestActivity::class.java)
                    }
                }
            }
        }
    }

    /**
     * 跳转桃木
     */
    @Composable
    private fun <T : ComponentActivity> EntryItem(entryName: String, iconId: Int, clazz: Class<T>) {
        Button(
            onClick = {
                jump2Page(clazz)
            },
            Modifier
                .fillMaxWidth()
                .padding(all = 8.dp)
        ) {
            Image(
                painter = painterResource(id = iconId),
                contentDescription = entryName,
                Modifier.size(32.dp)
            )
            Spacer(modifier = Modifier.size(ButtonDefaults.IconSize))
            Text(text = entryName)
        }
    }

    private fun <T : ComponentActivity> jump2Page(clazz: Class<T>) {
        startActivity(
            Intent(
                this@MainActivity,
                clazz
            )
        )
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposerTheme {
        Greeting("Android")
    }
}