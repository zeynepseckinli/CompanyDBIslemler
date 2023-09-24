package com.bilgeadam.repository;

import com.bilgeadam.repository.entity.Calisan;

public class CalisanRepository implements ICrud<Calisan>{

    private ConnectionProvider connectionProvider;

    public CalisanRepository(){
        this.connectionProvider = new ConnectionProvider();
    }

    @Override
    public boolean save(Calisan calisan) {
        // INSERT INTO tblcalisan (isim,soyisim) VALUES('Zeynep','Seckinli');

        String sqlSaveQuery = "INSERT INTO tblcalisan (isim,soyisim) " +
                "VALUES('"+calisan.getIsim()+"','"+calisan.getSoyIsim()+"')";
        return connectionProvider.executeUpdate(sqlSaveQuery);
    }
}
