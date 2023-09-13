package herokuapp_smoketest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses(
        {
                C01_CreateBooking.class,
                C02_GetBookingById.class,
                C03_UpdateBooking.class,
                C04_PartialUpdateBooking.class
                //Bu class'i olusturduk cünkü sirasiyla calistirmak icin ve program calisirken id, token vb degerlerin kaybolmamasi icin.
                //Cünkü mesela bir class'i sonlandirdigimizda bu degerler kaybolabiliyor. Ama böyle yaptigimizda programi biz sonlandirmadan kaybolmuyor
                // Java'da mesela C_01'i calistirdik sonrasinda Java bellegi bosaltiyor, mesela id degeri testten sonra 0'laniyor ve delete patch gibi islemlere
                        // 0' olarak gidioyr. Bu nedenle bagil olan testleri birlikte calistirmak en iyi yöntem
        }
)
public class Runner {
}
