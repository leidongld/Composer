package com.openld.composer.widgets

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.openld.composer.main.ui.theme.ComposerTheme

/**
 * 组件总页面
 */
class WidgetsActivity : ComponentActivity() {
    private lateinit var mWidgetEntryList: List<WidgetEntryBean>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initEntryData()

        setContent {
            ComposerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    LazyColumn(
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxSize()
                    ) {
                        items(mWidgetEntryList) { entryItemBean ->
                            WidgetEntryItem(entryItemBean)
                        }
                    }
                }
            }
        }
    }

    private fun initEntryData() {
        mWidgetEntryList = mutableListOf(
            WidgetEntryBean("AlertDialog", TestAlertDialogActivity::class.java)
        )
    }

    @Composable
    private fun WidgetEntryItem(entryBean: WidgetEntryBean) {
        Button(onClick = { jump2Page(entryBean.clazz) }, modifier = Modifier.fillMaxWidth()) {
            Text(text = entryBean.name)
        }
    }

    /**
     * 页面跳转
     */
    private fun jump2Page(clazz: Class<out ComponentActivity>) {
        startActivity(Intent(this@WidgetsActivity, clazz))
    }
}
