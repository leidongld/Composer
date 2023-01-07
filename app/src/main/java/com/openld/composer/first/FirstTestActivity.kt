package com.openld.composer.first

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.openld.composer.R
import com.openld.composer.ui.theme.ComposerTheme

/**
 * 第一个简单的Compose页面
 */
class FirstTestActivity : ComponentActivity() {
    private lateinit var mProductList: List<ProductCardBean>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initProductsData()

        setContent {
            ComposerTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    // 这是产品列表
                    LazyColumn() {
                        items(mProductList) { productBean ->
                            ProductCard(cardBean = productBean)
                        }
                    }
                }
            }
        }
    }

    /**
     * 初始化产品数据
     */
    private fun initProductsData() {
        mProductList = mutableListOf(
            ProductCardBean(
                "碧根果",
                "        美国山核桃（学名：Carya illinoinensis (Wangenh.) K. Koch），属胡桃科的一种植物。又名“薄壳山核桃、薄皮山核桃”等。大乔木，高可达50米；芽黄褐色。小枝被柔毛。奇数羽状复叶，叶柄及叶轴初被柔毛；小叶具极短的小叶柄，顶端渐尖，边缘具单锯齿或重锯齿，初被腺体及柔毛，后来毛脱落而常在脉上有疏毛。雄性柔荑花序3条1束，几乎无总梗。雄蕊的花药有毛。雌性穗状花序直立，花序轴密被柔毛，总苞的裂片有毛。果实矩圆状或长椭圆形，革质，内果皮平滑，灰褐色；基部不完全2室。5月开花，9-11月果成熟。\n" +
                        "        为著名干果树种，在适生地区是优良的行道树和庭荫树，还可植作风景林，也适于河流沿岸、湖泊周围及平原地区“四旁”绿化。果仁可食用。",
                R.drawable.bigenguo,
                22.0F
            ),
            ProductCardBean(
                "开心果",
                "        阿月浑子（学名：Pistacia vera L.）是漆树科、黄连木属植物。小乔木，高5-7米。奇数羽状复叶互生，有小叶3-5枚，叶柄上面平，无翅或具狭翅。圆锥花序长4-10厘米，花序轴及分枝被微柔毛；子房卵圆形，长约1毫米，花柱长约0.5毫米。果较大，长圆形，长约2厘米，宽约1厘米，先端急尖，具细尖头，成熟时黄绿色至粉红色。 \n" +
                        "        原产于伊朗，分布于土耳其、意大利、法国、希腊、叙利亚、阿富汗、伊拉克等国，美国西南部、加利福尼亚州亦有一定种植面积，俄罗斯以及中国新疆等地，也已广泛栽培。 喜温、喜光树种，抗热抗寒性能极强，抗风沙，耐贫瘠，耐盐碱，对土壤要求不是很严。适宜在年均温≥11℃，极端低温≥-26℃，年有效积温4000℃以上地区生长。 \n" +
                        "        阿月浑子是世界四大干果之一，也是中国新疆喀什地区特有的珍贵木本油料、干果、药用等多种用途的经济树种，果实富含维生素、矿物质和抗氧化元素，具有低脂肪、低卡路里、高纤维的显著特点，对心脑血管疾病、老年性视网膜病变、防衰老等具有医疗保健功效，是世界坚果市场十分畅销的保健休闲食品。",
                R.drawable.kaixinguo,
                56.0F
            ),
            ProductCardBean(
                "胡桃",
                "       胡桃（学名：Juglans regia L.）是胡桃科、胡桃属植物，俗称核桃。乔木，高达20-25米；树干较别的种类矮，树冠广阔；树皮幼时灰绿色。奇数羽状复叶长25-30厘米，叶柄及叶轴幼时被有极短腺毛及腺体；小叶椭圆状卵形至长椭圆形。雄性葇荑花序下垂。雄花的苞片、小苞片及花被片均被腺毛；雄蕊6-30枚，花药黄色，无毛。雌花的总苞被极短腺毛，柱头浅绿色。果序短，杞俯垂；果实近于球状，无毛；果核稍具皱曲，有2条纵棱，顶端具短尖头；隔膜较薄，内里无空隙；内果皮壁内具不规则的空隙或无空隙而仅具皱曲。花期5月，果期10月。 \n" +
                        "       分布于中亚、西亚、南亚、欧洲和中国；在中国分布于于中国华北、西北、西南、华中、华南和华东。生于海拔400-1800米之山坡及丘陵地带，中国平原及丘陵地区常见栽培。 \n" +
                        "       胡桃具有较高的营养价值，其根、茎、叶、果实都各有用途，可以说“全身是宝”。是中国经济树种中分布最广的树种之一。中国以加工胡桃仁为主，主要产品有核桃仁食品、核桃油、胡桃保健品等，充分体现了胡桃种植、加工的巨大食用价值。 [10]  种仁含油量高，可生食，亦可榨油食用；木材坚实，是很好的硬木材料。 胡桃是十分珍贵的第三纪残遗植物，对研究古代植物区系的变迁和古地理及第三纪、第四纪气候的变化有着重要的科学价值。",
                R.drawable.hetao,
                18.0F
            ),
            ProductCardBean(
                "红枣",
                "     枣（学名：Ziziphus jujuba Mill.），别称枣子，大枣、刺枣，贯枣。鼠李科枣属植物，落叶小乔木，稀灌木，高达10余米，树皮褐色或灰褐色，叶柄长1-6毫米，或在长枝上的可达1厘米，无毛或有疏微毛，托叶刺纤细，后期常脱落。花黄绿色，两性，无毛，具短总花梗，单生或密集成腋生聚伞花序。核果矩圆形或是长卵圆形，长2-3.5厘米，直径1.5-2厘米，成熟后由红色变红紫色，中果皮肉质、厚、味甜。种子扁椭圆形，长约1厘米，宽8毫米。 \n" +
                        "       生长于海拔1700米以下的山区，丘陵或平原。广为栽培。本种原产中国，亚洲、欧洲和美洲常有栽培。 \n" +
                        "       枣含有丰富的维生素C、维生素P，除供鲜食外，常可以制成蜜枣、红枣、熏枣、黑枣、酒枣、牙枣等蜜饯和果脯，还可以作枣泥、枣面、枣酒、枣醋等，为食品工业原料。",
                R.drawable.hongzao,
                9.9F
            ),
            ProductCardBean(
                "蛋糕",
                "       蛋糕是一种古老的西点，一般是由烤箱制作的，蛋糕是用鸡蛋、白糖、小麦粉为主要原料。以牛奶、果汁、奶粉、香粉、色拉油、水，起酥油、泡打粉为辅料。经过搅拌、调制、烘烤后制成一种像海绵的点心。\n" +
                        "       蛋糕是一种面食，通常是甜的，典型的蛋糕是以烤的方式制作出来。蛋糕的材料主要包括了面粉、甜味剂（通常是蔗糖）、黏合剂（一般是鸡蛋，素食主义者可用面筋和淀粉代替）、起酥油（一般是牛油或人造牛油，低脂肪含量的蛋糕会以浓缩果汁代替），液体（牛奶、水或果汁），香精和发酵剂（例如酵母或者发酵粉）。",
                R.drawable.dangao,
                7.9F
            ),
            ProductCardBean(
                "布丁",
                "     布丁，是英语pudding的音译，中文意译则为“奶冻”，西餐甜点之一。\n" +
                        "       广义来说，它泛指由浆状的材料凝固成固体状的食品，如圣诞布丁、面包布丁、约克郡布丁等，常见制法包括焗、蒸、烤等。狭义来说，布丁是一种半凝固状的冷冻的甜品，主要材料为鸡蛋和奶黄，类似果冻。在英国，“布丁”一词可以代指任何甜点。",
                R.drawable.buding,
                14.0F
            ),
            ProductCardBean(
                "巴旦木",
                "        扁桃（学名：Amygdalus communis L.）：中型乔木或灌木，高3-6米；枝直立或平展，无刺，具多数短枝，幼时无毛，一年生枝浅褐色，多年生枝灰褐色至灰黑色；冬芽卵形，棕褐色。叶片披针形或椭圆状披针形，幼嫩时微被疏柔毛，老时无毛，叶边具浅钝锯齿。花单生，先于叶开放，花瓣长圆形，白色至粉红色。果实斜卵形或长圆卵形，扁平，长3-4.3厘米，直径2-3厘米，顶端尖或稍钝，基部多数近截形，外面密被短柔毛；果肉薄，成熟时开裂；核卵形，表面多少光滑，具蜂窝状孔穴；种仁味甜或苦。花期3-4月，果期7-8月。2n=16。 \n" +
                        "       原产于亚洲西部，生于低至中海拔的山区，常见于多石砾的干旱坡地。扁桃抗旱性强，可作桃和杏的砧木。木材坚硬，浅红色，磨光性好，可制作小家具和旋工用具。扁桃仁含脂肪、苦杏仁酶、苦杏仁素、配糖类等，可作糖果、糕点、制药和化妆品工业的有价值原料。核壳中提出的物质可作酒类的着色剂和增进特别的风味。 \n" +
                        "       中国新疆、陕西、甘肃等地区有少量栽培，在新、旧大陆的许多地区均有栽培，特别适宜生长于温暖干旱地区。",
                R.drawable.badanmu,
                24.0F
            ),
            ProductCardBean(
                "蚕豆",
                "     蚕豆（学名：Vicia faba L.），别名南豆、胡豆等，属于豆科、野豌豆属，一年生或越年生草本植物。 \n" +
                        "       蚕豆是世界上第三大重要的冬季食用豆作物。蚕豆营养价值较高，其蛋白质含量为25%-35%。蚕豆还富含糖、矿物质、维他命、钙和铁。此外，作为固氮作物，蚕豆可以将自然界中分子态氮转化为氮素化合物，增加土壤氮素含量。 \n" +
                        "       据宋《太平御览》记载，蚕豆由西汉张骞自西域引入中原地区  。蚕豆在我国种植广泛，自古即是重要的食物资源，同时也是重要的出口资源。 \n" +
                        "       蚕豆隶属于小杂粮，在生活中有十分重要的价值。既可作为传统口粮，又是现代绿色食品和营养保健食品。是富含营养及蛋白质的粮食作物和动物饲料。 ",
                R.drawable.candou,
                6.0F
            )
        )
    }
}

