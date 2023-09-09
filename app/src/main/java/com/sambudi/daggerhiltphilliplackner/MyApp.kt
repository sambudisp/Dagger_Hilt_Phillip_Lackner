package com.sambudi.daggerhiltphilliplackner

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp // Supaya dagger-hilt bisa get "Application" yang kita buat
class MyApp  : Application(){
}