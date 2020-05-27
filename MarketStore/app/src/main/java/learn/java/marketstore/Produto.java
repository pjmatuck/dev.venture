package learn.java.marketstore;

import android.os.Parcel;
import android.os.Parcelable;

public class Produto implements Parcelable {

    private int id;
    private String nomeProduto;
    private String breveDescricao;
    private String longaDescricao;
    private float preco;

    public Produto(int id, String nomeProduto, String breveDescricao, String longaDescricao, float preco) {
        this.id = id;
        this.nomeProduto = nomeProduto;
        this.breveDescricao = breveDescricao;
        this.longaDescricao = longaDescricao;
        this.preco = preco;
    }

    protected Produto(Parcel in) {
        id = in.readInt();
        nomeProduto = in.readString();
        breveDescricao = in.readString();
        longaDescricao = in.readString();
        preco = in.readFloat();
    }

    public static final Creator<Produto> CREATOR = new Creator<Produto>() {
        @Override
        public Produto createFromParcel(Parcel in) {
            return new Produto(in);
        }

        @Override
        public Produto[] newArray(int size) {
            return new Produto[size];
        }
    };

    public int getId() {
        return id;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public String getBreveDescricao() {
        return breveDescricao;
    }

    public String getLongaDescricao() {
        return longaDescricao;
    }

    public float getPreco() {
        return preco;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(nomeProduto);
        dest.writeString(breveDescricao);
        dest.writeString(longaDescricao);
        dest.writeFloat(preco);
    }
}
