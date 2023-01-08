package com.openld.composer.main

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.openld.composer.R
import com.openld.composer.first.FirstTestActivity
import com.openld.composer.ui.theme.ComposerTheme
import com.openld.composer.widgets.WidgetsActivity

class MainActivity : ComponentActivity() {
    private lateinit var mEntryList: List<EntryItemBean>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initEntries();

        setContent {
            ComposerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background,
                    elevation = 2.dp
                ) {
                    LazyColumn() {
                        items(mEntryList) { entryItemBean ->
                            EntryItem(entryItemBean)
                        }
                    }
                }
            }
        }
    }

    private fun initEntries() {
        mEntryList = mutableListOf(
            EntryItemBean(
                "第一个页面",
                R.drawable.badanmu,
                FirstTestActivity::class.java
            ),

            EntryItemBean(
                "组件学习",
                R.drawable.hetao,
                WidgetsActivity::class.java
            )
        )
    }

    /**
     * 跳转桃木
     */
    @Composable
    private fun EntryItem(entryItemBean: EntryItemBean) {
        Button(
            onClick = {
                jump2Page(entryItemBean.goalPageClass)
            },
            Modifier
                .fillMaxWidth()
                .padding(all = 8.dp)
        ) {
            Image(
                painter = painterResource(id = entryItemBean.iconId),
                contentDescription = entryItemBean.function,
                Modifier.size(32.dp)
            )
            Spacer(modifier = Modifier.size(ButtonDefaults.IconSize))
            Text(text = entryItemBean.function)
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