package dev.reymark.data;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import javax.sql.rowset.CachedRowSet;

import dev.reymark.App;
import dev.reymark.models.hr.Office;
import dev.sol.db.DBService;

public class OfficeDAO {
    private static String TABLE = "office";
    private static final DBService DB = App.DB_COOP;

    private static Office data(CachedRowSet crs) {
        try {
            String office_id = crs.getString("officeID");
            String office_name = crs.getString("officeName");

            return new Office(office_id, office_name);
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return null;
    }

    public static List<Office> getOfficeList() {
        CachedRowSet crs = DB.select_all(TABLE);
        List<Office> list = new LinkedList<>();

        try {
            while (crs.next()) {
                Office office = data(crs);
                if (office != null)
                    ;
                list.add(office);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

}
