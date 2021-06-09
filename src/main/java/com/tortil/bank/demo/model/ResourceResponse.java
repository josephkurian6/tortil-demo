package com.tortil.bank.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

/**
 * Model for RepresentationModel response, contains self reference URL
 */
@AllArgsConstructor
@Data
public class ResourceResponse extends RepresentationModel<ResourceResponse> {
    private Object data;
}
