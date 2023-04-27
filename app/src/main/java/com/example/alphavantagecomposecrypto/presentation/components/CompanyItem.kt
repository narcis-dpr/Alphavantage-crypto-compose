package com.example.alphavantagecomposecrypto.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.alphavantagecomposecrypto.data.model.CompanyListings

@Composable
fun CompanyItem(
    modifier: Modifier = Modifier,
    companyListings: CompanyListings
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(modifier = Modifier.fillMaxWidth(),
        Arrangement.SpaceEvenly) {
            Text(text = companyListings.name)
            Spacer(modifier = Modifier.width(20.dp))
            Text(text = companyListings.symbol)
        }
        Text(text = companyListings.exchange)

    }
}
@Preview
@Composable
fun ShowItem() {
    Surface() {
        CompanyItem( modifier = Modifier
            .fillMaxWidth()
            .height(72.dp)
            ,companyListings = CompanyListings(
                name = "Alphabet",
                symbol = "ALB",
                exchange = "2.0"
            )
        )
    }

}