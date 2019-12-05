package steps;

import Utils.CommonUtils;
import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.Table;

import java.util.HashMap;
import java.util.Map;
import pages.Homepage;

public class HomepageSteps {
    private Homepage homepage = new Homepage();

    @Step("Open Airways website <Qatar_URL>")
    public void Openurl(String link) {
        homepage.openurl(System.getenv(link));
    }

    @Step("Signup1 for <Lastname> <table>")
    public void Signup1(String Lastname, Table table) {
        if (!table.equals(null)) {
            try {
                Map<String, String> tableasMap = new HashMap<>();
                if (table.getTableRows().size() == 1)
                    tableasMap = CommonUtils.convertChildtableToMap(table);
                else
                    tableasMap = CommonUtils.converTabletoMap(table);
                homepage.signup(tableasMap, Lastname);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    @Step("Signup2 for <Lastname> <table>")
    public void Signup2(String Lastname, Table table) {
        if (!table.equals(null)) {
            try {
                Map<String, String> tableasMap = new HashMap<>();
                if (table.getTableRows().size() == 1)
                    tableasMap = CommonUtils.convertChildtableToMap(table);
                else
                    tableasMap = CommonUtils.converTabletoMap(table);
                homepage.signup(tableasMap, Lastname);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

