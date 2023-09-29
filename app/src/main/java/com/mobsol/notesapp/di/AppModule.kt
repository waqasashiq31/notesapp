package com.mobsol.notesapp.di

import android.app.Application
import androidx.room.Room
import com.mobsol.notesapp.feature_note.data.data_source.NoteDatabase
import com.mobsol.notesapp.feature_note.data.repository.NoteRepositoryImpl
import com.mobsol.notesapp.feature_note.domain.repository.NoteRepository
import com.mobsol.notesapp.feature_note.domain.usecase.AddNoteUseCase
import com.mobsol.notesapp.feature_note.domain.usecase.DeleteNoteUseCase
import com.mobsol.notesapp.feature_note.domain.usecase.GetNotesUseCase
import com.mobsol.notesapp.feature_note.domain.usecase.NoteUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Provides
    @Singleton
    fun provideRoomDatabase(app: Application): NoteDatabase {
        return Room.databaseBuilder(
            app,
            NoteDatabase::class.java,
            NoteDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideNoteRepository(db: NoteDatabase) : NoteRepository {
        return NoteRepositoryImpl(db.noteDao)
    }

    @Provides
    @Singleton
    fun provideNoteUseCases(noteRepository: NoteRepository) : NoteUseCases {
        return NoteUseCases(
            getNotesUseCase = GetNotesUseCase(noteRepository),
            deleteNoteUseCase = DeleteNoteUseCase(noteRepository),
            addNoteUseCase = AddNoteUseCase(noteRepository)
        )
    }
}