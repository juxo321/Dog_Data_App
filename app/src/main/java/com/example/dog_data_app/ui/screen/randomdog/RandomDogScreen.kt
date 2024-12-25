package com.example.dog_data_app.ui.screen.randomdog

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.example.dog_data_app.R
import com.example.dog_data_app.domain.model.Dog


@Preview()
@Composable
fun RandomDogScreen(
    viewModel: RandomDogViewModel = hiltViewModel(),
    modifier: Modifier = Modifier
) {

    val dog by viewModel.dog.observeAsState(null)
    val isLoading by viewModel.isLoading.observeAsState(true)
    val error by viewModel.error.observeAsState(false)

    val options by viewModel.breeds.observeAsState(emptyList())
    val selectedOption by viewModel.selectedOption.observeAsState("")

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.LightGray)
            .padding(10.dp),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        BreedDropDown(viewModel, options, selectedOption, isLoading)
        DogImage(dog, isLoading, error)
        SearchDogButton(viewModel, selectedOption, isLoading, error)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BreedDropDown(
    viewModel: RandomDogViewModel, options: List<String>, selectedOption: String, isLoading: Boolean
) {
    var expanded by rememberSaveable { mutableStateOf(false) }

    ExposedDropdownMenuBox(
        modifier = Modifier.padding(10.dp),
        expanded = expanded,
        onExpandedChange = { expanded = !expanded }
    ) {
        TextField(
            readOnly = true,
            value = selectedOption,
            onValueChange = {},
            label = { Text("Select dog breed") },
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
            },
            enabled = !isLoading,
            modifier = Modifier
                .fillMaxWidth()
                .menuAnchor()
        )
        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            options.forEach { option ->
                DropdownMenuItem(
                    text = { Text(option) },
                    onClick = {
                        viewModel.selectedOption.value = option
                        expanded = false
                    })
            }
        }
    }
}

@Composable
fun DogImage(dog: Dog?, isLoading: Boolean, error: Boolean) {
    Card(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        ),
        modifier = Modifier
            .fillMaxWidth()
            .height(400.dp)
            .padding(10.dp)
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            when {
                isLoading -> {
                    CircularProgressIndicator()
                }

                error -> {
                    Text("Something goes wrong, try again :)!")
                }

                else -> {
                    if (dog != null) {
                        AsyncImage(
                            model = ImageRequest.Builder(LocalContext.current)
                                .data(dog.message)
                                .crossfade(true)
                                .build(),
                            contentDescription = dog.message,
                            contentScale = ContentScale.Crop,
                            error = painterResource(R.drawable.ic_launcher_foreground),
                            modifier = Modifier
                                .size(300.dp)
                                .clip(RoundedCornerShape(10.dp))

                        )
                    }
                }
            }
        }
    }
}


@Composable
fun SearchDogButton(
    viewModel: RandomDogViewModel, selectedOption: String, isLoading: Boolean, error: Boolean
) {
    ElevatedButton(
        onClick = { viewModel.getRandomDog(selectedOption) },
        enabled = !isLoading,
        colors = ButtonDefaults.buttonColors(
            contentColor = Color.White,
            containerColor = Color.DarkGray
        ),

        ) {
        Row(modifier = Modifier.padding(5.dp)) {
            Icon(
                painter = painterResource(R.drawable.ic_random),
                contentDescription = "Random icon"
            )
            Text(
                text = "Get random Image",
                fontWeight = FontWeight.SemiBold, modifier = Modifier.padding(start = 12.dp),
            )
        }

    }
}