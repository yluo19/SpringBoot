package com.yuro.passbook.service;

import com.yuro.passbook.vo.PassTemplate;

public interface IHbasePassService {

    boolean dropPassTemplateToHbase (PassTemplate passTemplate);
}
