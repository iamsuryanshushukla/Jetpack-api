package com.example.jetpackapi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.jetpackapi.ui.theme.JetpackApiTheme

//@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    val appsViewModel by viewModels<AppsViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
//        val appsViewModel  = AppsViewModel()
        super.onCreate(savedInstanceState)
        setContent {
            JetpackApiTheme {
                // A surface container using the 'background' color from the theme

//                    HomeScreen(appsViewModel)
//                GridScreen(appsViewModel = appsViewModel)

                Myapp(appsViewModel = appsViewModel)

            }
        }
    }
}

@Composable
fun Myapp(appsViewModel: AppsViewModel){
    var seeAll by rememberSaveable{
        mutableStateOf(true)
    }
    if (seeAll){
        HomeScreen(appsViewModel = appsViewModel, onSeeAllClicked = {
            seeAll = false
        })
    }
    else{
        GridScreen(appsViewModel = appsViewModel, onBackClicked = {
            seeAll = true
        })
    }

}


@Composable
fun GridScreen(appsViewModel: AppsViewModel,onBackClicked:()->Unit){

    Column() {
        
        TextButton(onClick = onBackClicked) {
            Text(text = "Back")

        }
        GridView(appsList = appsViewModel.appsListResponse)
        appsViewModel.getAppsList()
    }

}


@Composable
fun HomeScreen(appsViewModel: AppsViewModel,onSeeAllClicked:()->Unit){

    Column(modifier = Modifier
        .fillMaxHeight()
        .fillMaxWidth(), verticalArrangement = Arrangement.Center) {
        Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.End) {
            TextButton(onClick = onSeeAllClicked) {
                Text(text = "See All")
                
            }
            HorizontalView(appsList = appsViewModel.appsListResponse)
            appsViewModel.getAppsList()
        }


    }
}



@Composable
fun Design(result:com.example.jetpackapi.model.Result) {
    val imagePainter = rememberImagePainter(data = result.artworkUrl100)
    Column(horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(painter = imagePainter, contentDescription ="", modifier = Modifier
            .size(100.dp)
            .padding(10.dp) )
        Text(text = result.artistName, fontSize = 15.sp, modifier = Modifier.padding(bottom = 10.dp))
    }
    
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun GridView(appsList: List<com.example.jetpackapi.model.Result>){
    LazyVerticalGrid(cells = GridCells.Fixed(2), modifier = Modifier.padding(top = 0.dp)){
        items(appsList){item: com.example.jetpackapi.model.Result ->  
            Design(result = item)
            
        }
        
    }
}

@Composable
fun HorizontalView(appsList: List<com.example.jetpackapi.model.Result>){
//    val homeViewModel = viewModel(modelClass = HomeViewModel::class.java)
//    val state by homeViewModel.state.collectAsState()

    LazyRow(contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp), modifier = Modifier.background(Color.Cyan)){

        items(appsList){item: com.example.jetpackapi.model.Result ->
            Design(result = item)

        }
//        if (state.isEmpty()){
//            item{
//                CircularProgressIndicator(modifier = Modifier
//                    .fillMaxSize()
//                    .wrapContentSize(align = Alignment.Center))
//            }
//        }
//
//        items(state){item: Apple ->
//            Design(apple = item)
//        }
        
    }
}




@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackApiTheme {


//        Design(user = ImageAndText(R.drawable.paisa,"Ssmaple"))
        val result = com.example.jetpackapi.model.Result("Suryanshu","https://is2-ssl.mzstatic.com/image/thumb/Purple112/v4/63/98/e5/6398e5ac-905c-d5b8-4e0f-eb6a5eb7000b/logo_youtube_color-1x_U007emarketing-0-6-0-85-220.png/100x100bb.png",
            listOf(),"","","","","")
//        HorizontalView(appsList = listOf(result) )
        Design(result = result)
    }
}