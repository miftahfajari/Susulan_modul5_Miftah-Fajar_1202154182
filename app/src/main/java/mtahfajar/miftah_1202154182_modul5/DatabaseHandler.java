package mtahfajar.miftah_1202154182_modul5;

/**
 * Created by Miftah on 25/03/2018.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import mtahfajar.miftah_1202154182_modul5.MainActivity;

import java.util.LinkedList;

public class DatabaseHandler extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "db_activity";

    private static final String TABLE_NAME = "tb_todo";

    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_DESC = "desc";
    private static final String KEY_PRIORITY = "priority";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TODO_TABLE = "CREATE TABLE " + TABLE_NAME + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"
                + KEY_DESC + " TEXT, " +KEY_PRIORITY + " TEXT)";
        db.execSQL(CREATE_TODO_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);

        onCreate(db);
    }

    public void save(Activity activity){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(KEY_NAME, activity.getTodo());
        values.put(KEY_DESC, activity.getDescription());
        values.put(KEY_PRIORITY, activity.getPriority());

        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public LinkedList<Activity> findAll(){
        LinkedList<Activity> listBuku = new LinkedList<Activity>();
        String query="SELECT * FROM "+TABLE_NAME;

        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery(query, null);

        if(cursor.moveToFirst()){
            do{
                Activity activity = new Activity();
                activity.setId(Integer.valueOf(cursor.getString(0)));
                activity.setTodo(cursor.getString(1));
                activity.setDescription(cursor.getString(2));
                activity.setPriority(cursor.getString(3));
                listBuku.add(activity);
            }while(cursor.moveToNext());
        }

        return listBuku;
    }

    public boolean delete(Activity activity){
        SQLiteDatabase db=this.getWritableDatabase();
        return db.delete(TABLE_NAME, "id =" + activity.getId(), null) > 0;
    }
}
