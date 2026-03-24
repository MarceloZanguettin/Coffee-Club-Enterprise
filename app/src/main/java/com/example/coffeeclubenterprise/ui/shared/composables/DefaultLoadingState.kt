package com.example.coffeeclubenterprise.ui.shared.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.coffeeclubenterprise.ui.theme.CoffeeClubEnterpriseTheme
import com.dotlottie.dlplayer.Mode
import com.lottiefiles.dotlottie.core.compose.ui.DotLottieAnimation
import com.lottiefiles.dotlottie.core.util.DotLottieSource

@Composable
fun DefaultLoadingState(
    modifier: Modifier = Modifier,
    loadingMessage: String = "Carregando..."
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // DotLottieAnimation uses native libraries that are not supported in Preview.
            // We use LocalInspectionMode to show a placeholder when in Preview.
            if (LocalInspectionMode.current) {
                Box(
                    modifier = Modifier
                        .size(250.dp)
                        .background(Color.LightGray)
                )
            } else {
                DotLottieAnimation(
                    source = DotLottieSource.Url("https://lottie.host/2c66fc15-abdc-4947-b798-8a37082b4a42/DYIN0ZxbgX.lottie"),
                    autoplay = true,
                    loop = true,
                    speed = 1.15f,
                    useFrameInterpolation = true,
                    playMode = Mode.FORWARD,
                    modifier = Modifier.size(250.dp)
                )
            }
            Spacer(Modifier.size(8.dp))
            Text(
                text = loadingMessage,
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.primary
            )
        }
    }
}

@Preview(showBackground = true, heightDp = 400)
@Composable
private fun DefaultLoadingStatePreview(modifier: Modifier = Modifier) {
    CoffeeClubEnterpriseTheme {
        DefaultLoadingState()
    }
}
