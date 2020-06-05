package com.tiens.enjoylife.mapper.orm;

import com.alibaba.fastjson.JSONObject;
import com.tiens.coreservice.api.dto.RemoteAddressDTO;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * 说明:List<RemoteAddressDTO>自定义类型处理器
 *
 * @author liulong
 * @date 2020-06-04
 */
public class DeliveryAreadCodeTypeHandler extends BaseTypeHandler<List<RemoteAddressDTO>> {


    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, List<RemoteAddressDTO> addressBaseDTOList, JdbcType jdbcType) throws SQLException {
        String addressAreaCodeList = JSONObject.toJSONString(addressBaseDTOList);
        preparedStatement.setString(i, addressAreaCodeList);
    }

    @Override
    public List<RemoteAddressDTO> getNullableResult(ResultSet resultSet, String s) throws SQLException {
        return JSONObject.parseArray(resultSet.getString(s), RemoteAddressDTO.class);
    }

    @Override
    public List<RemoteAddressDTO> getNullableResult(ResultSet resultSet, int i) throws SQLException {
        return JSONObject.parseArray(resultSet.getString(i), RemoteAddressDTO.class);
    }

    @Override
    public List<RemoteAddressDTO> getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        return JSONObject.parseArray(callableStatement.getString(i), RemoteAddressDTO.class);
    }
}
