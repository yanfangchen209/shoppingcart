package shopping.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import shopping.dto.Product;
import shopping.service.ProductDao;

public class PostgresProductDao implements ProductDao{
	private static final String SELECT_PRODUCT_BY_ID = "select * from product where id=?";
	private static String SELECT_ALL_SQL = "select * from product";
	private static String ADD_PRODUCT_SQL = "insert into product(name, category, price) VALUES (?, ?, ?)";
	
	/**
	 * In this example, I do not use the java try with resource,
	 * Looks how cumbersome it is to handle the try catch finally here.
	 * 
	 * We need make sure Connection, PreparedStatement, ResultSet are closed properly.
	 * In java we do this in the finally block of try statement.
	 */
	@Override
	public List<Product> findAll(){
		List<Product> products = new ArrayList<>();
		
		//Declare the variable outside of try.
		//If delcared inside try,  they're not visible in finally block.
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultset = null;
		try {
			
			//Get an connection from our DataSource.
			connection = Database.getConnection();
			
			//Create an prepare statement with the select all sql.
			statement = connection.prepareStatement(SELECT_ALL_SQL);
			resultset = statement.executeQuery();
			
			//Iterate the ResetSet to collect data into product list.
			while(resultset.next()) {
				//For each row, we read the column values of the row and create an product.
				Product product = new Product(
						resultset.getLong("id"),
						resultset.getString("name"),
						resultset.getString("category"), 
						resultset.getDouble("price"));
				
				//Add the created product in our list.
				products.add(product);
			}
		} catch (SQLException exception) {
			throw new RuntimeException(exception);
		} finally {
			//It's better to close resultset first, then statement, then connection.
			
			//resultset may be null, if error happens, so we need check if it's null before we call close method.
			if(resultset != null) {
				try {
					resultset.close();
				} catch (SQLException e) {
					throw new RuntimeException(e);
				}
			}
			if(statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					throw new RuntimeException(e);
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					throw new RuntimeException(e);
				}
				
			}
		}
		
		//Return the products list.
		return products;
	}

	@Override
	public Product find(long id) {
		
			//In java try with resource, the object that are closable will be closed by java,
			//We don't need to worry about it.
			try(Connection connection = Database.getConnection();
				PreparedStatement statement = connection.prepareStatement(SELECT_PRODUCT_BY_ID);){
				
				
				statement.setLong(1, id);
				try(ResultSet resultset = statement.executeQuery()){
					Product product = null;
					//resultset.next return true means we have data available.
					//And we should have at most one row of data.
					if(resultset.next()) {
						product = new Product(resultset.getLong("id"), 
								 	resultset.getString("name"),
									resultset.getString("category"), 
									resultset.getDouble("price"));
					}
					
					
					return product;
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
			
	}

	@Override
	public void update(Product product) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public long add(Product product) {
		try(Connection connection = Database.getConnection();
			
			//Statement.RETURN_GENERATED_KEYS, with this parameter, we can get the generated key using statement.getGeneratedKeys()
			PreparedStatement statement = connection.prepareStatement(ADD_PRODUCT_SQL, Statement.RETURN_GENERATED_KEYS);	){
			
			
			statement.setString(1, product.getName());
			statement.setString(2, product.getCategory());
			statement.setDouble(3, product.getPrice());
			statement.executeUpdate();
			
			try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
	            if (generatedKeys.next()) {
	                return generatedKeys.getLong(1);
	            }
	            else {
	                throw new RuntimeException("Add product failed, no ID obtained.");
	            }
	        }
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
