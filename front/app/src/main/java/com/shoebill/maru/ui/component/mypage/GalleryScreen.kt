package com.shoebill.maru.ui.component.mypage

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.shoebill.maru.viewmodel.MyPageViewModel

@Composable
fun GalleryScreen(
    myPageViewModel: MyPageViewModel = viewModel()
) {
    val galleryList = myPageViewModel.galleryList

    LazyVerticalGrid(columns = GridCells.Adaptive(minSize = 128.dp)) {
        items(galleryList) { photo ->
            AsyncImage(
                model = photo.imageUrl,
                contentDescription = "landmark picture",
                modifier = Modifier
                    .size(120.dp)
                    .padding(horizontal = 0.5.dp, vertical = 0.5.dp),
                contentScale = ContentScale.Crop
            )
        }
    }
}