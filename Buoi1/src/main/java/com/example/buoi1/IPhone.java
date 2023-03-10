package com.example.buoi1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("Iphone")
public class IPhone implements Phone {

  @Autowired
  private Type type;

  public void using() {
    System.out.println("Người dùng đang sử dụng IPhone");
    type.type();
  }

}
