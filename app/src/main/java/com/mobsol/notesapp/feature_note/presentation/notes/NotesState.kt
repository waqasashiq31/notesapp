package com.mobsol.notesapp.feature_note.presentation.notes

import android.provider.ContactsContract.CommonDataKinds.Note
import com.mobsol.notesapp.feature_note.domain.util.NoteOrder
import com.mobsol.notesapp.feature_note.domain.util.OrderType

data class NotesState(
    val notes: List<Note> = emptyList(),
    val noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending),
    val isOrderSelectionVisible: Boolean = false
)