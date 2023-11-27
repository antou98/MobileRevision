package com.example.revisionmobileexam.Data;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "TableString")
public class TableString {

    @DatabaseField(columnName = "idJoueur", generatedId = true )
    private int id;

    @DatabaseField
    private String info;

    public TableString( String info) {
        this.info = info;
    }

    public TableString(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "TableString{" +
                "id=" + id +
                ", info='" + info + '\'' +
                '}';
    }
}
