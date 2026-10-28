package com.aramjan.app.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aramjan.app.theme.*
import com.aramjan.app.viewmodel.MainViewModel

@Composable
fun HomeScreen(
    viewModel: MainViewModel,
    onNavigateToGame: () -> Unit,
    onNavigateToVideo: () -> Unit,
    onNavigateToVoice: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BgWarm)
            .padding(20.dp)
    ) {
        // Header
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .size(48.dp)
                        .clip(CircleShape)
                        .background(SoftPeach),
                    contentAlignment = Alignment.Center
                ) {
                    Text("👤", fontSize = 24.sp)
                }
                Spacer(modifier = Modifier.width(12.dp))
                Column {
                    Text("سلام، مریم خانم", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = TextDark)
                    Text("امروز روز خوبی خواهد بود", fontSize = 12.sp, color = TextMuted)
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Banner
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = LightMint)
        ) {
            Row(
                modifier = Modifier.padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("💡", fontSize = 32.sp)
                Spacer(modifier = Modifier.width(12.dp))
                Text(
                    text = "امروز هم چند دقیقه برای ذهن‌تان وقت بگذارید",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    color = PrimaryTeal
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text("فعالیت‌های امروز", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = TextDark)
        Spacer(modifier = Modifier.height(12.dp))

        // Cards
        ActivityCard(
            title = "بازی حافظه",
            subtitle = "تقویت ذهن با ضرب‌المثل‌ها",
            icon = "🧠",
            bgColor = PrimaryTeal,
            textColor = Color.White,
            onClick = onNavigateToGame
        )
        Spacer(modifier = Modifier.height(12.dp))

        ActivityCard(
            title = "ویدیوی آموزشی",
            subtitle = "تمرین تنفس آرامش‌بخش",
            icon = "🎬",
            bgColor = SoftPeach,
            textColor = TextDark,
            onClick = onNavigateToVideo
        )
        Spacer(modifier = Modifier.height(12.dp))

        ActivityCard(
            title = "خاطرات صوتی",
            subtitle = "ثبت لحظات شیرین امروز",
            icon = "🎙️",
            bgColor = Color.White,
            textColor = TextDark,
            onClick = onNavigateToVoice
        )
    }
}

@Composable
fun ActivityCard(
    title: String,
    subtitle: String,
    icon: String,
    bgColor: Color,
    textColor: Color,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() },
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = bgColor)
    ) {
        Row(
            modifier = Modifier.padding(20.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(icon, fontSize = 28.sp)
                Spacer(modifier = Modifier.width(16.dp))
                Column {
                    Text(title, fontSize = 16.sp, fontWeight = FontWeight.Bold, color = textColor)
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(subtitle, fontSize = 12.sp, color = textColor.copy(alpha = 0.8f))
                }
            }
            Text("◀", fontSize = 16.sp, color = textColor)
        }
    }
}
