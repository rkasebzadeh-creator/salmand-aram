@echo off
echo Starting AramJan APK Build...
call gradlew.bat assembleDebug
if %ERRORLEVEL% NEQ 0 (
    echo.
    echo [ERROR] Build failed. Please check Java installation and Android SDK.
    pause
) else (
    echo.
    echo [SUCCESS] APK created at: app\build\outputs\apk\debug\app-debug.apk
    pause
)
