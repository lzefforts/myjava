package org.study.mapStruct;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface PersonMapper {


    @Mapping(source = "inCome", target = "shouRu")
    @Mapping(source = "outCome", target = "zhiChu")
    PersonDto toPersonDto(Person person);
}
