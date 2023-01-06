package com.openld.composer.first

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.openld.composer.R
import com.openld.composer.ui.theme.ComposerTheme

class FirstTestActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background
                ) {
                    Column() {
                        MessageCard(
                            FirstCardBean(
                                "碧根果", "这是碧根果的描述", R.drawable.bigenguo
                            )
                        )
                        MessageCard(
                            FirstCardBean(
                                "开心果", "这是开心果的描述", R.drawable.kaixinguo
                            )
                        )
                        MessageCard(
                            FirstCardBean(
                                "核桃", "这是核桃的描述", R.drawable.hetao
                            )
                        )
                        MessageCard(
                            FirstCardBean(
                                "红枣", "这是红枣的描述", R.drawable.hongzao
                            )
                        )
                        MessageCard(
                            FirstCardBean(
                                "蛋糕", "这是蛋糕的描述", R.drawable.dangao
                            )
                        )
                        MessageCard(
                            FirstCardBean(
                                "布丁", "这是布丁的描述", R.drawable.buding
                            )
                        )
                        MessageCard(
                            FirstCardBean(
                                "蚕豆", "这是蚕豆的描述", R.drawable.candou
                            )
                        )
                        MessageCard(
                            FirstCardBean(
                                "蛋黄酥", "这是蛋黄酥的描述", R.drawable.danhuangsu
                            )
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun MessageCard(cardBean: FirstCardBean) {
    Surface(
        shape = MaterialTheme.shapes.medium,
        elevation = 2.dp,
        modifier = Modifier
            .padding(8.dp, 8.dp)
            .clickable {
//                Toast
//                    .makeText(this@FirstTestActivity, "点击了${cardBean.title}", Toast.LENGTH_SHORT)
//                    .show()
            }
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {
            Image(
                painter = painterResource(id = cardBean.imageId),
                contentDescription = cardBean.title,
                Modifier
                    .size(56.dp)
                    .clip(CircleShape)
                    .border(
                        width = 2.dp,
                        color = MaterialTheme.colors.secondary,
                        shape = CircleShape
                    )
                    .align(alignment = Alignment.CenterVertically)
            )
            Spacer(modifier = Modifier.padding(horizontal = 8.dp))
            Column(
                modifier = Modifier
                    .align(alignment = Alignment.CenterVertically)
                    .padding(vertical = 8.dp)
            ) {
                Text(
                    text = "Hello, ${cardBean.title}",
                    color = Color.Black,
                    fontSize = 24.sp,
                    maxLines = 1,
                    style = MaterialTheme.typography.subtitle2
                )
                Spacer(modifier = Modifier.size(8.dp))
                Text(
                    text = cardBean.description,
                    color = Color.Gray,
                    fontSize = 18.sp,
                    maxLines = 1,
                    style = MaterialTheme.typography.body2
                )
            }
        }
    }
}

@Composable
fun Greeting2(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    ComposerTheme {
        Greeting2("Android")
    }
}