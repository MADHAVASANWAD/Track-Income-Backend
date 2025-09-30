package com.finance.exception;

import lombok.*;

@Data
public class ResourceNotFoundException extends RuntimeException {

     String resourcename;
     String fieldname;
     long fieldvalue;

   public   ResourceNotFoundException(String resourcename,String fieldname,long fieldvalue){
         super(String.format("%s not found %s : %s ",resourcename,fieldname,fieldvalue));
         this.resourcename = resourcename;
         this.fieldname = fieldname;
         this.fieldvalue = fieldvalue;
     }


}
