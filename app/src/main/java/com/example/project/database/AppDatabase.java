package com.example.project.database;
import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.project.model.User;

// entities array that lists all of the data entities associated with the database.
@Database(entities = {User.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();
}