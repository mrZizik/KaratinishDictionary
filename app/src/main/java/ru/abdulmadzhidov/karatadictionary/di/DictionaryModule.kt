package ru.abdulmadzhidov.karatadictionary.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import ru.abdulmadzhidov.karatadictionary.data.DictionaryRepository
import ru.abdulmadzhidov.karatadictionary.data.DictionaryRepositoryImpl
import ru.abdulmadzhidov.karatadictionary.data.db.DictionaryDatabase
import ru.abdulmadzhidov.karatadictionary.domain.DictionaryInteractor
import ru.abdulmadzhidov.karatadictionary.domain.DictionaryInteractorImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object FooModule {

    @Singleton
    @Provides
    fun provideDictionaryRepository(db: DictionaryDatabase): DictionaryRepository =
        DictionaryRepositoryImpl(db)

    @Singleton
    @Provides
    fun provideDictionaryInteractor(dictionaryRepository: DictionaryRepository): DictionaryInteractor =
        DictionaryInteractorImpl(dictionaryRepository)

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context) = DictionaryDatabase.get(context)
}