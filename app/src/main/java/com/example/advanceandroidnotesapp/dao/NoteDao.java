package com.example.advanceandroidnotesapp.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.advanceandroidnotesapp.entities.Note;

import java.util.Date;
import java.util.List;

@Dao// Data Access Object (DAO) của Room Persistence Library. Nó giúp Room xác định
// rằng interface này chứa các phương thức để truy cập cơ sở dữ liệu.
public interface NoteDao {

    @Query("SELECT * FROM notes ORDER BY id DESC")
    List<Note> getAllNotes();

    //Sua query
    @Query("SELECT * FROM notes WHERE DATE(date_column) = DATE(:targetDate) ORDER BY id DESC")
    List<Note> getNotesByDate(Date targetDate);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertNote(Note note);

    @Delete
    void deleteNote(Note note);

//    @Query("SELECT * FROM notes " +
//            "ORDER BY strftime('%Y', date_column) DESC, " +
//            "strftime('%m', date_column) DESC, " +
//            "strftime('%d', date_column) DESC")
//    List<Note> getAllNotesByYearMonthDay();
}
