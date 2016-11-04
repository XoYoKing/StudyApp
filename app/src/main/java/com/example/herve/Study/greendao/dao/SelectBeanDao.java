package com.example.herve.Study.greendao.dao;

import java.util.List;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.query.Query;
import org.greenrobot.greendao.query.QueryBuilder;

import com.example.herve.Study.bean.SelectBean;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "SELECT_BEAN".
*/
public class SelectBeanDao extends AbstractDao<SelectBean, Long> {

    public static final String TABLENAME = "SELECT_BEAN";

    /**
     * Properties of entity SelectBean.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property SelectId = new Property(0, Long.class, "selectId", true, "_id");
        public final static Property Select = new Property(1, String.class, "select", false, "SELECT");
    }

    private Query<SelectBean> answerBean_SelectBeensQuery;
    private Query<SelectBean> questionBean_SelectBeensQuery;

    public SelectBeanDao(DaoConfig config) {
        super(config);
    }
    
    public SelectBeanDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"SELECT_BEAN\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: selectId
                "\"SELECT\" TEXT);"); // 1: select
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"SELECT_BEAN\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, SelectBean entity) {
        stmt.clearBindings();
 
        Long selectId = entity.getSelectId();
        if (selectId != null) {
            stmt.bindLong(1, selectId);
        }
 
        String select = entity.getSelect();
        if (select != null) {
            stmt.bindString(2, select);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, SelectBean entity) {
        stmt.clearBindings();
 
        Long selectId = entity.getSelectId();
        if (selectId != null) {
            stmt.bindLong(1, selectId);
        }
 
        String select = entity.getSelect();
        if (select != null) {
            stmt.bindString(2, select);
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public SelectBean readEntity(Cursor cursor, int offset) {
        SelectBean entity = new SelectBean( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // selectId
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1) // select
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, SelectBean entity, int offset) {
        entity.setSelectId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setSelect(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(SelectBean entity, long rowId) {
        entity.setSelectId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(SelectBean entity) {
        if(entity != null) {
            return entity.getSelectId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(SelectBean entity) {
        return entity.getSelectId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
    /** Internal query to resolve the "selectBeens" to-many relationship of AnswerBean. */
    public List<SelectBean> _queryAnswerBean_SelectBeens(Long selectId) {
        synchronized (this) {
            if (answerBean_SelectBeensQuery == null) {
                QueryBuilder<SelectBean> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.SelectId.eq(null));
                answerBean_SelectBeensQuery = queryBuilder.build();
            }
        }
        Query<SelectBean> query = answerBean_SelectBeensQuery.forCurrentThread();
        query.setParameter(0, selectId);
        return query.list();
    }

    /** Internal query to resolve the "selectBeens" to-many relationship of QuestionBean. */
    public List<SelectBean> _queryQuestionBean_SelectBeens(Long selectId) {
        synchronized (this) {
            if (questionBean_SelectBeensQuery == null) {
                QueryBuilder<SelectBean> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.SelectId.eq(null));
                questionBean_SelectBeensQuery = queryBuilder.build();
            }
        }
        Query<SelectBean> query = questionBean_SelectBeensQuery.forCurrentThread();
        query.setParameter(0, selectId);
        return query.list();
    }

}
