package com.cnpmHDT.api.mapper;

import com.cnpmHDT.api.dto.province.ProvinceDto;
import com.cnpmHDT.api.form.province.CreateProvinceForm;
import com.cnpmHDT.api.form.province.UpdateProvinceForm;
import com.cnpmHDT.api.storage.model.Province;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-06-02T10:00:50+0700",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.13 (Oracle Corporation)"
)
@Component
public class ProvinceMapperImpl implements ProvinceMapper {

    @Override
    public Province fromCreateProvinceFormToEntity(CreateProvinceForm createProvinceForm) {
        if ( createProvinceForm == null ) {
            return null;
        }

        Province province = new Province();

        province.setKind( createProvinceForm.getProvinceKind() );
        province.setName( createProvinceForm.getName() );
        province.setStatus( createProvinceForm.getStatus() );

        return province;
    }

    @Override
    public void fromUpdateProvinceFormToEntity(UpdateProvinceForm updateProvinceForm, Province province) {
        if ( updateProvinceForm == null ) {
            return;
        }

        if ( updateProvinceForm.getName() != null ) {
            province.setName( updateProvinceForm.getName() );
        }
        if ( updateProvinceForm.getStatus() != null ) {
            province.setStatus( updateProvinceForm.getStatus() );
        }
    }

    @Override
    public ProvinceDto fromEntityToAdminDto(Province province) {
        if ( province == null ) {
            return null;
        }

        ProvinceDto provinceDto = new ProvinceDto();

        provinceDto.setCreatedDate( province.getCreatedDate() );
        provinceDto.setCreatedBy( province.getCreatedBy() );
        provinceDto.setName( province.getName() );
        provinceDto.setModifiedDate( province.getModifiedDate() );
        provinceDto.setProvinceKind( province.getKind() );
        provinceDto.setModifiedBy( province.getModifiedBy() );
        provinceDto.setId( province.getId() );
        provinceDto.setProvinceName( provinceParentProvinceName( province ) );
        Long id = provinceParentProvinceId( province );
        if ( id != null ) {
            provinceDto.setParentId( id.intValue() );
        }
        provinceDto.setStatus( province.getStatus() );

        return provinceDto;
    }

    @Override
    public List<ProvinceDto> fromEntityListToProvinceDtoList(List<Province> provinces) {
        if ( provinces == null ) {
            return null;
        }

        List<ProvinceDto> list = new ArrayList<ProvinceDto>( provinces.size() );
        for ( Province province : provinces ) {
            list.add( fromEntityToAdminDto( province ) );
        }

        return list;
    }

    private String provinceParentProvinceName(Province province) {
        if ( province == null ) {
            return null;
        }
        Province parentProvince = province.getParentProvince();
        if ( parentProvince == null ) {
            return null;
        }
        String name = parentProvince.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }

    private Long provinceParentProvinceId(Province province) {
        if ( province == null ) {
            return null;
        }
        Province parentProvince = province.getParentProvince();
        if ( parentProvince == null ) {
            return null;
        }
        Long id = parentProvince.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
