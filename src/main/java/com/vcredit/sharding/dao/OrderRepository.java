/*
 * Copyright 2016-2018 shardingsphere.io.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * </p>
 */

package com.vcredit.sharding.dao;

import com.vcredit.sharding.model.Order;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface OrderRepository {
    @Select("select * from t_order where order_id = #{id}")
    Order findById(Long id);

    @Select("select * from t_order where user_id = #{userId}")
    List<Order> findByUserId(Integer userId);

    @Select("select * from t_order where order_id = #{id} and user_id = #{userId}")
    Order findByIdAndUserId(@Param("id") Long id, @Param("userId") Integer userId);

    @Select("select * from t_order where order_id between #{startOrderId} and #{endOrderId}")
    List<Order> findByIdBetween(@Param("startOrderId") Long startOrderId, @Param("endOrderId")Long endOrderId);

    @Select("select * from t_order where user_id = #{userId} and order_id between #{startOrderId} and #{endOrderId}")
    List<Order> findByUserIdAndIdBetween(@Param("userId") Integer userId, @Param("startOrderId") Long startOrderId, @Param("endOrderId")Long endOrderId);
    
    void createIfNotExistsTable();
    
    void truncateTable();

    @Insert("INSERT INTO t_order (user_id, status) VALUES (#{order.userId}, #{order.status})")
    @Options(useGeneratedKeys = true, keyProperty = "order.orderId")
    Long insert(@Param("order") Order model);
    
    void delete(Long orderId);
    
    void dropTable();
}
