package top.technopedia.myapplicationkamus.Database;

import android.provider.BaseColumns;


public class DatabaseContract {

    public static String TABLE_INA_TO_ENG  = "ind_to_eng";
    public static String TABLE_ENG_TO_INA  = "eng_to_ind";

    public static final class KamusColumns implements BaseColumns {
        public static String FIELD_KATA     = "kata";
        public static String FIELD_ARTI     = "arti";
    }

}
