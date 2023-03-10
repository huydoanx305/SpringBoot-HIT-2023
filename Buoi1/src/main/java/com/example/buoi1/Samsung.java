package com.example.buoi1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("Samsung")
@Primary
public class Samsung implements Phone {

  @Autowired
  private Type type;

  @Override
  public void using() {
    System.out.println("Người dùng đang sử dụng Samsung");
    type.type();
  }
}
