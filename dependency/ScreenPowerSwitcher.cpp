#include <jni.h>
#include <windows.h>
#include "by_home_core_ScreenPowerSwitcher.h"

JNIEXPORT void JNICALL Java_by_home_core_ScreenPowerSwitcher_switchOn(JNIEnv *env, jobject obj)
{
	SendMessage(HWND_BROADCAST, WM_SYSCOMMAND, SC_MONITORPOWER, (LPARAM) -1);
	return;
}


JNIEXPORT void JNICALL Java_by_home_core_ScreenPowerSwitcher_switchOff(JNIEnv *env, jobject obj)
{
	SendMessage(HWND_BROADCAST, WM_SYSCOMMAND, SC_MONITORPOWER, (LPARAM) 2);
	return;
}

JNIEXPORT void JNICALL Java_by_home_core_ScreenPowerSwitcher_lowPower(JNIEnv *env, jobject obj) 
{
	SendMessage(HWND_BROADCAST, WM_SYSCOMMAND, SC_MONITORPOWER, (LPARAM) 1);
	return;
}
