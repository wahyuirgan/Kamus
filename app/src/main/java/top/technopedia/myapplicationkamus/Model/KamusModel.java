package top.technopedia.myapplicationkamus.Model;

import android.os.Parcel;
import android.os.Parcelable;


public class KamusModel implements Parcelable {
    private int id;
    private String kata;
    private String deskripsi;
    private String category;

    public KamusModel(String kata, String deskripsi){
        this.kata       = kata;
        this.deskripsi  = deskripsi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKata() {
        return kata;
    }

    public void setKata(String kata) {
        this.kata = kata;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.kata);
        dest.writeString(this.deskripsi);
        dest.writeString(this.category);
    }

    public KamusModel() {
    }

    private KamusModel(Parcel in) {
        this.id = in.readInt();
        this.kata = in.readString();
        this.deskripsi = in.readString();
        this.category = in.readString();
    }

    public static final Creator<KamusModel> CREATOR = new Creator<KamusModel>() {
        @Override
        public KamusModel createFromParcel(Parcel source) {
            return new KamusModel(source);
        }

        @Override
        public KamusModel[] newArray(int size) {
            return new KamusModel[size];
        }
    };
}
