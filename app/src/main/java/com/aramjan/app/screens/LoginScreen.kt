package com.aramjan.app.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aramjan.app.model.MoodType
import com.aramjan.app.theme.*
import com.aramjan.app.viewmodel.MainViewModel

@Composable
fun LoginScreen(
    viewModel: MainViewModel,
    onLoginClick: () -> Unit
) {
    val selectedMood by viewModel.selectedMood.collectAsState()
    val phoneNumber by viewModel.phoneNumber.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BgWarm)
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Spacer(modifier = Modifier.height(20.dp))

        // Logo
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Box(
                modifier = Modifier
                    .size(80.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .background(PrimaryTeal),
                contentAlignment = Alignment.Center
            ) {
                Text("🍃", fontSize = 40.sp)
            }
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = "آرام جان",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = PrimaryTeal
            )
        }

        // Phone Input Card
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = androidx.compose.ui.graphics.Color.White),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
        ) {
            Column(modifier = Modifier.padding(20.dp)) {
                Text(
                    text = "شماره تلفن همراه خود را وارد کنید",
                    fontSize = 14.sp,
                    color = TextMuted,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Right
                )
                Spacer(modifier = Modifier.height(12.dp))
                OutlinedTextField(
                    value = phoneNumber,
                    onValueChange = { viewModel.updatePhoneNumber(it) },
                    placeholder = { Text("۰۹۱۲۳۴۵۶۷۸۹", color = TextMuted) },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp),
                    singleLine = true
                )
                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    onClick = onLoginClick,
                    modifier = Modifier.fillMaxWidth().height(50.dp),
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = PrimaryTeal)
                ) {
                    Text("ورود با شماره همراه", fontSize = 16.sp, fontWeight = FontWeight.Bold)
                }
            }
        }

        // Mood Selector
        Column(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = "امروز حالتان چطور است؟",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = TextDark,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Right
            )
            Spacer(modifier = Modifier.height(12.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                MoodType.values().forEach { mood ->
                    val isSelected = selectedMood == mood
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .height(75.dp)
                            .clip(RoundedCornerShape(12.dp))
                            .background(if (isSelected) LightMint else androidx.compose.ui.graphics.Color.White)
                            .border(
                                width = if (isSelected) 2.dp else 1.dp,
                                color = if (isSelected) PrimaryTeal else CardBorder,
                                shape = RoundedCornerShape(12.dp)
                            )
                            .clickable { viewModel.selectMood(mood) },
                        contentAlignment = Alignment.Center
                    ) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text(mood.emoji, fontSize = 22.sp)
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                mood.title,
                                fontSize = 13.sp,
                                color = if (isSelected) PrimaryTeal else TextDark,
                                fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal
                            )
                        }
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(10.dp))
    }
}
