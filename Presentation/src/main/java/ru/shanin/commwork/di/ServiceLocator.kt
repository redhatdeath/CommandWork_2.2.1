package ru.shanin.commwork.di

import android.content.Context
import com.ngallazzi.data.repositories.books.BooksLocalDataSource
import com.ngallazzi.data.repositories.books.BooksLocalDataSourceImpl
import com.ngallazzi.data.repositories.books.BooksRepositoryImpl
import kotlinx.coroutines.Dispatchers
import ru.shanin.data.database.RoomLocalDatabase
import ru.shanin.data.repositoryimpl.PeopleDataRepositoryImpl

object ServiceLocator {
    private var database: RoomLocalDatabase? = null

    private val PeopleEntityMapper by lazy {
        PeopleEntityMapper()
    }
    private val CommandWorkEntityMapper by lazy {
        CommandWorkEntityMapper()
    }

    @Volatile
    var PeopleRepository: PeopleDataRepositoryImpl? = null
    var CommandWorkRepository: CommandWorkRepositoryImpl? = null

    fun provideBooksRepository(context: Context): BooksRepositoryImpl {
        // useful because this method can be accessed by multiple threads
        synchronized(this) {
            return booksRepository ?: createBooksRepository(context)
        }
    }



    private fun createBooksLocalDataSource(context: Context): BooksLocalDataSource {
        val database = database ?: createDataBase(context)
        return BooksLocalDataSourceImpl(
            database.bookDao(),
            Dispatchers.IO,
            bookEntityMapper
        )
    }

    private fun createDataBase(context: Context): RoomLocalDatabase {
        val result = RoomLocalDatabase.getDatabase(context)
        database = result
        return result
    }
}