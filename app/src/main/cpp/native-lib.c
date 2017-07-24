//
// Created by jaehyek on 2017-06-10.
//

#include <jni.h>
#include <time.h>
#include <android/log.h>
#include <android/bitmap.h>

#include <stdio.h>
#include <stdlib.h>
#include <math.h>

#define  LOG_TAG    "libimageprocessing"
#define  LOGI(...)  __android_log_print(ANDROID_LOG_INFO,LOG_TAG,__VA_ARGS__)
#define  LOGE(...)  __android_log_print(ANDROID_LOG_ERROR,LOG_TAG,__VA_ARGS__)


JNIEXPORT void JNICALL Java_com_dai_dai_1test_CamPreviewActivity_sendData(JNIEnv * env, jobject  obj, jbyteArray data)
{
    jbyte            *pdata;
    jbyte aa ;


    pdata=(*env)->GetByteArrayElements(env,data,0);
    aa = *pdata ;

    (*env)->ReleaseByteArrayElements(env,data,pdata,JNI_ABORT); /* abort to not copy back contents */

//    return JNI_FALSE;
}
