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

import com.vcredit.sharding.model.OrderItem;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface OrderItemRepository {

    @Select("select * from t_order_item where order_item_id = #{id}")
    OrderItem findById(Long id);
    
    void createIfNotExistsTable();
    
    void truncateTable();

    @Insert("INSERT INTO t_order_item (user_id, order_id) VALUES (#{userId}, #{orderId})")
    Long insert(OrderItem model);
    
    void delete(Long orderItemId);
    
    List<OrderItem> selectAll();
    
    void dropTable();
}
