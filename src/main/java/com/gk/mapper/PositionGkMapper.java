package com.gk.mapper;

import com.gk.model.PositionGk;
import com.gk.model.PositionGkExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PositionGkMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_position_gk
     *
     * @mbg.generated
     */
    long countByExample(PositionGkExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_position_gk
     *
     * @mbg.generated
     */
    int deleteByExample(PositionGkExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_position_gk
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_position_gk
     *
     * @mbg.generated
     */
    int insert(PositionGk record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_position_gk
     *
     * @mbg.generated
     */
    int insertSelective(PositionGk record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_position_gk
     *
     * @mbg.generated
     */
    List<PositionGk> selectByExample(PositionGkExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_position_gk
     *
     * @mbg.generated
     */
    PositionGk selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_position_gk
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") PositionGk record, @Param("example") PositionGkExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_position_gk
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") PositionGk record, @Param("example") PositionGkExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_position_gk
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(PositionGk record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_position_gk
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(PositionGk record);
}