/**
 * 产品卡片
 *
 * @param cardBean 产品卡片Bean
 */
@Composable
private fun ProductCard(cardBean: ProductCardBean) {
    // 上下文
    val context = LocalContext.current

    // 与点击配合决定产品详情要不要展开显示的控制字段
    var isExpand by remember { mutableStateOf(false) }

    Surface(
        shape = MaterialTheme.shapes.medium,
        elevation = 8.dp,
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .clickable {
                isExpand = !isExpand
                Toast
                    .makeText(context, "点击了${cardBean.title}", Toast.LENGTH_SHORT)
                    .show()
            }
    ) {
        Column() {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                // 产品图片
                Image(
                    painter = painterResource(id = cardBean.imageId),
                    contentDescription = cardBean.title,
                    Modifier
                        .size(72.dp)
                        .clip(CircleShape)
                        .border(
                            width = 2.dp,
                            color = MaterialTheme.colors.secondary,
                            shape = CircleShape
                        )
                        .align(alignment = Alignment.CenterVertically)
                        .clickable {
                            Toast
                                .makeText(context, "点击了${cardBean.title}的icon", Toast.LENGTH_SHORT)
                                .show()
                        }
                )
                Spacer(modifier = Modifier.padding(horizontal = 8.dp))

                // 产品title
                Text(
                    text = cardBean.title,
                    color = Color.Black,
                    fontSize = 24.sp,
                    maxLines = 1,
                    style = MaterialTheme.typography.subtitle2,
                    modifier = Modifier
                        .align(alignment = Alignment.CenterVertically)
                        .weight(1F)
                )

                Spacer(modifier = Modifier.padding(8.dp))

                // 产品价钱
                Text(
                    text = "${cardBean.price} 元",
                    color = Color.Red,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .align(alignment = Alignment.CenterVertically)
                        .padding(8.dp)
                        .wrapContentSize()
                )
            }

            // 详细描述
            Text(
                text = cardBean.description,
                fontSize = 16.sp,
                modifier = Modifier
                    .padding(24.dp)
                    .animateContentSize(),
                maxLines = if (isExpand) Int.MAX_VALUE else 1,
                overflow = TextOverflow.Ellipsis
            )
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