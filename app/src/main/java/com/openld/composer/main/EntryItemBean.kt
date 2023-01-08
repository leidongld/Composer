package com.openld.composer.main

import androidx.activity.ComponentActivity

/**
 * author: lllddd
 * created on: 2023/1/7 21:25
 * description:主页的入口数据Bean
 */
data class EntryItemBean(
    val function: String,
    val iconId: Int,
    // out ComponentActivity 此时要求传入的类型为ComponentActivity或者其子类
    // in ComponentActivity 此时要求传入的类型为ComponentActivity或者其父类
    val goalPageClass: Class<out ComponentActivity>
) {
}