package com.yuro.passbook.merchants.DAO;

import com.yuro.passbook.merchants.entity.Merchants;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *  <h1> Merchants Dao 接口</h1>
 */

public interface MerchantsDao extends JpaRepository<Merchants, Integer> {

    /**
     * 根据 id 获取商户对象
     * @param id 商户 id
     * @return {@link Merchants}
     */
    Merchants findById(Integer id);

    /**
     * 根据商户名称获取商户对象
     * @param name 商户名称
     * @return {@link Merchants}
     */
    Merchants findByName(String name);


}
