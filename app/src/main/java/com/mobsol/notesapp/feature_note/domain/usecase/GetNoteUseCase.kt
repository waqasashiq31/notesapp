package com.mobsol.notesapp.feature_note.domain.usecase

import com.mobsol.notesapp.feature_note.domain.model.Note
import com.mobsol.notesapp.feature_note.domain.repository.NoteRepository

class GetNoteUseCase (
    private val noteRepository: NoteRepository
) {
    suspend operator fun invoke(id: Int): Note? {
        return noteRepository.getNoteById(id)
    }
}