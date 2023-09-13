package pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true) //@JsonIgnoreProperties(ignoreUnknown = true) //Bunlarin disinda bir data geldigi zaman gormezden gel, normalde örnekte id hatasi almistik bu gibi hatalari görmezden geliyor bu sayede
public class JsonPlaceHolderPojo {
    // 1. Private variable'lar oluştur

    //Variable'lari static yapmamaya dikkat et. Cünkü her obje'nin degeri farkli olmali. !!
    private Integer userId;
    private String title;
    private Boolean completed;

    // 2. Parametreli ve Parametresiz constructor'lar oluştur
    //Parametresiz constructor'a ihtiyacimiz var cünkü data dönüsümlerini yapiyoruz response.as..'de(Deserialization) orada kullaniliyor bu otomatik olarak
    public JsonPlaceHolderPojo(Integer userId, String title, Boolean completed) {
        this.userId = userId;
        this.title = title;
        this.completed = completed;
    }

    public JsonPlaceHolderPojo() {
    }

        // 3. public getter ve setter metotlarını oluştur
        //getter'lar parametresiz olur, setter'Lar parametreli
        //setter'lar void olması lazım.
    //Pojo class taki variable lara ulasimi kisitlamak icin private yaptik.(Encapsulation)
    //get islemi ile assertion yaptik

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    // 4. toString() metodunu oluştur
    @Override
    public String toString() {
        return "JsonPlaceHolderPojo{" +
                "userId=" + userId +
                ", title='" + title + '\'' +
                ", completed=" + completed +
                '}';
    }
    //Ic ice jsonlar geliyorsa ayri ayri pojo class lar olusturmamiz gerekir
    //pojo class variable lari private yapip getter, setter methodlariyla cagisirip degisiklik yaptigimiz class lardir.
}
