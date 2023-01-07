package com.openld.composer.first

/**
 * author: lllddd
 * created on: 2023/1/5 16:18
 * description:第一张卡片的数据Bean
 */
data class ProductCardBean(
    val title: String,
    val description: String,
    val imageId: Int,
    val price: Float
) {
}