package com.example.buoi1;

import org.springframework.stereotype.Component;

@Component
public class TypeImpl implements Type {

  @Override
  public void type() {
    System.out.println("Type");
  }

}
