package herokuapp_smoketest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses(
        {
                C01_PostRequest.class,
                C02_GetRequest.class,
                C03_PutRequest.class

        }

)
//Oluşturulan classların çalışma sırasını belirtiyoruz
public class Runner {
}
