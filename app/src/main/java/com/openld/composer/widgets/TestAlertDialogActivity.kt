package com.openld.composer.widgets

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.openld.composer.R
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
                        ShowAlertDialog1Button()
                        ShowAlertDialog2Button()
                        ShowCustomAlertDialogButton()
                    }
                }
            }
        }
    }

    /**
     * 展示自定义弹窗
     */
    @Composable
    private fun ShowCustomAlertDialogButton() {
        val context = LocalContext.current

        var isShow by remember {
            mutableStateOf(false)
        }

        var imageIndex by remember {
            mutableStateOf(-1)
        }

        Button(
            onClick = { isShow = true },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp, horizontal = 16.dp)
        ) {
            Text("展示自定义弹窗")
        }

        if (isShow) {
            Dialog(onDismissRequest = { isShow = false }) {
                Surface(
                    modifier = Modifier
                        .clip(RoundedCornerShape(8.dp))
                        .wrapContentSize(),
                    elevation = 8.dp
                ) {
                    Box(
                        modifier = Modifier
                            .wrapContentSize()
                            .background(Color.White),
                        contentAlignment = Alignment.Center,
                    ) {
                        Column(
                            modifier = Modifier.padding(24.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = "自定义弹窗",
                                fontSize = 24.sp,
                                color = Color.Blue,
                                fontWeight = FontWeight.Bold
                            )

                            Spacer(modifier = Modifier.padding(vertical = 8.dp))

                            Image(
                                painterResource(id = if (imageIndex == -1) R.drawable.travel else R.drawable.hat),
                                contentDescription = "这是一张图片",
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clickable {
                                        imageIndex *= -1
                                        Toast
                                            .makeText(
                                                context,
                                                "点击了图片",
                                                Toast.LENGTH_SHORT
                                            )
                                            .show()
                                    },
                                contentScale = ContentScale.FillWidth
                            )

                            Spacer(modifier = Modifier.padding(vertical = 8.dp))

                            LinearProgressIndicator(color = Color.Blue)

                            Spacer(modifier = Modifier.padding(vertical = 8.dp))

                            Text("加载中 ing...", color = Color.Blue)
                        }
                    }
                }
            }
        }
    }

    /**
     * 展示单按钮弹窗
     */
    @Composable
    private fun ShowAlertDialog1Button() {
        var isShow by remember {
            mutableStateOf(false)
        }

        Button(
            onClick = { isShow = true }, modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp, horizontal = 16.dp)
        ) {
            Text("展示单按钮AlertDialog")
        }

        if (isShow) {
            AlertDialog(modifier = Modifier.wrapContentSize(),
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
                buttons = {
                    Row(
                        modifier = Modifier.padding(all = 8.dp),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Button(
                            modifier = Modifier.fillMaxWidth(),
                            onClick = { isShow = false }
                        ) {
                            Text("必须接受！")
                        }
                    }
                }
            )
        }
    }

    /**
     * 展示双按钮弹窗
     */
    @Composable
    private fun ShowAlertDialog2Button() {
        var isShow by remember {
            mutableStateOf(false)
        }

        Button(
            onClick = { isShow = true },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp, horizontal = 16.dp)
        ) {
            Text(text = "展示双按钮AlertDialog")
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