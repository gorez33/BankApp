package com.example.bankapp.mapper;

import com.example.bankapp.dto.ClientDTO;
import com.example.bankapp.entity.Client;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClientMapper {


    List<ClientDTO> toDTOList(List<Client> clientList);
}
