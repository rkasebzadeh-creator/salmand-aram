package com.aramjan.app.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
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

@Composable
fun VideoScreen(
    onBackClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BgWarm)
            .padding(20.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            IconButton(onClick = onBackClick) {
                Text("➡️", fontSize = 20.sp)
            }
            Spacer(modifier = Modifier.width(8.dp))
            Text("ویدیوی آموزشی", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = TextDark)
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Video Player Container
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(Color.Black),
            contentAlignment = Alignment.Center
        ) {
            Text("▶️", fontSize = 48.sp)
            Box(
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(12.dp)
                    .background(Color.Black.copy(alpha = 0.6f), RoundedCornerShape(6.dp))
                    .padding(horizontal = 8.dp, vertical = 4.dp)
            ) {
                Text("۰۵:۲۰", color = Color.White, fontSize = 12.sp)
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text("تنفس آرام برای ذهنی روشن", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = TextDark)
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            "این تمرین ساده به شما کمک می‌کند تا در چند دقیقه استرس روزانه را کاهش دهید و تمرکز خود را بازیابید.",
            fontSize = 14.sp,
            color = TextMuted,
            lineHeight = 22.sp
        )

        Spacer(modifier = Modifier.weight(1f))

        // Warning Box
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(containerColor = SoftPeach)
        ) {
            Row(modifier = Modifier.padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
                Text("⚠️", fontSize = 24.sp)
                Spacer(modifier = Modifier.width(12.dp))
                Text(
                    "در صورت احساس سرگیجه، تمرین را متوقف کنید و به حالت عادی نفس بکشید.",
                    fontSize = 12.sp,
                    color = TextDark
                )
            }
        }
    }
}
