package com.example.expendablecarddesign

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.expendablecarddesign.ui.theme.ExpendableCardDesignTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ExpendableCardDesignTheme {
                // A surface container using the 'background' color from the theme
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colorScheme.background)
                        .padding(24.dp),
                    verticalArrangement = Arrangement.SpaceAround
                ) {
                    CreditCard(
                        cardNumber = "8169 2121 4100 5622",
                        name = "Shahnawaz Khan",
                        validityMonth = "11",
                        validityYear = "2027",
                        cvv = "548",
                        cardType = R.drawable.mastercard
                    )
                    CreditCard(
                        cardNumber = "9586 4621 5725 4476",
                        name = "Jackson Sen",
                        validityMonth = "04",
                        validityYear = "2025",
                        cvv = "795",
                        cardType = R.drawable.visacard
                    )
                    CreditCard(
                        cardNumber = "4495 2876 3157 9523",
                        name = "Yamez Shizu",
                        validityMonth = "09",
                        validityYear = "2030",
                        cvv = "201",
                        cardType = R.drawable.rupaycard
                    )
                }

            }
        }
    }
}
