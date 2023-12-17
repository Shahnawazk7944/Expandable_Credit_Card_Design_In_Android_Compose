package com.example.expendablecarddesign

import androidx.compose.animation.ContentTransform
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.example.expendablecarddesign.ui.theme.CardBackgroundColor
import com.example.expendablecarddesign.ui.theme.PrimaryWhiteColor
import com.example.expendablecarddesign.ui.theme.SecondaryDarkColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreditCard() {
    var cardState by remember {
        mutableStateOf(false)
    }

    Card(modifier = Modifier
        .height(Dp(500f))
        .fillMaxWidth()
        .animateContentSize(
            animationSpec = tween(
                delayMillis = 300, easing = LinearOutSlowInEasing
            )

        ), colors = CardDefaults.cardColors(
        containerColor = CardBackgroundColor,
    ), shape = ShapeDefaults.Medium, onClick = {
        cardState = !cardState
    }) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {
            Column(modifier = Modifier.padding(bottom = 10.dp)) {
                Text(
                    text = "Card Number",
                    color = SecondaryDarkColor,
                    style = MaterialTheme.typography.titleMedium
                )
                Row(
                    modifier = Modifier.padding(top = 5.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Text(
                        modifier = Modifier.weight(5f),
                        text = "1234 1234 1234 1234",
                        color = PrimaryWhiteColor,
                        style = MaterialTheme.typography.titleLarge
                    )
                    IconButton(
                        onClick = { cardState = !cardState }, modifier = Modifier.alpha(5f).weight(1f),
                    ) {
                        Icon(
                            imageVector = Icons.Default.ArrowDropDown,
                            contentDescription = "drop down Icon"
                        )
                    }
                }


            }

        }

    }


}

@Composable
@Preview(showBackground = true)
fun CreditCartPreview() {
    CreditCard()
}