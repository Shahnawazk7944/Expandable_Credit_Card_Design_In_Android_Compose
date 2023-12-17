package com.example.expendablecarddesign

import android.media.Image
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.outlined.ArrowForward
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.expendablecarddesign.ui.theme.CardBackgroundColor
import com.example.expendablecarddesign.ui.theme.CardPayNowBackgroundColor
import com.example.expendablecarddesign.ui.theme.PrimaryWhiteColor
import com.example.expendablecarddesign.ui.theme.SecondaryDarkColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreditCard(cardType:Int ,cardNumber: String, name: String, validityMonth: String, validityYear: String, cvv: String) {
    var cardState by remember {
        mutableStateOf(false)
    }
    val rotateState by animateFloatAsState(targetValue = if (cardState) 180f else 0f)

    Card(modifier = Modifier
        .fillMaxWidth()
        .animateContentSize(
            animationSpec = tween(
                durationMillis = 300, easing = LinearOutSlowInEasing
            )
        ), colors = CardDefaults.cardColors(
        containerColor = CardBackgroundColor,
    ), shape = ShapeDefaults.Medium, onClick = {
        cardState = !cardState
    }) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, top = 20.dp, bottom = 20.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                verticalAlignment = Alignment.Top,
            ) {
                Column(
                    modifier = Modifier.weight(5f)
                ) {
                    Text(
                        text = "Card Number",
                        textAlign = TextAlign.Center,
                        color = SecondaryDarkColor,
                        style = MaterialTheme.typography.titleSmall
                    )
                    Text(
                        text = cardNumber,
                        color = PrimaryWhiteColor,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        style = MaterialTheme.typography.titleMedium
                    )

                }

                Image(
                    painter = painterResource(id = cardType),
                    contentDescription = "Image",
                    modifier = Modifier
                        .height(50.dp)
                        .width(50.dp)
                        .weight(1f)

                )
                IconButton(
                    onClick = { cardState = !cardState },
                    modifier = Modifier
                        .alpha(5f)
                        .rotate(rotateState),
                ) {

                    Icon(
                        imageVector = Icons.Default.ArrowDropDown,
                        contentDescription = "dropDownIcon"
                    )
                }


            }
            if (cardState) {
                Column(
                    modifier = Modifier.padding(top = 20.dp),
                ) {
                    Text(
                        text = "Cardholder Name",
                        textAlign = TextAlign.Center,
                        color = SecondaryDarkColor,
                        style = MaterialTheme.typography.titleSmall
                    )
                    Text(
                        text = name,
                        color = PrimaryWhiteColor,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        style = MaterialTheme.typography.titleMedium
                    )

                }
                Row(
                    modifier = Modifier.padding(top = 20.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(modifier = Modifier.weight(2f)) {
                        Text(

                            text = "Valid thru",
                            textAlign = TextAlign.Center,
                            color = SecondaryDarkColor,
                            style = MaterialTheme.typography.titleSmall
                        )
                        Text(

                            text = "$validityMonth / $validityYear",
                            color = PrimaryWhiteColor,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            style = MaterialTheme.typography.titleMedium
                        )

                    }
                    Column(modifier = Modifier.weight(2f)) {
                        Text(
                            text = "CVV",
                            textAlign = TextAlign.Center,
                            color = SecondaryDarkColor,
                            style = MaterialTheme.typography.titleSmall
                        )
                        Text(
                            text = cvv,
                            color = PrimaryWhiteColor,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            style = MaterialTheme.typography.titleMedium
                        )

                    }
                    Image(
                        painter = painterResource(id = R.drawable.pay),
                        contentDescription = "Image",
                        modifier = Modifier
                            .height(60.dp)
                            .width(70.dp)
                            .weight(1f)

                    )
                    Icon(modifier = Modifier
                        .size(40.dp)
                        .padding(end = 10.dp),
                        imageVector = Icons.Filled.ArrowForward,
                        contentDescription = "dropDownIcon",
                        tint = CardPayNowBackgroundColor
                    )
                }
            }


        }

    }


}

@Composable
@Preview(showBackground = true)
fun CreditCartPreview() {
    CreditCard(
        cardNumber = "8169 2121 4100 5622" , name = "Shahnawaz Khan",
        validityMonth = "11",validityYear = "2027", cvv = "548", cardType = R.drawable.mastercard)
}