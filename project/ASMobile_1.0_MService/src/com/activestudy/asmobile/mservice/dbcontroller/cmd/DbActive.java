/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.activestudy.asmobile.mservice.dbcontroller.cmd;

import com.activestudy.Utility.Define.AbsDefine;
import com.activestudy.Utitity.db.DbConnectionExtra;
import com.activestudy.Utitity.db.oracle.DbProcess;
import com.activestudy.asmobile.mservice.dbcontroller.OracleConnection;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

/**
 *
 * @author tanhai
 */
public class DbActive extends DbProcess {
    String activationId;
    
    @Override
    public void execute(DbConnectionExtra conn)  {
        PreparedStatement pStmt = null;
        try {
            pStmt = ((OracleConnection) conn).getStmActiveSubs();
            ResultSet rs = pStmt.executeQuery();
            if (rs != null) {
//                int categoryIndex, classIndex, unitIndex, categoryId, classId, unitId;
//                String categoryName, className, unitName;
//                while (rs.next()) {
//                    
//                    categoryIndex = rs.getInt("category_key_press");
//                    classIndex = rs.getInt("Class_key_press");
//                    unitIndex = rs.getInt("Unit_key_press");
//                    categoryId = rs.getInt("category_id");
//                    classId = rs.getInt("ClassID");
//                    unitId = rs.getInt("UnitID");
//                    categoryName = rs.getNString("category_name");
//                    className = rs.getNString("class_name");
//                    unitName = rs.getNString("Unit_name");
//                    
//                    logger.info("DbActive ID: " + categoryId + " category_key_press: " + categoryIndex + " category_name: " + categoryName + " ClassID: " + classId + " Class_key_press: " + classIndex + " class_name: " +className + " UnitID: " + unitId + " unitIndex: " + unitIndex + " unitName: " + unitName);                    
//                    if( true == categorys.addCategory(Categorys.getNextIndexCategory(),categoryIndex, categoryId,categoryName, classIndex, classId, className, unitIndex, unitId, unitName)){                    
//                        logger.error("Success to addCategory ID: " + categoryId + " category_key_press: " + categoryIndex + " category_name: " + categoryName + " ClassID: " + classId + " Class_key_press: " + classIndex + " class_name: " +className + " UnitID: " + unitId + " unitIndex: " + unitIndex + " unitName: " + unitName);                    
//                        
////                        if(categorys.isExit(Categorys.getCurrentCategory(), categoryIndex)){
////                            logger.error("Exits Category ID: " + categoryId + " category_key_press: " + categoryIndex + " category_name: " + categoryName + " ClassID: " + classId + " Class_key_press: " + classIndex + " class_name: " +className + " UnitID: " + unitId + " unitIndex: " + unitIndex + " unitName: " + unitName);                    
////                        }else{
////                            logger.error("Not exits Category ID: " + categoryId + " category_key_press: " + categoryIndex + " category_name: " + categoryName + " ClassID: " + classId + " Class_key_press: " + classIndex + " class_name: " +className + " UnitID: " + unitId + " unitIndex: " + unitIndex + " unitName: " + unitName);                    
////                        }
//                    }else{
//                        logger.error("Error to addCategory ID: " + categoryId + " category_key_press: " + categoryIndex + " category_name: " + categoryName + " ClassID: " + classId + " Class_key_press: " + classIndex + " class_name: " +className + " UnitID: " + unitId + " unitIndex: " + unitIndex + " unitName: " + unitName);                    
//                    }
//                }
//                Categorys.changeCurrentCategory();
                result = AbsDefine.KEY_SUCCESS;            
                rs.close();
            }else{
                 logger.error("LoadCategory UnSuccess, ResultSet is Null");
            }
        } catch (SQLException se) {
            logger.error("LoadCategory ErrorCode: " +se.getErrorCode() + " Error: " + se.getMessage() + " STACK: " + se);
        } finally {
//            try {
//                if (pStmt != null) {
//                    pStmt.close();
//                }
//            } catch (SQLException ex) {
//                logger.error("DbActive ErrorCode: " +ex.getErrorCode() + " Error: " + ex.getMessage() + " STACK: " + ex);
//            }
        }

    }

    public String getActivationId() {
        return activationId;
    }

    public void setActivationId(String activationId) {
        this.activationId = activationId;
    }
    

}
