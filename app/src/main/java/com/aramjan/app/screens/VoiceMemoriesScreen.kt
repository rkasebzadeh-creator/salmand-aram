package com.aramjan.app.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aramjan.app.model.VoiceMemory
import com.aramjan.app.theme.*
import com.aramjan.app.viewmodel.VoiceViewModel

@Composable
fun VoiceMemoriesScreen(
    viewModel: VoiceViewModel,
    onBackClick: () -> Unit
) {
    val isRecording by viewModel.isRecording.collectAsState()

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
            Text("خاطرات صوتی", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = TextDark)
        }

        Spacer(modifier = Modifier.height(20.dp))

        // Recorder Widget
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {
            Column(
                modifier = Modifier.padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("صدایتان ماندگار است", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = TextDark)
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    if (isRecording) "در حال ضبط... 🔴" else "برای ضبط کلیک کنید",
                    fontSize = 13.sp,
                    color = if (isRecording) TerracottaRed else TextMuted
                )
                Spacer(modifier = Modifier.height(16.dp))

                Box(
                    modifier = Modifier
                        .size(72.dp)
                        .clip(CircleShape)
                        .background(TerracottaRed)
                        .clickable { viewModel.toggleRecording() },
                    contentAlignment = Alignment.Center
                ) {
                    Text(if (isRecording) "⏹️" else "🎙️", fontSize = 32.sp)
                }

                if (isRecording) {
                    Spacer(modifier = Modifier.height(12.dp))
                    Text("۰۰:۳۲", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = TerracottaRed)
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text("خاطرات ضبط‌شده", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = TextDark)
        Spacer(modifier = Modifier.height(12.dp))

        LazyColumn(verticalArrangement = Arrangement.spacedBy(10.dp)) {
            items(viewModel.voiceMemories) { memory ->
                VoiceMemoryItem(memory)
            }
        }
    }
}

@Composable
fun VoiceMemoryItem(memory: VoiceMemory) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape)
                        .background(LightMint),
                    contentAlignment = Alignment.Center
                ) {
                    Text("▶️", fontSize = 16.sp)
                }
                Spacer(modifier = Modifier.width(12.dp))
                Column {
                    Text(memory.title, fontSize = 15.sp, fontWeight = FontWeight.Bold, color = TextDark)
                    Text(memory.dateText, fontSize = 12.sp, color = TextMuted)
                }
            }
            Text(memory.durationText, fontSize = 12.sp, color = TextMuted)
        }
    }
}
