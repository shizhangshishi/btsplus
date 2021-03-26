package fd.se.btsplus.bts.http;

import fd.se.btsplus.bts.model.respnse.BtsLoginRes;

public interface IBtsHttpCaller {

    String BTS_URL = "http://10.176.122.171:8012";

    BtsLoginRes login(String username, String password);

}
