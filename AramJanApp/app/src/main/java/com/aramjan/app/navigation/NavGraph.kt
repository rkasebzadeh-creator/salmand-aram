package com.aramjan.app.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.aramjan.app.screens.*
import com.aramjan.app.viewmodel.*

object Destinations {
    const val LOGIN = "login"
    const val HOME = "home"
    const val MEMORY_GAME = "memory_game"
    const val EDUCATIONAL_VIDEO = "educational_video"
    const val VOICE_MEMORIES = "voice_memories"
}

@Composable
fun AramJanNavGraph(
    navController: NavHostController = rememberNavController(),
    mainViewModel: MainViewModel = viewModel(),
    gameViewModel: GameViewModel = viewModel(),
    voiceViewModel: VoiceViewModel = viewModel()
) {
    NavHost(
        navController = navController,
        startDestination = Destinations.LOGIN
    ) {
        composable(Destinations.LOGIN) {
            LoginScreen(
                viewModel = mainViewModel,
                onLoginClick = {
                    navController.navigate(Destinations.HOME) {
                        popUpTo(Destinations.LOGIN) { inclusive = true }
                    }
                }
            )
        }

        composable(Destinations.HOME) {
            HomeScreen(
                viewModel = mainViewModel,
                onNavigateToGame = { navController.navigate(Destinations.MEMORY_GAME) },
                onNavigateToVideo = { navController.navigate(Destinations.EDUCATIONAL_VIDEO) },
                onNavigateToVoice = { navController.navigate(Destinations.VOICE_MEMORIES) }
            )
        }

        composable(Destinations.MEMORY_GAME) {
            MemoryGameScreen(
                viewModel = gameViewModel,
                onBackClick = { navController.popBackStack() }
            )
        }

        composable(Destinations.EDUCATIONAL_VIDEO) {
            VideoScreen(
                onBackClick = { navController.popBackStack() }
            )
        }

        composable(Destinations.VOICE_MEMORIES) {
            VoiceMemoriesScreen(
                viewModel = voiceViewModel,
                onBackClick = { navController.popBackStack() }
            )
        }
    }
}
