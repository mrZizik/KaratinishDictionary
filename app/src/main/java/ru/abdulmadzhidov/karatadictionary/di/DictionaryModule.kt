package ru.abdulmadzhidov.karatadictionary.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.abdulmadzhidov.karatadictionary.data.DictionaryRepository
import ru.abdulmadzhidov.karatadictionary.data.DictionaryRepositoryImpl
import ru.abdulmadzhidov.karatadictionary.domain.DictionaryInteractor
import ru.abdulmadzhidov.karatadictionary.domain.DictionaryInteractorImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object FooModule {

    @Singleton
    @Provides
    fun provideDictionaryRepository(): DictionaryRepository =
        DictionaryRepositoryImpl()

    @Singleton
    @Provides
    fun provideDictionaryInteractor(dictionaryRepository: DictionaryRepository): DictionaryInteractor =
        DictionaryInteractorImpl(dictionaryRepository)
}