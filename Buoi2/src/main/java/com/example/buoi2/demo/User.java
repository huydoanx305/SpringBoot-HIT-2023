package com.example.buoi2.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class User {

  @Qualifier("XeWave")
  @Autowired
  private XeMay xeMay;

  public void getXeMay() {
    xeMay.xe();
  }
}
