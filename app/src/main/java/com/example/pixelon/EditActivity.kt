package com.example.pixelon

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import com.example.pixelon.ui.theme.PixelonTheme
import coil.compose.rememberAsyncImagePainter

import coil.compose.AsyncImage


class EditActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PixelonTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    var uriString: String? = null

                    uriString = intent.extras?.getString("imageUri")
                    if (uriString == null)
                        uriString = intent.extras?.get(Intent.EXTRA_STREAM).toString()
                    val uri = Uri.parse(uriString)



                    Column(modifier = Modifier.fillMaxSize()) {
                        EditImage(uri = uri)

                    }
                }
            }
        }
    }
}

@Composable
fun EditImage(uri: Uri) {
    val painter = rememberAsyncImagePainter(uri)

    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally)
    {
        Image(painter = painter, contentDescription = null)
    }


}
