package com.example.module2practice

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextIndent
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AllTasksApp()
        }
    }
}

@Composable
fun AllTasksApp() {
    var selectedTask by remember { mutableIntStateOf(1) }
    val row1 = listOf(1, 3, 4, 5)
    val row2 = listOf(6, 7, 8, 10)

    Column(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFEEEEEE))
                .padding(top = 40.dp, bottom = 8.dp, start = 8.dp, end = 8.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            listOf(row1, row2).forEach { rowTasks ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    rowTasks.forEach { taskNumber ->
                        Button(
                            onClick = { selectedTask = taskNumber },
                            modifier = Modifier.weight(1f),
                            contentPadding = PaddingValues(vertical = 4.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = if (selectedTask == taskNumber) Color(0xFF6200EE) else Color.Gray
                            )
                        ) {
                            Text(text = "№$taskNumber", color = Color.White, fontSize = 12.sp)
                        }
                    }
                }
            }
        }
        HorizontalDivider()

        Box(modifier = Modifier.fillMaxSize()) {
            when (selectedTask) {
                1 -> Task1Screen()
                3 -> Task3Screen()
                4 -> Task4Screen()
                5 -> Task5Screen()
                6 -> Task6Screen()
                7 -> Task7Screen()
                8 -> WaterTracker()
                10 -> ShoppingCartScreen()
            }
        }
    }
}

// ==================== ЗАДАНИЕ 1 и 2 ====================

@Composable
fun Hello(name: String?) {
    val displayName = name ?: "Имя не задано"
    Text(
        text = "Привет, $displayName!",
        fontSize = 20.sp,
        modifier = Modifier.padding(8.dp)
    )
}

@Composable
fun Task1Screen() {
    Column(modifier = Modifier.padding(16.dp)) {
        Hello(name = "Нармин")
        Hello(name = null)
    }
}

@Preview(name = "portrait", showBackground = true, widthDp = 360, heightDp = 640)
@Composable
fun HelloPreviewPortrait() {
    Hello(name = "Нармин")
}

@Preview(name = "landscape", showBackground = true, widthDp = 640, heightDp = 360)
@Composable
fun HelloPreviewLandscape() {
    Hello(name = "Нармин")
}

@Preview(name = "round", showBackground = true, backgroundColor = 0xFFFFFF00, widthDp = 200, heightDp = 200)
@Composable
fun HelloPreviewRound() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Yellow),
        contentAlignment = Alignment.Center
    ) {
        Hello(name = "Нармин")
    }
}

// ==================== ЗАДАНИЕ 3 ====================

@Composable
fun Task3Screen() {
    val description = stringResource(id = R.string.compose_description)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Text(
            text = description,
            color = Color.Green,
            fontSize = 16.sp,
            fontStyle = FontStyle.Italic,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )

        Text(
            text = description,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )

        Text(
            text = description,
            fontSize = 24.sp,
            color = Color.Black,
            textDecoration = TextDecoration.Underline,
            style = TextStyle(textIndent = TextIndent(firstLine = 48.sp)),
            modifier = Modifier
                .background(Color.Green)
                .padding(8.dp)
        )
    }
}

// ==================== ЗАДАНИЕ 4 ====================

@Composable
fun Task4Screen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Button(
            onClick = { },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            border = BorderStroke(2.dp, Color.Gray),
            elevation = ButtonDefaults.buttonElevation(defaultElevation = 4.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.LightGray,
                contentColor = Color.Black
            )
        ) {
            Text(text = "Нажми на меня")
        }
    }
}

// ==================== ЗАДАНИЕ 5 ====================

@Composable
fun Task5Screen() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .background(Color.LightGray)
            .padding(vertical = 16.dp),
        contentAlignment = Alignment.Center
    ) {
        Surface(
            modifier = Modifier
                .fillMaxHeight()
                .aspectRatio(1f),
            shape = CircleShape,
            color = Color(0xFFFF5722)
        ) {
            Box(contentAlignment = Alignment.Center) {
                Text(
                    text = "НА",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
            }
        }
    }
}

// ==================== ЗАДАНИЕ 6 ====================

@Composable
fun CircleTopRight() {
    Box(
        modifier = Modifier
            .size(width = 240.dp, height = 120.dp)
            .background(Color.Black),
        contentAlignment = Alignment.TopEnd
    ) {
        Image(
            painter = painterResource(id = R.drawable.circle),
            contentDescription = "Circle Top Right"
        )
    }
}

@Composable
fun CircleCenterPurple() {
    Box(
        modifier = Modifier
            .size(width = 240.dp, height = 120.dp)
            .background(Color.Blue),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.circle),
            contentDescription = "Circle Purple",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds,
            colorFilter = ColorFilter.tint(Color(0xFF9C27B0))
        )
    }
}

@Composable
fun Task6Screen() {
    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        CircleTopRight()
        CircleCenterPurple()
    }
}

// ==================== ЗАДАНИЕ 7 ====================

@Composable
fun Task7Screen() {
    var count by remember { mutableIntStateOf(0) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Счетчик: $count", fontSize = 24.sp)
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { count++ }) {
            Text(text = "Увеличить")
        }
    }
}

// ==================== ЗАДАНИЕ 8 ====================

@Composable
fun WaterTracker() {
    var waterCount by remember { mutableIntStateOf(0) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Выпито воды: ${waterCount * 250} мл", fontSize = 22.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(16.dp))
        Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            Button(onClick = { waterCount++ }) {
                Text(text = "+250 мл")
            }
            OutlinedButton(onClick = { waterCount = 0 }) {
                Text(text = "Сбросить")
            }
        }
    }
}

// ==================== ЗАДАНИЕ 10 ====================

data class CartProduct(val id: Int, val name: String, val price: Int)

@Composable
fun ShoppingCartScreen() {
    val context = LocalContext.current
    var products by remember {
        mutableStateOf(
            listOf(
                CartProduct(1, "Товар 1", 100),
                CartProduct(2, "Товар 2", 250),
                CartProduct(3, "Товар 3", 3)
            )
        )
    }

    val totalSum = products.sumOf { it.price }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(text = "Корзина покупок", fontSize = 22.sp, fontWeight = FontWeight.Bold)

        products.forEach { product ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "${product.name} — ${formatRubles(product.price)}", fontSize = 18.sp)
                Button(onClick = {
                    products = products.filter { it.id != product.id }
                }) {
                    Text(text = "Удалить")
                }
            }
        }

        HorizontalDivider()

        Text(
            text = "Итого: ${formatRubles(totalSum)}",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )

        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            Button(onClick = {
                val nextId = (products.maxOfOrNull { it.id } ?: 0) + 1
                val randomPrice = Random.nextInt(1, 500)
                products = products + CartProduct(nextId, "Товар $nextId", randomPrice)
            }) {
                Text(text = "Добавить товар")
            }

            Button(onClick = {
                Toast.makeText(
                    context,
                    "Заказ оформлен на сумму ${formatRubles(totalSum)}",
                    Toast.LENGTH_SHORT
                ).show()
            }) {
                Text(text = "Оформить")
            }
        }
    }
}

fun formatRubles(amount: Int): String {
    val mod100 = amount % 100
    val mod10 = amount % 10
    val word = when {
        mod100 in 11..14 -> "рублей"
        mod10 == 1 -> "рубль"
        mod10 in 2..4 -> "рубля"
        else -> "рублей"
    }
    return "$amount $word"
}
