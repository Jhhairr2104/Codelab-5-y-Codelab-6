package com.illareklab.tarjeta

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFFE6F0F8)
                ) {
                    BusinessCard()
                }
            }
        }
    }
}

@Composable
fun BusinessCard(modifier: Modifier = Modifier) {

    Column(
        modifier = modifier.fillMaxSize()
    ) {

        BusinessCardHeader(
            modifier = Modifier.weight(1f)
        )

        BusinessCardContact(
            modifier = Modifier.padding(
                start = 80.dp,
                bottom = 32.dp
            )
        )
    }
}

@Composable
fun BusinessCardHeader(modifier: Modifier = Modifier) {

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            painter = painterResource(R.drawable.android_logo),
            contentDescription = null,
            modifier = Modifier.size(150.dp)
        )

        Text(
            text = stringResource(R.string.full_name),
            fontSize = 36.sp,
            color = Color(0xFF1A2A33)
        )

        Text(
            text = stringResource(R.string.job_title),
            fontWeight = FontWeight.Bold,
            color = Color(0xFF176B87)
        )
    }
}

@Composable
fun BusinessCardContact(modifier: Modifier = Modifier) {

    Column(
        modifier = modifier
    ) {

        ContactRow(
            icon = {
                Icon(
                    imageVector = Icons.Default.Phone,
                    contentDescription = "Phone",
                    tint = Color(0xFF176B87)
                )
            },
            text = stringResource(R.string.phone_number)
        )

        ContactRow(
            icon = {
                Icon(
                    imageVector = Icons.Default.Share,
                    contentDescription = "Social media",
                    tint = Color(0xFF176B87)
                )
            },
            text = stringResource(R.string.social_media)
        )

        ContactRow(
            icon = {
                Icon(
                    imageVector = Icons.Default.Email,
                    contentDescription = "Email",
                    tint = Color(0xFF176B87)
                )
            },
            text = stringResource(R.string.email)
        )
    }
}

@Composable
fun ContactRow(
    icon: @Composable () -> Unit,
    text: String
) {

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(bottom = 8.dp)
    ) {

        icon()

        Spacer(
            modifier = Modifier.size(16.dp)
        )

        Text(
            text = text,
            color = Color(0xFF1A2A33)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    MaterialTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color(0xFFE6F0F8)
        ) {
            BusinessCard()
        }
    }
}