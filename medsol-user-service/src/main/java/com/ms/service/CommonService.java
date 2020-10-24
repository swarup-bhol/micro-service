package com.ms.service;

import com.ms.dto.Response;

public interface CommonService {
   public Response<Object> response(int status, String msg, Object res);
}
