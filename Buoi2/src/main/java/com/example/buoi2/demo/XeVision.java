package com.example.buoi2.demo;

import org.springframework.stereotype.Component;

@Component("XeVision")
public class XeVision implements XeMay {

  @Override
  public void xe() {
    System.out.println("Xe Vision");
  }

}
