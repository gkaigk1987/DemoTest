package com.gk.mapper;

import com.gk.model.PlivateRoute;
import com.gk.model.PlivateRouteExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PlivateRouteMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_plivate_route
     *
     * @mbg.generated
     */
    long countByExample(PlivateRouteExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_plivate_route
     *
     * @mbg.generated
     */
    int deleteByExample(PlivateRouteExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_plivate_route
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(String uuid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_plivate_route
     *
     * @mbg.generated
     */
    int insert(PlivateRoute record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_plivate_route
     *
     * @mbg.generated
     */
    int insertSelective(PlivateRoute record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_plivate_route
     *
     * @mbg.generated
     */
    List<PlivateRoute> selectByExample(PlivateRouteExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_plivate_route
     *
     * @mbg.generated
     */
    PlivateRoute selectByPrimaryKey(String uuid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_plivate_route
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") PlivateRoute record, @Param("example") PlivateRouteExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_plivate_route
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") PlivateRoute record, @Param("example") PlivateRouteExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_plivate_route
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(PlivateRoute record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_plivate_route
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(PlivateRoute record);
}