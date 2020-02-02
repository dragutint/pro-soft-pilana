/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface IGeneralObject extends Serializable {
    public String getTableName();
    public String getColumnNamesForInsert();
    public String getInsertValues();
    public void setId(int id);
    public IGeneralObject getObject(ResultSet rs) throws SQLException;
    public String getObjectCase();
    public List<IGeneralObject> getList(ResultSet rs) throws SQLException;
    public Integer getId();
    public String getUpdateValues();

}
