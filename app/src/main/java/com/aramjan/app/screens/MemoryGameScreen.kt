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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aramjan.app.theme.*
import com.aramjan.app.viewmodel.GameViewModel

@Composable
fun MemoryGameScreen(
    viewModel: GameViewModel,
    onBackClick: () -> Unit
) {
    val question = viewModel.questions[0]
    val selectedAnswer by viewModel.selectedAnswer.collectAsState()
    val score by viewModel.score.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BgWarm)
            .padding(20.dp)
    ) {
        // Top bar
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = onBackClick) {
                Text("➡️", fontSize = 20.sp)
            }
            Text("پرسش ۱ از ۳", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = TextDark)
            Text("$score امتیاز ⭐", fontSize = 14.sp, color = PrimaryTeal, fontWeight = FontWeight.Bold)
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Progress bar
        LinearProgressIndicator(
            progress = { 0.33f },
            modifier = Modifier.fillMaxWidth().height(8.dp).clip(RoundedCornerShape(4.dp)),
            color = TerracottaRed,
            trackColor = CardBorder
        )

        Spacer(modifier = Modifier.height(32.dp))

        // Question Card
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {
            Column(
                modifier = Modifier.padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("کدام واژه این ضرب‌المثل را کامل می‌کند؟", fontSize = 14.sp, color = TextMuted)
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = question.text,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = PrimaryTeal
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Options
        question.options.forEachIndexed { index, option ->
            val isSelected = selectedAnswer == index
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(if (isSelected) LightMint else Color.White)
                    .border(
                        width = if (isSelected) 2.dp else 1.dp,
                        color = if (isSelected) PrimaryTeal else CardBorder,
                        shape = RoundedCornerShape(12.dp)
                    )
                    .clickable { viewModel.selectAnswer(index) }
                    .padding(horizontal = 20.dp),
                contentAlignment = Alignment.CenterStart
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(option, fontSize = 16.sp, fontWeight = FontWeight.Medium, color = TextDark)
                    if (isSelected) {
                        Text("✅", fontSize = 18.sp)
                    }
                }
            }
            Spacer(modifier = Modifier.height(12.dp))
        }
    }
}
