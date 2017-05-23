package jrgroup.braintest.DAO;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by JR on 2017/04/26.
 */

public class MyDataBase extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "HighScore";
    private static final int DATABASE_VERSION = 1;

    public static String getTableReflexion() {
        return TABLE_REFLEXION;
    }

    //Data Table
    private  static final String TABLE_REFLEXION = "ReflexionGame";
    private  static final String TABLE_MEMORY = "MemoryGame";
    private  static final String TABLE_VISION = "VisionGame";
    private  static final String TABLE_QUICKMATH = "QuickMathGame";

    //Data Table Column
    private static final String REFLEXION_ID = "ID";

    public static String getReflexionName() {
        return REFLEXION_NAME;
    }

    private static final String REFLEXION_NAME = "Name";

    public static String getReflexionScore() {
        return REFLEXION_SCORE;
    }

    private static final String REFLEXION_SCORE = "Score";

    private static final String MEMORY_ID = "ID";
    private static final String MEMORY_NAME = "Name";
    private static final String MEMORY_SCORE = "Score";

    private static final String VISION_ID = "ID";
    private static final String VISION_NAME = "Name";
    private static final String VISION_SCORE = "Score";

    private static final String QUICKMATH_ID = "ID";
    private static final String QUICKMATH_NAME = "Name";
    private static final String QUICKMATH_SCORE = "Score";

    public MyDataBase(Context context) {
        super(context,DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE_REFLEXION = "CREATE TABLE " + TABLE_REFLEXION + "( " + REFLEXION_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + REFLEXION_NAME + " TEXT," + REFLEXION_SCORE + " TEXT)";
        db.execSQL(CREATE_TABLE_REFLEXION);

        String CREATE_TABLE_MEMORY = "CREATE TABLE " + TABLE_MEMORY + "( " + MEMORY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + MEMORY_NAME + " TEXT," + MEMORY_SCORE + " TEXT)";
        db.execSQL(CREATE_TABLE_MEMORY);

        String CREATE_TABLE_VISION = "CREATE TABLE " + TABLE_VISION + "( " + VISION_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + VISION_NAME + " TEXT," + VISION_SCORE + " TEXT)";
        db.execSQL(CREATE_TABLE_VISION);

        String CREATE_TABLE_QUICKMATH = "CREATE TABLE " + TABLE_QUICKMATH + "( " + QUICKMATH_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + QUICKMATH_NAME + " TEXT," + QUICKMATH_SCORE + " TEXT)";
        db.execSQL(CREATE_TABLE_QUICKMATH);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (newVersion != oldVersion){
            db.execSQL("DROP TABLE IF EXISTS" + TABLE_REFLEXION);
            db.execSQL("DROP TABLE IF EXISTS" + TABLE_MEMORY);
            db.execSQL("DROP TABLE IF EXISTS" + TABLE_VISION);
            db.execSQL("DROP TABLE IF EXISTS" + TABLE_QUICKMATH);
        }
    }
}
