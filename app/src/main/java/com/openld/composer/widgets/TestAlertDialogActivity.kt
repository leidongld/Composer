package com.openld.composer.widgets

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.openld.composer.widgets.ui.theme.ComposerTheme

class TestAlertDialogActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComposerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column(modifier = Modifier.fillMaxSize()) {
                        ShowAlertDialogButton()
//                        ShowCustomDialogButton()
                    }
                }
            }
        }
    }

    @Composable
    private fun ShowCustomDialogButton() {
        TODO("Not yet implemented")
    }

    @Composable
    private fun ShowAlertDialogButton() {
        var isShow by remember { mutableStateOf(false) }

        Button(
            onClick = { isShow = true },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(text = "展示一个AlertDialog")
        }

        if (isShow) {
            AlertDialog(
                onDismissRequest = {
                    Toast.makeText(this@TestAlertDialogActivity, "用户取消了弹窗", Toast.LENGTH_SHORT)
                        .show()
                    isShow = false
                },
                title = {
                    Text(
                        text = "开启位置服务",
                        fontWeight = FontWeight.W700,
                        style = MaterialTheme.typography.h6
                    )
                },
                text = {
                    Text(
                        text = "这将意味着，我们会给您提供精准的位置服务，并且您将接受关于您订阅的位置信息",
                        fontSize = 16.sp
                    )
                },
                confirmButton = {
                    TextButton(
                        onClick = {
                            Toast.makeText(
                                this@TestAlertDialogActivity,
                                "用户确认了",
                                Toast.LENGTH_SHORT
                            ).show()
                            isShow = false
                        },
                    ) {
                        Text(
                            "确认",
                            fontWeight = FontWeight.W700,
                            style = MaterialTheme.typography.button
                        )
                    }
                },
                dismissButton = {
                    TextButton(
                        onClick = {
                            Toast.makeText(
                                this@TestAlertDialogActivity,
                                "用户取消了",
                                Toast.LENGTH_SHORT
                            ).show()
                            isShow = false
                        }
                    ) {
                        Text(
                            "取消",
                            fontWeight = FontWeight.W700,
                            style = MaterialTheme.typography.button
                        )
                    }
                }
            )
        }
    }
}