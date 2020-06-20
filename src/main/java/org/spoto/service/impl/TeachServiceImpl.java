package org.spoto.service.impl;

import org.spoto.aop.An;
import org.spoto.aop.AopStudy;
import org.spoto.service.TeachService;
import org.springframework.stereotype.Service;

@Service("teachService")
public class TeachServiceImpl implements TeachService {

    @An
    public String teach(){

        System.out.println("I am a teacher");

        return "I can teach you";
    }

    @An
    public String practise(){

        System.out.println("学习要多做练习");

        return "熟能生巧";
    }


}
