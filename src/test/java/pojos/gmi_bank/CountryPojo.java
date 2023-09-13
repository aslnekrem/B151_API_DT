package pojos.gmi_bank;

import java.io.Serializable;

public class CountryPojo implements Serializable {
    /*
    Post'da id koyamiyoruz. Bu pojo'yu get'de kullaniyoruz. Text'deki ile otomatik bir pojo olustururken country yine vardi
    orada. Otomatik bir CountryPojo olusturacakti. Fakat biz CountryPojo post isleminde olusturdugumuz icin üstüne yazacakti
    id'li olarak. Fakat post'da id olmamasi lazim bu yüzden ilk olusturdugumuz CountryPojo class'in adina post ekledik. Ve get islemi icin otomatik olusturulan
    CounrtryPojo'da id oldu. id'li olan CountryPojo'yu get'de, id'siz olan PostCountryPojo'yu da post da kullanabiliyoruz böylelikle
    karismadan ve üstüne yazmadan.

     */
    private int id;
    private String name;
    private Object states; //Burayi istesek list'de yapabilirdik. PostCountryPojo'ya bakabilirsin. Cünkü Response'dan biliyoruz zaten List oldugunu

    public CountryPojo() {
    }

    public CountryPojo(int id, String name, Object states) {
        this.id = id;
        this.name = name;
        this.states = states;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setStates(Object states) {
        this.states = states;
    }

    public Object getStates() {
        return states;
    }

    @Override
    public String toString() {
        return
                "CountryPojo{" +
                        "id = '" + id + '\'' +
                        ",name = '" + name + '\'' +
                        ",states = '" + states + '\'' +
                        "}";
    }
}