package com.project.coches.persistence.mapper;

import com.project.coches.domain.dto.PurchaseRequestDto;
import com.project.coches.persistence.entity.PurchaseEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

/**
 * mapper de compras
 */
@Mapper(componentModel = "spring")
public interface IPurchaseMapper {

    PurchaseRequestDto toPurchaseRequestDto(PurchaseEntity purchaseEntity);


    @Mapping(target = "carsPurchase", ignore = true)
    PurchaseEntity toPurchaseEntity(PurchaseRequestDto purchaseRequestDto);


    List<PurchaseRequestDto> toPurchasesRequestDtos(List<PurchaseEntity> purchasesEntities);

}
