package com.example.buoi2.demo;

import org.springframework.stereotype.Component;

@Component("XeWave")
public class XeWave implements XeMay {

  @Override
  public void xe() {
    System.out.println("Xe Wave");
  }

}
