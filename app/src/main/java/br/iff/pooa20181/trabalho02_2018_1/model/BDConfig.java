package br.iff.pooa20181.trabalho02_2018_1.model;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class BDConfig extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Realm.init(getApplicationContext());

        RealmConfiguration.Builder builder = new RealmConfiguration.Builder();
        builder.name("ELE.realm");
        builder.schemaVersion(0);
        builder.deleteRealmIfMigrationNeeded();
        RealmConfiguration realmConfiguration = builder.build();
        Realm.setDefaultConfiguration(realmConfiguration);
    }
}
