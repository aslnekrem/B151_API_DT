package pojos.gmi_bank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PostCountryPojo implements Serializable {

    //Buradan private id; ' yi sildik cünkü biz id ile gönderi yapamiyoruz hicbir zaman. Cünkü id otomatik olusturulup bize dönüyor
	/*
	Post'da id koyamiyoruz. Bu pojo'yu post'da kullaniyoruz. Text'deki ile otomatik bir pojo olustururken country yine vardi
	orada. Otomatik bir CountryPojo olusturacakti. Fakat biz CountryPojo post isleminde olusturdugumuz icin üstüne yazacakti
	id'li olarak. Fakat post'da id olmamasi lazim bu yüzden bu class'in adina post ekledik. Ve get islemi icin otomatik olusturulan
	CounrtryPojo'da id oldu. id'li olan CountryPojo'yu get'de id'siz olan PostCountryPojo'yu da posst da kullanabiliyoruz böylelikle
	karismadan.

	 */
    private String name;
    private List<StatesPojo> states;

    public PostCountryPojo() {
    }

    public PostCountryPojo(String name, List<StatesPojo> states) {
        this.name = name;
        this.states = states;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setStates(List<StatesPojo> states) {
        this.states = states;
    }

    public List<StatesPojo> getStates() {
        return states;
    }

    @Override
    public String toString() {
        return
                "CountryPojo{" +
                        "name = '" + name + '\'' +
                        ",states = '" + states + '\'' +
                        "}";
    }
}