#include <jni.h>
#include "by_home_core_WorkstationLocker.h"
#include <windows.h>

JNIEXPORT void JNICALL Java_by_home_core_WorkstationLocker_lock(JNIEnv *env, jobject obj)
{
	LockWorkStation();
	return;
}