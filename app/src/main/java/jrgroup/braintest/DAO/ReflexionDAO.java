package jrgroup.braintest.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.Log;

import jrgroup.braintest.DTO.Reflextion;

/**
 * Created by JR on 2017/04/26.
 */

public class ReflexionDAO {
    private static final String TAG = ReflexionDAO.class.getName();
    Context context;
    SQLiteDatabase db;
    MyDataBase myDataBase;

    public ReflexionDAO(Context context){
        this.context = context;
        myDataBase = new MyDataBase(context);
    }

    public void Them(Reflextion ref)
    {
        db.beginTransaction();
        try {
            db = myDataBase.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put(MyDataBase.getReflexionName(), ref.getName());
            values.put(MyDataBase.getReflexionScore(), ref.getScore());
            db.insert(MyDataBase.getTableReflexion(), null, values);
        }
        catch (SQLiteException ex) {
            Log.d(TAG, "loi them");
        }
        finally {
            db.endTransaction();
        }
    }
}
