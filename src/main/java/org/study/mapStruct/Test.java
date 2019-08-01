package org.study.mapStruct;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Test {

    private static final int cycleNum = 100;

    public static void main(String[] args) {
        Person person = createPerson();

        doWithMapper(person);
        doWithBeanUtils(person);
        doWithSet(person);

    }

    private static void doWithSet(Person person) {
        long beginTime = System.currentTimeMillis();
        List<PersonDto> list = new ArrayList<>();
        for(int i=0;i<=cycleNum;i++){
            PersonDto dto = new PersonDto();
            dto.setName(person.getName());
            dto.setAddress(person.getAddress());
            dto.setAge(person.getAge());
            dto.setSex(person.getSex());
            dto.setShouRu(person.getInCome());
            dto.setZhiChu(person.getOutCome());
            list.add(dto);
        }
        long endTime = System.currentTimeMillis();
        long time = endTime-beginTime;
        System.out.println("doWithSet time:"+time);
    }

    private static void doWithBeanUtils(Person person) {
        long beginTime = System.currentTimeMillis();
        List<PersonDto> list = new ArrayList<>();
        for(int i=0;i<=cycleNum;i++){
            PersonDto dto = new PersonDto();
            BeanUtils.copyProperties(person,dto);
            list.add(dto);
        }
        long endTime = System.currentTimeMillis();
        long time = endTime-beginTime;
        System.out.println("doWithBeanUtils time:"+time);
    }

    private static void doWithMapper(Person person) {
        long beginTime = System.currentTimeMillis();
        PersonMapper personMapper = Mappers.getMapper(PersonMapper.class);
        List<PersonDto> list = new ArrayList<>();
        for(int i=0;i<=cycleNum;i++){
            PersonDto dto = personMapper.toPersonDto(person);
            list.add(dto);
        }
        long endTime = System.currentTimeMillis();
        long time = endTime-beginTime;
        System.out.println("doWithMapper time:"+time);
    }

    private static Person createPerson() {
        Person person = new Person();
        person.setName("哈哈哈");
        person.setSex("男");
        person.setAge(22);
        person.setAddress("北京市朝阳区酒仙桥北路电子IT产业园101号楼");
        person.setInCome(BigDecimal.valueOf(123.45));
        person.setOutCome(BigDecimal.valueOf(345.67));
        return person;
    }
}
