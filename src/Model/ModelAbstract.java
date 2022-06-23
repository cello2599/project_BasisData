
package Model;
import java.sql.Connection;
import Helper.KoneksiDb;
/**
 *
 * @author DEMITRIUS
 */
public class ModelAbstract {
    Connection conn = KoneksiDb.getConnection();
}
