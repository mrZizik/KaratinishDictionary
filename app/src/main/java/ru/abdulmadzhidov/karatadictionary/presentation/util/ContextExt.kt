package ru.abdulmadzhidov.karatadictionary.presentation.util

import android.content.Context
import android.content.Intent
import ru.abdulmadzhidov.karatadictionary.BuildConfig
import ru.abdulmadzhidov.karatadictionary.R

fun Context.shareApp() {
    val intent = Intent(Intent.ACTION_SEND);
    val shareMessage = "${getString(R.string.app_name)} - https://play.google.com/store/apps/details?id=${BuildConfig.APPLICATION_ID}"
    intent.setType("text/plain");
    intent.putExtra(Intent.EXTRA_TEXT, shareMessage);
    startActivity(Intent.createChooser(intent, getString(R.string.share)));
}

fun Context.shareWord(title: String, translation: String) {
    val intent = Intent(Intent.ACTION_SEND);
    val shareMessage = "$title - $translation"
    intent.setType("text/plain");
    intent.putExtra(Intent.EXTRA_TEXT, shareMessage);
    startActivity(Intent.createChooser(intent, getString(R.string.share)));
}