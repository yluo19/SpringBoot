package com.yuro.passbook.service.Impl;

import com.spring4all.spring.boot.starter.hbase.api.HbaseTemplate;
import com.yuro.passbook.constant.Constants;
import com.yuro.passbook.service.IHbasePassService;
import com.yuro.passbook.utils.RowKeyGenerateUntils;
import com.yuro.passbook.vo.PassTemplate;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.util.Bytes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Pass Hbase 服务
 */
@Slf4j
@Service
public class HbasePassServiceImpl implements IHbasePassService {

    /** Hbase 客户端 */
    private final HbaseTemplate hbaseTemplate;

    @Autowired
    public HbasePassServiceImpl(HbaseTemplate hbaseTemplate) {
        this.hbaseTemplate = hbaseTemplate;
    }

    /**
     * PassTemplate 入Habse库
     * @param passTemplate
     * @return
     */
    @Override
    public boolean dropPassTemplateToHbase(PassTemplate passTemplate) {

        if(null == passTemplate)
            return false;

        String rowKey = RowKeyGenerateUntils.genPassTemplateRowKey(passTemplate);

        try{
            if (hbaseTemplate.getConnection().getTable(TableName.valueOf(Constants.PassTemplateTable.TABLE_NAME))
                    .exists(new Get(Bytes.toBytes(rowKey)))){
                log.warn("RowKey {} is already exist !", rowKey);
                return false;
            }

        }catch (Exception ex){
            log.error("DropPassTemplateToHbase Error : {}", ex.getMessage());
            return false;
        }

        Put put = new Put(Bytes.toBytes(rowKey));

        put.addColumn(  Bytes.toBytes(Constants.PassTemplateTable.FAMILY_B),
                        Bytes.toBytes(Constants.PassTemplateTable.ID),
                        Bytes.toBytes(passTemplate.getId())
                );
        put.addColumn(  Bytes.toBytes(Constants.PassTemplateTable.FAMILY_B),
                Bytes.toBytes(Constants.PassTemplateTable.TITLE),
                Bytes.toBytes(passTemplate.getTitle())
        );
        put.addColumn(  Bytes.toBytes(Constants.PassTemplateTable.FAMILY_B),
                Bytes.toBytes(Constants.PassTemplateTable.SUMMARY),
                Bytes.toBytes(passTemplate.getSummary())
        );
        put.addColumn(  Bytes.toBytes(Constants.PassTemplateTable.FAMILY_B),
                Bytes.toBytes(Constants.PassTemplateTable.DESC),
                Bytes.toBytes(passTemplate.getDesc())
        );
        put.addColumn(  Bytes.toBytes(Constants.PassTemplateTable.FAMILY_B),
                Bytes.toBytes(Constants.PassTemplateTable.HAS_TOKEN),
                Bytes.toBytes(passTemplate.getHasToken())
        );
        put.addColumn(  Bytes.toBytes(Constants.PassTemplateTable.FAMILY_B),
                Bytes.toBytes(Constants.PassTemplateTable.BACKGROUND),
                Bytes.toBytes(passTemplate.getBackground())
        );



        put.addColumn(  Bytes.toBytes(Constants.PassTemplateTable.FAMILY_C),
                Bytes.toBytes(Constants.PassTemplateTable.LIMIT),
                Bytes.toBytes(passTemplate.getLimit())
        );
        put.addColumn(  Bytes.toBytes(Constants.PassTemplateTable.FAMILY_C),
                Bytes.toBytes(Constants.PassTemplateTable.START),
                Bytes.toBytes(DateFormatUtils.ISO_DATE_FORMAT.format(passTemplate.getStart()))
        );
        put.addColumn(  Bytes.toBytes(Constants.PassTemplateTable.FAMILY_C),
                Bytes.toBytes(Constants.PassTemplateTable.END),
                Bytes.toBytes(DateFormatUtils.ISO_DATE_FORMAT.format(passTemplate.getEnd()))
        );

        hbaseTemplate.saveOrUpdate(Constants.PassTemplateTable.TABLE_NAME, put);  //save 方法


        return true;
    }
}
