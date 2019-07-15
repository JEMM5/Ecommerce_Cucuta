package prueba.cucecommerce.pojo;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class CategoriaRowMapper implements RowMapper<TCategoria>{

	public TCategoria mapRow(ResultSet rs, int rowNum) throws SQLException {
		TCategoria tCategoria = new TCategoria();
		tCategoria.setCodigo(rs.getInt("codigo"));
		tCategoria.setNombre(rs.getString("nombre"));
		tCategoria.setVisible(rs.getBoolean("visible"));
		tCategoria.setCategoria_superior(rs.getInt("categoria_superior"));
		return tCategoria;
		
	}

}
