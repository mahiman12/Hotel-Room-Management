package com.mahiman.hotelroommanagement.configs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JsonResponse {

    private Boolean success;
    private String message;
    private Object data;

}
