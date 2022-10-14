package valtechspring.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;
import javax.swing.tree.RowMapper;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;


import valtechspring.orm.Car;
import valtechspring.orm.CarDetails;

public class CarDAOImpl implements CarDAO {

	private DataSource dataSource;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	/* (non-Javadoc)
	 * @see valtechspring.jdbc.CarDAO#save(valtechspring.orm.Car)
	 */
	@Override
	public void save(Car car){
        JdbcTemplate temp= new  JdbcTemplate(dataSource);
        temp.update("insert into Car (kms,numOfOwners,validInsurance,color,make,model,price,version,yearManufactured,id)"+" values(?,?,?,?,?,?,?,?,?,?)"
        ,car.getCarDetails().getKms(),car.getCarDetails().getNumOfOwners(),car.getCarDetails().isValidInsurance()
        ,car.getColor(),car.getMake(),car.getModel()
        ,car.getPrice(),car.getYearManufactured(),car.getVersion());
    }
    /* (non-Javadoc)
	 * @see valtechspring.jdbc.CarDAO#update(valtechspring.orm.Car)
	 */
    @Override
	public void update(Car car){
    	 JdbcTemplate temp= new  JdbcTemplate(dataSource);
        temp.update("update car set kms=?,numofowners=?,validinsurance=?,color=?,make=?,model=?,price=?,version=? where id=?",car.getCarDetails().getKms(),
                car.getCarDetails().getNumOfOwners(),car.getCarDetails().isValidInsurance(),car.getColor(),
                car.getMake(),car.getModel(),car.getPrice(),car.getYearManufactured(),car.getVersion()+1);
    }
    
   /* (non-Javadoc)
 * @see valtechspring.jdbc.CarDAO#delete(valtechspring.orm.Car)
 */
@Override
public void delete(Car car){
	   JdbcTemplate temp= new  JdbcTemplate(dataSource);
	   temp.update("delete from car where id = ?",car.getId());
	   }
private static class CarRowMapper implements org.springframework.jdbc.core.RowMapper<Car> {



       public Car mapRow(ResultSet rs, int row) throws SQLException {
            int kms=rs.getInt(1);
            int numofOwners = rs.getInt(2);
            boolean validInsurance = rs.getBoolean(3);
            
            CarDetails cd = new CarDetails(kms,validInsurance,numofOwners);
            
            String color= rs.getString(4);
            String make = rs.getString(5);
            String model = rs.getString(6);
            float price = rs.getFloat(7);
            int version = rs.getInt(8);
             int yearMfg = rs.getInt(9);
             int id = rs.getInt(10);
             Car car= new Car(id,make,model,color,price, yearMfg, cd);
            return car;
          }
       //String make, String model, String color, float price, int yearManufactured,CarDetails carDetails
        
    }

   /* (non-Javadoc)
 * @see valtechspring.jdbc.CarDAO#get(int)
 */
//   public Car get(int id) {
//       JdbcTemplate temp = new JdbcTemplate(dataSource);
//         return temp.queryForObject("Select kms,numOfOWners,color,make,model,price,version,yearManufactured,id from car where id=?",new CarRowMapper(),id);
//             }
//   
   public Car get(int id) {
       JdbcTemplate temp = new JdbcTemplate(dataSource);
         return temp.queryForObject("Select kms,numOfOWners,validInsurance,color,make,model,price,yearManufactured,version,id from car where id=?",new CarRowMapper(),id);
             }
   public List<Car> getAll(){
       JdbcTemplate temp = new JdbcTemplate(dataSource);
       return temp.query("Select id,kms,numOfOWners,validInsurance,color,make,model,price,version,yearManufactured,id from car ",new CarRowMapper());
        }
}