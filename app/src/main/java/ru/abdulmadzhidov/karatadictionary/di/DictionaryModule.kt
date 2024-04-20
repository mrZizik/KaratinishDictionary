package ru.abdulmadzhidov.karatadictionary.di

import android.content.Context
import android.nfc.tech.MifareUltralight.PAGE_SIZE
import androidx.paging.Pager
import androidx.paging.PagingConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import ru.abdulmadzhidov.karatadictionary.data.DictionaryRepository
import ru.abdulmadzhidov.karatadictionary.data.DictionaryRepositoryImpl
import ru.abdulmadzhidov.karatadictionary.data.db.DictionaryDatabase
import ru.abdulmadzhidov.karatadictionary.data.db.SearchDataSourceFactory
import ru.abdulmadzhidov.karatadictionary.data.db.dto.WordLocal
import ru.abdulmadzhidov.karatadictionary.domain.DictionaryInteractor
import ru.abdulmadzhidov.karatadictionary.domain.DictionaryInteractorImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object FooModule {

    @Singleton
    @Provides
    fun provideDictionaryRepository(pager: Pager<Int, WordLocal>, dataSourceFactory: SearchDataSourceFactory): DictionaryRepository =
        DictionaryRepositoryImpl(pager, dataSourceFactory)

    @Singleton
    @Provides
    fun provideDictionaryInteractor(dictionaryRepository: DictionaryRepository): DictionaryInteractor =
        DictionaryInteractorImpl(dictionaryRepository)

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context) = DictionaryDatabase.get(context)

    @Provides
    @Singleton
    fun providePager(
        searchDataSource: SearchDataSourceFactory
    ): Pager<Int, WordLocal> {
        return Pager(
            config = PagingConfig(
                pageSize = 20,
                enablePlaceholders = true,
                prefetchDistance = 60,
                initialLoadSize = 40
            ),
            pagingSourceFactory = searchDataSource::load,
        )
    }

    @Provides
    @Singleton
    fun provideSearchDataSource(db: DictionaryDatabase) = SearchDataSourceFactory(db.wordsDao())

}