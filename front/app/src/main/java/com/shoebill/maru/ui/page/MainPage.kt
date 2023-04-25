package com.shoebill.maru.ui.page

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.FabPosition
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.shoebill.maru.R
import com.shoebill.maru.ui.component.MapboxScreen
import com.shoebill.maru.ui.component.SearchBar
import com.shoebill.maru.viewmodel.MapViewModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainPage(
    viewModel: MapViewModel,
    navController: NavHostController = rememberNavController(),
) {
    Scaffold(
        content = {
            MapboxScreen(viewModel)
            Column {
                SearchBar()

            }
        },
        floatingActionButton = {

            Button(onClick = { navController.navigate("login") }) {
                Text(text = "로그인 페이지 ㄱㄱ")
            }
            FloatingActionButton(
                onClick = {
                    viewModel.clearFocus()
                    // TODO: 카메라 화면으로 이동
                },
                modifier = Modifier
                    .size(60.dp),
                shape = RoundedCornerShape(16.dp),
                backgroundColor = Color.White,
                content = {
                    Icon(
                        modifier = Modifier
                            .size(40.dp)
                            .graphicsLayer(alpha = 0.99f)
                            .drawWithCache {
                                onDrawWithContent {
                                    drawContent()
                                    drawRect(
                                        Brush.linearGradient(
                                            listOf(
                                                Color(0xFF6039DF),
                                                Color(0xFFA14AB7)
                                            )
                                        ),
                                        blendMode = BlendMode.SrcAtop
                                    )
                                }
                            },
                        painter = painterResource(id = R.drawable.camera),
                        contentDescription = ""
                    )
                }
            )
        },
        floatingActionButtonPosition = FabPosition.Center
    )
}